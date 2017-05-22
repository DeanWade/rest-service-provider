package hello.controller;

import hello.model.Customer;
import hello.repository.mongo.CustomerMongo;
import hello.repository.mongo.CustomerMongoRepository;

public abstract class CustomerController {
	

    public Customer save(String firstname, String lastname){
		Customer customer = new CustomerMongo(firstname, lastname);
    	return getRepository().save(customer);
    }
    
    public Customer findByFirstName (String firstName){
		return getRepository().findByFirstName(firstName);
    }
    
    public Iterable<Customer> findAll(){
    	return this.getRepository().findAll();
    }
	
	protected abstract CustomerMongoRepository getRepository();
	
	protected abstract Customer createCustomer(String firstName, String lastName);
}
