package com.ravi.mukti.service;

import com.ravi.mukti.repository.ClientRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientRepository {
    @Override
    public String calToken(String partnerKey, String redirectUrl) {
        String baseStr = partnerKey + redirectUrl;
        String hashedString = DigestUtils.sha256Hex(baseStr);
        return hashedString;
    }
}
