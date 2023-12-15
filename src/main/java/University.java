import java.util.Map;
import java.util.UUID;

public record University(
        UUID universityId,
        String name,
        Map<UUID, Course> courses
) {
}
