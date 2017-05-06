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
    		@RequestParam(value="sync", defaultValue="none") String sync) {
    	return providerService.greeting(name, sync);
    }
    
    @RequestMapping("/provider/exception")
    public Greeting exception() {
    	return providerService.exception();
    }
    
}
