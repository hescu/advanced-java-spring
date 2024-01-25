package platform.codingnomads.co.springtest.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepo;

    @MockBean
    private MovieService movieService;

    @Test
    public void testGetAllMoviesSuccess() throws Exception {
        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllMoviesFailure() throws Exception {
        movieRepo.deleteAll();

        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {
        List<Movie> mockMovieList = new ArrayList<>();
        mockMovieList.add(Movie.builder().name("Batman Returns").rating(8.7).build());
        mockMovieList.add(Movie.builder().name("Filth").rating(7.7).build());
        mockMovieList.add(Movie.builder().name("Remember the Titans").rating(6.6).build());
        mockMovieList.add(Movie.builder().name("The Man from Earth").rating(9.9).build());

        when(movieService.getAllMovies()).thenReturn(mockMovieList);

        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(4)));
    }
}
