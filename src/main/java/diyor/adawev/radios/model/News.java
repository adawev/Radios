package diyor.adawev.radios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToMany
    private List<Comment> comment;
    @ManyToMany
    private List<Photo> photo;
    @ManyToMany
    private List<Tag> tag;
    @CreatedDate
    private LocalDateTime created_date = LocalDateTime.now();
}
