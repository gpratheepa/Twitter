package com.tweets.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaMapper;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		JodaMapper jodaMapper = new JodaMapper();
		jodaMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		MappingJackson2HttpMessageConverter configuredConverter = new MappingJackson2HttpMessageConverter();
		configuredConverter.setObjectMapper(jodaMapper);
		restTemplate.getMessageConverters().removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);
		restTemplate.getMessageConverters().add(configuredConverter);
		return restTemplate;
	}
}
