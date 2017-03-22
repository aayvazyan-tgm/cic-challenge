package sanfran.filming;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ari Ayvazyan
 * @version 22.03.2017
 */
@Repository
public interface MovieRepository extends JpaRepository<MovieLocation, Long> {
    List<MovieLocation> findBylocations(String lastname);
}
