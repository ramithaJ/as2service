package com.wiley.gr.ace.authorservices.external.util;

import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticle;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournal;
import com.wiley.gr.ace.authorservices.model.external.PdhModel;



/**
 * The Class PdhLookupServiceUtil.
 */
public class PdhLookupServiceUtil {
/**
	 * Lookup.
	 *
	 * @param xml the xml
	 * @param clazz the clazz
	 * @return the object
	 * @throws Exception the exception
	 */
	public static Object lookup(String xml) throws Exception{
		PdhModel model = (PdhModel) XmlUnmarshaller.unmarshall(xml, PdhModel.class);
		Object unmarshedObject=null;
		if (model.getProductEntities().getTitle().getTitleDhProdTypeCd()
				.equals("ARTICLE")) {
			unmarshedObject = (PdhLookupArticle) XmlUnmarshaller.unmarshall(xml,
					PdhLookupArticle.class);
		} else if (model.getProductEntities().getTitle().getTitleDhProdTypeCd()
				.equals("JOURNAL")) {
			unmarshedObject = (PdhLookupJournal) XmlUnmarshaller.unmarshall(xml,
					PdhLookupJournal.class);
		}
		return unmarshedObject;
	}
}
