package com.spring.gradle.defect.configeration;

import com.spring.gradle.defect.Security.CustomUserDetails;
import com.spring.gradle.defect.Security.JWTRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = false,
        securedEnabled = false,
        jsr250Enabled = true
)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/webjars/**",
            "/authenticate/**",
            "/user/**",
            "/roles/**"
    };
    private static final String[] ADMIN_AUTH_LIST={};
    private static final String[] PM_AUTH_LIST={"/members/**","/project/**","/module/**"};
    private static final String[] DEVELOPER_AUTH_LIST={"/defect/getAll","/defect/get/{id}"
            ,"/defect/status","/release/**"};
    private static final String[] QA_AUTH_LIST={"/defect/**","/smokeTest/**"};

    @Autowired
    private CustomUserDetails userService;
    @Autowired
    private JWTRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/roles/**").permitAll()
                .antMatchers(ADMIN_AUTH_LIST).hasRole("ADMIN")
                .antMatchers(PM_AUTH_LIST).hasRole("PM")
                .antMatchers(DEVELOPER_AUTH_LIST).hasRole("DEVELOPER")
                .antMatchers(QA_AUTH_LIST).hasRole("QA")
                .anyRequest()
                .authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
