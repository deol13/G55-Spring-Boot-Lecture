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
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    /*
    ManyToOne/OneToMany - Many side is usually the owning side
    OneToOne - Choose based on use case or data model
    ManyToMany - Pick one side as owning, use mappedBy on the other
     */

    @OneToMany(mappedBy = "instructor")
    private Set<Course> course = new HashSet<>();

    public Instructor(String name) {
        this.name = name;
    }
}
