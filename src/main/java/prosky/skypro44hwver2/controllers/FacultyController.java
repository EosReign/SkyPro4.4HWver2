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

    @PostMapping(path ="/create")// Create
    @ResponseBody
    public Faculty createFaculty(@RequestParam("name") String facultyName,
                                 @RequestParam("color") String facultyColor) {
        return facultyService.create(facultyName, facultyColor);
    }

    @GetMapping(path = "/{facultyId}")// READ
    public Faculty readFaculty(@PathVariable Long facultyId) {
        return facultyService.read(facultyId);
    }

    @PutMapping(path = "/update") //UPDATE
    public Faculty updateFaculty(@RequestParam("id") Long facultyId,
                                 @RequestParam("name") String facultyName,
                                 @RequestParam("color") String facultyColor) {
        return facultyService.update(facultyId, facultyName, facultyColor);
    }

    @DeleteMapping(path = "/{facultyId}") // DELETE
    public ResponseEntity deleteFaculty(@PathVariable Long facultyId) {
        facultyService.delete(facultyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/color/{facultyColor}")
    public Collection<Faculty> findFacultyByColor(@PathVariable String facultyColor) {
        return facultyService.findByFacultyColor(facultyColor);
    }

    @GetMapping(path = "/name/{facultyName}")
    public Collection<Faculty> findFacultyByName(@PathVariable String facultyName) {
        return facultyService.findByFacultyName(facultyName);
    }
}
