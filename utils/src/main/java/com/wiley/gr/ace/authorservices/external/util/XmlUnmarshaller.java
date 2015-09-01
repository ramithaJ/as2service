package com.wiley.gr.ace.authorservices.external.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;

/**
 * The Class XmlUnmarshaller.
 */
public class XmlUnmarshaller {

    /**
     * Unmarshall.
     *
     * @param xml
     *            the xml
     * @param clazz
     *            the clazz
     * @return the object
     * @throws Exception
     *             the exception
     */
    public static Object unmarshall(final String xml, final Class<?> clazz)
            throws Exception {
        final StringReader reader = new StringReader(xml);
        final JAXBContext context = JAXBContext.newInstance(clazz);
        final Object xmlData = context.createUnmarshaller().unmarshal(reader);
        return xmlData;
    }
}
