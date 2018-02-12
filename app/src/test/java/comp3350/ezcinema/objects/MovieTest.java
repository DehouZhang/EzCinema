package comp3350.ezcinema.objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dow on 12/02/2018.
 */
public class MovieTest {
    private Movie movie = new Movie("1", "SuperBad", "3 teens try to have a party", "Comedy", 10.0);

    @Test
    public void getMovieID() throws Exception {
        assertEquals("1", movie.getMovieID());
    }

    @Test
    public void getMovieName() throws Exception {
        assertEquals("SuperBad", movie.getMovieName());
    }

    @Test
    public void getMovieDescription() throws Exception {
        assertEquals("3 teens try to have a party", movie.getMovieDescription());
    }

    @Test
    public void getMovieRating() throws Exception {
        assertEquals(10.0, movie.getMovieRating(), 0);
    }

    @Test
    public void getGenre() throws Exception {
        assertEquals("Comedy", movie.getGenre());
    }
}