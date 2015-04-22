package com.wiley.gr.ace.authorservices.persistence.entity;



public class Article {
	private int articleId;
	private String articleName;
	  private String submittedBy;
	  private String submittedDate;
	  private boolean articleStatus;
	  private String statusUpdatedDate;
	  private boolean showLicenceAgreementToSign;
	  
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	
	public boolean isArticleStatus() {
		return articleStatus;
	}
	public void setArticleStatus(boolean articleStatus) {
		this.articleStatus = articleStatus;
	}
	
	public String getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getStatusUpdatedDate() {
		return statusUpdatedDate;
	}
	public void setStatusUpdatedDate(String statusUpdatedDate) {
		this.statusUpdatedDate = statusUpdatedDate;
	}
	public boolean isShowLicenceAgreementToSign() {
		return showLicenceAgreementToSign;
	}
	public void setShowLicenceAgreementToSign(boolean showLicenceAgreementToSign) {
		this.showLicenceAgreementToSign = showLicenceAgreementToSign;
	}

}
