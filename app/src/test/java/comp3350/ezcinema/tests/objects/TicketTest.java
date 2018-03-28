package comp3350.ezcinema.tests.objects;

import junit.framework.TestCase;

import comp3350.ezcinema.objects.Ticket;


public class TicketTest extends TestCase {

    private Ticket ticket1,badName,badTheater,badShowtime,badRow,badColumn,allBad;

    public void setUp() throws Exception {


        ticket1 = new Ticket("Fifty Shades Freed","Cinema City Northgate","13:20",0,0);
        badName = new Ticket("","Cineplex Odeon McGillivray Cinemas","12:00",0,0);
        badTheater = new Ticket("Fifty Shades Freed","","12:00",0,0);
        badShowtime = new Ticket("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","",0,0);
        badRow = new Ticket("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","12:00",5,0);
        badColumn = new Ticket("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","12:00",0,5);
        allBad = new Ticket("","","",5,5);

    }


    public void testGetMethods() throws Exception {

        //test all of the good tickets info
        assertEquals("Fifty Shades Freed",ticket1.getMovieName());
        assertEquals("13:20",ticket1.getShowTime());
        assertEquals("Cinema City Northgate",ticket1.getTheaterName());

        int testArray [] = {0,0};
        int array [] = ticket1.getSeatLocation();
        assertEquals(testArray[0],array[0]);
        assertEquals(testArray[1],array[1]);

        assertEquals("Fifty Shades Freed" + "\t" + "13:20" + "\n" + "Cinema City Northgate" + "\nSeat:" + 1 + ", " + 1 ,ticket1.toString());


        //test info of bad tickets
            //bad name
            assertEquals(null,badName.getMovieName());
            assertEquals(null,badName.getShowTime());
            assertEquals(null,badName.getTheaterName());

            array = badName.getSeatLocation();
            assertEquals(-1,array[0]);
            assertEquals(-1,array[1]);
            assertEquals(null,badName.toString());


            //bad theater
            assertEquals(null,badTheater.getMovieName());
            assertEquals(null,badTheater.getShowTime());
            assertEquals(null,badTheater.getTheaterName());

            array = badTheater.getSeatLocation();
            assertEquals(-1,array[0]);
            assertEquals(-1,array[1]);
            assertEquals(null,badTheater.toString());


            //bad showtime
            assertEquals(null,badShowtime.getMovieName());
            assertEquals(null,badShowtime.getShowTime());
            assertEquals(null,badShowtime.getTheaterName());

            array = badShowtime.getSeatLocation();
            assertEquals(-1,array[0]);
            assertEquals(-1,array[1]);
            assertEquals(null,badShowtime.toString());

            //bad row
            assertEquals(null,badRow.getMovieName());
            assertEquals(null,badRow.getShowTime());
            assertEquals(null,badRow.getTheaterName());

            array = badRow.getSeatLocation();
            assertEquals(-1,array[0]);
            assertEquals(-1,array[1]);
            assertEquals(null,badRow.toString());


            //bad column
            assertEquals(null,badColumn.getMovieName());
            assertEquals(null,badColumn.getShowTime());
            assertEquals(null,badColumn.getTheaterName());

            array = badColumn.getSeatLocation();
            assertEquals(-1,array[0]);
            assertEquals(-1,array[1]);
             assertEquals(null,badColumn.toString());

            //everything incorrect
            assertEquals(null,allBad.getMovieName());
            assertEquals(null,allBad.getShowTime());
            assertEquals(null,allBad.getTheaterName());

            array = allBad.getSeatLocation();
            assertEquals(-1,array[0]);
            assertEquals(-1,array[1]);
            assertEquals(null,allBad.toString());

    }
}