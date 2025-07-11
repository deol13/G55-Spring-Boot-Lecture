package se.lexicon.g55springbootlecture.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String postalCode;

    // @Transient means this field must only be used in the Java application, it will not be persisted to the database
//    @Transient
//    private String demo;

    // This lets this side of the associated relation know of it and allows it
    // information from the "main" side.
    @OneToOne(mappedBy = "address")
    private Student student;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }
}
