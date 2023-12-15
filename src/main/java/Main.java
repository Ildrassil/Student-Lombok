import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
     Student student = new Student(UUID.randomUUID(), "John", "123 Main St");
     Student student1 = new Student(UUID.randomUUID(), "Jane", "123 Main St");
     Student student2 = new Student(UUID.randomUUID(), "Paul", "123 Main St");
     Student student3 = new Student(UUID.randomUUID(), "George", "123 Main St");

     Teacher teacher = new Teacher("Florian", UUID.randomUUID(), "Math");
     Teacher englishTeacher = Teacher.builder()
             .teacherId(UUID.randomUUID())
             .name("Mrs.Knowsy")
             .subject("English")
             .build();

     Course course = new Course(UUID.randomUUID(), "Math", teacher, Map.of(student.getStudentId(), Grade.GOOD, student1.getStudentId(), Grade.GOOD, student2.getStudentId(), Grade.EXCELLENT, student3.getStudentId(), Grade.NOT_SO_OKAY));

        student2.setName("Christian");
        System.out.println(student2.getName());
        System.out.println(student3.getStudentId());
        System.out.println(teacher.name());

        Student student4 = Student.builder()
                .studentId(UUID.randomUUID())
                .address("Waldmannstraße 123")
                .name("Philon")
                .build();

        Course english = Course.builder()
                .courseId(UUID.randomUUID())
                .name("English Honors")
                .teacher(englishTeacher)
                .build();

        Course englishCopy = english.withGrades(Map.of(student.getStudentId(),Grade.GOOD, student4.getStudentId(), Grade.OKAY));
        System.out.println(englishCopy.getGrades());

        Map<UUID, Course> coursesOfFuBerlin = new HashMap<>() {{
            put(course.getCourseId(), course);
            put(englishCopy.getCourseId(), englishCopy);
        }};


        University fuBerlin = new University(UUID.randomUUID(), "FU Berlin", coursesOfFuBerlin);

        UniversityService fuBerlinService = new UniversityService(fuBerlin);

        System.out.println(fuBerlinService.getAllGoodStudents());

    }
}
