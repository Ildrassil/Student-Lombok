import lombok.*;

import java.util.Map;
import java.util.UUID;
@Value
@AllArgsConstructor
@Builder
@With
public class Course {
    UUID courseId;
    String name;
    Teacher teacher;
    Map<UUID, Grade> grades;
}
