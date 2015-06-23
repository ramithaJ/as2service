package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 23, 2015 2:35:20 PM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SavedOrders generated by hbm2java
 */
@Entity
@Table(name = "SAVED_ORDERS")
public class SavedOrders implements java.io.Serializable {

    private Integer orderId;
    private Users usersByCreatedBy;
    private Users usersByUpdatedBy;
    private UserProfile userProfile;
    private Articles articles;
    private String orderObject;
    private Date createdDate;
    private Date updatedDate;

    public SavedOrders() {
    }

    public SavedOrders(Integer orderId) {
        this.orderId = orderId;
    }

    public SavedOrders(Integer orderId, Users usersByCreatedBy,
            Users usersByUpdatedBy, UserProfile userProfile, Articles articles,
            String orderObject, Date createdDate, Date updatedDate) {
        this.orderId = orderId;
        this.usersByCreatedBy = usersByCreatedBy;
        this.usersByUpdatedBy = usersByUpdatedBy;
        this.userProfile = userProfile;
        this.articles = articles;
        this.orderObject = orderObject;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Id
    @Column(name = "ORDER_ID", unique = true, nullable = false, precision = 22, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SAVED_ORDERS_SEQ")
    @SequenceGenerator(name = "SAVED_ORDERS_SEQ", sequenceName = "SAVED_ORDERS_SEQ", allocationSize = 1)
    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY")
    public Users getUsersByCreatedBy() {
        return this.usersByCreatedBy;
    }

    public void setUsersByCreatedBy(Users usersByCreatedBy) {
        this.usersByCreatedBy = usersByCreatedBy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATED_BY")
    public Users getUsersByUpdatedBy() {
        return this.usersByUpdatedBy;
    }

    public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
        this.usersByUpdatedBy = usersByUpdatedBy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    public Articles getArticles() {
        return this.articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    @Lob
    @Column(name = "ORDER_OBJECT")
    public String getOrderObject() {
        return this.orderObject;
    }

    public void setOrderObject(String orderObject) {
        this.orderObject = orderObject;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", length = 7)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATED_DATE", length = 7)
    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
