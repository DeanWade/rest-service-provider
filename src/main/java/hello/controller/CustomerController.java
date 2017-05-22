package hello.controller;

import org.springframework.data.repository.CrudRepository;

import hello.model.Customer;

public abstract class CustomerController {
	
    public Customer save(String firstname, String lastname){
		Customer customer = createCustomer(firstname, lastname);
    	return getRepository().save(customer);
    }
    
    public Iterable<Customer> findAll(){
    	return getRepository().findAll();
    }
	
	protected abstract CrudRepository<Customer, String> getRepository();
	
	protected abstract Customer createCustomer(String firstName, String lastName);
}
