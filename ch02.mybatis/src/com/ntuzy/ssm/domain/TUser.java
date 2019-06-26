package com.ntuzy.ssm.domain;

public class TUser {
    private Integer id;

    private String name;

    private String passowrd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd == null ? null : passowrd.trim();
    }
}