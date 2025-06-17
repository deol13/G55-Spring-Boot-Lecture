package se.lexicon.g55springbootlecture.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.g55springbootlecture.domain.entity.Student;

import java.util.List;
import java.util.Optional;

// Repository layer.

// @Component and @Repository Does the same thing
//                                                         entity,id type
@Repository // These are optional if you use Crud or JPA repository because they already exist there.
public interface StudentRepository extends CrudRepository<Student,Integer> {
// spring data jpa generates all basic CRUD operations for the Student entity
/*
    save(S entity); // insert into student values() OR update existing one
    saveAll(Iterable<S> entities);
    findById(ID id); // select * from student where id = ?
    existsById(ID id);
    findAll();
    findAllById(Iterable<ID> ids);
    long count();
    deleteById(ID id);
    delete(T entity);
    deleteAllById(Iterable<? extends ID> ids);
    deleteAll(Iterable<? extends T> entities);
    deleteAll();
 */

    // As long as we follow naming conventions we just define and Spring data JPA will implement the method.
    // So Spring data JPA will implement the method below to work as the comment shows.
    // This is Query lookup, one way to create custom methods.

    // Method name query
    // select * from student where LOWER(first_name) like %?%
    List<Student> findByFirstNameIgnoreCaseContains(String firstName);

    // JPQL
    @Query("select s from Student s where s.firstName = :firstName")
    List<Student> getStudentDataByFirstName(@Param("firstName") String firstName);

    // JPQL
    // update student set status = ? where id = ?
    // :status and :id can be whatever name you want, @Param() just need to match.
    @Modifying // tells Spring Data JPA that this query will modify the database, and if it is not a select query.
    @Transactional
    @Query("update Student s set s.status = :status where s.id = :id")
    int updateStudentStatusById(@Param("id") String id, @Param("status") boolean status);

    Optional<Student> findByEmail(String email);

    List<Student> findByFirstName(String firstName);

}
