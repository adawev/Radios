package diyor.adawev.radios.dto;

import diyor.adawev.radios.model.Profile;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    private String name;
    private String description;
    private Integer profile;
    private Long like_count;
    private Long dislike_count;
}
