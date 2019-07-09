package com.hellofan.backend.model;

import java.util.Date;

public class StudyPlan {
    private int id;
    private String tradictional;
    private Date learnTimes;
    private double efactor;
    private Date nextDate;
    private Date updateTime;
    private int repeatTimes;
    private String learnDate;

    /**
     * 外键，用户名
     */
    private String userName;

    public int getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public String getLearnDate() {
        return learnDate;
    }

    public void setLearnDate(String learnDate) {
        this.learnDate = learnDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
