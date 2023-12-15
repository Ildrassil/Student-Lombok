import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UniversityService {
    private University university;

    public double getAverageGradeOfCourse(UUID courseId) {
        Course course = university.courses().get(courseId);

        double total = course.getGrades().values().stream()
                .map(Grade::getValue)
                .reduce(0, Integer::sum);
        double numberOfStudents = course.getGrades().size();

        return total / numberOfStudents;
    }

    public double getAverageGradeOfUniversity() {
        List<Double> averageGrades = university.courses().values().stream()
                .map(course -> getAverageGradeOfCourse(course.getCourseId()))
                .toList();

        double totalGrade = averageGrades.stream().reduce(0.0, Double::sum);
        double numberOfCourses = university.courses().size();

        return totalGrade / numberOfCourses;
    }

    public List<UUID> getAllGoodStudents() {
        Map<UUID, List<Grade>> gradesOfStudents = getGradesOfStudents();

        return gradesOfStudents.entrySet().stream()
                .filter(entry -> getAverageGradeOfStudent(entry.getValue()) <= 2)
                .map(Map.Entry::getKey)
                .toList();
    }

    private Map<UUID, List<Grade>> getGradesOfStudents() {
        Map<UUID, List<Grade>> gradesOfStudents = new HashMap<>();

        for (Course course : university.courses().values()) {
            Map<UUID, Grade> grades = course.getGrades();
            for (UUID studentId : grades.keySet()) {
                gradesOfStudents.computeIfAbsent(studentId, k -> new ArrayList<>());
                gradesOfStudents.get(studentId).add(grades.get(studentId));
            }

        }
        return gradesOfStudents;
    }

    private double getAverageGradeOfStudent(List<Grade> grades) {
        double totalGrade = grades.stream()
                .map(Grade::getValue)
                .reduce(0, Integer::sum);

        double numberOfCourses = grades.size();

        return totalGrade / numberOfCourses;
    }
}
