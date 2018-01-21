package org.nerdcoding.example.soap.soap.client;

import org.nerdcoding.example.soap.server.web.WeatherEndpoint;
import org.nerdcoding.example.soap.server.web.WeatherEndpointService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapClientApplication.class, args);
	}

	@Bean
	public WeatherEndpoint weatherEndpoint() {
		return new WeatherEndpointService().getWeatherEndpointPort();
	}
}
