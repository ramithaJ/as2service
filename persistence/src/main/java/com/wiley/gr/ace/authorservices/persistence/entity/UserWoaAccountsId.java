package com.wiley.gr.ace.authorservices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserWoaAccountsId generated by hbm2java
 */
@Embeddable
public class UserWoaAccountsId implements java.io.Serializable {
    
    private int userId;
    private String woaaccntId;
    
    public UserWoaAccountsId() {
    }
    
    public UserWoaAccountsId(int userId, String woaaccntId) {
        this.userId = userId;
        this.woaaccntId = woaaccntId;
    }
    
    @Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    @Column(name = "WOAACCNT_ID", nullable = false, length = 25)
    public String getWoaaccntId() {
        return this.woaaccntId;
    }
    
    public void setWoaaccntId(String woaaccntId) {
        this.woaaccntId = woaaccntId;
    }
    
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof UserWoaAccountsId))
            return false;
        UserWoaAccountsId castOther = (UserWoaAccountsId) other;
        
        return (this.getUserId() == castOther.getUserId())
                && ((this.getWoaaccntId() == castOther.getWoaaccntId()) || (this
                        .getWoaaccntId() != null
                        && castOther.getWoaaccntId() != null && this
                        .getWoaaccntId().equals(castOther.getWoaaccntId())));
    }
    
    public int hashCode() {
        int result = 17;
        
        result = 37 * result + this.getUserId();
        result = 37
                * result
                + (getWoaaccntId() == null ? 0 : this.getWoaaccntId()
                        .hashCode());
        return result;
    }
    
}
