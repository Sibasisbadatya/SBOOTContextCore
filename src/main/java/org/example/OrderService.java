package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope("prototype")
public class OrderService {
//    private PaymentService paymentService;

//    OrderService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

//    public void placeOrder() {
//        paymentService.pay();
//        System.out.println("Order Placed");
//    }
    OrderService(){
        System.out.println("Order Service Created");
    }

    public void getOrderDetails(){
        System.out.println("Order Details");
    }
}
