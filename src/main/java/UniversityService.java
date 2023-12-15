import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UniversityService {
    University university;

    public double getAverageGrade(UUID courseId) {
        Course course = university.courses().get(courseId);
        double total = course.getGrades().values().stream().reduce(0, Integer::sum);
        double numberOfStudents = course.getGrades().size();
        return total /numberOfStudents;
    }

    public double getAverage(){
       List<Integer> averageGrades = new ArrayList<>();
       List <Course> courses = university.courses().get().stream().collect(Collectors.toList());
    }

}
