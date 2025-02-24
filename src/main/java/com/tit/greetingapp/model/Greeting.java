package com.tit.greetingapp.model;

import jakarta.persistence.*;

@Entity // Marks this class as a JPA entity (table in DB)
@Table(name = "greetings") // Optional: Specifies table name
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;
    private String message;

    public Greeting() {}

    public Greeting(String message) {
        this.message = message;
    }

    public Greeting(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
