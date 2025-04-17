package diyor.adawev.radios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShopCartDto {
    private Integer photo;
    private Integer product;
    private Double price;
    private Integer quantity;
    private Integer totalPrice;
    private String couponCode;
    private String shipping;
}
