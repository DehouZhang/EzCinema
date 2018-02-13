package comp3350.ezcinema.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.objects.Movie;

/**
 * Created by Dow on 12/02/2018.
 */
public class AccessMovieTest {

    private AccessMovie accessor;
    private ArrayList list;

    @Before
    public void setUp() throws Exception {
        Main.startUp();
        accessor = new AccessMovie();
        list = new ArrayList<Movie>();
        accessor.getMovies(list);
    }

    @Test
    public void getMovies() throws Exception{
        assertNotNull(list);
    }

}