package sanfran.filming;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ari Ayvazyan
 * @version 22.03.2017
 */
@Component
public class MovieDatabase {
    List<MovieLocation> movieLocations;

    public MovieDatabase() {
        this.movieLocations = fetchMovieLocations();
    }

    private List<MovieLocation> fetchMovieLocations() {
        List<MovieLocation> result = new LinkedList<>();
        result.add(new MovieLocation("Woah", "sample description"));
        result.add(new MovieLocation("Woah", "sample description"));
        result.add(new MovieLocation("Woah", "sample description"));
        return result;
    }

    public List<MovieLocation> getAllMovieLocations() {
        return movieLocations;
    }
}
