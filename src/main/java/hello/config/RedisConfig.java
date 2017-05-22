package hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import hello.model.Greeting;

@Configuration
//@EnableRedisRepositories("")
public class RedisConfig {
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		return connectionFactory;
	}
	
//	@Bean
	public LettuceConnectionFactory lettuceConnectionFactory(){
		return new LettuceConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Greeting> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String, Greeting> redisTemplate = new RedisTemplate<String, Greeting>();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}

}
