/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.event.JournalInfo;
import com.wiley.gr.ace.authorservices.persistence.entity.JournalConfiguration;
import com.wiley.gr.ace.authorservices.persistence.entity.JournalSetupStates;
import com.wiley.gr.ace.authorservices.persistence.services.SaveJournalInfoDAO;
import com.wiley.gr.ace.authorservices.services.service.SaveJournalInfoService;

/**
 * The Class SaveJournalInfoServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class SaveJournalInfoServiceImpl implements SaveJournalInfoService {

    /** The journal info dao. */
    @Autowired(required = true)
    SaveJournalInfoDAO saveJournalInfoDAO;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SaveJournalInfoServiceImpl.class);

    /**
     * Parses the journal info type event.
     *
     * @param journalInfoTypeEvent
     *            the journal info type event
     * @throws Exception
     *             the exception
     */
    @Override
    public void parseJournalInfoTypeEvent(final String journalInfoTypeEvent)
            throws Exception {
        boolean result = false;
        LOGGER.info("Parsing Journal Info Type Event ...");
        if (null != journalInfoTypeEvent
                && journalInfoTypeEvent.trim().length() > 0) {

            final StringReader reader = new StringReader(journalInfoTypeEvent);
            final DocumentBuilderFactory dbf = DocumentBuilderFactory
                    .newInstance();
            dbf.setNamespaceAware(true);

            final JAXBContext journalInfoTypeContext = JAXBContext
                    .newInstance(JournalInfo.class);
            final JournalInfo journalInfo = (JournalInfo) journalInfoTypeContext
                    .createUnmarshaller().unmarshal(reader);

            final JournalConfiguration journalConfiguration = new JournalConfiguration();
            final Integer dhId = saveJournalInfoDAO.getJournalId(journalInfo
                    .getJournalID());
            if (dhId != Integer.parseInt(journalInfo.getJournalID())) {
                journalConfiguration.setDhId(Integer.parseInt(journalInfo
                        .getJournalID()));
                journalConfiguration.setNickname(journalInfo.getJournalName());
                final JournalSetupStates journalSetupStates = new JournalSetupStates();
                journalSetupStates.setSetupStateCd(journalInfo
                        .getJournalSetupState());
                journalConfiguration.setJournalSetupStates(journalSetupStates);
                journalConfiguration.setTitleDispOoo(journalInfo
                        .getRevenueModel());

                result = saveJournalInfoDAO.saveJournalInfo(journalConfiguration);
                System.err.println(" Journal Info Type Event " + result);
            }
        }
    }
}
