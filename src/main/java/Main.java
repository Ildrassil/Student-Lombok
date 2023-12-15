import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
     Student student = new Student(UUID.randomUUID(), "John", "123 Main St", 3);
     Student student1 = new Student(UUID.randomUUID(), "Jane", "123 Main St", 3);
     Student student2 = new Student(UUID.randomUUID(), "Paul", "123 Main St", 3);
     Student student3 = new Student(UUID.randomUUID(), "George", "123 Main St", 1);
     Teacher teacher = new Teacher("Florian", UUID.randomUUID(), "Math");
     Teacher englishTeacher = Teacher.builder()
             .teacherId(UUID.randomUUID())
             .name("Mrs.Knowsy")
             .subject("English")
             .build();

     Course course = new Course(UUID.randomUUID(), "Math", teacher, Map.of(student.getStudentId(), student, student1.getStudentId(), student1, student2.getStudentId(), student2, student3.getStudentId(), student3));

        student1.setGrade(1);
        student2.setName("Christian");
        System.out.println(student2.getName());
        System.out.println(student3.getStudentId());
        System.out.println(student1.getGrade());
        System.out.println(teacher.name());
        Student student4 = Student.builder()
                .studentId(UUID.randomUUID())
                .address("Waldmannstraße 123")
                .grade(2)
                .name("Philon")
                .build();
        Course english = Course.builder()
                .courseId(UUID.randomUUID())
                .name("English Honors")
                .teacher(englishTeacher)
                .build();
        Course englishCopy = english.withStudents(Map.of(student.studentId,student, student4.studentId, student4));
        System.out.println(englishCopy.getStudents());



    }
}
