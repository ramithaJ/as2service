package com.wiley.gr.ace.authorservices.external.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.model.PdhArticleData;
import com.wiley.gr.ace.authorservices.model.PdhJournalData;
import com.wiley.gr.ace.authorservices.model.Prices;
import com.wiley.gr.ace.authorservices.model.external.Identifier;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticle;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournal;
import com.wiley.gr.ace.authorservices.model.external.PdhModel;
import com.wiley.gr.ace.authorservices.model.external.Price;
import com.wiley.gr.ace.authorservices.model.external.Product;
import com.wiley.gr.ace.authorservices.model.external.ProductCodes;
import com.wiley.gr.ace.authorservices.model.external.ProductContributor;
import com.wiley.gr.ace.authorservices.model.external.ProductDates;
import com.wiley.gr.ace.authorservices.model.external.ProductExtension;
import com.wiley.gr.ace.authorservices.model.external.ProductImages;
import com.wiley.gr.ace.authorservices.model.external.ProductRegion;
import com.wiley.gr.ace.authorservices.model.external.ProductRelationChild;
import com.wiley.gr.ace.authorservices.model.external.ProductStatus;
import com.wiley.gr.ace.authorservices.model.external.ProductUrl;
import com.wiley.gr.ace.authorservices.model.external.Title;

/**
 * The Class PdhLookupServiceUtil.
 */
public class PdhLookupServiceUtil {

    /**
     * Lookup.
     *
     * @param xml
     *            the xml
     * @return the object
     * @throws Exception
     *             the exception
     */
    public static Object lookup(String xml) throws Exception {
        PdhModel model = (PdhModel) XmlUnmarshaller.unmarshall(xml,
                PdhModel.class);
        Object unmarshedObject = null;
        List<Identifier> identifierList = model.getProductEntities()
                .getIdentifier();
        for (Identifier identifier : identifierList) {
            if ("ARTICLE_IDENTIFIER".equalsIgnoreCase(identifier.getDhTypeCd())) {
                unmarshedObject = (PdhLookupArticle) XmlUnmarshaller
                        .unmarshall(xml, PdhLookupArticle.class);
            } else if ("JOURNAL_CODE"
                    .equalsIgnoreCase(identifier.getDhTypeCd())) {
                unmarshedObject = (PdhLookupJournal) XmlUnmarshaller
                        .unmarshall(xml, PdhLookupJournal.class);
            }
        }
        return unmarshedObject;
    }

    /**
     * Invoke pdh lookup data.
     *
     * @param pdhLookupObject
     *            the pdh lookup object
     * @return the object
     */
    public static Object invokePdhLookupData(final Object pdhLookupObject) {
        if (pdhLookupObject instanceof PdhLookupArticle) {
            PdhLookupArticle pdhLookupArticle = (PdhLookupArticle) pdhLookupObject;
            return (Object) parsePdhArticleData(pdhLookupArticle);
        } else {
            PdhLookupJournal pdhLookupJournal = (PdhLookupJournal) pdhLookupObject;
            return (Object) parsePdhJournalData(pdhLookupJournal);
        }
    }

    /**
     * Parses the pdh article data.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @return the pdh article data
     */
    private static PdhArticleData parsePdhArticleData(
            final PdhLookupArticle pdhLookupArticle) {
        PdhArticleData pdhArticleData = new PdhArticleData();
        parseArticleData(pdhLookupArticle, pdhArticleData);
        return pdhArticleData;
    }

    /**
     * Parses the article data.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param pdhArticleData
     *            the pdh article data
     */
    private static void parseArticleData(
            final PdhLookupArticle pdhLookupArticle,
            final PdhArticleData pdhArticleData) {
        Title title = pdhLookupArticle.getArticleProductEntities().getTitle();
        if (!StringUtils.isEmpty(title)) {
            pdhArticleData.setDhId(title.getTitleDhProdId());
            pdhArticleData.setTitle(title.getTitleText());
        }
        parseArticleDetails(pdhLookupArticle, pdhArticleData);
        parseJournalDhId(pdhLookupArticle, pdhArticleData);
    }

    /**
     * Parses the journal dh id.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param pdhArticleData
     *            the pdh article data
     */
    private static void parseJournalDhId(
            final PdhLookupArticle pdhLookupArticle,
            final PdhArticleData pdhArticleData) {
        List<ProductRelationChild> productRelationChilds = pdhLookupArticle
                .getArticleProductEntities().getProductRelationChild();
        if (!StringUtils.isEmpty(productRelationChilds)) {
            for (ProductRelationChild productRelationChild : productRelationChilds) {
                if ("JA".equalsIgnoreCase(productRelationChild
                        .getDhRelTypeCdChild())) {
                    pdhArticleData.setJournalDhId(productRelationChild
                            .getDhParProdIdChild());
                }
            }
        }
    }

