package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
