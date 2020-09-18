package com.ravi.mukti.service.impl;

import com.ravi.mukti.helper.HMAC;
import com.ravi.mukti.service.BaseGenerator;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

@Service
public class BaseGeneratorImpl implements BaseGenerator {
    @Override
    public String calToken(String partnerKey, String redirectUrl) {
        String baseStr = partnerKey + redirectUrl;
        String hashedString = DigestUtils.sha256Hex(baseStr);
        return hashedString;
    }

    @Override
    public String generateLink(Integer partnerId, String partnerKey) {
        Long unixTimeStamp = Instant.now().getEpochSecond();
        String host = "https://partner.uat.shopeemobile.com";
        String path = "/api/v2/shop/auth_partner";
        String redirectUrl = "https://www.haistar.co.id";
        BigInteger hexFormat = null;
        byte[] hmacSha256 = null;

        // Concatenate String
        String baseString = partnerId + path + unixTimeStamp;

        try {
            hmacSha256 = HMAC.calcHmacSha256(partnerKey.getBytes(), baseString.getBytes());
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        String link = host + path + "?partner_id="+ partnerId + "&timestamp=" + unixTimeStamp + "&sign=" + DigestUtils.sha256Hex(hmacSha256) + "&redirect=" + redirectUrl;

        return link;
    }
}