    /**
     * Parses the article details.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param pdhArticleData
     *            the pdh article data
     */
    private static void parseArticleDetails(
            final PdhLookupArticle pdhLookupArticle,
            final PdhArticleData pdhArticleData) {
        List<Identifier> identifierList = pdhLookupArticle
                .getArticleProductEntities().getIdentifier();
        if (!StringUtils.isEmpty(identifierList)) {
            for (Identifier identifier : identifierList) {
                if ("ARTICLE_IDENTIFIER".equalsIgnoreCase(identifier
                        .getDhTypeCd())) {
                    pdhArticleData.setArticleId(identifier.getIdentCd());
                } else if ("DOI".equalsIgnoreCase(identifier.getDhTypeCd())) {
                    pdhArticleData.setArticleDoi(identifier.getIdentCd());
                } else if ("EDITORIAL_REF_CODE".equalsIgnoreCase(identifier
                        .getDhTypeCd())) {
                    pdhArticleData.setEditorialRefCode(identifier.getIdentCd());
                } else if ("ARTICLE_AID".equalsIgnoreCase(identifier
                        .getDhTypeCd())) {
                    pdhArticleData.setArticleAid(identifier.getIdentCd());
                }
            }
        }
        parseAuthors(pdhLookupArticle, pdhArticleData);
    }

    /**
     * Parses the authors.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param pdhArticleData
     *            the pdh article data
     */
    private static void parseAuthors(final PdhLookupArticle pdhLookupArticle,
            final PdhArticleData pdhArticleData) {
        List<ProductContributor> productContributorList = pdhLookupArticle
                .getArticleProductEntities().getProductContributor();
        if (!StringUtils.isEmpty(productContributorList)) {
            List<String> coAuthorsList = new ArrayList<String>();
            String coAuthors = null;
            for (ProductContributor productContributor : productContributorList) {
                String authorRoleCd = productContributor.getDhRoleTypeCd();
                if ("Corresponding Author".equalsIgnoreCase(authorRoleCd)) {
                    pdhArticleData.setAuthorName(productContributor
                            .getFirstName().concat(" ")
                            .concat(productContributor.getLastName()));
                    pdhArticleData.setAuthorEmail(productContributor
                            .getEmailAddr());
                } else if ("Author".equalsIgnoreCase(authorRoleCd)) {
                    coAuthors = productContributor.getFirstName().concat(" ")
                            .concat(productContributor.getLastName());
                    coAuthorsList.add(coAuthors);
                }
            }
            pdhArticleData.setCoAuthors(coAuthorsList);
        }
        parseArticleExtensions(pdhLookupArticle, pdhArticleData);
    }

    /**
     * Parses the article extensions.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param pdhArticleData
     *            the pdh article data
     */
    private static void parseArticleExtensions(
            final PdhLookupArticle pdhLookupArticle,
            final PdhArticleData pdhArticleData) {
        List<ProductExtension> productExtensions = pdhLookupArticle
                .getArticleProductEntities().getProductExtension();
        if (!StringUtils.isEmpty(productExtensions)) {
            for (ProductExtension productExtension : productExtensions) {
                String dhExtCd = productExtension.getDhExtCd();
                String extValue = productExtension.getExtValue();
                if ("AUTHOR_SERVICES_FLAG".equalsIgnoreCase(dhExtCd)) {
                    pdhArticleData.setIsInvitedInAs(extValue);
                } else if ("ARTICLE_TYPE".equalsIgnoreCase(dhExtCd)) {
                    pdhArticleData.setArticleType(extValue);
                } else if ("JPCMS_COPYRIGHT_LINE".equalsIgnoreCase(dhExtCd)) {
                    pdhArticleData.setJpcmsCopyrightLine(extValue);
                }
            }
        }
        parseProductRegion(pdhLookupArticle, pdhArticleData);
    }

    /**
     * Parses the product region.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param pdhArticleData
     *            the pdh article data
     */
    private static void parseProductRegion(
            final PdhLookupArticle pdhLookupArticle,
            final PdhArticleData pdhArticleData) {
        ProductRegion productRegion = pdhLookupArticle
                .getArticleProductEntities().getProductRegion();
        if (!StringUtils.isEmpty(productRegion)) {
            pdhArticleData.setProductRegion(productRegion.getProdRegRegDesc());
        }
        parseProductDates(pdhLookupArticle, pdhArticleData);
    }

