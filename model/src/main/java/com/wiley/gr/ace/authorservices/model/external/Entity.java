package com.wiley.gr.ace.authorservices.model.external;

public class Entity {
	String entityType;
	AddressData address;
	ProfileInformation profileInformation;
	InterestData interestData;
	JournalElement journalElement;
	Alerts alerts;
	String sourceSystem;
	String entityId;

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public AddressData getAddress() {
		return address;
	}

	public void setAddress(AddressData address) {
		this.address = address;
	}

	public ProfileInformation getProfileInformation() {
		return profileInformation;
	}

	public void setProfileInformation(ProfileInformation profileInformation) {
		this.profileInformation = profileInformation;
	}

	public InterestData getInterestData() {
		return interestData;
	}

	public void setInterestData(InterestData interestData) {
		this.interestData = interestData;
	}

	public JournalElement getJournalElement() {
		return journalElement;
	}

	public void setJournalElement(JournalElement journalElement) {
		this.journalElement = journalElement;
	}

	public Alerts getAlerts() {
		return alerts;
	}

	public void setAlerts(Alerts alerts) {
		this.alerts = alerts;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
}
