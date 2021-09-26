package com.example.juice_delivery_app;

public class class_order_reject {
    private String order;
    private String reason;
    private String description;

    public class_order_reject(String order, String reason, String description) {
        this.order = order;
        this.reason = reason;
        this.description = description;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
