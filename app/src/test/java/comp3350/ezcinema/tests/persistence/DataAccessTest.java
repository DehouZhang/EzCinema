package comp3350.ezcinema.tests.persistence;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.persistence.DataAccess;
import comp3350.ezcinema.tests.persistence.DataAccessStub;

public class DataAccessTest extends TestCase
{
    private DataAccess dataAccess;

    public DataAccessTest(String arg0)
    {
        super(arg0);
    }

    public void setUp()
    {
        System.out.println("\nStarting Persistence test DataAccess (using stub)");
        // Use the following statements to run with the stub database:
        dataAccess = new DataAccessStub();
        dataAccess.open("Stub");
        // or switch to the real database:
        // dataAccess = new DataAccessObject(Main.dbName);
        // dataAccess.open(Main.getDBPathName());
    }

    public void tearDown() {
        System.out.println("Finished Persistence test DataAccess (using stub)");
    }

    public void test1()
    {
        ArrayList<Movie> movies;
        ArrayList<Theater> theaters;

        Movie movie;
        Theater theater;

        String result;

        movies= new ArrayList<Movie>();
        result= dataAccess.getMovieSequential(movies);
        assertNull(result); // result should be null
        assertEquals(8,movies.size());
        movie = movies.get(0);
        assertEquals("Fifty Shades Freed",movie.getMovieName());
    }
}
