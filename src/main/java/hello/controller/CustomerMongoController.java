package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Customer;
import hello.repository.mongo.CustomerMongo;
import hello.repository.mongo.CustomerMongoRepository;

@RestController
@RequestMapping(value="/repository/mongo", produces = "application/json")
public class CustomerMongoController extends CustomerController {
    
    @Autowired(required=false)
    private CustomerMongoRepository repository;

	@PutMapping("/customer")
    public Customer save(
    		@RequestParam(value="name", defaultValue="firstname") String firstname,
    		@RequestParam(value="name", defaultValue="lastname") String lastname){
    	return super.save(firstname, lastname);
    }
    
	@GetMapping("/customer")
    public Customer findByFirstName (@RequestParam(value="name", defaultValue="firstname") String firstname){
		return super.findByFirstName(firstname);
    }
    
	@GetMapping("/customer/all")
    public Iterable<Customer> findAll(){
    	return super.findAll();
    }

	@Override
	protected CustomerMongoRepository getRepository() {
		return repository;
	}
	
	@Override
	protected Customer createCustomer(String firstName, String lastName) {
		return new CustomerMongo(firstName, lastName);
	}
	
}
