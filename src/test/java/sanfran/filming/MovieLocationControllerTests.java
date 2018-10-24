package sanfran.filming;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Ari Ayvazyan
 * @version 22.03.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieLocationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private static final String LOCATION = "MyTestLocation";
    private static final String TITLE = "myTestMovie";

    @Test
    public void testFilterAndAdd() throws Exception {
        this.mockMvc.perform(get("/addMovie")
                .param("title", TITLE)
                .param("locations", LOCATION))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/getFiltered/" + LOCATION))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].locations").value(LOCATION))
                .andExpect(jsonPath("$[0].title").value(TITLE));
    }

}
