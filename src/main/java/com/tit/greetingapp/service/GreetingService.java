package com.tit.greetingapp.service;

import com.tit.greetingapp.model.Greeting;
import com.tit.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;


@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    public String getGreetingMessage() {
        return "Hello World";
    }


    // UC3: Personalized Greeting (New Feature)
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return getGreetingMessage();  // Reusing UC2 method for default
        }
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message); // Create a Greeting entity
        return greetingRepository.save(greeting);  // Save to database
    }
}
