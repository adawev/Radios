package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.AboutUsDto;
import diyor.adawev.radios.dto.ProfileDto;
import diyor.adawev.radios.model.AboutUs;
import diyor.adawev.radios.model.Profile;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about-us")
public class AboutUsController {
    @Autowired
    AboutUsService aboutUsService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<AboutUs> all = aboutUsService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        AboutUs account = aboutUsService.getById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody AboutUsDto aboutUsDto){
        Result result = aboutUsService.create(aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody AboutUsDto aboutUsDto){
        Result result = aboutUsService.update(id, aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = aboutUsService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
