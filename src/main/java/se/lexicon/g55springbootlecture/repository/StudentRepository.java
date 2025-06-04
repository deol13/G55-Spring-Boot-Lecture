package se.lexicon.g55springbootlecture.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.g55springbootlecture.domain.entity.Student;

import java.util.List;

// Repository layer.

// @Component and @Repository Does the same thing
//                                                         entity,id type
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    // As long as we follow naming conventions we just define and Spring data JPA will implement the method.
    // So Spring data JPA will implement the method below to work as the comment shows.
    // This is Query lookup, one way to create custom methods.
    // select * from student where first_name = ?
    List<Student> findByFirstName(String firstName);

    // JPQL
    @Query("select s from Student s where s.firstName = :firstName")
    List<Student> getStudentDataByFirstName(@Param("firstName") String firstName);
}
