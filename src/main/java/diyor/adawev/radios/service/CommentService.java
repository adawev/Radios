package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.CommentDto;
import diyor.adawev.radios.dto.ProfileDto;
import diyor.adawev.radios.model.Comment;
import diyor.adawev.radios.model.Profile;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.repo.CommentRepo;
import diyor.adawev.radios.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ProfileRepo profileRepo;

    public List<Comment> getAll() {
        return commentRepo.findAll();
    }
    public Comment getById(Integer id) {
        return commentRepo.findById(id).get();
    }

    public Result create(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setDescription(commentDto.getDescription());
        Profile profile = profileRepo.findById(commentDto.getProfile()).get();
        comment.setProfile(profile);
        comment.setLike_count(commentDto.getLike_count());
        comment.setDislike_count(commentDto.getDislike_count());
        commentRepo.save(comment);
        return new Result(true, "Profile created");
    }
    public Result update(Integer id, CommentDto commentDto) {
        Optional<Comment> byId = commentRepo.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();
            comment.setName(commentDto.getName());
            comment.setDescription(commentDto.getDescription());
            Profile profile = profileRepo.findById(commentDto.getProfile()).get();
            comment.setProfile(profile);
            comment.setLike_count(commentDto.getLike_count());
            comment.setDislike_count(commentDto.getDislike_count());
            commentRepo.save(comment);
            return new Result(true, "Profile updated");
        }
        return new Result(true, "Profile not found");
    }
    public Result delete(Integer id) {
        Optional<Comment> byId = commentRepo.findById(id);
        if (byId.isPresent()) {
            commentRepo.delete(byId.get());
            return new Result(true, "Profile deleted");
        }
        return new Result(true, "Profile not found");
    }
}
