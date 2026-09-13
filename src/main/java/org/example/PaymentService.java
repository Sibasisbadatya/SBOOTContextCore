package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
//    @Autowired
//    private  OrderService orderService;

       PaymentService(){
           System.out.println("Payment Service Created");
       }

//    PaymentService(OrderService orderService){
//        this.orderService=orderService;
//    }

//    public void pay() {
//        System.out.println("Payment Successful");
//        orderService.getOrderDetails();
//    }
}
