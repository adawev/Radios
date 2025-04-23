package diyor.adawev.radios.controller;

import diyor.adawev.radios.dto.AccountDto;
import diyor.adawev.radios.dto.ProfileDto;
import diyor.adawev.radios.model.Account;
import diyor.adawev.radios.model.Profile;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Profile> all = profileService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping
    public HttpEntity<?> getById(Integer id){
        Profile account = profileService.getById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(ProfileDto profileDto){
        Result result = profileService.create(profileDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping
    public HttpEntity<?> update(Integer id, ProfileDto profileDto){
        Result result = profileService.update(id, profileDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(Integer id){
        Result result = profileService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
