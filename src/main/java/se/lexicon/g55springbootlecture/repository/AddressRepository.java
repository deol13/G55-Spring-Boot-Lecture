package se.lexicon.g55springbootlecture.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g55springbootlecture.domain.entity.Address;

@Repository // These are optional if you use Crud or JPA repository because they already exist there.
public interface AddressRepository extends CrudRepository<Address, Integer> {
    // spring data jpa generates all basic CRUD operations for the Student entity
/*
    save(S entity); // insert into student values() OR OR update existing one
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
}
