package prosky.skypro44hwver2.services;

import org.springframework.stereotype.Service;
import prosky.skypro44hwver2.entity.Faculty;
import prosky.skypro44hwver2.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(String facultyName, String facultyColor) {
        Faculty faculty = new Faculty(facultyName, facultyColor);
        return facultyRepository.save(faculty);
    }

    public Faculty read(Long facultyId) {
        return facultyRepository.findById(facultyId).get();
    }

    public Faculty update(Long facultyId, String facultyName, String facultyColor) {
        Faculty faculty = new Faculty(facultyId, facultyName, facultyColor);
        return facultyRepository.save(faculty);
    }

    public void delete(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findByFacultyColor(String facultyColor) {
        return facultyRepository.findByFacultyColor(facultyColor);
    }

    public Collection<Faculty> findByFacultyName(String facultyName) {
        return facultyRepository.findByFacultyName(facultyName);
    }
}
