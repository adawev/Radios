package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.CategoryDto;
import diyor.adawev.radios.dto.ShopCartDto;
import diyor.adawev.radios.model.*;
import diyor.adawev.radios.repo.PhotoRepo;
import diyor.adawev.radios.repo.ProductRepo;
import diyor.adawev.radios.repo.ShopCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopCartService {
    @Autowired
    ShopCartRepo shopCartRepo;
    @Autowired
    PhotoRepo photoRepo;
    @Autowired
    ProductRepo productRepo;

    public List<ShopCart> getAll() {
        return shopCartRepo.findAll();
    }
    public ShopCart getById(Integer id) {
        return shopCartRepo.findById(id).get();
    }

    public Result create(ShopCartDto shopCartDto) {
        ShopCart shopCart = new ShopCart();
        Photo photo = photoRepo.findById(shopCartDto.getPhoto()).get();
        shopCart.setPhoto((List<Photo>) photo);
        Product product = productRepo.findById(shopCartDto.getProduct()).get();
        shopCart.setPhoto((List<Photo>) photo);
        shopCart.setPrice(shopCartDto.getPrice());
        shopCart.setQuantity(shopCartDto.getQuantity());
        shopCart.setTotalPrice(shopCartDto.getTotalPrice());
        shopCart.setCouponCode(shopCartDto.getCouponCode());
        shopCart.setShipping(shopCartDto.getShipping());
        shopCartRepo.save(shopCart);
        return new Result(true, "Shop cart created");
    }
    public Result update(Integer id, ShopCartDto shopCartDto) {
        Optional<ShopCart> byId = shopCartRepo.findById(id);
        if (byId.isPresent()) {
            ShopCart shopCart = byId.get();
            Photo photo = photoRepo.findById(shopCartDto.getPhoto()).get();
            shopCart.setPhoto((List<Photo>) photo);
            Product product = productRepo.findById(shopCartDto.getProduct()).get();
            shopCart.setPhoto((List<Photo>) photo);
            shopCart.setPrice(shopCartDto.getPrice());
            shopCart.setQuantity(shopCartDto.getQuantity());
            shopCart.setTotalPrice(shopCartDto.getTotalPrice());
            shopCart.setCouponCode(shopCartDto.getCouponCode());
            shopCart.setShipping(shopCartDto.getShipping());
            shopCartRepo.save(shopCart);
            return new Result(true, "Shop cart updated");
        }
        return new Result(true, "Shop cart not found");
    }
    public Result delete(Integer id) {
        Optional<ShopCart> byId = shopCartRepo.findById(id);
        if (byId.isPresent()) {
            shopCartRepo.delete(byId.get());
            return new Result(true, "Shop cart deleted");
        }
        return new Result(true, "Shop cart not found");
    }
}
