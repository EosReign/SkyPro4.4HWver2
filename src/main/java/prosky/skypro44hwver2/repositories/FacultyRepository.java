package prosky.skypro44hwver2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prosky.skypro44hwver2.entity.Faculty;

import java.util.Collection;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findByFacultyColor(String facultyColor);
    Collection<Faculty> findByFacultyName(String facultyName);
}
