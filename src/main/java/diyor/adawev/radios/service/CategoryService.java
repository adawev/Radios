package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.CategoryDto;
import diyor.adawev.radios.dto.ProductDto;
import diyor.adawev.radios.model.Category;
import diyor.adawev.radios.model.Product;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;


    public List<Category> getAll() {
        return categoryRepo.findAll();
    }
    public Category getById(Integer id) {
        return categoryRepo.findById(id).get();
    }

    public Result create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepo.save(category);
        return new Result(true, "Category created");
    }
    public Result update(Integer id, CategoryDto categoryDto) {
        Optional<Category> byId = categoryRepo.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            categoryRepo.save(category);
            return new Result(true, "Category updated");
        }
        return new Result(true, "Category not found");
    }
    public Result delete(Integer id) {
        Optional<Category> byId = categoryRepo.findById(id);
        if (byId.isPresent()) {
            categoryRepo.delete(byId.get());
            return new Result(true, "Category deleted");
        }
        return new Result(true, "Category not found");
    }
}
