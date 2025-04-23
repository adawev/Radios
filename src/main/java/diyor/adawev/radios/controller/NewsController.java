package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.CommentDto;
import diyor.adawev.radios.dto.NewsDto;
import diyor.adawev.radios.model.Comment;
import diyor.adawev.radios.model.News;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<News> all = newsService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        News account = newsService.getById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody NewsDto newsDto){
        Result result = newsService.create(newsDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody NewsDto newsDto){
        Result result = newsService.update(id, newsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = newsService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
