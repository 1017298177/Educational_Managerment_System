package com.ed.pojo;


import java.util.List;

public class User extends MyPage{
    private Integer userId;

    private String userSno;

    private String userPassword;

    private String userName;

    private String userClass;

    private String userSex;

    private Integer userAge;

    private String userEmail;

    private String userDep;

    private String userCard;

    private String userImage;

    private String userNation;

    private String userTel;

    private String userSemester;

    private String userCollege;

    private List<Achievement> achievements;

    private List<Book> books;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userSno='" + userSno + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userClass='" + userClass + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userEmail='" + userEmail + '\'' +
                ", userDep='" + userDep + '\'' +
                ", userCard='" + userCard + '\'' +
                ", userImage='" + userImage + '\'' +
                ", userNation='" + userNation + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userSemester='" + userSemester + '\'' +
                ", userCollege='" + userCollege + '\'' +
                ", achievements=" + achievements +
                ", books=" + books +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserSno() {
        return userSno;
    }

    public void setUserSno(String userSno) {
        this.userSno = userSno;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserDep() {
        return userDep;
    }

    public void setUserDep(String userDep) {
        this.userDep = userDep;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserNation() {
        return userNation;
    }

    public void setUserNation(String userNation) {
        this.userNation = userNation;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserSemester() {
        return userSemester;
    }

    public void setUserSemester(String userSemester) {
        this.userSemester = userSemester;
    }

    public String getUserCollege() {
        return userCollege;
    }

    public void setUserCollege(String userCollege) {
        this.userCollege = userCollege;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}