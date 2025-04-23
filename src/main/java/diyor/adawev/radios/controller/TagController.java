package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.AccountDto;
import diyor.adawev.radios.dto.TagDto;
import diyor.adawev.radios.model.Account;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.model.Tag;
import diyor.adawev.radios.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Tag> all = tagService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        Tag account = tagService.getById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody TagDto tagDto){
        Result result = tagService.create(tagDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody TagDto tagDto){
        Result result = tagService.update(id, tagDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = tagService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
