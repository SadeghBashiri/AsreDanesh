package com.asredanesh.demo.entities;

import com.asredanesh.demo.base.domains.BaseEntity;

import javax.persistence.*;

@Entity
public class Contact extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "phone", nullable = false, length = 11)
    private String phoneNumber;

    @Column(nullable = false, unique = true, length = 40)
    private String email;

    private String organization;

    @Column(nullable = false, unique = true, length = 100)
    private String github;

    private Integer githubCount;

    @Override
    public Long getId() {
        return id;
    }

    @Override
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
