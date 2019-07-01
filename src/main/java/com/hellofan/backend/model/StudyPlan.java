package com.hellofan.backend.model;

import java.util.Date;

public class StudyPlan {
    private int id;
    private String tradictional;
    private Date learnTimes;
    private String value;
    private int user;
    private double efactor;
    private Date nextDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTradictional() {
        return tradictional;
    }

    public void setTradictional(String tradictional) {
        this.tradictional = tradictional;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public double getEfactor() {
        return efactor;
    }

    public void setEfactor(double efactor) {
        this.efactor = efactor;
    }

    public Date getLearnTimes() {
        return learnTimes;
    }

    public void setLearnTimes(Date learnTimes) {
        this.learnTimes = learnTimes;
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }
}
