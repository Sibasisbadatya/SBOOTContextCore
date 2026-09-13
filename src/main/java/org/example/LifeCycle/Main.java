package org.example.LifeCycle;

import org.example.LifeCycle.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); doesn't have close method
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        ConfigurableApplicationContext is the child class of ApplicationContext which extends ApplicationContext and has close method
//        through this applicationContext we acn interact with the IOC
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.placeOrder();
        applicationContext.close();
    }
}



//BEAN - LIFECYCLE
// 1.IOC CONTAINER START

// 2.READS CONFIGURATION

// 3.READ BEAN DEFINITION
//at first it reads all class's bean definition
//for eg for orderService
//    beanName:"orderService" ..but we can give custom name also
//    beanClass:OrderService
//    scope:singleton
//    lazy:false
//    dependencies:paymentService

// 4.INSTANTIATION OF OBJECTS

// 5.DEPENDECIES ARE INJECTED
//if dependencies are craeted with constructor then dependency injection and object creation happens at same time
// for setter and method injection object creation an ddependency creation happens at different time

// 6.AWARE INTERFACES ARE CALLED
//details explained inOrderService with OrderService implements BeanNameAware, ApplicationContextAware

// 7.INITIALISATION CALLBACKS (after object creation and before service implementation used)
//    a.InitializingBean(Interface)->used for iniialisation Steps
//    b.Init Methods (instead of implementing InitializingBean interface we can use
//    init method in the bean class and specify it in the @Bean annotation in the AppConfig class)
//    c.PostConstruct instead of above 2 we simply write @PostCOnstruct above a method to which we want to initialise.(it comes from jakarta library)

// Question is why we don't initialise them in constructor instead.
// we dont want to have slow object creation and if we did depencies injected with setter method or method injection, for this we already read that
// during object/bean creation dependencies are not injected instead they are injected afterwards excepts for constructor injection. so if we do write initialisaton steps in constructor
// then we cant use uninjected dependencies to perform some work.

// 8.BEAN IS READY TO USE

// 9.DESTRUCTION CALLBACKS
//    a.DisposableBean(Interface)->used for destruction Steps
//    b.destroy Methods (instead of implementing InitializingBean interface we can use
//    destroy method in the bean class and specify it in the @Bean annotation in the AppConfig class)
//    c.PreDestroy instead of above 2 we simply write @PostCOnstruct above a method to which we want to destruction.(it comes from jakarta library)

// 10.BEANS DESTROYED


//FOR SINGLETON BEAN TYPE LAZY IOC will only handle upto 3 during bean creation but after calling for bean after steps will occur and handled by IOC

//but for prototype beans (where each call returns new instantiated bean) upto 7/8 only IOC handles afterwars we have to handle (eg for destruction callbacks)
//they got destroyed by garbage collector but we can implement our own destroy method and call it explicitly after using the bean.

