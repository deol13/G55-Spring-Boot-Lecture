package se.lexicon.g55springbootlecture.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
// Java EE = jakarta

/*
CREATE TABLE Student(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
);
 */

// Lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
//@Setter
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "email")

//@Data // creates @Getter, @Setter, @EqualsAndHashCode and @ToString

@Entity //JPA, marks this as a database entity
//@Table(name = "students")
public class Student {
    @Id //Jakarta persistence   Primary Key and not null
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY = AUTO_INCREMENT    Do not work on Strings, something else is needed.   Only number data types
    private int id;
    @Column(nullable = false, length = 100)
    @Setter private String firstName;
    @Column(nullable = false, length = 100)
    @Setter private String lastName;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    private boolean status;
    private LocalDateTime createDate;

    //This will be called before saving to database, initializing default values to status and createDate
    @PrePersist
    public void onCreate() {
        this.status = true;
        this.createDate = LocalDateTime.now();
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
