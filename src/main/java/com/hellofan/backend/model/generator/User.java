package com.hellofan.backend.model.generator;

import java.util.Date;

public class User {
    private Integer id;

    private String phoneNum;

    private String password;

    private String userName;

    private Date updateTime;

    private Integer currentWord;

    private Integer wordsPerday;

    private String nickName;

    private String sex;

    private String school;

    private String avatarUrl;

    private String studyDays;

    private String brief;

    private String lastLearnDate;

    private String todayWords;

    public User(Integer id, String phoneNum, String password, String userName, Date updateTime, Integer currentWord, Integer wordsPerday, String nickName, String sex, String school, String avatarUrl, String studyDays, String brief) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.password = password;
        this.userName = userName;
        this.updateTime = updateTime;
        this.currentWord = currentWord;
        this.wordsPerday = wordsPerday;
        this.nickName = nickName;
        this.sex = sex;
        this.school = school;
        this.avatarUrl = avatarUrl;
        this.studyDays = studyDays;
        this.brief = brief;
    }

    public User(Integer id, String phoneNum, String password, String userName, Date updateTime, Integer currentWord, Integer wordsPerday, String nickName, String sex, String school, String avatarUrl, String studyDays, String brief, String lastLearnDate, String todayWords) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.password = password;
        this.userName = userName;
        this.updateTime = updateTime;
        this.currentWord = currentWord;
        this.wordsPerday = wordsPerday;
        this.nickName = nickName;
        this.sex = sex;
        this.school = school;
        this.avatarUrl = avatarUrl;
        this.studyDays = studyDays;
        this.brief = brief;
        this.lastLearnDate = lastLearnDate;
        this.todayWords = todayWords;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(Integer currentWord) {
        this.currentWord = currentWord;
    }

    public Integer getWordsPerday() {
        return wordsPerday;
    }

    public void setWordsPerday(Integer wordsPerday) {
        this.wordsPerday = wordsPerday;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getStudyDays() {
        return studyDays;
    }

    public void setStudyDays(String studyDays) {
        this.studyDays = studyDays == null ? null : studyDays.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getLastLearnDate() {
        return lastLearnDate;
    }

    public void setLastLearnDate(String lastLearnDate) {
        this.lastLearnDate = lastLearnDate == null ? null : lastLearnDate.trim();
    }

    public String getTodayWords() {
        return todayWords;
    }

    public void setTodayWords(String todayWords) {
        this.todayWords = todayWords == null ? null : todayWords.trim();
    }
}