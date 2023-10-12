package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletontBean {

    public SingletontBean(){
        System.out.println("singleton creation");
    }
    public String getMyScope(){
        return "Singleton";
    }
}
