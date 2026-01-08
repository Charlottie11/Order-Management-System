package com.store.main;

import com.store.order.*;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderApp {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();

        orders.add(new OnlineOrder(11111, 1000.34));
        orders.add(new OnlineOrder(11112, 200.50));
        orders.add(new OnlineOrder(11113, 798));
        orders.add(new OnlineOrder(11114, 3541.79));
        orders.add(new OnlineOrder(11115, 165));

        OnlineOrder cancelledOrder1 = new OnlineOrder(11116, 10203.63);
        OnlineOrder cancelledOrder2 = new OnlineOrder(11117, 3651);
        orders.add(cancelledOrder1);
        orders.add(cancelledOrder2);

        cancelledOrder1.cancelOrder();
        cancelledOrder2.cancelOrder();

        Iterator<Order> lister = orders.iterator();

        while (lister.hasNext()) {
            Order order = lister.next();
            order.processOrder();
            if (order.getOrderStatus() == OrderStatus.CANCELLED) {
                lister.remove();
            }

            if (order.getOrderStatus() != OrderStatus.CANCELLED) {
                if (order instanceof OnlineOrder) {
                    if (order.getAmount() < 1000) {
                        ((OnlineOrder) order).pay();
                    }
                }
            }
            System.out.println(order.getOrderSummary());
            
            
        }

    }
}
