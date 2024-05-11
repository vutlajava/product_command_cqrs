package com.cmd.config;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.cmd.dto.ProductEvent;
import com.cmd.util.KafkaConstants;

@Configuration
public class KafkaProductConfig {
	
	
	@Bean
	public ProducerFactory<String,ProductEvent> producerFactory(){
		
		Map<String,Object> configProps = new HashMap<String,Object>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
	
		return new DefaultKafkaProducerFactory(configProps);
	}
	
	@Bean(name="kafkaTemplate")
	public KafkaTemplate<String,ProductEvent> kafkaTemplate() {
		return new KafkaTemplate<> (producerFactory());
	}

}
