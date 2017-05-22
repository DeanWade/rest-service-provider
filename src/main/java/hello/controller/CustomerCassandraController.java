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
@RequestMapping(value="/provider/cassandra", produces = "application/json")
public class CustomerCassandraController {
    
    @Autowired
    private CustomerCassandraRepository repository;

	@PutMapping("/customer")
    public Customer save(
    		@RequestParam(value="firstname", defaultValue="firstname") String firstname,
    		@RequestParam(value="lastname", defaultValue="lastname") String lastname){
		CustomerCassandra customer = createCustomer(firstname, lastname);
    	return getRepository().save(customer);
    }


	@GetMapping("/customer/all")
    public Iterable<CustomerCassandra> findAll(){
    	return getRepository().findAll();
    }
    
	private CrudRepository<CustomerCassandra, String> getRepository() {
		return repository;
	}
	
	protected CustomerCassandra createCustomer(String firstName, String lastName) {
		return new CustomerCassandra(firstName, lastName);
	}
	
}
