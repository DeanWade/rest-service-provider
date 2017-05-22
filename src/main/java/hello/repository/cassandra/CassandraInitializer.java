package hello.repository.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hello.model.Customer;

@Component
public class CassandraInitializer implements CommandLineRunner {

	@Autowired
	private CustomerCassandraRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new CustomerCassandra("Alice", "Smith"));
		this.repository.save(new CustomerCassandra("Bob", "Smith"));
		this.repository.save(new CustomerCassandra("Kate", "Smith"));
		this.repository.save(new CustomerCassandra("Jack", "Smith"));
		this.repository.save(new CustomerCassandra("Tom", "Smith"));
		this.repository.save(new CustomerCassandra("Type", "Cassandra"));
		
		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();
	}

}
