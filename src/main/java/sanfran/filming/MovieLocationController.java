package sanfran.filming;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ari Ayvazyan
 * @version 22.03.2017
 */
@RestController
public class MovieLocationController {

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/getAll")
    public List<MovieLocation> getAll(){
        return movieRepository.findAll();
    }

    @RequestMapping("/getFiltered/{locations}")
    public List<MovieLocation> getFiltered(@PathVariable String locations){
        return movieRepository.findBylocations(locations);
    }
}
