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
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private String email;
    @ManyToMany
    private List<Address> address;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String notes;
    @CreatedDate
    private LocalDateTime created_date = LocalDateTime.now();
}
