package comp3350.ezcinema.tests.persistence;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Ticket;
import comp3350.ezcinema.persistence.DataAccess;

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
        //or switch to the real database:
        //dataAccess = new DataAccessObject(Main.dbName);
        //dataAccess.open(Main.getDBPathName());


    }

    public void tearDown()
    {
        System.out.println("Finished Persistence test DataAccess (using stub)");
    }




    public static void dataAccessTest(DataAccess dataAccess){
        DataAccessTest dataAccessTest = new DataAccessTest("");
        dataAccessTest.dataAccess = dataAccess;
        dataAccessTest.testCheckStatus();
        dataAccessTest.testCountRemain();
        dataAccessTest.testGetMovieSequential();
        dataAccessTest.testGetShowtimeList();
        dataAccessTest.testGetTheaterAddress();
        dataAccessTest.testGetTheaterSequential();
        dataAccessTest.testInsertTicket();
        dataAccessTest.testUpdateStatus();
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
        assertEquals("817 St.James Street",theater.getTheaterAddress());
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

         //Tomb Raider in Cineplex Odeon McGillivray Cinemas
         showtimes.clear();
         expected.clear();
         movie=new Movie("Tomb Raider");
         theater=new Theater("Cineplex Odeon McGillivray Cinemas");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("14:20");
         expected.add("17:50");
         expected.add("21:20");
         assertArrayEquals(expected.toArray(),showtimes.toArray());

         //Tomb Raider in Scotiabank Theatre Winnippeg
         showtimes.clear();
         expected.clear();
         movie=new Movie("Tomb Raider");
         theater=new Theater("Scotiabank Theatre Winnipeg");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("13:30");
         expected.add("14:20");
         expected.add("20:45");
         assertArrayEquals(expected.toArray(),showtimes.toArray());

         //Tomb Raider in Cinema City Northgate
         showtimes.clear();
         expected.clear();
         movie=new Movie("Tomb Raider");
         theater=new Theater("Cinema City Northgate");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("12:00");
         expected.add("16:30");
         expected.add("20:50");
         assertArrayEquals(expected.toArray(),showtimes.toArray());

         //Winchester in Cinema City Northgate
         showtimes.clear();
         expected.clear();
         movie=new Movie("Winchester");
         theater=new Theater("Famous Players Kildonan Place Cinemas");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("13:20");
         expected.add("16:50");
         expected.add("19:10");
         expected.add("22:00");
         assertArrayEquals(expected.toArray(),showtimes.toArray());

         //Winchester in SilverCity St.Vital Cinemas
         showtimes.clear();
         expected.clear();
         movie=new Movie("Winchester");
         theater=new Theater("SilverCity St.Vital Cinemas");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("12:00");
         expected.add("15:20");
         expected.add("19:40");
         assertArrayEquals(expected.toArray(),showtimes.toArray());

         //Jumangi: Welcome to the Jungle in SilverCity St.Vital Cinemas
         showtimes.clear();
         expected.clear();
         movie=new Movie("Jumangi: Welcome to the Jungle");
         theater=new Theater("Cinema City Northgate");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("13:20");
         expected.add("16:50");
         expected.add("19:10");
         expected.add("22:00");
         assertArrayEquals(expected.toArray(),showtimes.toArray());

         //Peter Rabbit in Cineplex Odeon McGillivray Cinemas
         showtimes.clear();
         expected.clear();
         movie=new Movie("Peter Rabbit");
         theater=new Theater("Cineplex Odeon McGillivray Cinemas");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("14:40");
         expected.add("17:40");
         expected.add("20:30");
         expected.add("23:40");
         assertArrayEquals(expected.toArray(),showtimes.toArray());

         //Unforgettable in Scotiabank Theatre Winnpipeg
         showtimes.clear();
         expected.clear();
         movie=new Movie("Unforgettable");
         theater=new Theater("Scotiabank Theatre Winnipeg");
         showtimes=dataAccess.getShowtimeList(movie,theater);
         expected.add("12:30");
         expected.add("16:20");
         expected.add("21:00");
         assertArrayEquals(expected.toArray(),showtimes.toArray());
     }

     public void testGetTheaterAddress()
     {
         String address;

         //test the address of Scotiabank Theatre Winnipeg
         address=dataAccess.getTheaterAddress("Scotiabank Theatre Winnipeg");
         assertEquals("817 St.James Street",address);

         //test the address of Famous Players Kildonan Place Cinemas
         address=dataAccess.getTheaterAddress("Famous Players Kildonan Place Cinemas");
         assertEquals("1555 Regent Avenue West",address);

         //test the address of Cinema City Northgate
         address=dataAccess.getTheaterAddress("Cinema City Northgate");
         assertEquals("1399 McPhillips Street",address);

         //test the address of SilverCity St.Vital Cinemas
         address=dataAccess.getTheaterAddress("SilverCity St.Vital Cinemas");
         assertEquals("160-1225 St.Mary's Road, Winnipeg",address);

         //test the address of Cineplex Odeon McGillivray Cinemas
         address=dataAccess.getTheaterAddress("Cineplex Odeon McGillivray Cinemas");
         assertEquals("2190 McGillivray Blvd",address);
     }


    public void testCountRemain()
    {
        ArrayList<String> showtimes=new ArrayList<>();
        MT mt;
        showtimes.clear();
        showtimes.add("14:40");
        showtimes.add("19:20");
        showtimes.add("23:30");
        mt = new MT("Tomb Raider","Famous Players Kildonan Place Cinemas",showtimes);
        assertEquals(25,dataAccess.countRemain(mt,"14:40"));
        dataAccess.updateStatus(mt,"14:40",0,0);
        assertEquals(24,dataAccess.countRemain(mt,"14:40"));
        dataAccess.updateStatus(mt,"14:40",0,1);
        dataAccess.updateStatus(mt,"14:40",0,2);
        dataAccess.updateStatus(mt,"14:40",0,3);
        dataAccess.updateStatus(mt,"14:40",0,4);
        dataAccess.updateStatus(mt,"14:40",1,0);
        assertEquals(19,dataAccess.countRemain(mt,"14:40"));

        showtimes.clear();
        showtimes.add("12:00");
        showtimes.add("15:20");
        showtimes.add("19:40");
        mt= new MT("Winchester","SilverCity St.Vital Cinemas",showtimes);
        assertEquals(25,dataAccess.countRemain(mt,"12:00"));
        dataAccess.updateStatus(mt,"12:00",0,0);
        assertEquals(24,dataAccess.countRemain(mt,"12:00"));
        dataAccess.updateStatus(mt,"12:00",0,1);
        assertEquals(23,dataAccess.countRemain(mt,"12:00"));
        dataAccess.updateStatus(mt,"12:00",0,2);
        dataAccess.updateStatus(mt,"12:00",0,3);
        assertEquals(21,dataAccess.countRemain(mt,"12:00"));
        dataAccess.updateStatus(mt,"12:00",0,4);
        dataAccess.updateStatus(mt,"12:00",1,1);
        dataAccess.updateStatus(mt,"12:00",1,2);
        assertEquals(18,dataAccess.countRemain(mt,"12:00"));
        dataAccess.updateStatus(mt,"12:00",1,3);
        dataAccess.updateStatus(mt,"12:00",1,4);
        assertEquals(16,dataAccess.countRemain(mt,"12:00"));

    }

    public void testCheckStatus()
    {
        ArrayList<String> showtimes=new ArrayList<>();
        MT mt;
        showtimes.add("14:40");
        showtimes.add("18:00");
        showtimes.add("21:20");
        mt = new MT("Peter Rabbit","Cinema City Northgate",showtimes);
        assertEquals(0,dataAccess.checkStatus(mt,"14:40",0,0));
        assertEquals(0,dataAccess.checkStatus(mt,"14:40",3,1));
        assertEquals(0,dataAccess.checkStatus(mt,"14:40",4,3));
        dataAccess.updateStatus(mt,"14:40",0,0);
        assertEquals(1,dataAccess.checkStatus(mt,"14:40",0,0));
        dataAccess.updateStatus(mt,"14:40",3,1);
        assertEquals(1,dataAccess.checkStatus(mt,"14:40",3,1));
        dataAccess.updateStatus(mt,"14:40",4,3);
        assertEquals(1,dataAccess.checkStatus(mt,"14:40",4,3));

        assertEquals(0,dataAccess.checkStatus(mt,"18:00",0,0));
        assertEquals(0,dataAccess.checkStatus(mt,"18:00",3,1));
        assertEquals(0,dataAccess.checkStatus(mt,"18:00",4,3));
        dataAccess.updateStatus(mt,"18:00",0,0);
        assertEquals(1,dataAccess.checkStatus(mt,"18:00",0,0));
        dataAccess.updateStatus(mt,"18:00",3,1);
        assertEquals(1,dataAccess.checkStatus(mt,"18:00",3,1));
        dataAccess.updateStatus(mt,"18:00",4,3);
        assertEquals(1,dataAccess.checkStatus(mt,"18:00",4,3));
    }
    public void testUpdateStatus()
    {
        System.out.println("\nStarting testUpdateStatus()");
        MT mt;
        ArrayList<String> showtimes=new ArrayList<>();

        showtimes.clear();
        showtimes.add("10:40");
        showtimes.add("14:20");
        showtimes.add("19:50");
        mt = new MT("Ferdinand","Cinema City Northgate",showtimes);
        for(int i=0;i<showtimes.size();i++)
        {
            assertNull(dataAccess.updateStatus(mt, showtimes.get(i), 3, 2));
            assertEquals(1, dataAccess.checkStatus(mt, showtimes.get(i), 3, 2));
        }

        showtimes.clear();;
        showtimes.add("12:00");
        showtimes.add("15:20");
        showtimes.add("19:40");
        mt=new MT("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas",showtimes);
        for(int i=0;i<showtimes.size();i++)
        {
            assertNull(dataAccess.updateStatus(mt, showtimes.get(i), 0, 1));
            assertEquals(1, dataAccess.checkStatus(mt, showtimes.get(i), 0, 1));
        }

        showtimes.clear();
        showtimes.add("12:00");
        showtimes.add("15:20");
        showtimes.add("19:40");
        mt=new MT("Jumangi: Welcome to the Jungle","SilverCity St.Vital Cinemas",showtimes);
        for(int i=0;i<showtimes.size();i++)
        {
            assertNull(dataAccess.updateStatus(mt, showtimes.get(i), 0, 1));
            assertEquals(1, dataAccess.checkStatus(mt, showtimes.get(i), 0, 1));
        }

        showtimes.clear();
        showtimes.add("14:40");
        showtimes.add("17:40");
        showtimes.add("20:30");
        showtimes.add("23:40");
        mt=new MT("Peter Rabbit","Cineplex Odeon McGillivray Cinemas",showtimes);
        for(int i=0;i<showtimes.size();i++)
        {
            assertNull(dataAccess.updateStatus(mt, showtimes.get(i), 2, 4));
            assertEquals(1, dataAccess.checkStatus(mt, showtimes.get(i), 2, 4));
        }
    }


    public void testInsertTicket(){

        //test empty ticket
        assertEquals(0,dataAccess.insertTicket(null, null, null, 0, 0));

        //test tickets missing info
        assertEquals(0,dataAccess.insertTicket(null,"Cinema City Northgate","10:40",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand",null,"10:40",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Cinema City Northgate",null,0,0));
        assertEquals(0,dataAccess.insertTicket(null,null,"10:40",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand",null,null,0,0));
        assertEquals(0,dataAccess.insertTicket(null,"Cinema City Northgate",null,0,0));



        //test incorrect info
        //movie name
        assertEquals(0,dataAccess.insertTicket("Fifty Shades Freed","Cinema City Northgate","10:40",0,0));
        assertEquals(0,dataAccess.insertTicket("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","11:25",0,0));
        assertEquals(0,dataAccess.insertTicket("Fifty Shades Freed","Famous Players Kildonan Place Cinemas","15:30",0,0));
        assertEquals(0,dataAccess.insertTicket("Fifty Shades Freed","Scotiabank Theatre Winnipeg","13:30",0,0));
        assertEquals(0,dataAccess.insertTicket("Fifty Shades Freed","SilverCity St.Vital Cinemas","14:50",0,0));


        //Theater name
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Cineplex Odeon McGillivray Cinemas","10:40",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Famous Players Kildonan Place Cinemas","11:25",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Scotiabank Theatre Winnipeg","15:30",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","SilverCity St.Vital Cinemas","13:30",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Cinema City Northgate","14:50",0,0));

        //showtime
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Cinema City Northgate","11:40",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Cineplex Odeon McGillivray Cinemas","12:25",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Famous Players Kildonan Place Cinemas","17:30",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Scotiabank Theatre Winnipeg","14:30",0,0));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","SilverCity St.Vital Cinemas","12:50",0,0));

        //row & col
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Cinema City Northgate","10:40",5,5));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Cineplex Odeon McGillivray Cinemas","11:25",6,6));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Famous Players Kildonan Place Cinemas","15:30",4,7));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Scotiabank Theatre Winnipeg","13:30",7,4));
        assertEquals(0,dataAccess.insertTicket("Ferdinand","SilverCity St.Vital Cinemas","14:50",-1,-1));


        //test normal tickets, create 5 then grab them
        assertEquals(1,dataAccess.insertTicket("Ferdinand","Cinema City Northgate","10:40",0,0));
        assertEquals(1,dataAccess.insertTicket("Ferdinand","Cineplex Odeon McGillivray Cinemas","11:25",0,0));
        assertEquals(1,dataAccess.insertTicket("Ferdinand","Famous Players Kildonan Place Cinemas","15:30",0,0));
        assertEquals(1,dataAccess.insertTicket("Ferdinand","Scotiabank Theatre Winnipeg","13:30",0,0));
        assertEquals(1,dataAccess.insertTicket("Ferdinand","SilverCity St.Vital Cinemas","14:50",0,0));


        //creating a ticket that's already there
        assertEquals(0,dataAccess.insertTicket("Ferdinand","Cinema City Northgate","10:40",0,0));

    }



    public void testGetTicketsSequential()
    {

        Ticket ticket,testTicket;
        ArrayList tickets,listoftickets;

        tickets = new ArrayList<Ticket>();
        listoftickets = new ArrayList<Ticket>();

        dataAccess.getTicketsSequential(tickets);

        if(tickets.isEmpty()) {
            assertEquals(1, dataAccess.insertTicket("Fifty Shades Freed", "Cinema City Northgate", "13:20", 0, 0));
            assertEquals(1, dataAccess.insertTicket("Fifty Shades Freed", "Cineplex Odeon McGillivray Cinemas", "12:00", 0, 0));
            assertEquals(1, dataAccess.insertTicket("Fifty Shades Freed", "Famous Players Kildonan Place Cinemas", "13:30", 0, 0));
            assertEquals(1, dataAccess.insertTicket("Fifty Shades Freed", "Scotiabank Theatre Winnipeg", "14:40", 0, 0));
            assertEquals(1, dataAccess.insertTicket("Fifty Shades Freed", "SilverCity St.Vital Cinemas", "14:00", 0, 0));

            listoftickets.add(new Ticket("Fifty Shades Freed","Cinema City Northgate","13:20",0,0));
            listoftickets.add(new Ticket("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","12:00",0,0));
            listoftickets.add(new Ticket("Fifty Shades Freed","Famous Players Kildonan Place Cinemas","13:30",0,0));
            listoftickets.add(new Ticket("Fifty Shades Freed","Scotiabank Theatre Winnipeg","14:40",0,0));
            listoftickets.add(new Ticket("Fifty Shades Freed","SilverCity St.Vital Cinemas","14:00",0,0));

            dataAccess.getTicketsSequential(tickets);
        }
        else
        {
            listoftickets.add(new Ticket("Ferdinand", "Cinema City Northgate", "10:40", 0, 0));
            listoftickets.add(new Ticket("Ferdinand", "Cineplex Odeon McGillivray Cinemas", "11:25", 0, 0));
            listoftickets.add(new Ticket("Ferdinand", "Famous Players Kildonan Place Cinemas", "15:30", 0, 0));
            listoftickets.add(new Ticket("Ferdinand", "Scotiabank Theatre Winnipeg", "13:30", 0, 0));
            listoftickets.add(new Ticket("Ferdinand", "SilverCity St.Vital Cinemas", "14:50", 0, 0));
        }

        //then retrieve and check them
        dataAccess.getTicketsSequential(tickets);

        int [] testTicketLocation ;
        int [] ticketLocation;
        for (int i = 0; i < listoftickets.size(); i++)
        {
            ticket = (Ticket)tickets.get(i);
            testTicket = (Ticket)listoftickets.get(i);

            assertEquals(testTicket.getMovieName(), ticket.getMovieName());
            assertEquals(testTicket.getTheaterName(), ticket.getTheaterName());
            assertEquals(testTicket.getShowTime(), ticket.getShowTime());

            testTicketLocation = testTicket.getSeatLocation();
            ticketLocation = ticket.getSeatLocation();

            assertEquals(testTicketLocation[0], ticketLocation[0]);
            assertEquals(testTicketLocation[1], ticketLocation[1]);
        }
    }


}


