package br.com.rodrigoamora.producer.events.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import br.com.rodrigoamora.producer.dto.ShopDTO;

@Configuration
public class KafkaConfig {

	@Value(value = "${kafka.bootstrapAddress:localhost:9092}")
	private String bootstrapAddress;

	public ProducerFactory<String, ShopDTO> producerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				bootstrapAddress);
		
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				JsonSerializer.class);
		props.put(ProducerConfig.CLIENT_ID_CONFIG,
				"shop-api");
		
		return new DefaultKafkaProducerFactory<>(props);
	}
	
	@Bean
	KafkaTemplate<String, ShopDTO> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
	
	public ConsumerFactory<String, ShopDTO> consumerFactory() {
		JsonDeserializer<ShopDTO> deserializer = new JsonDeserializer<>(ShopDTO.class);
		
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		
		return new DefaultKafkaConsumerFactory<>(props,
							new StringDeserializer(),
							deserializer);
	}
	
	@Bean
	ConcurrentKafkaListenerContainerFactory<String, ShopDTO> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, ShopDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
