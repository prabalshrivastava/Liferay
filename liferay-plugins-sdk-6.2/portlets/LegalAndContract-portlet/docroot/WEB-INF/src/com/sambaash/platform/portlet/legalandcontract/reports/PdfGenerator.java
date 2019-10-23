package com.sambaash.platform.portlet.legalandcontract.reports;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.QName;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PdfGenerator extends ReportGenerator {

	private static Log logger = LogFactoryUtil.getLog(PdfGenerator.class);

	private String type;
	private String rootTag;
	private String fontBase;

	public PdfGenerator(String type, String rootTag, String fontBase) {
		this.type = type;
		this.rootTag = rootTag;
		this.fontBase = fontBase;
	}

	private byte[] generatePdf(Object object) throws Exception {
		try {
			if(!this.fontBase.endsWith("/"))
				this.fontBase += "/";
			
			File xsltfile = new File(this.fontBase + this.type + ".xsl");
			String xml = convertToXml(object, this.rootTag);
			
			// initialize fop
			FopFactory fopFactory = FopFactory.newInstance();
			DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
//			File file = new File("fop.xconf");
			Configuration cfg = cfgBuilder.buildFromFile(new File(this.fontBase + "fop.xconf"));
			fopFactory.getFontManager().setFontBaseURL(new File(this.fontBase).toURI().toURL().toString());
			fopFactory.setUserConfig(cfg);
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			foUserAgent.setAuthor("Sambaash Pte Ltd");
			foUserAgent.setCreator("Sambaash");
			
			// xml + xsl => xslfo
			StreamSource source = new StreamSource(new StringReader(xml));
			StreamSource transformSource = new StreamSource(xsltfile);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			Transformer xslfoTransformer = TransformerFactory.newInstance()
					.newTransformer(transformSource);
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent,
					outStream);
			Result res = new SAXResult(fop.getDefaultHandler());
			
			// flush out
			xslfoTransformer.transform(source, res);
			return outStream.toByteArray();
		} catch (Exception e) {
			logger.error("Error while creating PDF thru FOP xsl", e);
			throw e;
		}
	}

	public String convertToXml(Object o, String rootName) {
		try {
			JAXBContext context = JAXBContext.newInstance(o.getClass(),
					ReportPayload.class, ReportRecord.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setEventHandler(new ValidationEventHandler() {
				// ignore errors
				public boolean handleEvent(ValidationEvent event) {
					return false;
				}
			});
			final StringWriter writer = new StringWriter();
			JAXBElement<Object> ele = new JAXBElement<Object>(new QName(
					rootName), Object.class, o);
			m.marshal(ele, writer);
			return writer.toString();
		} catch (Exception e) {
			logger.error("Error while converting to xml", e);
		}
		return null;
	}

	@Override
	public void generateReport(ReportPayload payload, File file)
			throws Exception {
		try {
			byte[] pdfBytes = this.generatePdf(payload);
			FileOutputStream foStream = new FileOutputStream(file);
			foStream.write(pdfBytes);
			foStream.close();
		} catch (Exception e) {
			logger.error("Error while writing pdf to file", e);
			throw e;
		}
	}
}
