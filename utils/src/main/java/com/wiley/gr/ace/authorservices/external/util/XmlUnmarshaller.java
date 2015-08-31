package com.wiley.gr.ace.authorservices.external.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlUnmarshaller.
 */
public class XmlUnmarshaller {
	
	
	/**
	 * Unmarshall.
	 *
	 * @param xml the xml
	 * @param clazz the clazz
	 * @return the object
	 * @throws Exception the exception
	 */
	public static Object unmarshall(String xml, Class<?> clazz) throws Exception {
		StringReader reader = new StringReader(xml);
		JAXBContext context = JAXBContext.newInstance(clazz);
		Object xmlData = context.createUnmarshaller().unmarshal(reader);
		return xmlData;
	}
}
