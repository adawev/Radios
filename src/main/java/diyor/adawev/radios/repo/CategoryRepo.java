package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
