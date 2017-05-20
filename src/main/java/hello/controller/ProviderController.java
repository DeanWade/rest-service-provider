package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.dao.CustomerRepository;
import hello.dao.GreetingRepository;
import hello.model.Customer;
import hello.model.Greeting;
import hello.service.ProviderService;

@RestController
@RequestMapping(value="/provider", produces = "application/json")
public class ProviderController {

	@Autowired
	private ProviderService providerService;
	
    @Autowired
    private GreetingRepository greetingRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
	
	@GetMapping("/greeting")
    public Greeting greeting(
    		@RequestParam(value="name", defaultValue="provider") String name,
    		@RequestParam(value="lock", defaultValue="none") String lock) {
    	return providerService.greeting(name, lock);
    }
    
    @GetMapping("/exception")
    public void exception() {
    	providerService.exception();
    }
    
	@GetMapping("/random/{index}")
	public Greeting randomUriPath(@PathVariable int index) {
		return providerService.randomUriPath(index);
	}
	
	@PutMapping("/dao/greeting")
    public Greeting save(@RequestParam(value="name", defaultValue="provider") String name){
		Greeting greeting = new Greeting(name);
    	return greetingRepository.save(greeting);
    }
    
	@GetMapping("/dao/greeting")
    public Greeting findByContent (@RequestParam(value="name", defaultValue="provider") String name){
    	return greetingRepository.findByContent(name);
    }
    
	@GetMapping("/dao/greetings")
    public Iterable<Greeting> findAll(){
    	return greetingRepository.findAll();
    }
	
	@PutMapping("/dao/customer")
    public Customer saveCustomer(@RequestParam(value="name", defaultValue="provider") String name){
		Customer customer = new Customer(name);
    	return customerRepository.save(customer);
    }
    
	@GetMapping("/dao/customer")
    public Customer findCustomerByFirstName (@RequestParam(value="name", defaultValue="provider") String name){
		return customerRepository.findByFirstName(name);
    }
    
	@GetMapping("/dao/customers")
    public List<Customer> findCustomers(){
		List<Customer> customers = this.customerRepository.findAll();
    	return customers;
    }
    
}
