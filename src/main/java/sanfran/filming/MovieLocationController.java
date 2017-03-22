package sanfran.filming;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ari Ayvazyan
 * @version 22.03.2017
 */
@RestController
public class MovieLocationController {

    @Autowired
    MovieDatabase movieDatabase;

    @RequestMapping("/getAllMovieLocations")
    public List<MovieLocation> greeting(){
        return movieDatabase.getAllMovieLocations();
    }
}
