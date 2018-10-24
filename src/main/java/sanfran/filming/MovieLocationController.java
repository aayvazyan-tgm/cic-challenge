package sanfran.filming;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ari Ayvazyan
 * @version 22.03.2017
 */
@RestController
public class MovieLocationController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieLocationController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     *
     * @return returns all saved Movies
     */
    @RequestMapping("/getAll")
    public List<MovieLocation> getAll() {
        return movieRepository.findAll();
    }

    /**
     * Adds a Movie
     * @param title the title of the movie
     * @param locations the filming sites
     */
    @RequestMapping("/addMovie")
    public void addMovie(@RequestParam String title, @RequestParam String locations) {
        movieRepository.save(new MovieLocation(title, locations));
    }

    /**
     *
     * @param locations the locations to search for
     * @return movies with matching locations
     */
    @RequestMapping("/getFiltered/{locations}")
    public List<MovieLocation> getFiltered(@PathVariable String locations) {
        return movieRepository.findBylocations(locations);
    }
}
