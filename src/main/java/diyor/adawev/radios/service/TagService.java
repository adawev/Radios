package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.AccountDto;
import diyor.adawev.radios.dto.TagDto;
import diyor.adawev.radios.model.Account;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.model.Tag;
import diyor.adawev.radios.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepo tagRepo;

    public List<Tag> getAll() {
        return tagRepo.findAll();
    }
    public Tag getById(Integer id) {
        return tagRepo.findById(id).get();
    }

    public Result create(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setName(tagDto.getName());

        tagRepo.save(tag);
        return new Result(true, "Tag created");
    }
    public Result update(Integer id, TagDto tagDto) {
        Optional<Tag> byId = tagRepo.findById(id);
        if (byId.isPresent()) {
            Tag tag = byId.get();
            tag.setName(tagDto.getName());
            tagRepo.save(tag);
            return new Result(true, "Tag updated");
        }
        return new Result(true, "Tag not found");
    }
    public Result delete(Integer id) {
        Optional<Tag> byId = tagRepo.findById(id);
        if (byId.isPresent()) {
            tagRepo.delete(byId.get());
            return new Result(true, "Tag deleted");
        }
        return new Result(true, "Tag not found");
    }
}
