package hello.repository.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hello.model.Customer;

@Component
public class DatabaseInitializer implements CommandLineRunner {
	
	@Autowired
	private CustomerJPARepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		this.repository.deleteAll();
		
		// save a couple of customers
		this.repository.save(new CustomerJPA("Alice", "Smith"));
		this.repository.save(new CustomerJPA("Bob", "Smith"));
		this.repository.save(new CustomerJPA("Kate", "Smith"));
		this.repository.save(new CustomerJPA("Jack", "Smith"));
		this.repository.save(new CustomerJPA("Tom", "Smith"));
		this.repository.save(new CustomerJPA("Type", "MySQL"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();
		
	}
	
}
