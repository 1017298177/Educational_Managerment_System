package com.ed.pojo;

public class Achievement extends MyPage {
    private Integer achievementId;

    private String achievementCourse;

    private String achievementCourseType;

    private Integer achievementCore;

    private Double achievementCourseCredit;

    private Integer achievementUserSno;

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementCourse() {
        return achievementCourse;
    }

    public void setAchievementCourse(String achievementCourse) {
        this.achievementCourse = achievementCourse;
    }

    public String getAchievementCourseType() {
        return achievementCourseType;
    }

    public void setAchievementCourseType(String achievementCourseType) {
        this.achievementCourseType = achievementCourseType;
    }

    public Integer getAchievementCore() {
        return achievementCore;
    }

    public void setAchievementCore(Integer achievementCore) {
        this.achievementCore = achievementCore;
    }

    public Double getAchievementCourseCredit() {
        return achievementCourseCredit;
    }

    public void setAchievementCourseCredit(Double achievementCourseCredit) {
        this.achievementCourseCredit = achievementCourseCredit;
    }

    public Integer getAchievementUserSno() {
        return achievementUserSno;
    }

    public void setAchievementUserSno(Integer achievementUserSno) {
        this.achievementUserSno = achievementUserSno;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "achievementId=" + achievementId +
                ", achievementCourse='" + achievementCourse + '\'' +
                ", achievementCourseType='" + achievementCourseType + '\'' +
                ", achievementCore=" + achievementCore +
                ", achievementCourseCredit=" + achievementCourseCredit +
                ", achievementUserSno=" + achievementUserSno +
                '}';
    }
}