package de.segoy.springframework.sfgdi.controllers;

import de.segoy.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorController {

    private final GreetingService greetingService;

    public ConstructorController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public GreetingService getGreetingService() {
        return greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
