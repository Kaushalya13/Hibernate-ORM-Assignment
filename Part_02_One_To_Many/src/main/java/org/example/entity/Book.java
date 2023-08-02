package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Book {
    @Id
    private String id;
    private String name;

    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
