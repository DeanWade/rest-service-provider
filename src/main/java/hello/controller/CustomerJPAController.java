package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Customer;
import hello.repository.jpa.CustomerJPA;
import hello.repository.jpa.CustomerJPARepository;

@RestController
@RequestMapping(value="/provider/database", produces = "application/json")
public class CustomerJPAController {
    
    @Autowired
    private CustomerJPARepository repository;

	@PutMapping("/customer")
    public Customer save(
    		@RequestParam(value="firstname", defaultValue="firstname") String firstname,
    		@RequestParam(value="lastname", defaultValue="lastname") String lastname){
		CustomerJPA customer = createCustomer(firstname, lastname);
    	return getRepository().save(customer);
    }
    
	@GetMapping("/customer/all")
    public Iterable<CustomerJPA> findAll(){
		return getRepository().findAll();
    }

	protected CrudRepository<CustomerJPA, String> getRepository() {
		return repository;
	}
	
	protected CustomerJPA createCustomer(String firstName, String lastName) {
		return new CustomerJPA(firstName, lastName);
	}
	
}
