package com.spring.gradle.defect.Security;

import com.spring.gradle.defect.entity.Roles;
import com.spring.gradle.defect.entity.User;
import com.spring.gradle.defect.repository.UserRepository;
import io.jsonwebtoken.*;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;

@Service
public class JWTUtility {
   
    private static final String Secret_Key = "defect_tracker";
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JWTUtility.class);

    public String generateAccessToken(User user){
        Set<Roles>roles=user.getRoles();
        List<String>role=new ArrayList<>();
        for(Roles i:roles){
            role.add(i.getRole_name());
        }
        return Jwts.builder().setSubject(user.getId()+","+user.getUsername())
                .claim("roles",user.getRoles().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256,Secret_Key).compact();
    }
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(Secret_Key).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
    public String getSubject(String token){
        return parseClaims(token).getSubject();
    }
    public Claims parseClaims(String token){
        return Jwts.parser()
                .setSigningKey(Secret_Key)
                .parseClaimsJws(token)
                .getBody();
    }


}
