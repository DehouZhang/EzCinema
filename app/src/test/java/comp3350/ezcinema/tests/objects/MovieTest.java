package comp3350.ezcinema.tests.objects;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import comp3350.ezcinema.objects.Movie;
import static org.junit.Assert.*;


public class MovieTest extends TestCase{


    private Movie movie1, movie2, movie3;
    private Comparator<Movie> movieNameComp;
    private Comparator<Movie> movieRatingComp;

    @Before
    public void setUp() throws Exception {
        movie1 = new Movie("SuperBad", "3 teens try to have a party", "Comedy", 10.0);
        movie2 = movie1;
        movie3 = new Movie("Amovie", "Exciting things happen", "Action", 1.0);
        movieNameComp = Movie.MovieNameComparator;
        movieRatingComp = Movie.MovieRatingComparator;

    }
    @Test
    public void testGetMethods() throws Exception {

        assertEquals("SuperBad", movie1.getMovieName());
        assertEquals("3 teens try to have a party", movie1.getMovieDescription());
        assertEquals(10.0, movie1.getMovieRating(), 0);
        assertEquals("Comedy", movie1.getGenre());
    }

    @Test
    public void testCompares() throws Exception{
        //SuperBad is bigger than Amovie
        assertTrue( movieNameComp.compare(movie1, movie3) > 0);
        //Same movie
        assertTrue( movieNameComp.compare(movie1, movie2) == 0);
        //Amovie is smaller than SuperBad
        assertTrue( movieNameComp.compare(movie3, movie1) < 0);


        assertTrue( movieRatingComp.compare(movie1, movie3) > 0);
        assertTrue( movieRatingComp.compare(movie1, movie2) == 0);
        assertTrue( movieRatingComp.compare(movie3, movie1) < 0);
    }

}