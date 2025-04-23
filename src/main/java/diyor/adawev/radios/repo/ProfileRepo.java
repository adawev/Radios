package diyor.adawev.radios.repo;

import diyor.adawev.radios.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Integer> {
}