    /**
     * Parses the product dates.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param pdhArticleData
     *            the pdh article data
     */
    private static void parseProductDates(
            final PdhLookupArticle pdhLookupArticle,
            final PdhArticleData pdhArticleData) {
        List<ProductDates> productDatesList = pdhLookupArticle
                .getArticleProductEntities().getProductDates();
        if (!StringUtils.isEmpty(productDatesList)) {
            for (ProductDates productDates : productDatesList) {
                String dateTypeCd = productDates.getDhDateTypeCd();
                Date dateValue = productDates.getProdDtDateValue();
                if ("ART_ACC_DT".equalsIgnoreCase(dateTypeCd)) {
                    pdhArticleData.setAcceptedDate(dateValue);
                } else if ("ART_WILEY_REC_DT".equalsIgnoreCase(dateTypeCd)) {
                    pdhArticleData.setWileyReceivedDate(dateValue);
                } else if ("CTA_RCV_DT".equalsIgnoreCase(dateTypeCd)) {
                    pdhArticleData.setCtaRcvdDate(dateValue);
                } else if ("ART_RCV_DT".equalsIgnoreCase(dateTypeCd)) {
                    pdhArticleData.setReceivedDate(dateValue);
                }
                parseProductDatesForArticle(dateTypeCd, dateValue,
                        pdhArticleData);
            }
        }
    }

    /**
     * Parses the product dates for article.
     *
     * @param dateTypeCd
     *            the date type cd
     * @param dateValue
     *            the date value
     * @param pdhArticleData
     *            the pdh article data
     */
    private static void parseProductDatesForArticle(final String dateTypeCd,
            final Date dateValue, final PdhArticleData pdhArticleData) {
        if ("ART_REV_DT".equalsIgnoreCase(dateTypeCd)) {
            pdhArticleData.setRevisedDate(dateValue);
        } else if ("ART_REV_DT".equalsIgnoreCase(dateTypeCd)) {
            pdhArticleData.setRevisedDate(dateValue);
        } else if ("ART_BOOKIN_DT".equalsIgnoreCase(dateTypeCd)) {
            pdhArticleData.setBookInDate(dateValue);
        } else if ("ART_PRFRCVD_DT".equalsIgnoreCase(dateTypeCd)) {
            pdhArticleData.setProofRcvdDate(dateValue);
        } else if ("ART_PRFOUT_DT".equalsIgnoreCase(dateTypeCd)) {
            pdhArticleData.setProofOutDate(dateValue);
        }
    }

    /**
     * Parses the pdh journal data.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @return the pdh journal data
     */
    private static PdhJournalData parsePdhJournalData(
            final PdhLookupJournal pdhLookupJournal) {
        PdhJournalData pdhJournalData = new PdhJournalData();
        parseJournalDetails(pdhLookupJournal, pdhJournalData);
        return pdhJournalData;
    }

