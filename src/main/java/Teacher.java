
import lombok.Builder;

import java.util.UUID;
@Builder

public record Teacher(
        String name,
        UUID teacherId,
        String subject
) {
}
