package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.AccountDto;
import diyor.adawev.radios.dto.AddressDto;
import diyor.adawev.radios.model.Account;
import diyor.adawev.radios.model.Address;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Account> all = accountService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        Account account = accountService.getById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody AccountDto accountDto){
        Result result = accountService.create(accountDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody AccountDto accountDto){
        Result result = accountService.update(id, accountDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Result result = accountService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
