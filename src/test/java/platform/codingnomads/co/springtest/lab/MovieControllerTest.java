package platform.codingnomads.co.springtest.lab;

import org.apache.http.client.HttpResponseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.server.ResponseStatusException;
import platform.codingnomads.co.springtest.TestUtil;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        when(movieService.getAllMovies()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));

        verify(movieService, times(1)).getAllMovies();
        verifyNoMoreInteractions(movieService);

    }

    @Test
    public void testGetAllMoviesNotFound() throws Exception {
        when(movieService.getAllMovies()).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

        mockMvc.perform(get("/all"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllMoviesSuccess2() throws Exception {
        List<Movie> mockMovieList = new ArrayList<>();
        mockMovieList.add(Movie.builder().id(1L).name("Batman Returns").rating(8.7).build());
        mockMovieList.add(Movie.builder().id(2L).name("Filth").rating(7.7).build());
        mockMovieList.add(Movie.builder().id(3L).name("Remember the Titans").rating(6.6).build());
        mockMovieList.add(Movie.builder().id(4L).name("The Man from Earth").rating(9.9).build());

        when(movieService.getAllMovies()).thenReturn(mockMovieList);

        MvcResult mvcResult = mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        byte[] jsonByteArray = mvcResult.getResponse().getContentAsByteArray();
        Movie[] returnedMovies = TestUtil.convertJsonBytesToObject(jsonByteArray, Movie[].class);

        assertThat(returnedMovies.length, is(4));

        for(Movie m: returnedMovies) {
            assertThat(m, notNullValue());
            assertThat(m.getId(), notNullValue());
            assertThat(m.getName(), notNullValue());
            assertThat(m.getRating(), notNullValue());
        }
    }

    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {
        List<Movie> mockMovieList = new ArrayList<>();
        mockMovieList.add(Movie.builder().id(1L).name("Batman Returns").rating(8.7).build());
        mockMovieList.add(Movie.builder().id(2L).name("Filth").rating(7.7).build());
        mockMovieList.add(Movie.builder().id(3L).name("Remember the Titans").rating(6.6).build());
        mockMovieList.add(Movie.builder().id(4L).name("The Man from Earth").rating(9.9).build());

        when(movieService.getAllMovies()).thenReturn(mockMovieList);

        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void testGetMoviesWithMinimumRatingSuccess() throws Exception {
        mockMvc.perform(get("/minimum-rating/1.0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testGetMoviesWithMinimumRatingFailure() throws Exception {
        when(movieService.getAllMovies()).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

        mockMvc.perform(get("/minimum-rating/1.0"))
                .andExpect(status().isNotFound());
    }
}
