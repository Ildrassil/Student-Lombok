import lombok.*;
import java.util.Map;
import java.util.UUID;

@Value
@AllArgsConstructor
@Builder
@With
public class Course {
    private UUID courseId;
    private String name;
    private Teacher teacher;
    private Map<UUID, Grade> grades;
}
