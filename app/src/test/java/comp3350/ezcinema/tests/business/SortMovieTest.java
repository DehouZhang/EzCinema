package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;
import java.util.ArrayList;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.business.AccessMovie;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.business.SortMovie;
import static org.junit.Assert.*;

public class SortMovieTest extends TestCase
{
    private Movie movie;
    private ArrayList<Movie> movies, sorted;
    private AccessMovie accessorM;
    private String [] nameOrder;
    private double [] ratingOrder;
    private String [] genres;



    public void setUp() throws Exception
    {
        Main.startUp();
        accessorM = new AccessMovie();
        movies = new ArrayList<Movie>();
        sorted = new ArrayList<Movie>();
        accessorM.getMovies(movies);

        nameOrder = new String[]{"Ferdinand", "Fifty Shades Freed", "Jumangi: Welcome to the Jungle",  "Peter Rabbit", "Red Sparrow", "Tomb Raider", "Unforgettable", "Winchester"};
        ratingOrder = new double[]{8.9, 6.7, 6.7, 6.4, 5.8, 5.6, 5.0, 2.8};
        genres = new String[]{"Family","Thriller", "Horror"};
    }

    public void testSortByName() throws Exception {


        sorted = (ArrayList<Movie>) SortMovie.sortByName(null);

        assertNull(sorted);

        sorted = (ArrayList<Movie>) SortMovie.sortByName(movies);

        assertNotNull(sorted);

        //System.out.println(sorted.toString());

        for(int n = 0; n < sorted.size(); n++){

            movie = (Movie) sorted.get(n);

            assertEquals(nameOrder[n], movie.getMovieName());
        }

    }


    public void testSortByRating() throws Exception {

        sorted = (ArrayList<Movie>) SortMovie.sortByRating(null);

        assertNull(sorted);

        sorted = (ArrayList<Movie>) SortMovie.sortByRating(movies);

        assertNotNull(sorted);

        //System.out.println(sorted.toString());

        for(int n = 0; n < sorted.size(); n++){

            movie = (Movie) sorted.get(n);

            assertEquals(ratingOrder[n], movie.getMovieRating());
        }
    }


    public void testSortByGenre() throws Exception{


        sorted = (ArrayList<Movie>) SortMovie.sortByGenre(null, null);

        assertNull(sorted);

        for(int i = 0; i < 3; i++) {
            sorted = SortMovie.sortByGenre(movies, genres[i]);

            assertNotNull(sorted);

            //System.out.println(sorted.toString());

            for (int n = 0; n < sorted.size(); n++) {

                movie = (Movie) sorted.get(n);
                assertEquals(genres[i], movie.getGenre());
            }
        }
    }

}