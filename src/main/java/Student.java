import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@Builder
@With
public class Student {

    UUID studentId;
    String name;
    String address;
    int grade;

}
