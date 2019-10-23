package com.sambaash.platform.portlet.spgroup.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.liferay.portlet.messageboards.model.MBMessage;

public class DiscussionTree {
	public List<Node> parentNodes = new ArrayList<Node>();
	public Map<Long, Node> parentNodeMap = new HashMap<Long, Node>();
	public Map<Long, Node> nodeMap = new HashMap<Long, Node>();
	private List<DiscussionTreeListener> listeners = new ArrayList<DiscussionTreeListener>();
	private long lastNotifiedDiscussionId = 0;
	
	public DiscussionTree(List<MBMessage> newSPGroupDiscussions) {
		prepareTree(newSPGroupDiscussions);
	}

	private void prepareTree(List<MBMessage> newSPGroupDiscussions) {
		// determine parent and child nodes
		for (MBMessage m: newSPGroupDiscussions) {
			DiscussionTree.Node node = addNode(m.getMessageId(), m);
			if (m.getParentMessageId()>0 && !parentNodeMap.containsKey(m.getParentMessageId())) {
				addParentNode(m.getParentMessageId());
			}
			if (parentNodeMap.containsKey(m.getMessageId())) {
				parentNodeMap.get(m.getMessageId()).content = m; // this is a parentNode
			}
			if (m.getParentMessageId()>0 && m.getParentMessageId() != m.getMessageId()) {
				nodeMap.get(m.getParentMessageId()).addChildNode(node);
			}
		}
		
		// resolve parent nodes that are actually child nodes
		Iterator<DiscussionTree.Node> it2 = parentNodes.iterator();
		while(it2.hasNext()) {
			DiscussionTree.Node node = it2.next();
			MBMessage msg = node.content;
			// this parent node is actually just a child of another parent node (nested)
			if (msg != null && parentNodeMap.containsKey(msg.getParentMessageId())) {  
				it2.remove();
//				parentNodeMap.remove(msg.getMessageId());
				nodeMap.get(msg.getParentMessageId()).addChildNode(node);
			}
		}
	}
	
	public DiscussionTree addListener(DiscussionTreeListener listener) {
		listeners.add(listener);
		return this;
	}
	
	public DiscussionTree addParentNode(long nodeId) {
		return addParentNode(nodeId, null);
	}
	
	public DiscussionTree addParentNode(long nodeId, MBMessage content) {
		Node parentNode = addNode(nodeId, content);
		parentNodeMap.put(nodeId, parentNode);
		parentNodes.add(parentNode);
		return this;
	}

	private Node addNode(long nodeId, MBMessage content) {
		Node node = nodeMap.get(nodeId);
		if (node==null) {
			node = new Node(nodeId, content);
		}
		node.nodeId = nodeId;
		nodeMap.put(nodeId, node);
		return node;
	}

	public void walkTheTree() {
		for (DiscussionTree.Node parentNode: parentNodes) {
			int level = 0;
			displayParentAndChildren(parentNode, level);
		}
	}

	private void displayParentAndChildren(
			DiscussionTree.Node parentNode, int level) {
		MBMessage parentMB = parentNode.content;
		if (parentMB != null ) {
			if (isGroupNode(parentMB)) {
//				notifyListenersOnDiscussionGroup(parentMB, level);
			} else {
				Node grandParentNode = parentNodeMap.get(parentMB.getParentMessageId());
				if (grandParentNode.content==null && lastNotifiedDiscussionId != grandParentNode.nodeId) {
					lastNotifiedDiscussionId = grandParentNode.nodeId;
					notifyListenersOnMissingDiscussion(grandParentNode.nodeId, level-1);
				}
				notifyListenersOnDiscussionContent(parentMB, level);
			}
		}
		// child node or group node
		if ((parentMB == null && parentNode.nodeId > 0) || (parentMB != null && parentMB.getParentMessageId() > 0) ) {
			++level;
		}
		for (DiscussionTree.Node childNode: parentNode.childNodes) {
			displayParentAndChildren(childNode, level);
		}
	}
	
	private void notifyListenersOnMissingDiscussion(long discussionId, int level) {
		for (DiscussionTreeListener listener: listeners) {
			listener.onMissingDiscussion(discussionId, level);
		}		
	}

	private boolean isGroupNode(MBMessage parentMB) {
		try {
			return Long.parseLong(parentMB.getSubject()) == Long.parseLong(parentMB.getBody());			
		} catch (Exception e) {
			return false;
		}
	}

//	private void notifyListenersOnDiscussionGroup(MBMessage discussionGroup, int level) {
//		for (DiscussionTreeListener listener: listeners) {
//			listener.onDiscussionTraversed(discussionGroup, level);
//		}
//	}
//
	private void notifyListenersOnDiscussionContent(MBMessage message, int level) {
		for (DiscussionTreeListener listener: listeners) {
			listener.onDiscussionContentTraversed(message, level);
		}
	}
	
	static public class Node {
		public long nodeId;
		public MBMessage content;
		public List<Node> childNodes = new ArrayList<Node>();

		public Node(long nodeId, MBMessage content) {
			this.nodeId = nodeId;
			this.content = content;
		}
		
		public void addChildNode(Node childNode) {
			if (!isAlreadyAChildNode(childNode)) {
				childNodes.add(childNode);
			}
		}

		private boolean isAlreadyAChildNode(Node childNode) {
			for (Node n: childNodes) {
				if (childNode.nodeId == n.nodeId) {
					return true;
				}
			}
			return false;
		}
		
	}
	
}
