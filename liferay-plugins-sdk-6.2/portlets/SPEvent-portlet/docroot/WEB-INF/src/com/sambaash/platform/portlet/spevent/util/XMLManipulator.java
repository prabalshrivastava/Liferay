package com.sambaash.platform.portlet.spevent.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import com.sambaash.platform.util.SambaashHtmlUtil;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;

import org.apache.xpath.XPathAPI;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import org.xml.sax.InputSource;
public class XMLManipulator {

	Element root = null;
	Document doc = null;

	public XMLManipulator() {
		String filepath = StringPool.BLANK;
		filepath ="/Development/viewprofile.xml";
		File docFile = new File(filepath);

		// Parse the file

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(docFile);
			doc.normalizeDocument();
			root = doc.getDocumentElement();
		} catch (Exception e) {
			_log.debug("Problem parsing the file " + e.getMessage());
		}
	}

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
	root = doc.getDocumentElement();
	} catch (Exception e) {
		_log.debug(e.getMessage());
	}
	}

	/**
	 * append a node with the given name at the specified location in the document
	 * <p>
	 * Takes a context node, the name of the new node, and an XPath expression.
	 * The new node is appended to the document at the point specified by the
	 * context node and the XPath statement
	 *
	 * @param startNode   context node on which to evaluate the xpath
	 * @param name        the name of the new node
	 * @param xql         the XPath expression
	 * @return            Returns the newly appended node
	 **/
	public Node appendNode(String name, String xql)
	{
		Node targetNode = null;
		try {
			targetNode = XPathAPI.selectSingleNode( root,"/profile" );
			Document doc = root.getOwnerDocument();
			Element newElement = doc.createElement( xql );
			targetNode.appendChild( (Node)newElement );
			Node targetNode1 = XPathAPI.selectSingleNode( root,"//"+xql );
			Element newElement1 = doc.createElement( name );
			targetNode1.appendChild( (Node)newElement1 );
		} catch (Exception e) {
			_log.error("error during append node <Otherdetails>" + e.getMessage());
		}

		return targetNode;
	}

	public Node appendNodeWithValue(String nodeName, String nodeValue, String xql)
	{
		Node targetNode = null;
		try {
			targetNode = XPathAPI.selectSingleNode( root, xql );
			Document doc = root.getOwnerDocument();

			Element newElement = doc.createElement( nodeName );
			targetNode.appendChild( (Node)newElement ).setTextContent( SambaashHtmlUtil.escape(nodeValue));

		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		}catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return targetNode;
	}

	public Node appendXmlWithId(String xql, String template, String id)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = null;
		try {
			docBuilder = factory.newDocumentBuilder();
			Document docA = docBuilder.parse(new InputSource(new StringReader(template)));
		doc = root.getOwnerDocument();
		Node targetNode = XPathAPI.selectSingleNode(root, xql);
		Element rootA = docA.getDocumentElement();
		rootA.setAttribute("id",id);
		targetNode.appendChild(doc.importNode(rootA, true));
		return targetNode;
		}catch (Exception e) {
			_log.error("Error appending dynamic section to userinfo" + e.getMessage());
		}

		return null;
	}

	public void cleanupXML() {
		//1. cleanup duplicate other details node
		try {
			NodeList otherDetails =  findNodeList("//profile/other_details");

			if (Validator.isNotNull(otherDetails)) {
				int odSize = otherDetails.getLength();

				if (odSize > 1){//if more than 1 node, delete the rest

						for (int i = 0; i < odSize; i++) {
						Node nodeToRemove = otherDetails.item(i);
						NodeList childList = nodeToRemove.getChildNodes();

						if (Validator.isNull(childList) || childList.getLength() == 0) {
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
			if (Validator.isNotNull(networkDetails)) {
				int s = networkDetails.getLength();

				for (int i = 0; i < s; i++) {
					Node nodeToRemove = networkDetails.item(i);
					Element link = (Element)networkDetails.item(i);

					if (link.getAttributeNode("fieldType") != null)//remove duplicate node w/ attribute fieldType (system field should not have attributes)
					{
						nodeToRemove.getParentNode().removeChild(nodeToRemove);
					}
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	} public String findNodeById(String xql, String idName, String idValue) {
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

		if (Validator.isNotNull(nodeList)) {
			int length = nodeList.getLength();

			for (int i = 0; i < length; i++) {
				Element link = (Element)nodeList.item( i );
				Attr a = link.getAttributeNode(idName);

				if (Validator.isNotNull(a)) {
					String attr = link.getAttributeNode(idName).getTextContent();
					//if (attr.equalsIgnoreCase(idValue)) {
						foundNode = attr;
					//}
				}
			}
		}

		return foundNode;
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

	public Node createSpecifiedNode(Node targetNode, String url) {
		if (Validator.isNotNull(url)) {
			Node newNode = doc.createElement("project");
			Node urlNode = doc.createElement("url");
			urlNode.setTextContent(url);
			newNode.appendChild(urlNode);
			return newNode;
		}else {
			return null;
		}
	}

	public void findAndAddNodeWithValue(String category, String categoryDetails, String node, String value, Map<String, String> attributes) {
		if (Validator.isNotNull(node)) {
			String xql = category;
			String nodeName = node.trim().toLowerCase();
			NodeList nodeInstance = null;
			try {

				if (Validator.isNotNull(categoryDetails)) {
		xql += "/" + categoryDetails;
		}

				nodeInstance = findNodeList( "//" + xql + "/" + nodeName  ); //find existing instances of nodeName
			} catch (Exception e) {
				_log.debug(e.getMessage(), e);
			}

			if (Validator.isNull(nodeInstance) || nodeInstance.getLength() == 0){ //check if node doesn't exists
				try {

					//append new node
					NodeList targetNodeList = findNodeList("//" + xql);

					if (Validator.isNotNull(targetNodeList)) {
						for (int i = 0; i < targetNodeList.getLength(); i++) {
							Node targetNode = targetNodeList.item(i);

							if (targetNode.getNodeType() == Node.ELEMENT_NODE) {
								Document doc = root.getOwnerDocument();
								Element newElement = doc.createElement( nodeName.replaceAll("( )+", "_") );

								String fieldType = attributes.get("fieldType");

								newElement.setAttribute("fieldType",fieldType);
								newElement.setAttribute("mandatory",attributes.get("mandatory"));
								newElement.setAttribute("maxLen",attributes.get("maxLen"));
								newElement.setAttribute("validation",attributes.get("validation"));
								newElement.setAttribute("edittable",attributes.get("edittable"));
								newElement.setAttribute("default",attributes.get("default"));
								newElement.setAttribute("label",attributes.get("label"));

								if (fieldType.equals("Dropdown") || fieldType.equals("Radio") || fieldType.equals("MultipleList")) {
									newElement.setAttribute("optionId",attributes.get("options"));//vocabularyId
								}

								targetNode.appendChild( (Node) newElement ).setTextContent( SambaashHtmlUtil.escape(value));//set new node with default value
							}
						}

						_log.debug("New field successfully added: " + nodeName);
					}
				} catch (Exception e) {
					_log.debug("Unable to append node with value: " + e.getMessage());
				}
			}else { //update existing node
				_log.debug("The same node already exists: " + node);

				for (int i = 0; i < nodeInstance.getLength(); i++) {
					Node instance = nodeInstance.item(i);

					if (instance.getNodeType() == Node.ELEMENT_NODE) {
						Element updateEl = (Element)instance;

						if (Validator.isNotNull(updateEl.getAttribute("fieldType"))){//update only the node with attribute "fieldtype"
							String fieldType = attributes.get("fieldType");
							updateEl.setAttribute("fieldType",fieldType);
							updateEl.setAttribute("mandatory",attributes.get("mandatory"));
							updateEl.setAttribute("maxLen",attributes.get("maxLen"));
							updateEl.setAttribute("validation",attributes.get("validation"));
							updateEl.setAttribute("edittable",attributes.get("edittable"));
							updateEl.setAttribute("default",attributes.get("default"));
							updateEl.setAttribute("label",attributes.get("label"));

							if (fieldType.equals("Dropdown") || fieldType.equals("Radio") || fieldType.equals("MultipleList")) {
								updateEl.setAttribute("optionId",attributes.get("options"));//vocabularyId
							}

							_log.debug("Node successfully updated: " + node);
						}

						if (Validator.isNull(updateEl.getTextContent())) {
							updateEl.setTextContent( SambaashHtmlUtil.escape(value)); //update default value
						}
					}
				}
			}
		}
	}

	public Node findNode(String xpath) {
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
			_log.debug(e.getMessage(), e);
		}catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return nodes;
	}

	public String getDefault(String nodeName)
	{
		String value = StringPool.BLANK;
		try
		{
			String xPath = "//"+nodeName;

			Node node = XPathAPI.selectSingleNode(root, xPath);

			if (Validator.isNotNull(node)) {
				value = node.getFirstChild().getNodeValue();
			}
		} catch ( Exception e)
		{
			_log.debug(e.getMessage());
		}

		return value;
	}

	public Map<String, String> getNameValueNodeAsMap(String xpath) throws Exception {
		Map<String, String> nodeMap = new HashMap<String, String>();
		NodeList nodes = findNodeList(xpath);
		String strNameValue = StringPool.BLANK;
		int id = 0;

		if (nodes != null) {
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

	public Map<String, String> getNodeAsMap(String xpath) {
		Map<String, String> nodeMap = new HashMap<String, String>();
		NodeList nodes = findNodeList(xpath);

		if (nodes != null) {
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

	/**
	 * Remove all nodes of the particular category
	 * @param xql
	 * @param node
	 * @return
	 * @throws Exception
	 */
	public NodeList removeAllNodes(String category, String nodeName)
	{
	NodeList tNode = null;
		try {
			doc = root.getOwnerDocument();
		doc.normalizeDocument();
			tNode = XPathAPI.selectNodeList( root, category + "/" + nodeName );

			for (int i = 0; i < tNode.getLength(); i++) {
			Node targetNode = tNode.item(i);
			while (targetNode.hasChildNodes()) {
				targetNode.removeChild(targetNode.getFirstChild());
				}

			targetNode.getParentNode().removeChild(targetNode);
			}

		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		}catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

	return tNode;
	}

	/**
	 * adds a new attribute for removal at a specified set of xml/node from the specified location in the document
	 * <p>
	 * Takes a context node, the count/instance of childnode to be removed, and an XPath expression.
	 * The childnode is attached to a new attribute at the point specified by the
	 * context node and the XPath statement
	 *
	 * @param startNode/root   	context node on which to evaluate the xpath
	 * @param count		  	   	the instance number of the child node to be removed
	 * @param xql         		the XPath expression
	 * @return            		Returns the new node with attached attribute
	 **/

	public Node removeNode(String xql, int instance, String node) {
	Node targetNode = null;
	NodeList tNode = null;
		try {
			doc = root.getOwnerDocument();
		doc.normalizeDocument();

			tNode = XPathAPI.selectNodeList( root,xql+"/"+node );
			targetNode = tNode.item(instance-1);
			targetNode.getParentNode().removeChild(targetNode);
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		}catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

	return targetNode;
	}

	/**
	 * Remove a node using an attribute value
	 * @param attributeName
	 * @param valueToDelete
	 * @param categoryName
	 * @throws TransformerException
	 */
	public void removeNodeByAttributeValue(String attributeName, String valueToDelete,
			String categoryName)
	{
		NodeList nodeList = null;
		try {
			nodeList = XPathAPI.selectNodeList( root, "//"+categoryName);
			int index = 0;
			int length = nodeList.getLength();

			for (index = 0; index < length; index++)
			{
				Node nodeToRemove = nodeList.item(index);
				Element link = (Element)nodeList.item( index );

				if (link.getAttributeNode(attributeName) != null
						&& link.getAttributeNode(attributeName).getValue().equals(valueToDelete))
				{
					nodeToRemove.getParentNode().removeChild(nodeToRemove);
				}
			}
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		}catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}
	}

	public Node removeSpecifiedNode(Node targetNode, String url) {
		return null;
	}

	public Node selectSingleNode(String nodeName, String idValue) {
		Node node = null;
		try {
			node = XPathAPI.selectSingleNode( root, "//"+nodeName +"[@id='" + idValue + "']/related_projects");
		} catch (Exception e) {
			_log.debug("node not found &&&&&& " + e.getMessage());
		}

		return node;
	}

	public Node setRelatedProjects(String nodeValue) throws TransformerException {

		Node node = doc.createElement("relatedProjects");
		node.setTextContent("nodeValue");

		return node;
	}

	/**
	 * Converts an Element Node or Document into its text representation
	 * <p>
	 * Converts either the SubTree designated by an Element node or an
	 * entire tree, specified by a Document object into an XML Text
	 * representation.
	 * @param node     The DOM node (doc or element) to convert
	 * @return        The input string's representation
	 **/
	public String toString(Node node) throws Exception
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		DOMImplementation domImpl = doc.getImplementation();
		DOMImplementationLS factory = (DOMImplementationLS)domImpl;

		LSOutput output = factory.createLSOutput();
		output.setByteStream(baos);

		LSSerializer serializer = factory.createLSSerializer();
		serializer.write(doc, output);

		return baos.toString();
	}

	public void updateXml(String resultXML) throws Exception {

		BufferedOutputStream bufferedOutput = null;
		try
		{

			// Open or create the output file

			bufferedOutput = new BufferedOutputStream(new FileOutputStream(resultXML));
			byte data[] = toString( doc ).getBytes();
			bufferedOutput.write(data);
			bufferedOutput.close();
		}
		catch (FileNotFoundException ex) {
			_log.debug(ex.getMessage());
		} catch (IOException ex) {
			_log.debug(ex.getMessage());
		} finally {
			//Close the BufferedOutputStream
			try {
				if (bufferedOutput != null) {
					bufferedOutput.flush();
					bufferedOutput.close();
				}
			} catch (IOException ex) {
				_log.debug(ex.getMessage());
			}
		}
	}

	public void updateXmlWithSortedXml(String sortedXml, String categoryName) throws Exception {
		try {
			Document doc = root.getOwnerDocument();
			Node sortedNode = XPathAPI.selectSingleNode(root, "//"+categoryName);
			root.removeChild(sortedNode);
			int start = sortedXml.indexOf("<workhistory>");
			//int end = sortedXml.lastIndexOf("</workhistory>");
			String xmlToAppend = sortedXml.substring(start);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
			Node fragmentNode = docBuilder.parse(
				new InputSource(new StringReader(xmlToAppend.trim())))
				.getDocumentElement();
				fragmentNode = doc.importNode(fragmentNode, true);

			root.appendChild(fragmentNode);
		} catch (TransformerException e) {
			_log.debug("Error on updateXmlWithSortedXml: " + e.getMessage());
		}catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(XMLManipulator.class);

}