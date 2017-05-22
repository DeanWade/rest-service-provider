package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Greeting;
import hello.service.ProviderService;

@RestController
@RequestMapping(value="/provider", produces = "application/json")
public class ProviderController {

	@Autowired
	private ProviderService providerService;
	
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
    
}
