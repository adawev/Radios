package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {
}
