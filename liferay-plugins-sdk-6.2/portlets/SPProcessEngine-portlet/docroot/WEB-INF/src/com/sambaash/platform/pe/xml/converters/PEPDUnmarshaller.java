package com.sambaash.platform.pe.xml.converters;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.pe.jaxb.PEProcessDefinition;

import java.io.File;
import java.io.StringReader;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class PEPDUnmarshaller {

	public static Map<String, Object> unmarshall(String xml) throws JAXBException {
		try {

			Map<String, Object> result = new HashMap<>();
			// File file = new File("processDefinition.xml");
			StringReader reader = new StringReader(xml);
			JAXBContext jaxbContext = JAXBContext.newInstance(PEProcessDefinition.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			PEPDUnmarshalListener listener = new PEPDUnmarshalListener();
			unmarshaller.setListener(listener);
			PEProcessDefinition pd = (PEProcessDefinition) unmarshaller.unmarshal(reader);

			result.put("pd", pd);
			result.put("nodedir", listener.getNodeDir());
			return result;

		} catch (JAXBException e) {
			throw e;
		}
	}

	public static void main(String a[]) {
		try {

			File file = new File("processDefinition.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(PEProcessDefinition.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			PEPDUnmarshalListener listener = new PEPDUnmarshalListener();
			unmarshaller.setListener(listener);
			PEProcessDefinition process = (PEProcessDefinition) unmarshaller.unmarshal(file);

		} catch (JAXBException e) {
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PEPDUnmarshaller.class);

}