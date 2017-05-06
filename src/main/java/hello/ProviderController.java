package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

	private final ProviderService providerService;
	
	public ProviderController(ProviderService providerService){
		this.providerService = providerService;
	}
	
    @RequestMapping("/provider/greeting")
    public Greeting greeting(
    		@RequestParam(value="name", defaultValue="Provider") String name,
    		@RequestParam(value="lock", defaultValue="none") String lock) {
    	return providerService.greeting(name, lock);
    }
    
    @RequestMapping("/provider/exception")
    public void exception() {
    	providerService.exception();
    }
    
}
