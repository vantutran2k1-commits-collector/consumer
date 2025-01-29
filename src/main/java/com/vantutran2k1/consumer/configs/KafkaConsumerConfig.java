package com.vantutran2k1.consumer.configs;

import com.vantutran2k1.consumer.payloads.CommitEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CommitEvent> userRegistrationListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CommitEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(commitsConsumerFactory());
        return factory;
    }

    private ConsumerFactory<String, CommitEvent> commitsConsumerFactory() {
        Map<String, Object> props = new HashMap<>(consumerProps());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "github_commits");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(CommitEvent.class));
    }

    private Map<String, Object> consumerProps() {
        return Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress
        );
    }
}
