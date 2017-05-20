package hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import hello.dao.CustomerRepository;
import hello.dao.GreetingRepository;
import hello.model.Customer;
import hello.model.Greeting;

@Component
public class AppInitializer implements CommandLineRunner {

    @Autowired
    private GreetingRepository greetingRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
	@Autowired
	private RedisTemplate<String, Greeting> redisTemplate;
    
	@Override
	public void run(String... args) throws Exception {
		initMySQL();
		initMongoDB();
		initRedis();
	}

	private void initRedis() {
		redisTemplate.opsForValue();
	}

	private void initMySQL(){
		greetingRepository.deleteAll();
		greetingRepository.save(new Greeting("Alice"));
		greetingRepository.save(new Greeting("Bob"));
		greetingRepository.save(new Greeting("Kate"));
		greetingRepository.save(new Greeting("Jack"));
		greetingRepository.save(new Greeting("Tom"));
	}
	
	private void initMongoDB(){
		this.customerRepository.deleteAll();
		
		// save a couple of customers
		this.customerRepository.save(new Customer("Alice", "Smith"));
		this.customerRepository.save(new Customer("Bob", "Smith"));
		this.customerRepository.save(new Customer("Kate", "Smith"));
		this.customerRepository.save(new Customer("Jack", "Smith"));
		this.customerRepository.save(new Customer("Tom", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.customerRepository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.customerRepository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}
