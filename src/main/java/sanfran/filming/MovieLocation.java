package sanfran.filming;

/**
 * @author Ari Ayvazyan
 * @version 22.03.2017
 */
public class MovieLocation {

    private String title;
    private String locations;

    public MovieLocation(final String title, final String locations) {
        this.title = title;
        this.locations = locations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }
}
