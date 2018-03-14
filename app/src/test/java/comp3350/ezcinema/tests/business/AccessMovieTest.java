package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;
import java.util.ArrayList;
import static org.junit.Assert.*;
import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.business.AccessMovie;


public class AccessMovieTest extends TestCase {

    private AccessMovie accessor;
    private ArrayList list;
    private String [] names;
    private double [] ratings;
    private String [] genres;




    public void setUp() throws Exception {
        Main.startUp();
        accessor = new AccessMovie();
        list = new ArrayList<Movie>();
        accessor.getMovies(list);

        names = new String[]{"Ferdinand", "Fifty Shades Freed", "Jumangi: Welcome to the Jungle",  "Peter Rabbit", "Red Sparrow", "Tomb Raider", "Unforgettable", "Winchester"};
        ratings = new double[]{6.7, 6.4, 5.8, 5.6, 6.7, 8.9, 5.0, 2.8};
        genres = new String[]{"Family", "Family", "Thriller", "Family", "Horror", "Thriller", "Thriller", "Horror"};
    }


    public void testExisitence() throws Exception{

        System.out.print("Whether the list is/isn't null and is not returned empty");

        assertNull(accessor.getMovies((null)));
        assertNotNull(list);
        assertNotEquals(0,list.size());
    }


    public void testContent() throws Exception{


        System.out.print("Test that the contents of the list are correct, alphabetical order" );
        Movie testMovie;

        //make sure they're the same size
        assertEquals(names.length,list.size());

        int n = 0;
        while(n < list.size()){

            testMovie = (Movie) list.get(n);

            assertEquals(names[n], testMovie.getMovieName());

            assertEquals(genres[n], testMovie.getGenre());

            assertEquals(ratings[n], testMovie.getMovieRating());

            n++;
        }

    }

}