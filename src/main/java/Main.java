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

        Course englishCopy = english.withGrades(Map.of(student.getStudentId(), Grade.GOOD, student4.getStudentId(), Grade.OKAY));

        // create Courses for University
        Map<UUID, Course> coursesOfFuBerlin = new HashMap<>() {{
            put(course.getCourseId(), course);
            put(englishCopy.getCourseId(), englishCopy);
        }};

        // create Map with all Students
        Map<UUID, Student> studentMap = new HashMap<>() {{
            put(student.getStudentId(), student);
            put(student1.getStudentId(), student1);
            put(student2.getStudentId(), student2);
            put(student3.getStudentId(), student3);
            put(student4.getStudentId(), student4);
        }};
        // create A StudentRepo
        StudentRepo students = new StudentRepo(studentMap);

        // creat a StudentService
        StudentService sutdentService = new StudentService(students);

        // create University for Service
        University fuBerlin = new University(UUID.randomUUID(), "FU Berlin", coursesOfFuBerlin, sutdentService);

        // create UniversityService
        UniversityService fuBerlinService = new UniversityService(fuBerlin);

        // Print all students' names
        fuBerlinService.getAllGoodStudents().forEach(id -> System.out.println(students.getStudents().get(id).getName()));

        // Average Grade course
        System.out.println(fuBerlinService.getAverageGradeOfCourse(course.getCourseId()));

        System.out.println(fuBerlinService.getAverageGradeOfCourse(englishCopy.getCourseId()));

        // Average Grade University
        System.out.println(fuBerlinService.getAverageGradeOfUniversity());

    }
}
