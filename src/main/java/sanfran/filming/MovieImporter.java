package sanfran.filming;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ari Ayvazyan
 * @version 22.03.2017
 */
@Component
public class MovieImporter {
    private List<MovieLocation> movieLocations;

    @Autowired
    public MovieImporter(MovieRepository movieRepository) {
        //Store all movies from the json file in the database
        movieRepository.saveAll(fetchMovieLocations());
    }

    /**
     * Retrieves Movie titles with their filming locations
     *
     * @return returns null if the movie locations can not be fetched
     */
    private List<MovieLocation> fetchMovieLocations() {
        try {
            List<MovieLocation> result = new LinkedList<>();
            Resource resource = new ClassPathResource("movieLocationData.json");
            DocumentContext document = JsonPath.parse(resource.getInputStream());

            JSONArray data = document.read("$.data");
            for (Object movieRaw : data) {
                JSONArray movie = (JSONArray) movieRaw;
                String movieTitle = (String) movie.get(8);
                String locations = (String) movie.get(10);
                result.add(new MovieLocation(movieTitle, locations));
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<MovieLocation> getAllMovieLocations() {
        return movieLocations;
    }
}
