package com.wiley.gr.ace.authorservices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserAreaOfInterestId generated by hbm2java
 */
@Embeddable
public class UserAreaOfInterestId implements java.io.Serializable {
    
    private int userId;
    private Integer areaOfInterestId;
    
    public UserAreaOfInterestId() {
    }
    
    public UserAreaOfInterestId(int userId, Integer areaOfInterestId) {
        this.userId = userId;
        this.areaOfInterestId = areaOfInterestId;
    }
    
    @Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    @Column(name = "AREA_OF_INTEREST_ID", nullable = false, precision = 22, scale = 0)
    public Integer getAreaOfInterestId() {
        return this.areaOfInterestId;
    }
    
    public void setAreaOfInterestId(Integer areaOfInterestId) {
        this.areaOfInterestId = areaOfInterestId;
    }
    
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof UserAreaOfInterestId))
            return false;
        UserAreaOfInterestId castOther = (UserAreaOfInterestId) other;
        
        return (this.getUserId() == castOther.getUserId())
                && ((this.getAreaOfInterestId() == castOther
                        .getAreaOfInterestId()) || (this.getAreaOfInterestId() != null
                        && castOther.getAreaOfInterestId() != null && this
                        .getAreaOfInterestId().equals(
                                castOther.getAreaOfInterestId())));
    }
    
    public int hashCode() {
        int result = 17;
        
        result = 37 * result + this.getUserId();
        result = 37
                * result
                + (getAreaOfInterestId() == null ? 0 : this
                        .getAreaOfInterestId().hashCode());
        return result;
    }
    
}
