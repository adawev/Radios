package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.PhotoDto;
import diyor.adawev.radios.dto.ProductDto;
import diyor.adawev.radios.model.Photo;
import diyor.adawev.radios.model.Product;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    PhotoService photoService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Photo> all = photoService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        Photo product = photoService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody PhotoDto photoDto){
        Result result = photoService.create(photoDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody PhotoDto photoDto){
        Result result = photoService.update(id, photoDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = photoService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
