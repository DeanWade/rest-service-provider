package hello;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final Lock lock = new ReentrantLock();

    @RequestMapping("/provider/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	return doGreetingWithMonitor(name);
    }
    
    private Greeting doGreetingWithMonitor(String name){
    	return doGreetingInSynchronized(name);
    }
    
    private synchronized Greeting doGreetingInSynchronized(String name){
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			//do nothing
		}
    	return doGreeting(name);
    }
    
    @SuppressWarnings("unused")
	private Greeting doGreetingWithLock(String name){
    	try {
    		if(lock.tryLock(10, TimeUnit.SECONDS)){
    			Thread.sleep(1000);
    			return doGreeting(name);
    		}
		} catch (InterruptedException e) {
			//do nothing
		}finally{
			lock.unlock();
		}
    	throw new MyException();
    }
    
    private Greeting doGreeting(String name){
    	return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
