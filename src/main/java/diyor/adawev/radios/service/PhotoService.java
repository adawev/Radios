package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.PhotoDto;
import diyor.adawev.radios.dto.ProductDto;
import diyor.adawev.radios.model.Photo;
import diyor.adawev.radios.model.Product;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    PhotoRepo photoRepo;

    public List<Photo> getAll() {
        return photoRepo.findAll();
    }
    public Photo getById(Integer id) {
        return photoRepo.findById(id).get();
    }

    public Result create(PhotoDto photoDto) {
        Photo photo = new Photo();
        photo.setName(photoDto.getName());
        photo.setSize(photoDto.getSize());
        photo.setPath(photoDto.getPath());
        photoRepo.save(photo);
        return new Result(true, "Photo created");
    }
    public Result update(Integer id, PhotoDto photoDto) {
        Optional<Photo> byId = photoRepo.findById(id);
        if (byId.isPresent()) {
            Photo photo = byId.get();
            photo.setName(photoDto.getName());
            photo.setSize(photoDto.getSize());
            photo.setPath(photoDto.getPath());
            photoRepo.save(photo);
            return new Result(true, "Photo updated");
        }
        return new Result(true, "Photo not found");
    }
    public Result delete(Integer id) {
        Optional<Photo> byId = photoRepo.findById(id);
        if (byId.isPresent()) {
            photoRepo.delete(byId.get());
            return new Result(true, "Photo deleted");
        }
        return new Result(true, "Photo not found");
    }
}
