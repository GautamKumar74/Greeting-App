package com.tit.greetingapp.service;

import com.tit.greetingapp.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    private final Map<Long, Greeting> greetings = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

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

    // UC4 - Save a Greeting message
    public Greeting saveGreeting(String message) {
        long id = idCounter.incrementAndGet();
        Greeting greeting = new Greeting(id, message);
        greetings.put(id, greeting);
        return greeting;
    }

    // UC4 - Retrieve a Greeting by ID
    public Greeting getGreetingById(Long id) {
        return greetings.get(id);
    }
}
