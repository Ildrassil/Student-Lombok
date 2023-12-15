import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.UUID;
@Data
@AllArgsConstructor
public class StudentRepo {

    Map<UUID, Student> students;
}
