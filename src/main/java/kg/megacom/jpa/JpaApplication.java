package kg.megacom.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer",25, LocalDate.of(2021,02,01),true));
			repository.save(new Customer("Bob", "O'Brian",null,LocalDate.of(2021,06,05),false));
			repository.save(new Customer("Kim", "Bauer",26,LocalDate.of(2020,01,02),true));
			repository.save(new Customer("David", "Palmer",34,LocalDate.of(2021,01,31),true));
			repository.save(new Customer("Michelle", "Dessler",45,LocalDate.of(2020,01,07),false));
			repository.save(new Customer("Bill", "Gates",42,LocalDate.of(2021,05,05),true));
			repository.save(new Customer("Elon", "Musk",32,LocalDate.of(2021,07,23),true));
			repository.save(new Customer("Allen", "Williams",26,LocalDate.of(2021,02,23),true));
			repository.save(new Customer("Allen", "Barry",27,LocalDate.of(2021,03,8),true));
			repository.save(new Customer("Bill", "Williams",30,LocalDate.of(2021,04,19),false));
			repository.save(new Customer("Mark", "Lee",48,LocalDate.of(2020,12,31),true));
			repository.save(new Customer("cOnOr", "Hung",33,LocalDate.of(2021,06,6),false));


			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastNameOrFirstNameEquals('Bauer','Allen'):");
			log.info("--------------------------------------------");
			repository.findByLastNameOrFirstNameEquals("Bauer","Allen").forEach(name -> {
				log.info(name.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("--------------------------------------------");
			log.info("Customer found with findByLastNameAndFirstName('Gates','Bill'):");
			repository.findByLastNameAndFirstName("Gates","Bill").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("--------------------------------------------");
			log.info("Customer found with findByLastNameOrFirstName('Lee, Allen'):");
			repository.findByLastNameOrFirstName("Lee","Allen").forEach(name -> {
				log.info(name.toString());
			});
			log.info("--------------------------------------------");
			log.info("Customer found with findByAgeGreaterThanAndAgeLessThanEqual('27','45'):");
			log.info("");
			repository.findByAgeGreaterThanAndAgeLessThanEqual(27,45).forEach(age -> {
				log.info(age.toString());
			});
			log.info("");
			log.info("--------------------------------------------");
			log.info("Customer found with findByStartDateBeforeAndStartDateAfter(2021.01.01 and 2020.01.01):");
			log.info("");
			repository.findByStartDateBeforeAndStartDateAfter(
					LocalDate.of(2021,01,01),
					LocalDate.of(2020,01,01) )
					.forEach(date -> {
				log.info(date.toString());
			});
			log.info("--------------------------------------------");
			log.info("Customer list checking for Null values in age ");
			repository.findByAgeNull().forEach(age-> {
				log.info(age.toString());
			});

			log.info("--------------------------------------------");
			log.info("Customer list with findByFirstNameLike('Mark'): ");
			log.info("");
			repository.findByFirstNameLike("Mark").forEach(name-> {
				log.info(name.toString());
			});

			log.info("--------------------------------------------");
			log.info("Customer list with findByFirstNameStartingWithAndFirstNameContainingAndFirstNameEndingWith('B','i','l'): ");
			log.info("");
			repository.findByFirstNameStartingWithAndFirstNameContainingAndFirstNameEndingWith(
					"B",
					"i",
					"l")
					.forEach(name-> {
				log.info(name.toString());
			});


			log.info("--------------------------------------------");
			log.info("Customer list with findByAgeOrderByLastNameDesc('26'): "); // Отобразит в порядке убывания букв в имене
			log.info("");
			repository.findByAgeOrderByLastNameDesc(26).forEach(orderBy-> {
				log.info(orderBy.toString());
			});

			log.info("--------------------------------------------");
			log.info("Customer list with findByLastNameNot('Bauer'): ");
			log.info("");
			repository.findByLastNameNot("Bauer").forEach(nameNot-> {
				log.info(nameNot.toString());
			});

			log.info("--------------------------------------------");
			log.info("Customer list with findByAgeIn('list1 (42,32,25)): ");
			log.info("");
			repository.findByAgeIn(Arrays.asList(42,32,25)).forEach(ageIn-> {
				log.info(ageIn.toString());
			});

			log.info("--------------------------------------------");
			log.info("Customer list with findByAgeNotIn('list (42,32,25)'): ");
			log.info("");
			repository.findByAgeNotIn(Arrays.asList(42,32,25) ).forEach(ageNotIn-> {
				log.info(ageNotIn.toString());
			});

			log.info("--------------------------------------------");
			log.info("Customer list with activeTrueOrFalse: ");
			log.info("");
			repository.findByActiveTrueOrActiveFalse().forEach(activeTrue-> {
				log.info(activeTrue.toString());
			});
			

			log.info("--------------------------------------------");
			log.info("Customer list with findByFirstNameIgnoreCase: ");
			log.info("");
			repository.findByFirstNameIgnoreCase("CONOR").forEach(ignoreCase-> {
				log.info(ignoreCase.toString());
			});


		};
	}
}
