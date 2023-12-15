import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
@Data
@AllArgsConstructor
public class StudentRepo {

    Map<UUID, Student> students;

    public Optional<Student> getStudentById(UUID studentId) {

        return Optional.ofNullable(students.get(studentId));



    }
}
