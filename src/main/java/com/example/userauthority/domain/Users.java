package com.example.userauthority.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;


@Entity
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "PASSWORD")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "CREATED_AT")
    private LocalDate create_At;

    @Column(name = "UPDATE_AT")
    private LocalDate update_At;



    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public LocalDate getCreate_At() {
        return create_At;
    }

    public void setCreate_At(LocalDate create_At) {
        this.create_At = create_At;
    }

    public LocalDate getUpdate_At() {
        return update_At;
    }

    public void setUpdate_At(LocalDate update_At) {
        this.update_At = update_At;
    }


    @PrePersist
    protected void onCreate() {
        this.create_At = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.update_At = LocalDate.now();
    }

    /*
    UserDetails interface methods
     */

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
