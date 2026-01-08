package com.store.order;

import com.store.payment.Payable;

public class OnlineOrder extends Order implements Payable{
    
    public OnlineOrder(int orderId, double amount) {
        super(orderId, amount);
 
    }
    @Override
    public void processOrder() {
        System.out.println("\n-------------------------------------");
        System.out.println("Processing Online Order ID: " + getOrderId());
        System.out.println("-------------------------------------\n");
    }

    @Override
    public void pay() {
        setStatus(OrderStatus.PAID);
        System.out.println("\n-----------------------------------");
        System.out.println("| Order ID: " + getOrderId()+ ", has been paid. |");
        System.out.println("-----------------------------------\n");
    }

    
}
