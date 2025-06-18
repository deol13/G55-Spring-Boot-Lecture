package se.lexicon.g55springbootlecture.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 100)
    private String courseName;

    // if you don't add mappedBy, another mapper table will be created.
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    // Will create a column with the name of instructor_id as a foreign key in this table/class
    // because we made this the owning side. The associated side will either have nothing or mappedby.
    // In ManyToOne, OneToMany or OneToOne it can be uni or bi directional, that means both or only one side needs to know.
    // By default, it will try to name the column by classname_primaryKeyName.
    // Add @JoinColumn(name = "name") to user a name of your choice.
    // @JoinColumn can add further configurations.
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Course(String courseName) {
        this.courseName = courseName;
    }
}
