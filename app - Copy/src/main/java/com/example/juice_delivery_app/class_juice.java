package com.example.juice_delivery_app;

import java.io.Serializable;

public class class_juice implements Serializable {
    private String title;
    private String price;
    private String key;
    private String type;

    public class_juice() {

    }

    public class_juice(String title, String price, String type) {
        this.title = title;
        this.price = price;
        this.type = type;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
