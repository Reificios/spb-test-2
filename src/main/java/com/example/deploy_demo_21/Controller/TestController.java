package com.example.deploy_demo_21.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.deploy_demo_21.Model.DTO.HelloWorldResponse;

import io.micrometer.tracing.annotation.NewSpan;

@RestController
@RefreshScope
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	private final RestTemplate restTemplate;

	public TestController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Value("${hello-message}")
	String message;
	
	@Value("${config-message}")
	String configMessage;
	
	@Value("${kube-message}")
	String kubeMessage;
	
	@Value("${alt-service}")
	String link;
	
	@GetMapping("/hello-world")
	public String HelloWorld() {
		logger.info("API call: Hello World");
		return "Hello World";
	}
	
	@GetMapping("/hello-world-2")
	public HelloWorldResponse HelloWorld2() {
		logger.info("API call: Hello World 2");
		return new HelloWorldResponse("Hello World");
	}
	
	@GetMapping("/hello-world-3")
	public String HelloWorld3() {
		logger.info("API call: Hello World 3");
		return "another hello world";
	}
	
	@GetMapping("/hello-msg")
	public String HelloMSG() {
		logger.info("API call: Hello World Message with " + message);
		return "Hello " + message;
	}
	
	@GetMapping("/hello-config")
	public String HelloConfig() {
		logger.info("API call: Hello World Message with " + message);
		return "Hello " + configMessage;
	}
	
	@GetMapping("/hello-kube")
	public String HelloKube() {
		logger.info("API call: Hello World Message with " + message);
		return "Hello " + kubeMessage;
	}
	
	@GetMapping("/hello-other")
	@NewSpan(value = "test-span")
	public String HelloOtherService() {
		logger.info("API call: Hello World from other service to " + link);
		
		final String uri = link;
		String result = restTemplate.getForObject(uri, String.class);
		
		return result;
	}
}
