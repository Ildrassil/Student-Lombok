import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.UUID;
@Data
@AllArgsConstructor

public class Course {
    UUID courseId;
    String name;
    Teacher teacher;
    Map<UUID, Student> students;
}
