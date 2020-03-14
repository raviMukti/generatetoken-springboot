package com.ravi.mukti.entity;

public class Client {
    private String requestedUrl;
    private String partnerKey;

    public Client(String requestedUrl, String partnerKey) {
        this.requestedUrl = requestedUrl;
        this.partnerKey = partnerKey;
    }

    public String getRequestedUrl() {
        return requestedUrl;
    }

    public void setRequestedUrl(String requestedUrl) {
        this.requestedUrl = requestedUrl;
    }

    public String getPartnerKey() {
        return partnerKey;
    }

    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }
}
