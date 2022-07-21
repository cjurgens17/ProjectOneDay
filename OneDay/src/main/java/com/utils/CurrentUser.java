package com.utils;

public class CurrentUser {

    public static CurrentUser currentUser;

    public static Integer employee_id;

    public static String username;

    public static String pass_word;

    public static String employee_type;


    public CurrentUser(Integer employee_id, String username, String pass_word, String employee_type){
        CurrentUser.employee_id = employee_id;
        CurrentUser.username = username;
        CurrentUser.pass_word = pass_word;
        CurrentUser.employee_type = employee_type;
    }



}
