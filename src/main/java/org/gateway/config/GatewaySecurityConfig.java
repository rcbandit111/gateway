package org.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
//@EnableWebSecurity
public class GatewaySecurityConfig {

//    @Bean
//    WebClient client() {
//        return WebClient.builder()
//                .build();
//    }

//    @Bean
//    public SecurityWebFilterChain intSpringSecurityFilterChain(ServerHttpSecurity http) {
//        http
//                .authorizeExchange()
//                .anyExchange().permitAll();
//        return http.build();
//    }



//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain (ServerHttpSecurity http) {
//
//        http.csrf().disable()
//                .authorizeExchange()
//                .pathMatchers("/api/**")
//                .permitAll();
////                .anyExchange()
////                .authenticated()
////                .and()
////                .oauth2Login(); // to redirect to oauth2 login page.
//        http.cors().configurationSource(request-> {
//            CorsConfiguration configuration = new CorsConfiguration();
//            configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//            configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS"));
//            configuration.setAllowedHeaders(List.of("*"));
//            return configuration;
//        });
//        return http.build();
//    }
}
