package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.ProductDto;
import diyor.adawev.radios.model.Product;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getAll() {
        return productRepo.findAll();
    }
    public Product getById(Integer id) {
        return productRepo.findById(id).get();
    }

    public Result create(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setReview(productDto.getReview());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setModel(productDto.getModel());
        productRepo.save(product);
        return new Result(true, "Product created");
    }
    public Result update(Integer id, ProductDto productDto) {
        Optional<Product> byId = productRepo.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            product.setName(productDto.getName());
            product.setReview(productDto.getReview());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setModel(productDto.getModel());
            productRepo.save(product);
            return new Result(true, "Product updated");
        }
        return new Result(true, "Product not found");
    }
    public Result delete(Integer id) {
        Optional<Product> byId = productRepo.findById(id);
        if (byId.isPresent()) {
            productRepo.delete(byId.get());
            return new Result(true, "Product deleted");
        }
        return new Result(true, "Product not found");
    }
}
