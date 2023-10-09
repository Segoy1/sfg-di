package de.segoy.springframework.sfgdi.controllers;

import de.segoy.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorControllerTest {

    ConstructorController controller;
    @BeforeEach
    void setUp() {
        controller = new ConstructorController(new ConstructorGreetingService());
    }

    @Test
    void getGreetingService() {
        System.out.println(controller.getGreetingService());
    }
}