package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Customer;
import hello.repository.cassandra.CustomerCassandra;
import hello.repository.cassandra.CustomerCassandraRepository;

@RestController
@RequestMapping(value="/repository/cassandra", produces = "application/json")
public class CustomerCassandraController extends CustomerController {
    
    @Autowired
    private CustomerCassandraRepository repository;

	@PutMapping("/customer")
    public Customer save(
    		@RequestParam(value="name", defaultValue="firstname") String firstname,
    		@RequestParam(value="name", defaultValue="lastname") String lastname){
    	return super.save(firstname, lastname);
    }
    
	@GetMapping("/customer/all")
    public Iterable<Customer> findAll(){
    	return super.findAll();
    }

	@Override
	protected CrudRepository<Customer, String> getRepository() {
		return repository;
	}
	
	@Override
	protected Customer createCustomer(String firstName, String lastName) {
		return new CustomerCassandra(firstName, lastName);
	}
	
}
