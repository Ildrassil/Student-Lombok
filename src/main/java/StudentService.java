import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.UUID;
@Data
@AllArgsConstructor
public class StudentService {

    StudentRepo students;

    public Student findStudentbyId(UUID studentId) throws StudentNotFoundException {
        return students.getStudentById(studentId).orElseThrow(()-> new StudentNotFoundException("Student " + studentId +" not found!"));
    }


}
