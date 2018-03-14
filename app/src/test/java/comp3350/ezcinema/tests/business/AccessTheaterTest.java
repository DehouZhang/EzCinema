package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import java.util.ArrayList;
import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.business.AccessTheater;


public class AccessTheaterTest extends TestCase{
    private AccessTheater accessor;
    private ArrayList list;
    private String [] names;
    private String [] addresses;


    public void setUp() throws Exception {
        Main.startUp();
        accessor = new AccessTheater();
        list = new ArrayList<Theater>();
        accessor.getTheaters(list);

        names = new String[]{"Cinema City Northgate", "Cineplex Odeon McGillivray Cinemas", "Famous Players Kildonan Place Cinemas", "Scotiabank Theatre Winnipeg", "SilverCity St.Vital Cinemas"};
        addresses = new String[]{"1399 McPhillips Street", "2190 McGillivray Blvd", "1555 Regent Avenue West", "817 St. James Street", "160-1225 St. Mary's Road, Winnipeg"};
    }


    public void testExisitence() throws Exception{

        System.out.print("Whether the list is/isn't null and is not returned empty");
        assertNull(accessor.getTheaters((null)));
        assertNotNull(list);
        assertNotEquals(0,list.size());

    }


    public void testContent() throws Exception{

        System.out.print("Test that the contents of the list are correct, alphabetical order" );
        Theater testTheater;

        //make sure they're the same size
        assertEquals(names.length,list.size());

        int n = 0;
        while(n < list.size()){

            testTheater = (Theater) list.get(n);

            assertEquals(names[n], testTheater.getTheaterName());

            assertEquals(addresses[n], testTheater.getTheaterAddress());

           // assertEquals(prices[n], testTheater.getTicketPrice());

            n++;
        }

    }
}