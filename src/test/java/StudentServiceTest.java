import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @org.junit.jupiter.api.Test
    void findStudentbyIdExceptionStudentNotFoundTest() {
        UUID actual = UUID.randomUUID();
       Student expected = new Student(UUID.randomUUID(),"Jakob Schneider","123 Street");
        Map<UUID,Student> students = new HashMap<>(){{put(expected.getStudentId(),expected); }};
       StudentRepo studentRepo = new StudentRepo(students);
       StudentService studentService = new StudentService(studentRepo);

       assertThrows( StudentNotFoundException.class, () ->
                                   studentService.findStudentbyId(actual)
        );
    }

}