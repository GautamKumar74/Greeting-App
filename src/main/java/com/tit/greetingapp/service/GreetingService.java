package com.tit.greetingapp.service;

import com.tit.greetingapp.model.Greeting;
import com.tit.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;


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

    // UC5 - Retrieve a Greeting by ID
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found for ID: " + id));
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll(); // Fetches all greetings from DB
    }

    // uc7
    public Greeting updateGreeting(Long id, String newMessage) {
        return greetingRepository.findById(id)
                .map(existingGreeting -> {
                    existingGreeting.setMessage(newMessage);
                    return greetingRepository.save(existingGreeting);
                })
                .orElseThrow(() -> new RuntimeException("Greeting with ID " + id + " not found!"));
    }
}
