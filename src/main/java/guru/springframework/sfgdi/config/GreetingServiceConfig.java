package guru.springframework.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;

import guru.springframework.sfgdi.services.ConstructorGreetingService;
import guru.springframework.sfgdi.services.I18nEnglishGreetingService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.PropertyInjectedGreetingService;

@ImportResource("config.xml")
@Configuration
public class GreetingServiceConfig {

	@Bean
	PetServiceFactory petServiceFactory() {
		return new PetServiceFactory();
	}
	
	
	@Profile({"dog", "default"})
	@Bean
	PetService dogPetService(PetServiceFactory petServiceFactory) {   //obiekt petServiceFactory wstrzykiwany z wczesniej utworzonego beana
		return petServiceFactory().getPetService("dog");
	}
	
	
	@Profile("cat")
	@Bean
	PetService catPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory().getPetService("cat");
	}
	
	
	@Profile("EN")
	@Bean("i18nService")
	I18nEnglishGreetingService i18nEnglishGreetingService() {
		return new I18nEnglishGreetingService();
	}
	
	
	//@Bean instantiated in xml config file
	ConstructorGreetingService constructorGreetingService() {
		return new ConstructorGreetingService();
	}

	@Bean
	PropertyInjectedGreetingService propertyInjectedGreetingService() {
		return new PropertyInjectedGreetingService();
	}
	@Primary
	@Bean
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}
	
}
