package com.sambaash.gu.custom.uploader;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.gu.helper.GUException;
import com.sambaash.platform.model.AddressMap;
import com.sambaash.platform.model.SPAddress;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashHtmlUtil;

public class XMLManipulator {

	Element root = null;
	Document doc = null;

	/**
	 * Returns the contents of all immediate child text nodes, can strip
	 * whitespace
	 * <p>
	 * Takes a node as input and merges all its immediate text nodes into a
	 * string. If the strip whitespace flag is set, whitespace at the beggining
	 * and end of each merged text node will be removed
	 *
	 * @param node
	 *            node to extract text contents of
	 * @param b_strip_whitespace
	 *            flag to set whitespace removal
	 * @return string containing text contents of the node
	 **/
	public static String getTextContents(Node node) {
		NodeList childNodes;
		StringBuffer contents = new StringBuffer();

		childNodes = node.getChildNodes();

		for (int i = 0; i < childNodes.getLength(); i++) {
			if (childNodes.item(i).getNodeType() == Node.TEXT_NODE) {
				contents.append(childNodes.item(i).getNodeValue()).append(
						StringPool.COMMA);
			}
		}

		return contents.toString();
	}

	public static void removeAll(Node node, short nodeType, String name) {
		if (node.getNodeType() == nodeType
				&& (name == null || node.getNodeName().equals(name))) {
			node.getParentNode().removeChild(node);
		} else {
			NodeList list = node.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {
				removeAll(list.item(i), nodeType, name);
			}
		}
	}

	public XMLManipulator() {
		String filepath = StringPool.BLANK;
		filepath = "/Development/viewprofile.xml";
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

	public Node appendNode(String name, String xql) {
		Node targetNode = null;
		try {
			targetNode = XPathAPI.selectSingleNode(root, xql);
			Document doc = root.getOwnerDocument();

			Element newElement = doc.createElement(name);
			targetNode.appendChild((Node) newElement);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return targetNode;
	}

	public Node appendNodeWithValue(String nodeName, String nodeValue,
			String xql) {
		Node targetNode = null;
		try {
			targetNode = XPathAPI.selectSingleNode(root, xql);
			Document doc = root.getOwnerDocument();

			Element newElement = doc.createElement(nodeName);
			targetNode.appendChild((Node) newElement).setTextContent(
					SambaashHtmlUtil.escape(nodeValue));

		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return targetNode;
	}

	/**
	 * append a set of xml at the specified location in the document
	 * <p>
	 * Takes a context node, the name of the xml template, and an XPath
	 * expression. The xml template is appended to the document at the point
	 * specified by the context node and the XPath statement
	 *
	 * @param startNode
	 *            context node on which to evaluate the xpath
	 * @param template
	 *            the name of the xml template
	 * @param xql
	 *            the XPath expression
	 * @return Returns the newly appended node
	 **/

	public Node appendXml(String xql, String template) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = factory.newDocumentBuilder();
			Document docA = docBuilder.parse(new InputSource(new StringReader(
					template)));
			doc = root.getOwnerDocument();
			Node targetNode = XPathAPI.selectSingleNode(root, xql);
			Element rootA = docA.getDocumentElement();
			targetNode.appendChild(doc.importNode(rootA, true));
			return targetNode;
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return null;
	}

	public Node appendXmlWithId(String xql, String template, String id) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = factory.newDocumentBuilder();
			Document docA = docBuilder.parse(new InputSource(new StringReader(
					template)));
			Element rootA = docA.getDocumentElement();
			rootA.setAttribute("id", id);

			doc = root.getOwnerDocument();
			Node targetNode = XPathAPI.selectSingleNode(root, xql);
			targetNode.appendChild(doc.importNode(rootA, true));
			return targetNode;
		} catch (Exception e) {
			_log.debug(e);
		}

		return null;
	}

