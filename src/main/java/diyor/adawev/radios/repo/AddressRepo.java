package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
