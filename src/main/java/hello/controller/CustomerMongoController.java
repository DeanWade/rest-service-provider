package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Customer;
import hello.repository.mongo.CustomerMongo;
import hello.repository.mongo.CustomerMongoRepository;

@RestController
@RequestMapping(value="/provider/mongo", produces = "application/json")
public class CustomerMongoController {
    
    @Autowired
    private CustomerMongoRepository repository;

	@PutMapping("/customer")
    public Customer save(
    		@RequestParam(value="firstname", defaultValue="firstname") String firstname,
    		@RequestParam(value="lastname", defaultValue="lastname") String lastname){
		CustomerMongo customer = createCustomer(firstname, lastname);
    	return getRepository().save(customer);
    }
    
	@GetMapping("/customer/all")
    public Iterable<CustomerMongo> findAll(){
		return getRepository().findAll();
    }
	
	protected CrudRepository<CustomerMongo, String> getRepository() {
		return repository;
	}
	
	protected CustomerMongo createCustomer(String firstName, String lastName) {
		return new CustomerMongo(firstName, lastName);
	}
	
}
