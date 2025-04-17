package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.CategoryDto;
import diyor.adawev.radios.dto.ShopCartDto;
import diyor.adawev.radios.model.Category;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.model.ShopCart;
import diyor.adawev.radios.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop-cart")
public class ShopCartController {
    @Autowired
    ShopCartService shopCartService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<ShopCart> all = shopCartService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping
    public HttpEntity<?> getById(Integer id){
        ShopCart product = shopCartService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(ShopCartDto shopCartDto){
        Result result = shopCartService.create(shopCartDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping
    public HttpEntity<?> update(Integer id, ShopCartDto shopCartDto){
        Result result = shopCartService.update(id, shopCartDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(Integer id){
        Result result = shopCartService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
