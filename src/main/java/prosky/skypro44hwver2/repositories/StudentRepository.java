package prosky.skypro44hwver2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prosky.skypro44hwver2.entity.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByStudentAge(int studentAge);
    Collection<Student> findByStudentAgeBetween(int studentMinAge, int studentMaxAge);
}
