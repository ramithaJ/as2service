package com.wiley.gr.ace.authorservices.persistence.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SecurityQuestionsId generated by hbm2java
 */
@Embeddable
public class SecurityQuestionsId implements java.io.Serializable {
    
    private Integer questionId;
    private String questDesc;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    
    public SecurityQuestionsId() {
    }
    
    public SecurityQuestionsId(Integer questionId, String questDesc,
            Date createdDate, String createdBy, Date updatedDate,
            String updatedBy) {
        this.questionId = questionId;
        this.questDesc = questDesc;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }
    
    @Column(name = "QUESTION_ID", precision = 22, scale = 0)
    public Integer getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    
    @Column(name = "QUEST_DESC", length = 500)
    public String getQuestDesc() {
        return this.questDesc;
    }
    
    public void setQuestDesc(String questDesc) {
        this.questDesc = questDesc;
    }
    
    @Column(name = "CREATED_DATE")
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    @Column(name = "CREATED_BY", length = 100)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    @Column(name = "UPDATED_DATE")
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    @Column(name = "UPDATED_BY", length = 100)
    public String getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof SecurityQuestionsId))
            return false;
        SecurityQuestionsId castOther = (SecurityQuestionsId) other;
        
        return ((this.getQuestionId() == castOther.getQuestionId()) || (this
                .getQuestionId() != null && castOther.getQuestionId() != null && this
                .getQuestionId().equals(castOther.getQuestionId())))
                && ((this.getQuestDesc() == castOther.getQuestDesc()) || (this
                        .getQuestDesc() != null
                        && castOther.getQuestDesc() != null && this
                        .getQuestDesc().equals(castOther.getQuestDesc())))
                && ((this.getCreatedDate() == castOther.getCreatedDate()) || (this
                        .getCreatedDate() != null
                        && castOther.getCreatedDate() != null && this
                        .getCreatedDate().equals(castOther.getCreatedDate())))
                && ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
                        .getCreatedBy() != null
                        && castOther.getCreatedBy() != null && this
                        .getCreatedBy().equals(castOther.getCreatedBy())))
                && ((this.getUpdatedDate() == castOther.getUpdatedDate()) || (this
                        .getUpdatedDate() != null
                        && castOther.getUpdatedDate() != null && this
                        .getUpdatedDate().equals(castOther.getUpdatedDate())))
                && ((this.getUpdatedBy() == castOther.getUpdatedBy()) || (this
                        .getUpdatedBy() != null
                        && castOther.getUpdatedBy() != null && this
                        .getUpdatedBy().equals(castOther.getUpdatedBy())));
    }
    
    public int hashCode() {
        int result = 17;
        
        result = 37
                * result
                + (getQuestionId() == null ? 0 : this.getQuestionId()
                        .hashCode());
        result = 37 * result
                + (getQuestDesc() == null ? 0 : this.getQuestDesc().hashCode());
        result = 37
                * result
                + (getCreatedDate() == null ? 0 : this.getCreatedDate()
                        .hashCode());
        result = 37 * result
                + (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
        result = 37
                * result
                + (getUpdatedDate() == null ? 0 : this.getUpdatedDate()
                        .hashCode());
        result = 37 * result
                + (getUpdatedBy() == null ? 0 : this.getUpdatedBy().hashCode());
        return result;
    }
    
}
