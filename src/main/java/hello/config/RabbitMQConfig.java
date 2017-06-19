package hello.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	public final static String exchangeName = "spring-boot-exchange";
	
	public final static String sendQueueName = "spring-boot-send";
    
	public final static String sendReceiveQueueName = "spring-boot-send-receive";
    
	public final static String replyQueueName = "spring-boot-reply";

    @Bean
    Queue sendQueue() {
        return new Queue(sendQueueName, false);
    }
    
    @Bean
    Queue sendReceiveQueue() {
        return new Queue(sendReceiveQueueName, false);
    }
    
    @Bean
    MessageConverter messageConverter(){
    	return new Jackson2JsonMessageConverter();
    }
    
    @Bean
    SimpleRabbitListenerContainerFactory listenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter());
        return factory;
    }
}
