package com.sambaash.platform.pe.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Unmarshalling {
	public static void main(String[] args) {

		try {

			File file = new File("processDefinition.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Process.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Process process = (Process) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
		}
	}

}