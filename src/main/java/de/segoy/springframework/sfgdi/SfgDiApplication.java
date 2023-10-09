package de.segoy.springframework.sfgdi;

import de.segoy.springframework.sfgdi.controllers.ConstructorController;
import de.segoy.springframework.sfgdi.controllers.I18nController;
import de.segoy.springframework.sfgdi.controllers.MyController;
import de.segoy.springframework.sfgdi.controllers.SetterBasedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
        MyController myController = (MyController) ctx.getBean("myController");

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");

        System.out.println(i18nController.sayHello());


        System.out.println( myController.sayHello());



        System.out.println("-----Setter");
        SetterBasedController setter = (SetterBasedController) ctx.getBean("setterBasedController");
        System.out.println(setter.getGreeting());

        System.out.println("-----Construct");
        ConstructorController controller = (ConstructorController) ctx.getBean("constructorController");
        System.out.println(controller.getGreeting());


    }

}
