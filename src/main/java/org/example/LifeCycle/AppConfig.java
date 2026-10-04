package org.example.LifeCycle;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("org.example.LifeCycle")
@Configuration
public class AppConfig {
    @Bean(initMethod = "initializing")
    public PaymentService paymentService() {
        return new PaymentService();
    }

    //    Here we made bean of PaymentService (and the name of the bean will be "paymentService") and
//    since the bean created from IOC with component annotation for PaymentService (register bean name as paymentService (camelcase))
//    and here also bean name is same so IOC will take priorise explcit bean declartion by us.
//    if here we createfd with different name IOC would have got 2 bean for same Class then error would have occured.


    @Bean(initMethod = "initializing")
    public PaymentService paymentService1() {
        return new PaymentService();
    }
//    even if the bean type is singleton ( which creates 1 bean for 1 bean definition)
//    since here there is 2 bean definition paymentService and paymentService1 so 2 bean will be created for same class PaymentService and if not resolved
//    for multiple bean then error would happen.


}
