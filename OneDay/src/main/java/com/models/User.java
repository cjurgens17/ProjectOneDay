package com.models;

public class User {

    private Integer userId;

    private String username;

    private String password;

    private String horoscope;

    private String mood;

    private String firstName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User(){

    }

    public User(String username, String password, String horoscope, String mood, String firstName) {
        this.username = username;
        this.password = password;
        this.horoscope = horoscope;
        this.mood = mood;
        this.firstName = firstName;
    }

    public User(Integer userId, String username, String password, String horoscope, String mood, String firstName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.horoscope = horoscope;
        this.mood = mood;
        this.firstName = firstName;
    }
}
