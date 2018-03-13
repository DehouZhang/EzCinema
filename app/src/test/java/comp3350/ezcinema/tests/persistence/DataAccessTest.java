package comp3350.ezcinema.tests.persistence;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.persistence.DataAccess;
import comp3350.ezcinema.persistence.DataAccessObject;
import comp3350.ezcinema.tests.persistence.DataAccessStub;
import comp3350.ezcinema.application.Main;
import static org.junit.Assert.assertArrayEquals;
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
        //dataAccess = new DataAccessObject(Main.dbName);
        //dataAccess.open(Main.getDBPathName());
    }

    public void tearDown() {
        System.out.println("Finished Persistence test DataAccess (using stub)");
    }

    public void testGetMovieSequential()
    {
        System.out.println("\nStarting testGetMovieSequential()");
        ArrayList<Movie> movies;
        Movie movie;
        String result;

        movies= new ArrayList<Movie>();
        result= dataAccess.getMovieSequential(movies);

        assertNull(result); // result should be null
        assertEquals(8,movies.size());
        //test the 1st movie
        movie=movies.get(0);
        assertEquals("Ferdinand",movie.getMovieName());
        assertEquals("After Ferdinand, a bull with a big heart, is mistaken for a dangerous beast, he is captured and torn from his home. Determined to return to his family, he rallies a misfit team on the ultimate adventure.",movie.getMovieDescription());
        assertEquals("Family",movie.getGenre());
        assertEquals(6.7,movie.getMovieRating());
        //test the 2nd movie
        movie = movies.get(1);
        assertEquals("Fifty Shades Freed",movie.getMovieName());
        assertEquals("Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship",movie.getMovieDescription());
        assertEquals("Family",movie.getGenre());
        assertEquals(6.4,movie.getMovieRating());
        //test the 4th movie
        movie = movies.get(3);
        assertEquals("Peter Rabbit",movie.getMovieName());
        assertEquals("Feature adaptation of Beatrix Potter's classic tale of a rebellious rabbit trying to sneak into a farmer's vegetable garden.",movie.getMovieDescription());
        assertEquals("Family",movie.getGenre());
        assertEquals(5.6,movie.getMovieRating());
        //test the 5th movie
        movie= movies.get(4);
        assertEquals("Red Sparrow",movie.getMovieName());
        assertEquals("Ballerina Dominika Egorova is recruited to Sparrow School, a Russian intelligence service where she is forced to use her body as a weapon. Her first mission, targeting a C.I.A. agent, threatens to unravel the security of both nations.",movie.getMovieDescription());
        assertEquals("Horror",movie.getGenre());
        assertEquals(6.7,movie.getMovieRating());
        //test the last movie
        movie=movies.get(movies.size()-1);
        assertEquals("Winchester",movie.getMovieName());
        assertEquals("Ensconced in her sprawling California mansion, eccentric firearm heiress Sarah Winchester believes she is haunted by the souls of people killed by the Winchester repeating rifle.",movie.getMovieDescription());
        assertEquals("Horror",movie.getGenre());
        assertEquals(2.8,movie.getMovieRating());

        movies.clear();

    }

    public void testGetTheaterSequential()
    {
        System.out.println("\nStarting testGetTheaterSequential()");
        ArrayList<Theater> theaters;
        Theater theater;
        String result;

        theaters= new ArrayList<Theater>();
        result= dataAccess.getTheaterSequential(theaters);

        assertNull(result); // result should be null
        assertEquals(5,theaters.size());
        //test the 1st theater
        theater=theaters.get(0);
        assertEquals("Cinema City Northgate",theater.getTheaterName());
        assertEquals("1399 McPhillips Street",theater.getTheaterAddress());
        //test the 2nd theater
        theater=theaters.get(1);
        assertEquals("Cineplex Odeon McGillivray Cinemas",theater.getTheaterName());
        assertEquals("2190 McGillivray Blvd",theater.getTheaterAddress());
        //test the 3nd theater
        theater=theaters.get(2);
        assertEquals("Famous Players Kildonan Place Cinemas",theater.getTheaterName());
        assertEquals("1555 Regent Avenue West",theater.getTheaterAddress());
        //test the 4th theater
        theater=theaters.get(3);
        assertEquals("Scotiabank Theatre Winnipeg",theater.getTheaterName());
        assertEquals("817 St. James Street",theater.getTheaterAddress());
        //test the last theater
        theater=theaters.get(4);
        assertEquals("SilverCity St.Vital Cinemas",theater.getTheaterName());
        assertEquals("160-1225 St.Mary's Road, Winnipeg",theater.getTheaterAddress());

        theaters.clear();
    }
     public void testGetShowtimeList()
     {
         System.out.println("\nStarting testGetShowtimeList()");
         Movie movie;
         Theater theater;
         ArrayList<String> showtimes=new ArrayList<>();
         ArrayList<String> expected= new ArrayList<>();

         //Fredinand in Cinema City Northgate
         showtimes.clear();
         expected.clear();
         movie=new Movie("Ferdinand");
         theater=new Theater("Cinema City Northgate");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("10:40");
         expected.add("14:20");
         expected.add("19:50");
         assertArrayEquals(expected.toArray(),showtimes.toArray());

         //Ferdinand in Cineplex Odeon McGillivray Cinemas
         showtimes.clear();
         expected.clear();
         movie=new Movie("Ferdinand");
         theater=new Theater("Cineplex Odeon McGillivray Cinemas");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("11:25");
         expected.add("15:40");
         expected.add("19:35");
         assertArrayEquals(expected.toArray(),showtimes.toArray());

         //Red Sparrow in Cineplex Odeon McGillivray Cinemas
         showtimes.clear();
         expected.clear();
         movie=new Movie("Red Sparrow");
         theater=new Theater("Cineplex Odeon McGillivray Cinemas");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("15:30");
         expected.add("19:50");
         expected.add("21:30");
         assertArrayEquals(expected.toArray(),showtimes.toArray());


     }



}
