package pl.sdacademy.spring.car_dealer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Application application =
                applicationContext.getBean("application", Application.class);
        application.start();
    }
}
