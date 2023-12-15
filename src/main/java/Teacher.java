
import java.util.UUID;

public record Teacher(
        String name,
        UUID teacherId,
        String subject
) {
}
