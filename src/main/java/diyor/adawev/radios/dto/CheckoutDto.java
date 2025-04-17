package diyor.adawev.radios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckoutDto {
    private String firstName;
    private String lastName;
    private String companyName;
    private String email;
    private Integer address;
    private String password;
    private String notes;
}
