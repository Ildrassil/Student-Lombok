import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
public class Student {

    UUID studentId;
    String name;
    String address;
    int grade;

}
