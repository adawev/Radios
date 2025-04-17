package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.AddressDto;
import diyor.adawev.radios.dto.CategoryDto;
import diyor.adawev.radios.model.Address;
import diyor.adawev.radios.model.Category;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Address> all = addressService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping
    public HttpEntity<?> getById(Integer id){
        Address product = addressService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(AddressDto addressDto){
        Result result = addressService.create(addressDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping
    public HttpEntity<?> update(Integer id, AddressDto addressDto){
        Result result = addressService.update(id, addressDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(Integer id){
        Result result = addressService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
