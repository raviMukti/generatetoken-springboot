package com.ravi.mukti.service;

public interface BaseGenerator {
    String calToken(String partnerKey, String redirectUrl);

    String generateLink(Integer partnerId, String partnerKey);
}