    /**
     * Parses the journal details.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseJournalDetails(
            final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        List<Identifier> identifiers = pdhLookupJournal
                .getJournalProductEntities().getIdentifier();
        if (!StringUtils.isEmpty(identifiers)) {
            for (Identifier identifier : identifiers) {
                String dhTypeCd = identifier.getDhTypeCd();
                String identCode = identifier.getIdentCd();
                if ("JOURNAL_CODE".equalsIgnoreCase(dhTypeCd)) {
                    pdhJournalData.setJournalId(identCode);
                } else if ("DOI".equalsIgnoreCase(dhTypeCd)) {
                    pdhJournalData.setJournalDoi(identCode);
                } else if ("WOL_CODE".equalsIgnoreCase(dhTypeCd)) {
                    pdhJournalData.setWolCode(identCode);
                } else if ("E-JOURNAL_CODE".equalsIgnoreCase(dhTypeCd)) {
                    pdhJournalData.seteJournalCode(identCode);
                }
                parseJournalIdentifies(dhTypeCd, identCode, pdhJournalData);
            }
        }
        parseJournalCodes(pdhLookupJournal, pdhJournalData);
    }

    /**
     * Parses the journal identifies.
     *
     * @param dhTypeCd
     *            the dh type cd
     * @param identCode
     *            the ident code
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseJournalIdentifies(final String dhTypeCd,
            final String identCode, final PdhJournalData pdhJournalData) {
        if ("JPCMS_INTERNAL_ID".equalsIgnoreCase(dhTypeCd)) {
            pdhJournalData.setJpcmsInternalId(identCode);
        } else if ("JPCMS_IDENTIFIER".equalsIgnoreCase(dhTypeCd)) {
            pdhJournalData.setJpcmsId(identCode);
        } else if ("ISSN".equalsIgnoreCase(dhTypeCd)) {
            pdhJournalData.setPrintIssn(identCode);
        } else if ("E-ISSN".equalsIgnoreCase(dhTypeCd)) {
            pdhJournalData.setElectronicIssn(identCode);
        } else if ("JOURNAL_ACRONYM".equalsIgnoreCase(dhTypeCd)) {
            pdhJournalData.setJournalAcronym(identCode);
        } else if ("ISBN10".equalsIgnoreCase(dhTypeCd)) {
            pdhJournalData.setIsbn(identCode);
        } else if ("OID".equalsIgnoreCase(dhTypeCd)) {
            pdhJournalData.setJournalOid(identCode);
        } else if ("JOURNAL_GROUP_CODE".equalsIgnoreCase(dhTypeCd)) {
            pdhJournalData.setGroupCode(identCode);
        }
    }

    /**
     * Parses the journal codes.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseJournalCodes(
            final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        List<ProductCodes> productCodesList = pdhLookupJournal
                .getJournalProductEntities().getProductCodes();
        if (!StringUtils.isEmpty(productCodesList)) {
            List<String> subjectCode = new ArrayList<String>();
            for (ProductCodes productCodes : productCodesList) {
                String typeCode = productCodes.getProdCdDhTypeCd();
                String codeValue = productCodes.getCodeValue();
                if ("SUBJECT_CODE".equalsIgnoreCase(typeCode)) {
                    subjectCode.add(codeValue);
                } else if ("PUB_SOURCE_CODE".equalsIgnoreCase(typeCode)) {
                    pdhJournalData.setPubSourceCode(codeValue);
                } else if ("JOURNAL_PRINT_CODE".equalsIgnoreCase(typeCode)) {
                    pdhJournalData.setPrintCode(codeValue);
                } else if ("JOURNAL_OWNERSHIP_STATUS"
                        .equalsIgnoreCase(typeCode)) {
                    pdhJournalData.setOwnershipStatus(codeValue);
                }
            }
            pdhJournalData.setSubjectCode(subjectCode);
        }
        parseJournalTypeId(pdhLookupJournal, pdhJournalData);
    }

    /**
     * Parses the journal type id.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseJournalTypeId(
            final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        Product product = pdhLookupJournal.getJournalProductEntities()
                .getProduct();
        if (!StringUtils.isEmpty(product)) {
            pdhJournalData.setDhId(product.getDhProdId());
            pdhJournalData.setSubcriptionType(product.getSubscriptionType());
            pdhJournalData.setPublicationDate(product.getPubDate());
        }
        parsePrices(pdhLookupJournal, pdhJournalData);
    }

    /**
     * Parses the prices.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parsePrices(final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        List<Price> priceList = pdhLookupJournal.getJournalProductEntities()
                .getPrice();
        List<Prices> pricesList = new ArrayList<Prices>();
        if (!StringUtils.isEmpty(priceList)) {
            for (Price price : priceList) {
                Prices prices = new Prices();
                prices.setArticleId(price.getPriceDhId());
                prices.setPrice(price.getPriceAmt());
                prices.setCurrency(price.getDhCurrencyCd());
                pricesList.add(prices);
            }
        }
        pdhJournalData.setPrices(pricesList);
        parseProductImages(pdhLookupJournal, pdhJournalData);
    }

    /**
     * Parses the product images.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseProductImages(
            final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        List<ProductImages> productImagesList = pdhLookupJournal
                .getJournalProductEntities().getProductImages();
        if (!StringUtils.isEmpty(productImagesList)) {
            for (ProductImages productImages : productImagesList) {
                String dhTypeCode = productImages.getProdImgDhTypeCd();
                String imageLink = productImages.getImageLink();
                if ("JOURNAL_COVER_IMAGE".equalsIgnoreCase(dhTypeCode)) {
                    pdhJournalData.setCoverImageLink(imageLink);
                } else if ("JOURNAL_BANNER_IMAGE".equalsIgnoreCase(dhTypeCode)) {
                    pdhJournalData.setBannerImageLink(imageLink);
                } else if ("JOURNAL_THUMBNAIL".equalsIgnoreCase(dhTypeCode)) {
                    pdhJournalData.setThumbnailLink(imageLink);
                }
            }
        }
        parseJournalTitles(pdhLookupJournal, pdhJournalData);
    }

    /**
     * Parses the journal titles.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseJournalTitles(
            final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        List<Title> titles = pdhLookupJournal.getJournalProductEntities()
                .getTitle();
        if (!StringUtils.isEmpty(titles)) {
            for (Title title : titles) {
                String titleTypeCode = title.getDhTitleTypeCd();
                String titleText = title.getTitleText();
                if ("FULL_TITLE".equalsIgnoreCase(titleTypeCode)) {
                    pdhJournalData.setJournalTitle(titleText);
                } else if ("ALTERNATE_TITLE".equalsIgnoreCase(titleTypeCode)) {
                    pdhJournalData.setAlternateTitle(titleText);
                }
            }
        }
        parseProductStatus(pdhLookupJournal, pdhJournalData);
    }

    /**
     * Parses the product status.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseProductStatus(
            final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        ProductStatus productStatus = pdhLookupJournal
                .getJournalProductEntities().getProductStatus();
        if (!StringUtils.isEmpty(productStatus)) {
            String statusTypeCd = productStatus.getDhStatTypeCd();
            String statusValue = productStatus.getStatusValue();
            if ("STATUS".equalsIgnoreCase(statusTypeCd)) {
                pdhJournalData.setJournalStatus(statusValue);
            }
        }
        parseProductUrls(pdhLookupJournal, pdhJournalData);
    }

    /**
     * Parses the product urls.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseProductUrls(
            final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        List<ProductUrl> productUrls = pdhLookupJournal
                .getJournalProductEntities().getProductUrl();
        if (!StringUtils.isEmpty(productUrls)) {
            for (ProductUrl productUrl : productUrls) {
                String urlTypeCd = productUrl.getProdUrlDhTypeCd();
                String url = productUrl.getUrl();
                if ("RSS_URL".equalsIgnoreCase(urlTypeCd)) {
                    pdhJournalData.setProductRssUrl(url);
                } else if ("WOL_URL".equalsIgnoreCase(urlTypeCd)) {
                    pdhJournalData.setProductRssUrl(url);
                }
            }
        }
        parseJournalRegion(pdhLookupJournal, pdhJournalData);
    }

    /**
     * Parses the journal region.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseJournalRegion(
            final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        ProductRegion productRegion = pdhLookupJournal
                .getJournalProductEntities().getProductRegion();
        if (!StringUtils.isEmpty(productRegion)) {
            pdhJournalData.setProductRegion(productRegion.getProdRegRegDesc());
        }
        parseJournalExtensions(pdhLookupJournal, pdhJournalData);
    }

    /**
     * Parses the journal extensions.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseJournalExtensions(
            final PdhLookupJournal pdhLookupJournal,
            final PdhJournalData pdhJournalData) {
        List<ProductExtension> productExtensions = pdhLookupJournal
                .getJournalProductEntities().getProductExtension();
        if (!StringUtils.isEmpty(productExtensions)) {
            for (ProductExtension productExtension : productExtensions) {
                String dhExtCd = productExtension.getDhExtCd();
                String extValue = productExtension.getExtValue();
                if ("MAINTAINED_IN_JPCMS".equalsIgnoreCase(dhExtCd)) {
                    pdhJournalData.setInJpcms(extValue);
                }
                parseJournalExtensionsValues(dhExtCd, extValue, pdhJournalData);
            }
        }
    }

    /**
     * Parses the journal extensions values.
     *
     * @param dhExtCd
     *            the dh ext cd
     * @param extValue
     *            the ext value
     * @param pdhJournalData
     *            the pdh journal data
     */
    private static void parseJournalExtensionsValues(final String dhExtCd,
            final String extValue, final PdhJournalData pdhJournalData) {
        if ("NEW_OFFICE".equalsIgnoreCase(dhExtCd)) {
            pdhJournalData.setNewOffice(extValue);
        } else if ("JOURNAL_PRODUCTION_OFFICE".equalsIgnoreCase(dhExtCd)) {
            pdhJournalData.setProductionOffice(extValue);
        } else if ("JOURNAL_PUBLICATION_GROUP".equalsIgnoreCase(dhExtCd)) {
            pdhJournalData.setPublicationGroup(extValue);
        } else if ("JOURNAL_ONLN_OPEN_STATUS".equalsIgnoreCase(dhExtCd)) {
            pdhJournalData.setOnlineOpenStatus(extValue);
        } else if ("PUBLISHER_LOCATION".equalsIgnoreCase(dhExtCd)) {
            pdhJournalData.setPublisherLocation(extValue);
        } else if ("ISI_IMPACT_FACTOR".equalsIgnoreCase(dhExtCd)) {
            pdhJournalData.setIsiImpactFactor(extValue);
        }
    }
}
