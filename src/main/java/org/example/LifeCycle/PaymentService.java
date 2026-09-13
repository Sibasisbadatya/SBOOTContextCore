package org.example.LifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class PaymentService implements InitializingBean, DisposableBean {

    public void payment(){
        System.out.println("Payment Done");
    }


    public void initializing(){
        System.out.println("Object creation is done with init Method");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Object creation is done");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Payment Bean is destroyed");
    }
}
