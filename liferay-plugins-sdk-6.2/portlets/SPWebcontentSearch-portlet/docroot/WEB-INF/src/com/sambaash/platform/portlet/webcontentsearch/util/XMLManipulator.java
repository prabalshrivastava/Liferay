package com.sambaash.platform.portlet.webcontentsearch.util;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
public class XMLManipulator {

	Element root = null;
	Document doc = null;

	private static Log _log = LogFactoryUtil.getLog(XMLManipulator.class);

	public XMLManipulator(String xmlString) {
		 try {
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           DocumentBuilder db = dbf.newDocumentBuilder();
           doc = db.parse(new InputSource(new StringReader(xmlString)));
           doc.normalizeDocument();
	    } catch (Exception e) {
	    	_log.debug(e.getMessage());
	    }

	    try {
	           root =doc.getDocumentElement();
	    } catch (Exception e) {
	    	_log.debug(e.getMessage());
	    }
	 }

	public int countXmlNode(String node) {
		int count = 0;
		Document doc;
		try {
			doc = root.getOwnerDocument();
			NodeList list = doc.getElementsByTagName(node);
			count = list.getLength();
		} catch (Exception e) {
			_log.debug(e.getMessage());
		}
		return count;

	}

	public String findNodeById(String xql, String idName, String idValue){
		//Document doc = root.getOwnerDocument();
		NodeList nodeList = null;
		try {
			nodeList = XPathAPI.selectNodeList( root, "//"+xql);
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		}catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}
		
		String foundNode = null;

		if(Validator.isNotNull(nodeList)){
			int length = nodeList.getLength();
			for (int i = 0; i < length; i++) {
				Element link = (Element) nodeList.item( i );
				Attr a = link.getAttributeNode(idName);
				if(Validator.isNotNull(a)){
					String attr = link.getAttributeNode(idName).getTextContent();
					//if (attr.equalsIgnoreCase(idValue)) {
						foundNode = attr;
					//}
				}
			}
		}
		return foundNode;
	}

	public NodeList getNodeList(String nodeName) {
		//Document doc = root.getOwnerDocument();
		NodeList nodeList = null;
		try {
			ClassLoader a = PortalClassLoaderUtil.getClassLoader();
			ClassLoader b = PortletClassLoaderUtil.getClassLoader();

			_log.debug("a : " + a.toString() );
			_log.debug("b : " + b.toString() );

			nodeList = XPathAPI.selectNodeList( root, "//"+nodeName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.debug("nodelist not found "+e.getMessage());
		}
		return nodeList;
	}

	public Node setRelatedProjects(String nodeValue) throws TransformerException{

		Node node = doc.createElement("relatedProjects");
		node.setTextContent("nodeValue");

		return node;
	}

	public Node selectSingleNode(String nodeName,String idValue) {
		Node node = null;
		try {
			node = XPathAPI.selectSingleNode( root, "//"+nodeName +"[@id='" + idValue + "']/related_projects");
		} catch (Exception e) {
			_log.debug("node not found &&&&&& " + e.getMessage());
		}
		return node;
	}

	public Node findNode(String xpath){
		Node node = null;
		try {
			doc = root.getOwnerDocument();
		    doc.normalizeDocument();
			node = XPathAPI.selectSingleNode(root, xpath);
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		}catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}
		return node;
	}

	public NodeList findNodeList(String xpath) {
		NodeList nodes = null;
		try {
			doc = root.getOwnerDocument();
		    doc.normalizeDocument();
			nodes = XPathAPI.selectNodeList(root, xpath);
		} catch (TransformerException e) {
			_log.error(e.getMessage());
		}catch (Exception e) {
			_log.error(e.getMessage());
		}
		return nodes;
	}

	public Map<String, String> getNodeAsMap(String xpath){
		Map<String, String> nodeMap = new HashMap<String, String>();
		NodeList nodes = findNodeList(xpath);
		
		if(nodes != null){
			for (int i = 0; i < nodes.getLength(); i++) {
				Node childNode = nodes.item(i);
				String key = childNode.getNodeName();
				String value = childNode.getTextContent().trim();
				if ( !key.equals("#text") ) {
					nodeMap.put(key+i, value);
				}
			}
		}
		return nodeMap;
	}

	public Map<String, String> getNameValueNodeAsMap(String xpath) throws Exception{
		Map<String, String> nodeMap = new HashMap<String, String>();
		NodeList nodes = findNodeList(xpath);
		String strNameValue = StringPool.BLANK;
		int id = 0;

		if(nodes != null){
			for (int i = 0; i < nodes.getLength(); i++) {
				Node childNode = nodes.item(i);
				String key = childNode.getNodeName();
				String value = childNode.getTextContent().trim();

				if (key.equals("name")) {
					strNameValue = value;
					id++;
				}
				if (key.equals("value")) {
					strNameValue += StringPool.COLON + value;
					nodeMap.put("msgr"+id, strNameValue);

					strNameValue = StringPool.BLANK;
				}

			}
		}
		return nodeMap;
	}


	public String getDefault(String nodeName)
	{
		String value = StringPool.BLANK;
		try
		{
			String xPath = "//"+nodeName;

			Node node = XPathAPI.selectSingleNode(root, xPath);
			
			if(Validator.isNotNull(node)){
				value = node.getFirstChild().getNodeValue();
			}
		} catch ( Exception e)
		{
			_log.debug(e.getMessage());
		}
		return value;
	}

	
	public void cleanupXML(){
		//1. cleanup duplicate other details node
		try {
			NodeList otherDetails =  findNodeList("//profile/other_details");
			if(Validator.isNotNull(otherDetails)){
				int odSize = otherDetails.getLength();
				if(odSize > 1){//if more than 1 node, delete the rest
					for (int i = 0; i < odSize; i++) {
						Node nodeToRemove = otherDetails.item(i);
						NodeList childList = nodeToRemove.getChildNodes();
						if(Validator.isNull(childList) || childList.getLength() == 0){
							nodeToRemove.getParentNode().removeChild(nodeToRemove);
						}
					}
				}
			}
		} catch (Exception e) {
			 _log.error(e.getMessage(), e);
		}
		//2. cleanup duplicate network details node
		try {
			NodeList networkDetails =  findNodeList("//profile/network_info/*");
			if(Validator.isNotNull(networkDetails)){
				int s = networkDetails.getLength();
				for (int i = 0; i < s; i++) {
					Node nodeToRemove = networkDetails.item(i);
					Element link = (Element) networkDetails.item(i);
					if (link.getAttributeNode("fieldType") != null)//remove duplicate node w/ attribute fieldType (system field should not have attributes)
					{
						nodeToRemove.getParentNode().removeChild(nodeToRemove);
					}
				}
			}
		} catch (Exception e) {
			 _log.error(e.getMessage(), e);
		}
	}
	
}