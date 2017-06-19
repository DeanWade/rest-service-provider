package hello.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import hello.config.RabbitMQConfig;
import hello.model.Greeting;

@Component
public class Receiver {
	
	public void handleMessage(String message){
        System.out.println("handleMessage : <" + message + ">");
	}

	@RabbitListener(queues=RabbitMQConfig.sendQueueName)
    public void receive(String message) {
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
        System.out.println("Received: <" + message + ">");
    }
	
	@RabbitListener(queues=RabbitMQConfig.sendReceiveQueueName)
    public Greeting receiveAndReply(String message) {
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
        System.out.println("Received and Reply: <" + message + ">");
        return new Greeting(0L, message.toUpperCase());
    }

}
