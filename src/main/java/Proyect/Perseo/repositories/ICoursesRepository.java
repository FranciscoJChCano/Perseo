package Proyect.Perseo.repositories;

import Proyect.Perseo.models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoursesRepository extends JpaRepository<Courses, Long> {
    
}
