package sanfran.filming;

import javax.persistence.*;

/**
 * @author Ari Ayvazyan
 * @version 22.03.2017
 */
@Entity
@Table(name = "movie")
public class MovieLocation {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String locations;

    public MovieLocation() {
    }

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
