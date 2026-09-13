package org.example.LifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("orderServiceBean")
public class OrderService implements BeanNameAware, ApplicationContextAware {
    private PaymentService paymentService;

    @PostConstruct
    public void initializingClass() {
        System.out.println("Order Class has been initialised .");
    }

    @PreDestroy
    public void disposingClass() {
        System.out.println("Order Class has been Disposed .");
    }

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.payment();
        System.out.println("Order Placed");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }


    //    this below method ise used to know the details of the IOC container from which this bean came or created.
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext name is" + applicationContext.getClass());
    }

//    callback methods because we dont call this methods explicitly rather Spring IOC calls this methods
//    but if we try to setbean("customBean") then it simply prints Bean name is :... but doesn't internally sets the name to the bean.
}
