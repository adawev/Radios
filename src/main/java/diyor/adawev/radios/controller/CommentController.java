package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.CommentDto;
import diyor.adawev.radios.dto.ProfileDto;
import diyor.adawev.radios.model.Comment;
import diyor.adawev.radios.model.Profile;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Comment> all = commentService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping
    public HttpEntity<?> getById(Integer id){
        Comment account = commentService.getById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(CommentDto commentDto){
        Result result = commentService.create(commentDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping
    public HttpEntity<?> update(Integer id, CommentDto commentDto){
        Result result = commentService.update(id, commentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(Integer id){
        Result result = commentService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
