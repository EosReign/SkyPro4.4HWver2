package prosky.skypro44hwver2.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity(name = "tableFaculties")
public class Faculty {
    @Id
    @GeneratedValue
    private Long facultyId;

    private String facultyName;

    private String facultyColor;

    @OneToMany(mappedBy = "faculty")
    private Collection<Student> tableStudents;

    public Faculty() {}

    public Faculty(String facultyName, String facultyColor) {
        this.facultyName = facultyName;
        this.facultyColor = facultyColor;
    }

    public Faculty(Long facultyId, String facultyName, String facultyColor) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyColor = facultyColor;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getFacultyColor() {
        return facultyColor;
    }

    public Collection<Student> getTableStudents() {
        return tableStudents;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setFacultyColor(String facultyColor) {
        this.facultyColor = facultyColor;
    }

    public void setTableStudents(Collection<Student> tableStudents) {
        this.tableStudents = tableStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(facultyId, faculty.facultyId) && Objects.equals(facultyName, faculty.facultyName) && Objects.equals(facultyColor, faculty.facultyColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, facultyName, facultyColor);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", facultyColor='" + facultyColor + '\'' +
                '}';
    }
}
