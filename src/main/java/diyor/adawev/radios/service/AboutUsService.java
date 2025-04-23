package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.AboutUsDto;
import diyor.adawev.radios.dto.ProfileDto;
import diyor.adawev.radios.model.AboutUs;
import diyor.adawev.radios.model.Photo;
import diyor.adawev.radios.model.Profile;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.repo.AboutUsRepo;
import diyor.adawev.radios.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutUsService {
    @Autowired
    AboutUsRepo aboutUsRepo;
    @Autowired
    PhotoRepo photoRepo;

    public List<AboutUs> getAll() {
        return aboutUsRepo.findAll();
    }
    public AboutUs getById(Integer id) {
        return aboutUsRepo.findById(id).get();
    }

    public Result create(AboutUsDto aboutUsDto) {
        AboutUs aboutUs = new AboutUs();
        Photo photo = photoRepo.findById(aboutUsDto.getPhoto()).get();
        aboutUs.setPhoto((List<Photo>) photo);
        aboutUs.setDescription(aboutUsDto.getDescription());
        aboutUsRepo.save(aboutUs);
        return new Result(true, "About Us created");
    }
    public Result update(Integer id, AboutUsDto aboutUsDto) {
        Optional<AboutUs> byId = aboutUsRepo.findById(id);
        if (byId.isPresent()) {
            AboutUs aboutUs = byId.get();
            Photo photo = photoRepo.findById(aboutUsDto.getPhoto()).get();
            aboutUs.setPhoto((List<Photo>) photo);
            aboutUs.setDescription(aboutUsDto.getDescription());
            aboutUsRepo.save(aboutUs);
            return new Result(true, "About Us updated");
        }
        return new Result(true, "About Us not found");
    }
    public Result delete(Integer id) {
        Optional<AboutUs> byId = aboutUsRepo.findById(id);
        if (byId.isPresent()) {
            aboutUsRepo.delete(byId.get());
            return new Result(true, "About Us deleted");
        }
        return new Result(true, "About Us not found");
    }
}
