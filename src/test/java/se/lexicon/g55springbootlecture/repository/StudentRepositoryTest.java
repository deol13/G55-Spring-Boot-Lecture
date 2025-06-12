package se.lexicon.g55springbootlecture.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.g55springbootlecture.domain.entity.Student;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest // Enables JPA tests with an embedded database (like H2), rolls back after each test
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Order(1)
    @DisplayName("Save Mehrdad")
    void testSaveStudent() {
        // Arrange: create a student instance
        Student student = new Student("Mehrdad", "Javan", "mehrdad@example.com");

        // Act: save the student to the in-memory DB
        Student saved = studentRepository.save(student);

        // Assert: verify that the student was assigned an ID (i.e., persisted)
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    @DisplayName("Find Simon by email")
    void testFindByEmail() {
        // Arrange: save a student with a known email
        Student student = new Student("Simon", "Elbrink", "simon@example.com");
        studentRepository.save(student);

        // Act: retrieve the student using a custom method
        Optional<Student> optional = studentRepository.findByEmail("simon@example.com");

        // Assert: check that the student was found
        assertThat(optional).isPresent();
    }

    @Test
    @DisplayName("Find by first name - Elnaz")
    void testFindByFirstName() {
        // Arrange: insert a student with first name "Elnaz"
        studentRepository.save(new Student("Elnaz", "Azizi", "elnaz@example.com"));

        // Act: find students with that first name
        List<Student> result = studentRepository.findByFirstName("Elnaz");

        // Assert: ensure exactly one student is returned
        assertThat(result).hasSize(1);
    }

    @Test
    @DisplayName("Find all students: Mehrdad, Simon, Tobias")
    void testFindAll() {
        // Arrange: save 3 students
        studentRepository.save(new Student("Mehrdad", "Javan", "mehrdad.all@example.com"));
        studentRepository.save(new Student("Simon", "Jones", "simon.all@example.com"));
        studentRepository.save(new Student("Tobias", "Andersson", "tobias.all@example.com"));

        // Act: retrieve all students from the DB
        List<Student> students = (List<Student>) studentRepository.findAll();

        // Assert: check that 3 students exist
        assertThat(students).hasSize(3);
    }
}
