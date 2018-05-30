package com.example.sweater;

import com.example.sweater.domain.Message;
import com.example.sweater.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private MessageRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
//        repository.save(new Message("Alice", "Smith"));
//        repository.save(new Message("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Message message : repository.findAll()) {
            System.out.println(message);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Message found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
//        for (Message message : repository.findByLastName("Smith")) {
//            System.out.println(message);
//        }

    }

}