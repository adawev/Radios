package diyor.adawev.radios.dto;

import diyor.adawev.radios.model.Photo;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AboutUsDto {
    private Integer photo;
    private String description;
}
