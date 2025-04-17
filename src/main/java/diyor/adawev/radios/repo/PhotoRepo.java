package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Integer> {
}
