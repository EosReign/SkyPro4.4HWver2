package prosky.skypro44hwver2.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prosky.skypro44hwver2.entity.Student;
import prosky.skypro44hwver2.services.StudentService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path ="/{studentName}/{studentAge}")// Create
    public Student createStudent(@PathVariable String studentName,
                                 @PathVariable int studentAge) {
        return studentService.create(studentName, studentAge);
    }

    @PostMapping(path = "/{studentId}") // Read
    public Student readStudent(@PathVariable Long studentId) {
        return studentService.read(studentId);
    }

    @PutMapping(path = "/{studentId}/{studentName}/{studentAge}") // Update
    public Student updateStudent(@PathVariable Long studentId,
                                 @PathVariable String studentName,
                                 @PathVariable int studentAge) {
        return studentService.update(studentId, studentName, studentAge);
    }

    @DeleteMapping(path = "/{studentId}") // DELETE
    public ResponseEntity deleteStudent(@PathVariable Long studentId) {
        studentService.delete(studentId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/age/{studentAge}")
    public Collection<Student> findStudent(@PathVariable int studentAge) {
        return studentService.findByAge(studentAge);
    }

    @PostMapping(path = "/age/{studentMinAge}/{studentMaxAge}")
    public Collection<Student> findStudent(@PathVariable int studentMinAge,
                                           @PathVariable int studentMaxAge) {
        return studentService.findByAgeBetween(studentMinAge, studentMaxAge);
    }




}
