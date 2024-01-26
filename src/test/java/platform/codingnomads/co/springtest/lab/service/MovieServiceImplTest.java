package platform.codingnomads.co.springtest.lab.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = SpringTestLab.class)
class MovieServiceImplTest {

    @Autowired
    MovieService movieService;

    @MockBean
    MovieRepository movieRepository;

    @Test
    void testGetAllMoviesSuccess() {
        List<Movie> mockMovieList = new ArrayList<>();
        mockMovieList.add(Movie.builder().id(1L).name("Batman Returns").rating(8.7).build());
        mockMovieList.add(Movie.builder().id(2L).name("Filth").rating(7.7).build());
        mockMovieList.add(Movie.builder().id(3L).name("Remember the Titans").rating(6.6).build());
        mockMovieList.add(Movie.builder().id(4L).name("The Man from Earth").rating(9.9).build());

        when(movieRepository.findAll()).thenReturn(mockMovieList);

        List<Movie> resultMovieList = movieService.getAllMovies();

        assertThat(resultMovieList, hasSize(4));
    }

    @Test
    void testGetAllMoviesFailure() {
        // Mocking behavior for an exception when findAll is called
        when(movieRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        // Assert that calling getAllMovies results in an exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> movieService.getAllMovies());

        // Optionally, assert details of the exception
        assertThat(exception.getMessage(), is("Database error"));
        assertThat(exception, instanceOf(RuntimeException.class));
    }

    @Test
    void testGetMoviesByMinimumRatingSuccess() {
        List<Movie> mockMovieList = new ArrayList<>();
        mockMovieList.add(Movie.builder().id(1L).name("Batman Returns").rating(8.7).build());

        when(movieRepository.findByRatingGreaterThanEqual(8.0)).thenReturn((mockMovieList));

        List<Movie> resultMovieList = movieService.getMoviesByMinimumRating(8.0);

        assertThat(resultMovieList, hasSize(1));
        assertThat(resultMovieList, hasItem(hasProperty("name", is("Batman Returns"))));
    }

    @Test
    void testGetMoviesByMinimumRatingFailure() {
        when(movieRepository.findByRatingGreaterThanEqual(anyDouble())).thenThrow(new RuntimeException("Database error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> movieService.getMoviesByMinimumRating(1.0));

        assertThat(exception.getMessage(), is("Database error"));
        assertThat(exception, instanceOf(RuntimeException.class));
    }
}