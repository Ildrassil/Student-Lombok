import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@Builder
@With
public class Student {
    private UUID studentId;
    private String name;
    private String address;


}
