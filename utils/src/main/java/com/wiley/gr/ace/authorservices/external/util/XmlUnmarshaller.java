package com.wiley.gr.ace.authorservices.external.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;

/**
 * The Class XmlUnmarshaller.
 */
public class XmlUnmarshaller {

    /**
     * This field holds the value of LOGGER
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(XmlUnmarshaller.class);

    /**
     * constructor.
     */
    private XmlUnmarshaller() {

    }

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
    public static Object unmarshall(final String xml, final Class<?> clazz) {

        Object xmlData = null;
        try {
            StringReader reader = new StringReader(xml);
            JAXBContext context = JAXBContext.newInstance(clazz);
            xmlData = context.createUnmarshaller().unmarshal(reader);
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException();
        }
        return xmlData;
    }
}
