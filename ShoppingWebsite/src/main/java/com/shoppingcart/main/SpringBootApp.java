package com.shoppingcart.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.shoppingcart.service","com.shoppingcart.controller","com.shoppingcart.model","com.shoppingcart.dao"})
@EnableJpaRepositories("com.shoppingcart.dao")
@EntityScan("com.shoppingcart.model")
public class SpringBootApp 
{
     public static void main(String[] args) 
     {
         SpringApplication.run(SpringBootApp.class, args);
     }
}
