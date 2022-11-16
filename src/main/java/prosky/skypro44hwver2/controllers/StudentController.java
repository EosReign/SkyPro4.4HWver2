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

    @PostMapping(path ="/create")// Create
    @ResponseBody
    public Student createStudent(@RequestParam("name") String studentName,
                                 @RequestParam("age") int studentAge) {
        return studentService.create(studentName, studentAge);
    }

    @GetMapping(path = "/{studentId}") // Read
    public Student readStudent(@PathVariable Long studentId) {
        return studentService.read(studentId);
    }

    @PutMapping(path = "/update") // Update
    public Student updateStudent(@RequestParam("id") Long studentId,
                                 @RequestParam("name") String studentName,
                                 @RequestParam("age") int studentAge) {
        return studentService.update(studentId, studentName, studentAge);
    }

    @DeleteMapping(path = "/{studentId}") // DELETE
    public ResponseEntity deleteStudent(@PathVariable Long studentId) {
        studentService.delete(studentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/age/{studentAge}")
    public Collection<Student> findStudent(@PathVariable int studentAge) {
        return studentService.findByAge(studentAge);
    }

    @GetMapping(path = "/age/{studentMinAge}/{studentMaxAge}")
    public Collection<Student> findStudent(@PathVariable int studentMinAge,
                                           @PathVariable int studentMaxAge) {
        return studentService.findByAgeBetween(studentMinAge, studentMaxAge);
    }




}
