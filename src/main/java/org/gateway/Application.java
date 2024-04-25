package org.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@SpringBootApplication(scanBasePackages = {"org.gateway"}, exclude = ReactiveUserDetailsServiceAutoConfiguration.class)
@EnableDiscoveryClient
public class Application {

    DiscoveryClient discoveryClient;

    public Application(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void testing() {

        int size = discoveryClient.getServices().size();
        System.out.println("Starting EventListener when ApplicationReadyEvent !!!");
        System.out.println("Kubernetes services size " + size);
        discoveryClient.probe();
        for (String service : discoveryClient.getServices()) {
            System.out.println("Discovered service " + service);
        }
    }

    public static void main(final String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration apiCorsConfiguration = new CorsConfiguration();
//        apiCorsConfiguration.setAllowCredentials(true);
//        apiCorsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
//        apiCorsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
//        apiCorsConfiguration.setAllowedMethods(Collections.singletonList("*"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", apiCorsConfiguration);
//        return source;
//    }
}
