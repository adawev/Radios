package diyor.adawev.radios.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfileDto {
    private String name;
    private String surname;
    private String email;
    private String password;
}
