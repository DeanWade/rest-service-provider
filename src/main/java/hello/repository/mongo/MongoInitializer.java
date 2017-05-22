package hello.repository.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hello.model.Customer;

@Component
public class MongoInitializer implements CommandLineRunner {

	@Autowired(required=false)
	private CustomerMongoRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		if(repository == null){
			return;
		}
		
		this.repository.deleteAll();
		
		// save a couple of customers
		this.repository.save(new CustomerMongo("Alice", "Smith"));
		this.repository.save(new CustomerMongo("Bob", "Smith"));
		this.repository.save(new CustomerMongo("Kate", "Smith"));
		this.repository.save(new CustomerMongo("Jack", "Smith"));
		this.repository.save(new CustomerMongo("Tom", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
	}
	
}