	public void cleanupXML() {
		// 1. cleanup duplicate other details node
		try {
			NodeList otherDetails = findNodeList("//profile/other_details");

			if (Validator.isNotNull(otherDetails)) {
				int odSize = otherDetails.getLength();

				if (odSize > 1) {// if more than 1 node, delete the rest

					for (int i = 0; i < odSize; i++) {
						Node nodeToRemove = otherDetails.item(i);
						NodeList childList = nodeToRemove.getChildNodes();

						if (Validator.isNull(childList)
								|| childList.getLength() == 0) {
							nodeToRemove.getParentNode().removeChild(
									nodeToRemove);
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		// 2. cleanup duplicate network details node
		try {
			NodeList networkDetails = findNodeList("//profile/network_info/*");
			if (Validator.isNotNull(networkDetails)) {
				int s = networkDetails.getLength();

				for (int i = 0; i < s; i++) {
					Node nodeToRemove = networkDetails.item(i);
					Element link = (Element) networkDetails.item(i);

					if (link.getAttributeNode("fieldType") != null)// remove
																	// duplicate
																	// node w/
																	// attribute
																	// fieldType
																	// (system
																	// field
																	// should
																	// not have
																	// attributes)
					{
						nodeToRemove.getParentNode().removeChild(nodeToRemove);
					}
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}
	
	public void cleanupXMLNetworkInfo() {
		// 2. cleanup duplicate network details node
		try {
			NodeList networkDetails = findNodeList("//profile/network_info/*");
			if (Validator.isNotNull(networkDetails)) {
				int s = networkDetails.getLength();

				for (int i = 0; i < s; i++) {
					Node nodeToRemove = networkDetails.item(i);
					while (nodeToRemove.hasChildNodes()) {
						nodeToRemove.removeChild(nodeToRemove.getFirstChild());
					}
					
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
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
	
	public NodeList getXSLNodes() {
		Document doc;
		NodeList list = null;
		try {
			doc = root.getOwnerDocument();
			list = doc.getElementsByTagName("*");
		} catch (Exception e) {
			_log.debug(e.getMessage());
		}

		return list;
	}

	public Node createSpecifiedNode(Node targetNode, String url) {
		if (Validator.isNotNull(url)) {
			Node newNode = doc.createElement("project");
			Node urlNode = doc.createElement("url");
			urlNode.setTextContent(url);
			newNode.appendChild(urlNode);
			return newNode;
		} else {
			return null;
		}
	}

	/**
	 * Find matching node values If no matching node, then create one i.e.
	 * <messenger> <messenger_url><name/><value/></messenger_url></messenger>
	 * 
	 * @param xql
	 * @param node
	 * @param name
	 * @param value
	 * @throws UserProfileException
	 * @throws Exception
	 */
	public Node appendNodeNameValue(String xql, String nodeName, String name,
			String value) throws UserProfileException {

		Node targetNode = null;

		if (Validator.isNotNull(value)) {
			NodeList nodes = findNodeList(xql + "/" + nodeName);

			for (int i = 0; i < nodes.getLength(); i++) {
				Node childNode = nodes.item(i);
				String key = childNode.getNodeName();
				String val = childNode.getTextContent().trim();

				if (!key.equals("#text")) {
					if (val.equals(name + value)) {
						throw new UserProfileException("Duplicate network info");
					}
				}
			}

			try {
				targetNode = XPathAPI.selectSingleNode(root, xql);
				String id = nodeName + StringPool.BLANK
						+ (countXmlNode(nodeName) + 1);
				Element newElement = doc.createElement(nodeName);
				newElement.setAttribute("id", id);

				Node nameNode = doc.createElement("name");
				Node valNode = doc.createElement("value");
				nameNode.setTextContent(name);
				valNode.setTextContent(value);

				newElement.appendChild(nameNode);
				newElement.appendChild(valNode);
				targetNode.appendChild((Node) newElement);
			} catch (TransformerException e) {
				_log.debug(e.getMessage(), e);
			} catch (Exception e) {
				_log.debug(e.getMessage(), e);
			}
		}

		return targetNode;
	}

	public void findAndAddNodeWithValue(String category,
			String categoryDetails, String node, String value,
			Map<String, String> attributes) {
		if (Validator.isNotNull(node)) {
			String xql = category;
			String nodeName = node.trim().toLowerCase();
			NodeList nodeInstance = null;
			try {
				if (Validator.isNotNull(categoryDetails)) {
					xql += "/" + categoryDetails;
				}

				nodeInstance = findNodeList("//" + xql + "/" + nodeName); // find
																			// existing
																			// instances
																			// of
																			// nodeName
			} catch (Exception e) {
				_log.debug(e.getMessage(), e);
			}

			if (Validator.isNull(nodeInstance) || nodeInstance.getLength() == 0) { // check
																					// if
																					// node
																					// doesn't
																					// exists
				try {

					// append new node
					NodeList targetNodeList = findNodeList("//" + xql);

					if (Validator.isNotNull(targetNodeList)) {
						for (int i = 0; i < targetNodeList.getLength(); i++) {
							Node targetNode = targetNodeList.item(i);

							if (targetNode.getNodeType() == Node.ELEMENT_NODE) {
								Document doc = root.getOwnerDocument();
								Element newElement = doc.createElement(nodeName
										.replaceAll("( )+", "_"));

								String fieldType = attributes.get("fieldType");

								newElement.setAttribute("fieldType", fieldType);
								newElement.setAttribute("mandatory",
										attributes.get("mandatory"));
								newElement.setAttribute("maxLen",
										attributes.get("maxLen"));
								newElement.setAttribute("validation",
										attributes.get("validation"));
								newElement.setAttribute("edittable",
										attributes.get("edittable"));
								newElement.setAttribute("default",
										attributes.get("default"));
								newElement.setAttribute("label",
										attributes.get("label"));

								if (fieldType.equals("Dropdown")
										|| fieldType.equals("Radio")
										|| fieldType.equals("MultipleList")) {
									newElement.setAttribute("optionId",
											attributes.get("options"));// vocabularyId
								}

								targetNode.appendChild((Node) newElement)
										.setTextContent(
												SambaashHtmlUtil.escape(value));// set
																				// new
																				// node
																				// with
																				// default
																				// value
							}
						}

						_log.debug("New field successfully added: " + nodeName);
					}
				} catch (Exception e) {
					_log.debug("Unable to append node with value: "
							+ e.getMessage());
				}
			} else { // update existing node
				_log.debug("The same node already exists: " + node);

				for (int i = 0; i < nodeInstance.getLength(); i++) {
					Node instance = nodeInstance.item(i);

					if (instance.getNodeType() == Node.ELEMENT_NODE) {
						Element updateEl = (Element) instance;

						if (Validator.isNotNull(updateEl
								.getAttribute("fieldType"))) {// update only the
																// node with
																// attribute
																// "fieldtype"
							String fieldType = attributes.get("fieldType");
							updateEl.setAttribute("fieldType", fieldType);
							updateEl.setAttribute("mandatory",
									attributes.get("mandatory"));
							updateEl.setAttribute("maxLen",
									attributes.get("maxLen"));
							updateEl.setAttribute("validation",
									attributes.get("validation"));
							updateEl.setAttribute("edittable",
									attributes.get("edittable"));
							updateEl.setAttribute("default",
									attributes.get("default"));
							updateEl.setAttribute("label",
									attributes.get("label"));

							if (fieldType.equals("Dropdown")
									|| fieldType.equals("Radio")
									|| fieldType.equals("MultipleList")) {
								updateEl.setAttribute("optionId",
										attributes.get("options"));// vocabularyId
							}

							_log.debug("Node successfully updated: " + node);
						}

						if (Validator.isNull(updateEl.getTextContent())) {
							updateEl.setTextContent(SambaashHtmlUtil
									.escape(value)); // update default value
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
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return node;
	}

	

	public Node appendNodeWithIdValue(String nodeName, String nodeValue,
			String xql) throws UserProfileException {
		Node targetNode = null;

		if (Validator.isNotNull(nodeValue)) {
			// check if value already exists, then dont add node
			NodeList nodes = findNodeList(xql + "/" + nodeName);

			if (Validator.isNotNull(nodes)) {
				for (int i = 0; i < nodes.getLength(); i++) {
					Node childNode = nodes.item(i);
					String key = childNode.getNodeName();
					String value = childNode.getTextContent().trim();

					if (!key.equals("#text")) {
						if (UserProfileUtil.getDomainNameFromUrl(nodeValue)
								.equals(UserProfileUtil
										.getDomainNameFromUrl(value))) {
							throw new UserProfileException(
									"Duplicate network info");
						}
					}
				}
			}

			try {
				targetNode = XPathAPI.selectSingleNode(root, xql);

				String id = nodeName + StringPool.BLANK
						+ (countXmlNode(nodeName) + 1);
				Element newElement = doc.createElement(nodeName);
				newElement.setAttribute("id", id);
				targetNode.appendChild((Node) newElement).setTextContent(
						SambaashHtmlUtil.escape(nodeValue));
			} catch (TransformerException e) {
				_log.debug(e.getMessage(), e);
			} catch (Exception e) {
				_log.debug(e.getMessage(), e);
			}
		}

		return targetNode;
	}

	public NodeList findNodeList(String xpath) {
		NodeList nodes = null;
		try {
			doc = root.getOwnerDocument();
			doc.normalizeDocument();
			nodes = XPathAPI.selectNodeList(root, xpath);
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return nodes;
	}

	public void findUpdateNameValue(String xql, String node, String name,
			String value) {

		if (Validator.isNotNull(value)) {
			NodeList nodeInstance;
			try {
				nodeInstance = XPathAPI.selectNodeList(root, xql
						+ "[contains(.,'" + value + "')]");

				if (nodeInstance == null || nodeInstance.getLength() == 0) {
					appendNodeWithValue("name", name, xql);
					appendNodeWithValue("value", value, xql);
				}
			} catch (TransformerException e) {
				_log.debug(e.getMessage(), e);
			} catch (Exception e) {
				_log.debug(e.getMessage(), e);
			}
		}
	}

	/**
	 * Find matching node values If no matching node, then create a new one
	 * 
	 * @param xql
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void findUpdateNodeValue(String xql, String node, String value) {

		if (Validator.isNotNull(value)) {
			NodeList nodeInstance = null;
			try {
				nodeInstance = XPathAPI.selectNodeList(root, xql + "/" + node
						+ "[contains(.,'" + value.toLowerCase() + "')]");
			} catch (TransformerException e) {
				_log.debug(e.getMessage(), e);
			} catch (Exception e) {
				_log.debug(e.getMessage(), e);
			}

			if (nodeInstance == null || nodeInstance.getLength() == 0) { // check
																			// if
																			// value
																			// doesn't
																			// exists
				try {
					appendNodeWithIdValue(node, value, xql);
				} catch (Exception e) {
					_log.debug("Unable to append node with value: "
							+ e.getMessage());
				} // then add new node with value
			}
		}
	}

	/**
	 * Returns the text contents of the first node mathcing an XPath expression
	 * <p>
	 * Takes a context node and an xpath expression and finds a matching node.
	 * The text contents of this node are returned as a string
	 *
	 * @param node
	 *            context node at which to eval xpath
	 * @param xql
	 *            XPath expression
	 * @return Text contents of matching node
	 * @throws Exception
	 **/
	public String findValue(String xql) throws Exception {

		if (Validator.isNull(xql)) {
			throw new Exception("findValue called with empty xql statement");
		}

		try {
			return getTextContents(XPathAPI.selectSingleNode(root, xql));
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return StringPool.BLANK;
	}

	public AddressMap getAddressDetails(String category) {
		NodeList nodes = null;
		AddressMap addressMap = null;

		try {
			nodes = XPathAPI.selectNodeList(root, "//" + category + "/"
					+ category + "_details");

			for (int i = 0; i < nodes.getLength(); i++) {
				if (addressMap == null) {
					addressMap = new AddressMap();
				}

				Node targetNode = nodes.item(i);
				Element el = (Element) nodes.item(i);
				String addressId = el.getAttributeNode("id").getValue();

				SPAddress address = new SPAddress();
				address.setAddressId(Long.valueOf(addressId));

				NodeList addressDetails = targetNode.getChildNodes();

				for (int j = 0; j < addressDetails.getLength(); j++) {
					Node details = addressDetails.item(j);

					if ("first_name_1".equalsIgnoreCase(details.getNodeName())) {
						address.setFirstName(details.getTextContent());
					} else if ("last_name_2".equalsIgnoreCase(details
							.getNodeName())) {
						address.setLastName(details.getTextContent());
					} else if ("street_address_3".equalsIgnoreCase(details
							.getNodeName())) {
						address.setStreetAddress(details.getTextContent());
					} else if ("postal_code_4".equalsIgnoreCase(details
							.getNodeName())) {
						address.setPostalCode(details.getTextContent());
					} else if ("city_5".equalsIgnoreCase(details.getNodeName())) {
						address.setCity(details.getTextContent());
					} else if ("country_6".equalsIgnoreCase(details
							.getNodeName())) {
						address.setCountry(details.getTextContent());
					} else if ("phone_7"
							.equalsIgnoreCase(details.getNodeName())) {
						address.setPhone(details.getTextContent());
					} else if ("default_shipping_address_8"
							.equalsIgnoreCase(details.getNodeName())) {
						address.setDefaultShippingAddress(StringPool.TRUE
								.equalsIgnoreCase(details.getTextContent()) ? true
								: false);
					} else if ("default_billing_address_9"
							.equalsIgnoreCase(details.getNodeName())) {
						address.setDefaultBillingAddress(StringPool.TRUE
								.equalsIgnoreCase(details.getTextContent()) ? true
								: false);
					}
				}

				addressMap.addAddress(address);
			}

		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return addressMap;
	}

	/**
	 * append a node with the given name at the specified location in the
	 * document
	 * <p>
	 * Takes a context node, the name of the new node, and an XPath expression.
	 * The new node is appended to the document at the point specified by the
	 * context node and the XPath statement
	 *
	 * @param startNode
	 *            context node on which to evaluate the xpath
	 * @param name
	 *            the name of the new node
	 * @param xql
	 *            the XPath expression
	 * @return Returns the newly appended node
	 **/

	public Map<String, String> getCompanyNameAndId(String nodeName)
			throws Exception {

		Node targetNode = null;
		NodeList parentNode = null;
		String xql = "//" + nodeName;
		int count = countXmlNode(nodeName);
		String companyName = StringPool.BLANK;
		String companyId = StringPool.BLANK;
		Map<String, String> workDetails = new HashMap<String, String>();
		try {
			parentNode = XPathAPI.selectNodeList(root, xql);

			for (int i = 1; i <= count; i++) {
				targetNode = parentNode.item(i - 1);
				Element newNode = (Element) targetNode.getParentNode();

				if (!StringPool.BLANK.equalsIgnoreCase(newNode
						.getAttribute("id"))) {
					if (companyId.length() == 0) {
						companyId += newNode.getAttribute("id");
					} else {
						companyId += "," + newNode.getAttribute("id");
					}
				}

				if (!StringPool.BLANK.equalsIgnoreCase(targetNode
						.getTextContent())) {
					if (companyName.length() == 0) {
						companyName += targetNode.getTextContent();
					} else {
						companyName += "," + targetNode.getTextContent();
					}
				}
			}

			workDetails.put("JobId", companyId);
			workDetails.put("CompanyName", companyName);
		} catch (Exception e) {
			_log.debug("WorkHistory details not found " + e.getMessage());
		}

		return workDetails;
	}

	public String getDefault(String nodeName) {
		String value = StringPool.BLANK;
		try {
			String xPath = "//" + nodeName;

			Node node = XPathAPI.selectSingleNode(root, xPath);

			if (Validator.isNotNull(node)) {
				value = node.getFirstChild().getNodeValue();
			}
		} catch (Exception e) {
			_log.debug(e.getMessage());
		}

		return value;
	}

	public Map<String, String> getNameValueNodeAsMap(String xpath)
			throws Exception {
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
					nodeMap.put("msgr" + id, strNameValue);

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

				if (!key.equals("#text")) {
					nodeMap.put(key + i, value);
				}
			}
		}

		return nodeMap;
	}

	public NodeList getNodeList(String nodeName) {
		// Document doc = root.getOwnerDocument();
		NodeList nodeList = null;
		try {
			ClassLoader a = PortalClassLoaderUtil.getClassLoader();
			ClassLoader b = PortletClassLoaderUtil.getClassLoader();

			_log.debug("a : " + a.toString());
			_log.debug("b : " + b.toString());

			nodeList = XPathAPI.selectNodeList(root, "//" + nodeName);
		} catch (Exception e) {

			// TODO Auto-generated catch block

			_log.debug("nodelist not found " + e.getMessage());
		}

		return nodeList;
	}

	/**
	 * Remove all nodes of the particular nodeName
	 * 
	 * @param xql
	 * @param node
	 * @return
	 * @throws Exception
	 */
	public NodeList removeAllNodes(String nodeName) {
		NodeList tNode = null;
		try {
			doc = root.getOwnerDocument();
			doc.normalizeDocument();
			tNode = XPathAPI.selectNodeList(root, nodeName);

			for (int i = 0; i < tNode.getLength(); i++) {
				Node targetNode = tNode.item(i);
				while (targetNode.hasChildNodes()) {
					targetNode.removeChild(targetNode.getFirstChild());
				}

				targetNode.getParentNode().removeChild(targetNode);
			}

		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return tNode;
	}

	/**
	 * Remove all nodes of the particular category
	 * 
	 * @param xql
	 * @param node
	 * @return
	 * @throws Exception
	 */
	public NodeList removeAllNodes(String category, String nodeName) {
		NodeList tNode = null;
		try {
			doc = root.getOwnerDocument();
			doc.normalizeDocument();
			tNode = XPathAPI.selectNodeList(root, category + "/" + nodeName);

			for (int i = 0; i < tNode.getLength(); i++) {
				Node targetNode = tNode.item(i);
				while (targetNode.hasChildNodes()) {
					targetNode.removeChild(targetNode.getFirstChild());
				}

				targetNode.getParentNode().removeChild(targetNode);
			}

		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return tNode;
	}

	public NodeList removeChildNodes(String category) {
		NodeList tNode = null;
		try {
			doc = root.getOwnerDocument();
			doc.normalizeDocument();
			tNode = XPathAPI.selectNodeList(root, category);
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		if (Validator.isNotNull(tNode)) {
			for (int i = 0; i < tNode.getLength(); i++) {
				Node nodeToRemove = (Node) tNode.item(i);
				while (nodeToRemove.hasChildNodes()) {
					nodeToRemove.removeChild(nodeToRemove.getFirstChild());
				}
			}
		}

		return tNode;
	}

	/**
	 * adds a new attribute for removal at a specified set of xml/node from the
	 * specified location in the document
	 * <p>
	 * Takes a context node, the count/instance of childnode to be removed, and
	 * an XPath expression. The childnode is attached to a new attribute at the
	 * point specified by the context node and the XPath statement
	 *
	 * @param startNode
	 *            /root context node on which to evaluate the xpath
	 * @param count
	 *            the instance number of the child node to be removed
	 * @param xql
	 *            the XPath expression
	 * @return Returns the new node with attached attribute
	 **/

	public Node removeNode(String xql, int instance, String node) {
		Node targetNode = null;
		NodeList tNode = null;
		try {
			doc = root.getOwnerDocument();
			doc.normalizeDocument();

			tNode = XPathAPI.selectNodeList(root, xql + "/" + node);
			targetNode = tNode.item(instance - 1);
			targetNode.getParentNode().removeChild(targetNode);
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		return targetNode;
	}

	/**
	 * Remove a node using an attribute value
	 * 
	 * @param attributeName
	 * @param valueToDelete
	 * @param categoryName
	 * @throws TransformerException
	 */
	public void removeNodeByAttributeValue(String attributeName,
			String valueToDelete, String categoryName) {
		NodeList nodeList = null;
		try {
			nodeList = XPathAPI.selectNodeList(root, "//" + categoryName);
			int index = 0;
			int length = nodeList.getLength();

			for (index = 0; index < length; index++) {
				Node nodeToRemove = nodeList.item(index);
				Element link = (Element) nodeList.item(index);

				if (link.getAttributeNode(attributeName) != null
						&& link.getAttributeNode(attributeName).getValue()
								.equals(valueToDelete)) {
					nodeToRemove.getParentNode().removeChild(nodeToRemove);
				}
			}
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}
	}

	public Node removeSpecifiedNode(Node targetNode, String url) {
		return null;
	}

	public Node selectSingleNode(String nodeName, String idValue) {
		Node node = null;
		try {
			node = XPathAPI.selectSingleNode(root, "//" + nodeName + "[@id='"
					+ idValue + "']/related_projects");
		} catch (Exception e) {
			_log.debug("node not found &&&&&& " + e.getMessage());
		}

		return node;
	}
	
	public Node selectNode(String categoryName, String categoryDetail) {
		Node node = null;
		try {
			node = XPathAPI.selectSingleNode(root, "//" + categoryName + "/" + categoryDetail);
		} catch (Exception e) {
			_log.debug("node not found &&&&&& " + e.getMessage());
		}
		return node;
	}
	public String createXml( String categoryName, String categoryDetails)
			throws SystemException, Exception {
		Node node = null;
		String _instance = String.valueOf(new Date().getTime());
		
		if (Validator.isNotNull(categoryName) && Validator.isNotNull(categoryDetails)) {
			String xmlFile = "";
			SPParameter parameter = null;

			// XMLManipulator manipulator = new XMLManipulator(userXml);

			String attr = findNodeById(categoryName + StringPool.SLASH + categoryDetails, "id", _instance);

			if (Validator.isNull(attr)) {
				attr = findNodeById("other_details" + StringPool.SLASH + categoryName + StringPool.SLASH
						+ categoryDetails, "id", _instance);
			}

			if (Validator.isNull(attr)) { // create new node
				try {
					parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0, categoryName
							+ ".xml.template");
					xmlFile = parameter.getDescription();
				} catch (NoSuchSPParameterException e1) {
					throw new GUException("Xml template not found.Looks reloading has not been done. ");
				}

				String mNode = "//profile";

				if (!(categoryName.startsWith("personal_info") || categoryName.startsWith("basic_info")
						|| categoryName.startsWith("availability_info") || categoryName.startsWith("network_info") || categoryName
							.startsWith("contact_info"))) {
					if (Validator.isNull(findNode("//profile/other_details"))) {
						appendNode("other_details", mNode);
					}

					mNode = "//other_details";
				}

				node = appendXmlWithId(categoryName, xmlFile, _instance);
				if (node == null) {
					_log.error("Can't find nodeId so it will add in otherDetails");
					if (Validator.isNull(findNode(mNode + "/" + categoryName))) {
						appendNode(categoryName, mNode);
					}
					node = appendXmlWithId(mNode + "/" + categoryName, xmlFile, _instance);

				}
			}
		}
		return _instance;
	}
	
	public String findNodeById(String xql, String idName, String idValue) {
		// Document doc = root.getOwnerDocument();
		NodeList nodeList = null;
		try {
			nodeList = XPathAPI.selectNodeList(root, "//" + xql);
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}

		String foundNode = null;

		if (Validator.isNotNull(nodeList)) {
			int length = nodeList.getLength();

			for (int i = 0; i < length; i++) {
				Element link = (Element) nodeList.item(i);
				Attr a = link.getAttributeNode(idName);

				if (Validator.isNotNull(a)) {
					String attr = link.getAttributeNode(idName)
							.getTextContent();

					if (attr.equalsIgnoreCase(idValue)) {
						foundNode = attr;
					}
				}
			}
		}

		return foundNode;
	}
	
	public Node selectNode(String xql) {
		Node targetNode = null;
		try {
			targetNode = XPathAPI.selectSingleNode(root, xql);
		} catch (Exception e) {
			_log.error(e);
		}

		return targetNode;
	}

	/** Set node value for contact info **/

	public Node setNodeValue(String value, String xql) {
		Node targetNode = null;
		try {
			targetNode = XPathAPI.selectSingleNode(root, xql);

			// Add in the new value

			if (!targetNode.getNodeName().equalsIgnoreCase("related_projects")) {
				if (value.equals("empty")) {
					value = StringPool.BLANK;
				}

				targetNode.setTextContent(SambaashHtmlUtil.escape(value));
			}
		} catch (Exception e) {
			_log.debug("node not found " + e.getMessage());
		}

		return targetNode;
	}

	/** set node value for networkinformation **/

	public Node setNodeValue(String value, String xql, String categoryName,
			int j, int instance) {
		NodeList nodeList = null;
		Node nodeToRemove = null;
		Node targetNode = null;

		try {
			targetNode = XPathAPI.selectSingleNode(root, xql);
			nodeList = XPathAPI.selectNodeList(root, xql + "/" + categoryName
					+ "_url");

			int index = 0;
			int length = nodeList.getLength();

			// Remove all of the current contents

			if (j == 1) {
				for (index = 0; index < length; index++) {
					nodeToRemove = nodeList.item(index);
					nodeToRemove.getParentNode().removeChild(nodeToRemove);
				}
			}

			// Add in the new value

			String tagName = categoryName + "_url";
			String imName = StringPool.BLANK;
			String imValue = StringPool.BLANK;

			if (value.equals("empty")) {
				value = StringPool.BLANK;
			}

			if (categoryName.equalsIgnoreCase("messenger")) {
				String[] valArr = value.trim().split(":");
				int i = valArr.length;

				if (i > 1) {
					imName = valArr[0].trim();
					imValue = valArr[1].trim();
				}
			}

			Node node = doc.createElement(tagName);

			if (Validator.isNotNull(value)) {
				if (categoryName.equalsIgnoreCase("messenger")) {
					Node nameNode = doc.createElement("name");
					Node valNode = doc.createElement("value");
					nameNode.setTextContent(imName);
					valNode.setTextContent(imValue);
					node.appendChild(nameNode);
					node.appendChild(valNode);
					targetNode.appendChild(node);

				} else {
					node.setTextContent(SambaashHtmlUtil.escape(value));
					targetNode.appendChild(node);
				}
			}
		} catch (Exception e) {
			_log.debug("node not found " + e.getMessage());
		}

		return nodeToRemove;
	}

	/** set node value for workhistory **/

	public Node setNodeValue(String value, String xql, String tagId,
			int instance, String userId) {
		Node targetNode = null;
		NodeList parentNode = null;
		try {
			parentNode = XPathAPI.selectNodeList(root, xql);

			if (instance == 1) {
				targetNode = parentNode.item(0);
			} else {
				targetNode = parentNode.item(instance - 1);
			}

			if (Validator.isNotNull(value)) {
				if (value.equals("empty"))
					value = StringPool.BLANK;
				targetNode.setTextContent(SambaashHtmlUtil.escape(value));
			}

		} catch (Exception e) {
			_log.debug("node not found " + e.getMessage());
		}

		return targetNode;
	}

	public Node setRelatedProjects(String nodeValue)
			throws TransformerException {

		Node node = doc.createElement("relatedProjects");
		node.setTextContent("nodeValue");

		return node;
	}

	/**
	 * finds a node based on an XPath expression and sets the text contents of
	 * it
	 * <p>
	 * Takes a context node and an XPath expression. The matching node gets a
	 * text node appending containing the contents of the value string. The node
	 * matching the XPath expression is returned
	 *
	 * @param startNode
	 *            context node on which to evaluate the xpath
	 * @param value
	 *            the text to add to the matched node
	 * @param xql
	 *            the XPath expression
	 * @return Returns the matched node
	 **/
	public Node setValue(String value, String xql) {
		Node targetNode = null;
		try {
			targetNode = XPathAPI.selectSingleNode(root, xql);
			NodeList children = targetNode.getChildNodes();
			int index = 0;
			int length = children.getLength();

			// Remove all of the current contents

			for (index = 0; index < length; index++) {
				targetNode.removeChild(children.item(index));
			}

			// Add in the new value

			Document doc = root.getOwnerDocument();
			targetNode.appendChild(doc.createTextNode(SambaashHtmlUtil
					.escape(value)));

		} catch (TransformerException e) {
			_log.error(e.getMessage());
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return targetNode;
	}

	/**
	 * Converts an Element Node or Document into its text representation
	 * <p>
	 * Converts either the SubTree designated by an Element node or an entire
	 * tree, specified by a Document object into an XML Text representation.
	 * 
	 * @param node
	 *            The DOM node (doc or element) to convert
	 * @return The input string's representation
	 **/
	public String toString(Node node) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		DOMImplementation domImpl = doc.getImplementation();
		DOMImplementationLS factory = (DOMImplementationLS) domImpl;

		LSOutput output = factory.createLSOutput();
		output.setByteStream(baos);

		LSSerializer serializer = factory.createLSSerializer();
		serializer.write(doc, output);

		return baos.toString();
	}

	public void updateXml(String resultXML) throws Exception {

		BufferedOutputStream bufferedOutput = null;
		try {

			// Open or create the output file

			bufferedOutput = new BufferedOutputStream(new FileOutputStream(
					resultXML));
			byte data[] = toString(doc).getBytes();
			bufferedOutput.write(data);
			bufferedOutput.close();
		} catch (FileNotFoundException ex) {
			_log.debug(ex.getMessage());
		} catch (IOException ex) {
			_log.debug(ex.getMessage());
		} finally {
			// Close the BufferedOutputStream
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

	public void updateXmlWithSortedXml(String sortedXml, String categoryName)
			throws Exception {
		try {
			Document doc = root.getOwnerDocument();
			Node sortedNode = XPathAPI.selectSingleNode(root, "//"
					+ categoryName);
			root.removeChild(sortedNode);
			int start = sortedXml.indexOf("<workhistory>");
			// int end = sortedXml.lastIndexOf("</workhistory>");
			String xmlToAppend = sortedXml.substring(start);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			Node fragmentNode = docBuilder.parse(
					new InputSource(new StringReader(xmlToAppend.trim())))
					.getDocumentElement();
			fragmentNode = doc.importNode(fragmentNode, true);

			root.appendChild(fragmentNode);
		} catch (TransformerException e) {
			_log.debug("Error on updateXmlWithSortedXml: " + e.getMessage());
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(XMLManipulator.class);

}