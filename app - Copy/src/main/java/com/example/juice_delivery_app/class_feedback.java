package com.example.juice_delivery_app;

public class class_feedback {
     private String userID;
     private String name;
     private String tel;
     private String decription;
     private String feedbackType;

    public class_feedback(String userID, String name, String tel, String decription, String feedbackType) {
        this.userID = userID;
        this.name = name;
        this.tel = tel;
        this.decription = decription;
        this.feedbackType = feedbackType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }
}
