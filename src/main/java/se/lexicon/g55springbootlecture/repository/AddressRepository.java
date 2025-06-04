package se.lexicon.g55springbootlecture.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g55springbootlecture.domain.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
