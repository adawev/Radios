package diyor.adawev.radios.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {
    private String city;
    private String street;
    private Integer zipcode;
    private String homeNumber;
}
