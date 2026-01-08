package com.store.order;

public abstract class Order {
    private final int orderId;
    private double amount;
    private OrderStatus status;

    public Order(int orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = OrderStatus.PENDING;
    }

    public abstract void processOrder();


    public String getOrderSummary() {
        return "Order ID: " + orderId + "\nAmount:  ₱" + amount + "\nOrder Status: " + status;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            System.out.println("Amount cannot be lower than 0.");
        }
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void cancelOrder() {
        
        setStatus(OrderStatus.CANCELLED);
    }
}


