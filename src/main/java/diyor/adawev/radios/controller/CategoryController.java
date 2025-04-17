package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.CategoryDto;
import diyor.adawev.radios.model.Category;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Category> all = categoryService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping
    public HttpEntity<?> getById(Integer id){
        Category product = categoryService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(CategoryDto categoryDto){
        Result result = categoryService.create(categoryDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping
    public HttpEntity<?> update(Integer id, CategoryDto categoryDto){
        Result result = categoryService.update(id, categoryDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(Integer id){
        Result result = categoryService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
