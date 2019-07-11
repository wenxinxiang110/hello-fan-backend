package com.hellofan.backend.model.generator;

import java.util.Date;

public class StudyPlan {
    private Integer id;

    private String tradictional;

    private Integer learnTimes;

    private String userName;

    private Date nextDate;

    private Double efactor;

    private Date updateTime;

    private Integer repeatTimes;

    private String learnDate;

    public StudyPlan(Integer id, String tradictional, Integer learnTimes, String userName, Date nextDate, Double efactor, Date updateTime, Integer repeatTimes) {
        this.id = id;
        this.tradictional = tradictional;
        this.learnTimes = learnTimes;
        this.userName = userName;
        this.nextDate = nextDate;
        this.efactor = efactor;
        this.updateTime = updateTime;
        this.repeatTimes = repeatTimes;
    }

    public StudyPlan(Integer id, String tradictional, Integer learnTimes, String userName, Date nextDate, Double efactor, Date updateTime, Integer repeatTimes, String learnDate) {
        this.id = id;
        this.tradictional = tradictional;
        this.learnTimes = learnTimes;
        this.userName = userName;
        this.nextDate = nextDate;
        this.efactor = efactor;
        this.updateTime = updateTime;
        this.repeatTimes = repeatTimes;
        this.learnDate = learnDate;
    }

    public StudyPlan() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradictional() {
        return tradictional;
    }

    public void setTradictional(String tradictional) {
        this.tradictional = tradictional == null ? null : tradictional.trim();
    }

    public Integer getLearnTimes() {
        return learnTimes;
    }

    public void setLearnTimes(Integer learnTimes) {
        this.learnTimes = learnTimes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    public Double getEfactor() {
        return efactor;
    }

    public void setEfactor(Double efactor) {
        this.efactor = efactor;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(Integer repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public String getLearnDate() {
        return learnDate;
    }

    public void setLearnDate(String learnDate) {
        this.learnDate = learnDate == null ? null : learnDate.trim();
    }
}