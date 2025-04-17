package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.ProductDto;
import diyor.adawev.radios.model.Product;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Product> all = productService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping
    public HttpEntity<?> getById(Integer id){
        Product product = productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(ProductDto productDto){
        Result result = productService.create(productDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping
    public HttpEntity<?> update(Integer id, ProductDto productDto){
        Result result = productService.update(id, productDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(Integer id){
        Result result = productService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
