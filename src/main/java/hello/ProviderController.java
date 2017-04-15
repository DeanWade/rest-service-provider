package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/provider/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	return doGreeting(name);
    }
    
    private synchronized Greeting doGreeting(String name){
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
    	return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
