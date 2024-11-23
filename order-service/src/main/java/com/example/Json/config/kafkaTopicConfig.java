package com.example.Json.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaTopicConfig {

	@Value("${spring.kafka.topic.name}")
	private String topicName;

	// create topic
	@Bean
	public NewTopic topic()
	{
		return TopicBuilder.name("order_topics").partitions(1).replicas(1).build();
	}
}
