package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class Entity.
 *
 * @author virtusa version 1.0
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

    private JournalElement journal;

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
     * Gets the entity type.
     *
     * @return the entityType
     */
    public final String getEntityType() {
        return entityType;
    }

    /**
     * Sets the entity type.
     *
     * @param entityType
     *            the entityType to set
     */
    public final void setEntityType(final String entityType) {
        this.entityType = entityType;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public final AddressData getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the address to set
     */
    public final void setAddress(final AddressData address) {
        this.address = address;
    }

    /**
     * Gets the profile information.
     *
     * @return the profileInformation
     */
    public final ProfileInformation getProfileInformation() {
        return profileInformation;
    }

    /**
     * Sets the profile information.
     *
     * @param profileInformation
     *            the profileInformation to set
     */
    public final void setProfileInformation(
            final ProfileInformation profileInformation) {
        this.profileInformation = profileInformation;
    }

    /**
     * Gets the interest data.
     *
     * @return the interestData
     */
    public final InterestData getInterestData() {
        return interestData;
    }

    /**
     * Sets the interest data.
     *
     * @param interestData
     *            the interestData to set
     */
    public final void setInterestData(final InterestData interestData) {
        this.interestData = interestData;
    }

    /**
     * Gets the alerts.
     *
     * @return the alerts
     */
    public final Alerts getAlerts() {
        return alerts;
    }

    /**
     * Sets the alerts.
     *
     * @param alerts
     *            the alerts to set
     */
    public final void setAlerts(final Alerts alerts) {
        this.alerts = alerts;
    }

    /**
     * Gets the source system.
     *
     * @return the sourceSystem
     */
    public final String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * Sets the source system.
     *
     * @param sourceSystem
     *            the sourceSystem to set
     */
    public final void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    /**
     * Gets the entity id.
     *
     * @return the entityId
     */
    public final String getEntityId() {
        return entityId;
    }

    /**
     * Sets the entity id.
     *
     * @param entityId
     *            the entityId to set
     */
    public final void setEntityId(final String entityId) {
        this.entityId = entityId;
    }

    /**
     * Gets the journal.
     *
     * @return the journal
     */
    public final JournalElement getJournal() {
        return journal;
    }

    /**
     * Sets the journal.
     *
     * @param journal
     *            the new journal
     */
    public final void setJournal(final JournalElement journal) {
        this.journal = journal;
    }

}
