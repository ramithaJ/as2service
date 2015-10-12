package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version 1.0
 *
 */
public class Entity {

    /**
     * This field holds the value of entityType.
     */
    private String entityType;

    /**
     * This field holds the value of address.
     */
    private AddressData address;

    /**
     * This field holds the value of profileInformation.
     */
    private ProfileInformation profileInformation;

    /**
     * This field holds the value of interestData.
     */
    private InterestData interestData;

    /**
     * This field holds the value of journalElement.
     */
    private JournalElement journalElement;

    /**
     * This field holds the value of alerts.
     */
    private Alerts alerts;

    /**
     * This field holds the value of sourceSystem.
     */
    private String sourceSystem;

    /**
     * This field holds the value of entityId.
     */
    private String entityId;

    /**
     * @return the entityType
     */
    public final String getEntityType() {
        return entityType;
    }

    /**
     * @param entityType
     *            the entityType to set
     */
    public final void setEntityType(final String entityType) {
        this.entityType = entityType;
    }

    /**
     * @return the address
     */
    public final AddressData getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public final void setAddress(final AddressData address) {
        this.address = address;
    }

    /**
     * @return the profileInformation
     */
    public final ProfileInformation getProfileInformation() {
        return profileInformation;
    }

    /**
     * @param profileInformation
     *            the profileInformation to set
     */
    public final void setProfileInformation(
            final ProfileInformation profileInformation) {
        this.profileInformation = profileInformation;
    }

    /**
     * @return the interestData
     */
    public final InterestData getInterestData() {
        return interestData;
    }

    /**
     * @param interestData
     *            the interestData to set
     */
    public final void setInterestData(final InterestData interestData) {
        this.interestData = interestData;
    }

    /**
     * @return the journalElement
     */
    public final JournalElement getJournalElement() {
        return journalElement;
    }

    /**
     * @param journalElement
     *            the journalElement to set
     */
    public final void setJournalElement(final JournalElement journalElement) {
        this.journalElement = journalElement;
    }

    /**
     * @return the alerts
     */
    public final Alerts getAlerts() {
        return alerts;
    }

    /**
     * @param alerts
     *            the alerts to set
     */
    public final void setAlerts(final Alerts alerts) {
        this.alerts = alerts;
    }

    /**
     * @return the sourceSystem
     */
    public final String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * @param sourceSystem
     *            the sourceSystem to set
     */
    public final void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    /**
     * @return the entityId
     */
    public final String getEntityId() {
        return entityId;
    }

    /**
     * @param entityId
     *            the entityId to set
     */
    public final void setEntityId(final String entityId) {
        this.entityId = entityId;
    }

}
