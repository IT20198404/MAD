package com.example.juice_delivery_app;

public class class_user_profle {
    private String name;
    private  String address;
    private String tel;
    private String bod;
    private String age;
    private  String nic;
    private String email;

    public class_user_profle(String name, String address, String tel, String bod, String age, String nic, String email) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.bod = bod;
        this.age = age;
        this.nic = nic;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
