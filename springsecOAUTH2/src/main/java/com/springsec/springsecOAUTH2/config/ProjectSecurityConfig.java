package com.springsec.springsecOAUTH2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests((requests)-> requests.requestMatchers("/secure").authenticated()
                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
        return httpSecurity.build();
    }

//    @Bean
//    ClientRegistrationRepository clientRegistrationRepository(){
//        ClientRegistration github = gitHubClientRegistration();
////        ClientRegistration facebook = facebookClientRegistration();
//        return new InMemoryClientRegistrationRepository(github);
//    }
//
//    private ClientRegistration gitHubClientRegistration(){
//        return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("Iv23liBz4WRj6kfzZqHy").clientSecret("8e36391f32871a65c30a571b1e20beb3c9239b89").build();
//    }

//    private ClientRegistration facebookClientRegistration(){
//        return CommonOAuth2Provider.FACEBOOK.getBuilder("facebook").clientId("").clientSecret("").build();
//    }
}

