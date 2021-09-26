package com.example.juice_delivery_app;

public class class_users {
    private String email;
    private String password;
    private String userType;
    public static String email_Global;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public class_users(String email, String password, String userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
        email_Global = email;
    }
}
