package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepo extends JpaRepository<Checkout, Integer> {
}
