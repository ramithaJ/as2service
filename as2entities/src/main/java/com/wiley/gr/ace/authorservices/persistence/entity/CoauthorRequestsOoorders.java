/*
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 8, 2015 3:59:02 PM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * CoauthorRequestsOoorders generated by hbm2java
 */
@Entity
@Table(name = "COAUTHOR_REQUESTS_OOORDERS")
public class CoauthorRequestsOoorders implements java.io.Serializable {

    private Integer requestId;
    private Users usersByCreatedBy;
    private Users usersByCoauthUserId;
    private Users usersByUpdatedBy;
    private Products products;
    private String messageFromCoauth;
    private Date createdDate;
    private Date updatedDate;

    public CoauthorRequestsOoorders() {
    }

    public CoauthorRequestsOoorders(final Integer requestId) {
        this.requestId = requestId;
    }

    public CoauthorRequestsOoorders(final Integer requestId,
            final Users usersByCreatedBy, final Users usersByCoauthUserId,
            final Users usersByUpdatedBy, final Products products,
            final String messageFromCoauth, final Date createdDate,
            final Date updatedDate) {
        this.requestId = requestId;
        this.usersByCreatedBy = usersByCreatedBy;
        this.usersByCoauthUserId = usersByCoauthUserId;
        this.usersByUpdatedBy = usersByUpdatedBy;
        this.products = products;
        this.messageFromCoauth = messageFromCoauth;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Id
    @Column(name = "REQUEST_ID", unique = true, nullable = false, precision = 22, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COAUTHOR_REQUESTS_OOORDERS_SEQ")
    @SequenceGenerator(name = "COAUTHOR_REQUESTS_OOORDERS_SEQ", sequenceName = "COAUTHOR_REQUESTS_OOORDERS_SEQ", allocationSize = 1)
    public Integer getRequestId() {
        return this.requestId;
    }

    public void setRequestId(final Integer requestId) {
        this.requestId = requestId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY")
    public Users getUsersByCreatedBy() {
        return this.usersByCreatedBy;
    }

    public void setUsersByCreatedBy(final Users usersByCreatedBy) {
        this.usersByCreatedBy = usersByCreatedBy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COAUTH_USER_ID")
    public Users getUsersByCoauthUserId() {
        return this.usersByCoauthUserId;
    }

    public void setUsersByCoauthUserId(final Users usersByCoauthUserId) {
        this.usersByCoauthUserId = usersByCoauthUserId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATED_BY")
    public Users getUsersByUpdatedBy() {
        return this.usersByUpdatedBy;
    }

    public void setUsersByUpdatedBy(final Users usersByUpdatedBy) {
        this.usersByUpdatedBy = usersByUpdatedBy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DH_ID")
    public Products getProducts() {
        return this.products;
    }

    public void setProducts(final Products products) {
        this.products = products;
    }

    @Column(name = "MESSAGE_FROM_COAUTH", length = 1000)
    public String getMessageFromCoauth() {
        return this.messageFromCoauth;
    }

    public void setMessageFromCoauth(final String messageFromCoauth) {
        this.messageFromCoauth = messageFromCoauth;
    }

    @Column(name = "CREATED_DATE")
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "UPDATED_DATE")
    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(final Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
