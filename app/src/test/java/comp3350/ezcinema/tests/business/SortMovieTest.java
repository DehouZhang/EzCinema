package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;
import java.util.ArrayList;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.business.SortMovie;
import static org.junit.Assert.*;

public class SortMovieTest extends TestCase{
    private Movie movie1, movie2, movie3;
    private ArrayList<Movie> movies, sorted;
    private SortMovie sortedMovie;


    public void setUp() throws Exception {
        movie1 = new Movie("C Movie", "your basic run of the mill decent movie", "Horror", 4.4);
        movie2 = new Movie("B Movie", "your basic run of the mill okay movie", "Family", 3.6);
        movie3 = new Movie("A Movie", "your basic run of the mill bad movie", "Thriller", 2.8);

        movies = new ArrayList<Movie>();
        sortedMovie = new SortMovie();

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
    }


    public void testSortByName() throws Exception {

        sorted = (ArrayList<Movie>) sortedMovie.sortByName(movies);

        assertNotNull(sorted);
        assertEquals("A Movie", (sorted.get(0)).getMovieName());

    }


    public void testSortByRating() throws Exception {

        sorted = (ArrayList<Movie>) sortedMovie.sortByRating(movies);

        assertEquals(2.8, (sorted.get(0)).getMovieRating(),0.1);
    }


    public void testSortByGenre() throws Exception{

        sorted = sortedMovie.sortByGenre(movies, "Family");
        sortedMovie.toString();
    }

}