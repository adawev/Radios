package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
