package com.asredanesh.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ContactSearchDto implements Serializable {

    private Long id;

    @Size(min = 5, message = "min character = 5")
    @NotNull(message = "no null field")
    private String name;

    @Size(min = 11, max = 11)
    private String phoneNumber;

    @Email
    private String email;

    private String organization;

    private String github;

    private Integer githubCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public Integer getGithubCount() {
        return githubCount;
    }

    public void setGithubCount(Integer githubCount) {
        this.githubCount = githubCount;
    }
}
