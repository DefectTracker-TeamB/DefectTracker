package com.spring.gradle.defect.Security;

import com.spring.gradle.defect.entity.Roles;
import com.spring.gradle.defect.entity.User;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class JWTRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JWTUtility jwtUtility;
    private final List<String> excludeUrlPatterns = new ArrayList<String>(Arrays.asList("/swagger-ui.html",
            "/swagger-uui.html", "/webjars/springfox-swagger-ui/springfox.css",
            "/webjars/springfox-swagger-ui/swagger-ui-bundle.js", "/webjars/springfox-swagger-ui/swagger-ui.css",
            "/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js",
            "/webjars/springfox-swagger-ui/springfox.js", "/swagger-resources/configuration/ui",
            "/webjars/springfox-swagger-ui/favicon-32x32.png", "/swagger-resources/configuration/security",
            "/swagger-resources", "/v2/api-docs",
            "/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-700.woff2",
            "/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-regular.woff2",
            "/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-700.woff2",
            "/webjars/springfox-swagger-ui/favicon-16x16.png"));
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return excludeUrlPatterns.contains(path);
    }

    @Override
   protected void doFilterInternal(HttpServletRequest request,
                                   HttpServletResponse response, FilterChain filterChain)
           throws ServletException, IOException {

       if (!hasAuthorizationBearer(request)) {
           filterChain.doFilter(request, response);
           return;
       }

       String token = getAccessToken(request);

       if (!jwtUtility.validateJwtToken(token)) {
           filterChain.doFilter(request, response);
           return;
       }

       setAuthenticationContext(token, request);
       filterChain.doFilter(request, response);
   }

    private boolean hasAuthorizationBearer(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
            return false;
        }

        return true;
    }

    private String getAccessToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.split(" ")[1].trim();
        return token;
    }

    private void setAuthenticationContext(String token, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(token);

        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

   private UserDetails getUserDetails(String token) {
       User userDetails = new User();
       String[] jwtSubject = jwtUtility.getSubject(token).split(",");
       Claims claims=jwtUtility.parseClaims(token);
       String claimRoles= (String) claims.get("roles");
       System.out.println(claimRoles);
       claimRoles=claimRoles.replace("[","").replace("]","");
       String[] roles=claimRoles.split(",");
       for (String role_name:roles){
           userDetails.addRole(new Roles(role_name));
       }
       userDetails.setId(Integer.parseInt(jwtSubject[0]));
       userDetails.setUsername(jwtSubject[1]);
       return userDetails;
   }
}


