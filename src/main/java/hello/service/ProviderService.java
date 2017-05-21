package hello.service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import hello.MyException;
import hello.model.Greeting;

@Service
public class ProviderService {

    private static final String template = "Hello, %s!";
    private static final String namespace = "hello.provider.greeting.";
    private final AtomicLong counter = new AtomicLong(1000);
    private final Lock lock = new ReentrantLock();
    
	@Autowired
	private RedisTemplate<String, Greeting> redisTemplate;
    
    public Greeting greeting(String name, String lock) {
    	if(lock.equals("lock")){
    		return doGreetingWithLock(name);
    	}
    	if(lock.equals("sync")){
    		return doGreetingWithSync(name);
    	}
    	return doGreeting(name);
    }
    

	public Greeting randomUriPath(int index) {
    	try {
    		if(index > 0 && index % 4 == 0){
    			Thread.sleep(4000);
    		}else{
    			Thread.sleep(1000);
    		}
		} catch (InterruptedException e) {
			//do nothing
		}
    	return doGreeting("RandomUriPath");
	}
    
    private synchronized Greeting doGreetingWithSync(String name){
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			//do nothing
		}
    	return doGreeting(name);
    }
    
	private Greeting doGreetingWithLock(String name){
		boolean locked = false;
    	try {
    		locked = lock.tryLock(2, TimeUnit.SECONDS);
    		if(locked){
    			Thread.sleep(1000);
    			return doGreeting(name);
    		}
		} catch (InterruptedException e) {
			throw new MyException(e);
		}finally{
			if(locked){
				lock.unlock();
			}
		}
    	throw new MyException("tryLock timeout");
    }
	
	public void exception() {
		throw new MyException("just throw MyException");
	}
    
    private Greeting doGreeting(String name){
    	ValueOperations<String, Greeting> ops = this.redisTemplate.opsForValue();
    	Greeting greeting = ops.get(namespace + name);
    	if(greeting != null){
    		return greeting;
    	}else{
    		greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
    		ops.set(namespace + name, greeting, 600, TimeUnit.SECONDS);
    		return greeting;
    	}
    }


}
