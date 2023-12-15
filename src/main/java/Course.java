import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.util.Map;
import java.util.UUID;
@Data
@AllArgsConstructor
@Builder
@With
public class Course {
    UUID courseId;
    String name;
    Teacher teacher;
    Map<UUID, Student> students;
}
