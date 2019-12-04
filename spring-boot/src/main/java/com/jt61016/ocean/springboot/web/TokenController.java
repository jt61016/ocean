package com.jt61016.ocean.springboot.web;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author jiangtao
 * @date 2019-12-04 14:37.
 */
@RestController
@RequestMapping("/token/")
public class TokenController {

    @GetMapping("toToken")
    public String toToken() {
        // 签名算法 ，将对token进行签名
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("SECRET");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        Map<String,Object> claimsMap = new HashMap<>();
        claimsMap.put("name","xiaoMing");
        claimsMap.put("age",14);
        JwtBuilder builderWithSercet = Jwts.builder().setSubject("subject")
                .setIssuer("issuer")
                .addClaims(claimsMap)
                .signWith(signatureAlgorithm, signingKey);

        return builderWithSercet.compact();
    }

    @GetMapping("fromToken")
    public String fromToken(String token) {
        // 签名算法 ，将对token进行签名
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("SECRET");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        StringBuilder sb = new StringBuilder("<h1>TOKEN INFO:</h1>");
        sb.append("<tr>source : " + token + "</tr><br/><br/>")
                .append("<tr>id : " + Optional.ofNullable(claims.getId()).orElse(" - ") + "</tr><br/>")
                .append("<tr>audience : " + Optional.ofNullable(claims.getAudience()).orElse(" - ") + "</tr><br/>")
                .append("<tr>expiration : " + (Objects.isNull(claims.getExpiration()) ? " - " : claims.getExpiration()) + "</tr><br/>")
                .append("<tr>issuedAt : " + (Objects.isNull(claims.getIssuedAt()) ? " - " : claims.getIssuedAt()) + "</tr><br/>")
                .append("<tr>issuer : " + Optional.ofNullable(claims.getIssuer()).orElse(" - ") + "</tr><br/>")
                .append("<tr>notBefore : " + (Objects.isNull(claims.getNotBefore()) ? " - " : claims.getNotBefore()) + "</tr><br/>")
                .append("<tr>subject : " + Optional.ofNullable(claims.getSubject()).orElse(" - ") + "</tr><br/>")
                .append("<tr>name : " + Optional.ofNullable(claims.get("name")).orElse(" - ") + "</tr><br/>")
                .append("<tr>age : " + Optional.ofNullable(claims.get("age")).orElse(" - ") + "</tr><br/>");

        return sb.toString();
    }

}
