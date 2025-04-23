package diyor.adawev.radios.dto;

import diyor.adawev.radios.model.Comment;
import diyor.adawev.radios.model.Photo;
import diyor.adawev.radios.model.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsDto {
    private String name;
    private String description;
    private Integer comment;
    private Integer photo;
    private Integer tag;
}
