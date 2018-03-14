package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;
import java.util.ArrayList;
import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.business.AccessMT;
import comp3350.ezcinema.business.AccessMovie;
import comp3350.ezcinema.business.AccessTheater;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import static org.junit.Assert.*;

public class AccessMTTest extends TestCase
{

    private AccessMT accessorMT;
    private AccessMovie accessorM;
    private AccessTheater accessorT;
    private ArrayList mlist;
    private ArrayList tlist;
    private String [] mNames;
    private String [] tNames;
    private String [] showtimesArray;


    private MT mt;
    private Movie movie;
    private Theater theater;


    public void setUp() throws Exception
    {
        Main.startUp();

        accessorM = new AccessMovie();
        mlist = new ArrayList<Movie>();
        accessorM.getMovies(mlist);

        accessorT = new AccessTheater();
        tlist = new ArrayList<Theater>();
        accessorT.getTheaters(tlist);

        accessorMT = new AccessMT();

        mNames = new String[]{"Ferdinand", "Fifty Shades Freed", "Jumangi: Welcome to the Jungle", "Peter Rabbit", "Red Sparrow", "Tomb Raider", "Unforgettable", "Winchester"};
        tNames = new String[]{"Cinema City Northgate", "Cineplex Odeon McGillivray Cinemas", "Famous Players Kildonan Place Cinemas","Scotiabank Theatre Winnipeg", "SilverCity St.Vital Cinemas"};

        showtimesArray = new String [] {"[10:40, 14:20, 19:50]","[11:25, 15:40, 19:35]", "[15:30, 19:20, 22:50]","[13:30, 16:40, 21:30]","[14:50, 18:30, 21:50]","[13:20, 16:50, 19:10, 22:00]", "[12:00, 15:20, 19:40]", "[13:30, 17:40, 20:25]", "[14:40, 18:00, 21:20]","[14:00, 17:40, 20:30, 23:40]",
                "[13:20, 16:50, 19:10, 22:00]", "[13:30, 17:40, 20:25]","[14:00, 17:40, 20:30, 23:40]","[14:40, 18:00, 21:20]","[12:00, 15:20, 19:40]","[14:40, 18:00, 21:20]","[14:40, 17:40, 20:30, 23:40]",
                "[12:00, 15:20, 19:40]","[13:20, 16:50, 19:10, 22:00]", "[13:30, 17:40, 20:25]", "[14:10, 19:50, 22:30]","[15:30, 19:50, 21:30]","[13:40, 17:00, 23:10]","[15:00, 18:10, 21:50]","[11:10, 14:20, 20:30]","[12:00, 16:30, 20:50]",
                "[14:20, 17:50, 21:20]","[14:40, 19:20, 23:30]","[13:30, 14:20, 20:45]","[15:45, 18:30, 21:40]","[12:20, 15:30, 18:10]","[13:00, 17:30, 21:20]","[13:00, 17:30, 21:20]","[12:30, 16:20, 21:00]","[14:50, 18:40, 21:50]","[14:00, 17:40, 20:30, 23:40]","[14;40, 18:00, 21:20]",
                "[13:20, 16:50, 19:10, 22:00]","[13:30, 17:40, 20:25]","[12:00, 15:20, 19:40]"};

     }

    public void testExisitence() throws Exception
    {

        System.out.println("Test That the lists aren't null or empty");
        assertNotNull(mlist);
        assertNotEquals(0,mlist.size());

        assertNotNull(tlist);
        assertNotEquals(0,tlist.size());

    }

    public void testFetchingMT() throws Exception
    {

        System.out.println("Test that the MT's are fetched properly");

        //nested for loop to cycle though theaters and movies to fetch MT objects

        mt =  accessorMT.getMT(null,null);
        assertNull(mt);

        for (int i = 0; i < mNames.length; i++)
        {
            for (int k = 0; k < tNames.length; k++)
            {
                movie = (Movie) mlist.get(i);
                theater = (Theater) tlist.get(k);
                mt = accessorMT.getMT(movie,theater);

                //only if the movie-theater pair exists
                if(mt != null)
                {
                    assertEquals(mNames[i], mt.getMovieName());

                    assertEquals(tNames[k], mt.getTheaterName());

                    //System.out.println(mt.getMovieName() +"  "+ mt.getTheaterName());
                }

            }
        }


    }



    public void testShowtimes() throws Exception {


        System.out.println("Test that the MT's have the proper showtimes");

        ArrayList<String> showtimes;

        //nested for loop to cycle though theaters and movies to check the showtimes in the MT objects
        int n = 0;
        for (int i = 0; i < mNames.length; i++) {
            for (int k = 0; k < tNames.length; k++) {
                movie = (Movie) mlist.get(i);
                theater = (Theater) tlist.get(k);
                mt = accessorMT.getMT(movie, theater);

                //only if the movie-theater pair exists
                if(mt != null){

                    showtimes = mt.getShowtime();

                    assertEquals(showtimesArray[n],showtimes.toString());
                    n++;
                }
            }
        }
    }





}








