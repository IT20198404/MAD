package com.example.juice_delivery_app;

public class class_pay {
    private  String orderId;
    private  String Itemprice;
    private  String deliveryCharge;
    private  String total;

    public class_pay(String orderId, String itemprice, String deliveryCharge, String total) {
        this.orderId = orderId;
        Itemprice = itemprice;
        this.deliveryCharge = deliveryCharge;
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemprice() {
        return Itemprice;
    }

    public void setItemprice(String itemprice) {
        Itemprice = itemprice;
    }

    public String getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
