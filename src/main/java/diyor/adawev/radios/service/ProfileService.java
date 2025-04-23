package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.AccountDto;
import diyor.adawev.radios.dto.ProfileDto;
import diyor.adawev.radios.model.Account;
import diyor.adawev.radios.model.Profile;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepo profileRepo;

    public List<Profile> getAll() {
        return profileRepo.findAll();
    }
    public Profile getById(Integer id) {
        return profileRepo.findById(id).get();
    }

    public Result create(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setEmail(profileDto.getEmail());
        profile.setPassword(profileDto.getPassword());
        profileRepo.save(profile);
        return new Result(true, "Profile created");
    }
    public Result update(Integer id, ProfileDto profileDto) {
        Optional<Profile> byId = profileRepo.findById(id);
        if (byId.isPresent()) {
            Profile profile = byId.get();
            profile.setName(profileDto.getName());
            profile.setSurname(profileDto.getSurname());
            profile.setEmail(profileDto.getEmail());
            profile.setPassword(profileDto.getPassword());
            profileRepo.save(profile);
            return new Result(true, "Profile updated");
        }
        return new Result(true, "Profile not found");
    }
    public Result delete(Integer id) {
        Optional<Profile> byId = profileRepo.findById(id);
        if (byId.isPresent()) {
            profileRepo.delete(byId.get());
            return new Result(true, "Profile deleted");
        }
        return new Result(true, "Profile not found");
    }
}
