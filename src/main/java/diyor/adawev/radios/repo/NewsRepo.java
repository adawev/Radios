package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Integer> {
}
