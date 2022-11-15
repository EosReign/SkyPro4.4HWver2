package prosky.skypro44hwver2.services;

import org.springframework.stereotype.Service;
import prosky.skypro44hwver2.entity.Student;
import prosky.skypro44hwver2.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(String studentName, int studentAge) {
        Student student = new Student(studentName, studentAge);
        return studentRepository.save(student);
    }

    public Student read(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    public Student update(Long studentId, String studentName, int studentAge) {
        Student student = new Student(studentId, studentName, studentAge);
        return studentRepository.save(student);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Collection<Student> findByAge(int studentAge) {
        return studentRepository.findByStudentAge(studentAge);
    }
    public Collection<Student> findByAgeBetween(int studentMinAge, int studentMaxAge) {
        return studentRepository.findByStudentAgeBetween(studentMinAge, studentMaxAge);
    }
}
