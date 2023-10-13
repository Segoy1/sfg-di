package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.ConstructorGreetingService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(ConstructorConfig.class)
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(ConstructorConfig constructorConfig){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(constructorConfig.getUsername());
        fakeDataSource.setPassword(constructorConfig.getPassword());
        fakeDataSource.setJdbcurl(constructorConfig.getJdbcurl());

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog","defult"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){return new SetterInjectedGreetingService();}

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){return new PrimaryGreetingService();}

}
