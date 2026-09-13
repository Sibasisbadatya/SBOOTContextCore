package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//       OrderService orderService = new OrderService();
//       orderService.placeOrder();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        .class denotes the reflection (metadata of the class) Class<AppConfig>
        PaymentService paymentService = applicationContext.getBean(PaymentService.class);
        OrderService orderService1 = applicationContext.getBean(OrderService.class);
        OrderService orderService2 = applicationContext.getBean(OrderService.class);
        System.out.println(orderService1==orderService2);
//        orderService.placeOrder();
    }

//    Best practice is to avoid circular dependency
//    but some hack tricks are there
//    1.Use mehtod or setter injection(in spring context not in spring boot)
//    2.Use @Lazy annotation on one of the dependency (it first proxy object and after creation it injects real object to the dependency variable)
}
