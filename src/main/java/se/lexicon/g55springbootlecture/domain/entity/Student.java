package se.lexicon.g55springbootlecture.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
    @UuidGenerator
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY = AUTO_INCREMENT    Do not work on Strings, something else is needed.   Only number data types
    //@Setter(AccessLevel.NONE) This is tells @Setter over the class not to make a setter method for this field
    private String id;  // changed from int
    @Column(nullable = false, length = 100)
    @Setter private String firstName;
    @Column(nullable = false, length = 100)
    @Setter private String lastName;
    @Column(nullable = false, length = 100, unique = true)
    @Setter private String email;

    @Setter private boolean status;
    @Setter private LocalDateTime createDate;

    // Cascade: is a feature in JPA that allows you to propagate operations performed on one entity to its related entities.
    // PERSIST = save
    // fetch: defines how the related entity is fetched from the database.
    // FetchType.EAGER means that the related entity (Address) is fetched immediately when the student is fetched.
    // FetchType.LAZY means that the related entity is fetched only when it is accessed for the first time.
    // Its more comment to use lazy to save on performance.
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE} , fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = true)
    @Setter private Address address;

    // This creates a mapper table, connection this class to courses class.
    // The mapper table is named students_courses
    @ManyToMany
    @JoinTable(
            name = "students_courses", // the main side is named first.
            joinColumns = @JoinColumn(name = "student_id"), // main side
            inverseJoinColumns = @JoinColumn(name = "course_id") // secondary side
    )
    private Set<Course> courses = new HashSet<>();

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

    // add helper methods to manipulate the course set.
    public void addCourse(Course course) {
        this.courses.add(course);

    }
    public void removeCourse(Course course) {
        this.courses.remove(course);
    }
}
