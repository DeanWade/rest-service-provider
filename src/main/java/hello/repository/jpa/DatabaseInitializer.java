package hello.repository.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hello.model.Customer;

@Component
public class DatabaseInitializer implements CommandLineRunner {
	
	@Autowired
	private CustomerJPARepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		this.customerRepository.deleteAll();
		
		// save a couple of customers
		this.customerRepository.save(new CustomerJPA("Alice", "Smith"));
		this.customerRepository.save(new CustomerJPA("Bob", "Smith"));
		this.customerRepository.save(new CustomerJPA("Kate", "Smith"));
		this.customerRepository.save(new CustomerJPA("Jack", "Smith"));
		this.customerRepository.save(new CustomerJPA("Tom", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(this.customerRepository.findByFirstName("Alice"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Customer customer : this.customerRepository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}
		
	}
	
}
