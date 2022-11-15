package prosky.skypro44hwver2.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prosky.skypro44hwver2.entity.Faculty;
import prosky.skypro44hwver2.services.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping(path ="/{facultyName}/{facultyColor}")// Create
    public Faculty createFaculty(@PathVariable String facultyName,
                                 @PathVariable String facultyColor) {
        return facultyService.create(facultyName, facultyColor);
    }

    @PostMapping(path = "/{facultyId}")// READ
    public Faculty readFaculty(@PathVariable Long facultyId) {
        return facultyService.read(facultyId);
    }

    @PutMapping(path = "/{facultyId}/{facultyName}/{facultyColor}") //UPDATE
    public Faculty updateFaculty(@PathVariable Long facultyId,
                                 @PathVariable String facultyName,
                                 @PathVariable String facultyColor) {
        return facultyService.update(facultyId, facultyName, facultyColor);
    }

    @DeleteMapping(path = "/{facultyId}") // DELETE
    public ResponseEntity deleteFaculty(@PathVariable Long facultyId) {
        facultyService.delete(facultyId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/color/{facultyColor}")
    public Collection<Faculty> findFacultyByColor(@PathVariable String facultyColor) {
        return facultyService.findByFacultyColor(facultyColor);
    }

    @PostMapping(path = "/name/{facultyName}")
    public Collection<Faculty> findFacultyByName(@PathVariable String facultyName) {
        return facultyService.findByFacultyName(facultyName);
    }
}
