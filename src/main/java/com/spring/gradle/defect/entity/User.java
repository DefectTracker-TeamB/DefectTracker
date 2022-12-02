package com.spring.gradle.defect.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.servlet.SessionTrackingMode;
import javax.validation.constraints.NotNull;

import java.util.*;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"password", "teamMembers",})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int emp_id;
    
    @NotNull(message = "User name shouldn't be null")
    private String name;
    
    @NotNull(message = "username shouldn't be null")
    private String username;
    
    @NotNull(message = "password shouldn't be null")
    private String password;
    
    @NotNull(message = "availability shouldn't be null")
    private int availability;
    
    @NotNull(message = "Designation shouldn't be null")
    private String Designation;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
    @JsonManagedReference
    private List<TeamMember> teamMembers;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<Roles>roles=new HashSet<>();

    public void addRole(Roles roles){
        this.roles.add(roles);
    }
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority>authorities=new ArrayList<>();
        for (Roles i:this.roles){
            authorities.add(new SimpleGrantedAuthority(i.getRole_name()));

        }
        return authorities;
    }
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
