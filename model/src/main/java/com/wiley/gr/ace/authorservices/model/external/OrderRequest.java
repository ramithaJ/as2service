package com.wiley.gr.ace.authorservices.model.external;


/**
 * @author virtusa version1.0
 *
 */
public class OrderRequest
{
    private String applicationKey;

    private OrderData orderData;

    private String userID;

    private String correlationID;

    public String getApplicationKey ()
    {
        return applicationKey;
    }

    public void setApplicationKey (String applicationKey)
    {
        this.applicationKey = applicationKey;
    }

    public OrderData getOrderData ()
    {
        return orderData;
    }

    public void setOrderData (OrderData orderData)
    {
        this.orderData = orderData;
    }

    public String getUserID ()
    {
        return userID;
    }

    public void setUserID (String userID)
    {
        this.userID = userID;
    }

    public String getCorrelationID ()
    {
        return correlationID;
    }

    public void setCorrelationID (String correlationID)
    {
        this.correlationID = correlationID;
    }


}

