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
public class ShopCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    private List<Photo> photo;
    @ManyToMany
    private List<Product> product;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Integer totalPrice;
    @Column(nullable = false)
    private String couponCode;
    @Column(nullable = false)
    private String shipping;
    @CreatedDate
    private LocalDateTime created_date=LocalDateTime.now();
}
