package se.lexicon.g55springbootlecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g55springbootlecture.domain.entity.Course;

@Repository // These are optional if you use Crud or JPA repository because they already exist there.
public interface CourseRepository extends JpaRepository<Course, Long> {
}
