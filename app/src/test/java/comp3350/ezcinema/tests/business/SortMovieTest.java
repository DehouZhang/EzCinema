package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;

import org.junit.Test;

import org.junit.Before;
import java.util.ArrayList;

import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.business.SortMovie;

import static org.junit.Assert.*;

/**
 * Created by 74 on 2/12/2018.
 */
public class SortMovieTest extends TestCase{
    private Movie movie1, movie2, movie3;
    private ArrayList<Movie> movies, sorted;
    private SortMovie sortedMovie;

    @Before
    public void setUp() throws Exception {
        movie1 = new Movie("1", "C Movie", "your basic run of the mill decent movie", "Horror", 4.4);
        movie2 = new Movie("2", "B Movie", "your basic run of the mill okay movie", "Family", 3.6);
        movie3 = new Movie("3", "A Movie", "your basic run of the mill bad movie", "Thriller", 2.8);

        movies = new ArrayList<Movie>();
        sortedMovie = new SortMovie();

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
    }

    @Test
    public void testSortByName() throws Exception {

        sorted = (ArrayList<Movie>) sortedMovie.sortByName(movies);

        assertEquals("A Movie", (sorted.get(0)).getMovieName());

    }

    @Test
    public void testSortByRating() throws Exception {

        sorted = (ArrayList<Movie>) sortedMovie.sortByRating(movies);

        assertEquals(2.8, (sorted.get(0)).getMovieRating(),0.1);
    }

}