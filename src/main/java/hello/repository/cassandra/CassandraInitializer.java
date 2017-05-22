package hello.repository.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hello.model.Customer;

@Component
public class CassandraInitializer implements CommandLineRunner {

	@Autowired(required=false)
	private CustomerCassandraRepository repository;

	@Override
	public void run(String... args) throws Exception {
		if(repository == null){
			return;
		}
//		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new CustomerCassandra("Alice", "Smith"));
		this.repository.save(new CustomerCassandra("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
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
