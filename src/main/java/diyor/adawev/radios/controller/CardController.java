package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.AccountDto;
import diyor.adawev.radios.dto.CardDto;
import diyor.adawev.radios.model.Account;
import diyor.adawev.radios.model.Card;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Card> all = cardService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        Card account = cardService.getById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody CardDto cardDto){
        Result result = cardService.create(cardDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody CardDto cardDto){
        Result result = cardService.update(id, cardDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = cardService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
