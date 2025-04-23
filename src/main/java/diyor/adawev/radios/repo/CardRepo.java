package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Integer> {
}
