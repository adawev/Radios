package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.NewsDto;
import diyor.adawev.radios.dto.ProfileDto;
import diyor.adawev.radios.model.*;
import diyor.adawev.radios.repo.CommentRepo;
import diyor.adawev.radios.repo.NewsRepo;
import diyor.adawev.radios.repo.PhotoRepo;
import diyor.adawev.radios.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    NewsRepo newsRepo;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    PhotoRepo photoRepo;
    @Autowired
    TagRepo tagRepo;

    public List<News> getAll() {
        return newsRepo.findAll();
    }
    public News getById(Integer id) {
        return newsRepo.findById(id).get();
    }

    public Result create(NewsDto newsDto) {
        News news = new News();
        news.setName(newsDto.getName());
        news.setDescription(newsDto.getDescription());
        Comment comment = commentRepo.findById(newsDto.getComment()).get();
        news.setComment((List<Comment>) comment);
        Photo photo = photoRepo.findById(newsDto.getPhoto()).get();
        news.setPhoto((List<Photo>) photo);
        Tag tag = tagRepo.findById(newsDto.getTag()).get();
        news.setTag((List<Tag>) tag);
        newsRepo.save(news);
        return new Result(true, "News created");
    }
    public Result update(Integer id, NewsDto newsDto) {
        Optional<News> byId = newsRepo.findById(id);
        if (byId.isPresent()) {
            News news = byId.get();
            news.setName(newsDto.getName());
            news.setDescription(newsDto.getDescription());
            Comment comment = commentRepo.findById(newsDto.getComment()).get();
            news.setComment((List<Comment>) comment);
            Photo photo = photoRepo.findById(newsDto.getPhoto()).get();
            news.setPhoto((List<Photo>) photo);
            Tag tag = tagRepo.findById(newsDto.getTag()).get();
            news.setTag((List<Tag>) tag);
            newsRepo.save(news);
            return new Result(true, "News updated");
        }
        return new Result(true, "News not found");
    }
    public Result delete(Integer id) {
        Optional<News> byId = newsRepo.findById(id);
        if (byId.isPresent()) {
            newsRepo.delete(byId.get());
            return new Result(true, "News deleted");
        }
        return new Result(true, "News not found");
    }
}
