package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.business.AccessMovie;

/**
 * Created by Dow on 12/02/2018.
 */
public class AccessMovieTest extends TestCase {

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
    public void testGetMovies() throws Exception{
        assertNotNull(list);
    }

}