package com.wiley.gr.ace.authorservices.model.external;

public class ViewLicenseAgreement {

    private WALSRequest getLicenseCopyRequest;

    public final WALSRequest getGetLicenseCopyRequest() {
        return getLicenseCopyRequest;
    }

    public final void setGetLicenseCopyRequest(
            final WALSRequest getLicenseCopyRequest) {
        this.getLicenseCopyRequest = getLicenseCopyRequest;
    }

}
