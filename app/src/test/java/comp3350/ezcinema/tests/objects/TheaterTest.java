package comp3350.ezcinema.tests.objects;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import comp3350.ezcinema.objects.Theater;

import static org.junit.Assert.*;


public class TheaterTest extends TestCase
{

    private Theater theater_normal_data, theater_equivalent_data, theater_no_name, theater_no_address, theater_empty, theater_alt_data;
    private Comparator<Theater> theaterNameComp;

    public TheaterTest(String arg0)
    {
        super(arg0);
    }

    @Before
    public void setUp() throws Exception
    {

        theater_normal_data = new Theater("Scotiabank Theatre Winnipeg","817 St.James Street");
        theater_equivalent_data = new Theater("Scotiabank Theatre Winnipeg","817 St.James Street");
        theater_no_name = new Theater("","1555 Regent Avenue West");
        theater_no_address = new Theater("Cinema City Northgate","");
        theater_empty = new Theater("","");
        theater_alt_data = new Theater("Cineplex Odeon McGillivray Cinemas","2190 McGillivray Blvd");
        theaterNameComp = Theater.TheaterNameComparator;
    }
    @Test
    public void testGetMethods() throws Exception
    {
        //normal cases
        assertEquals(theater_normal_data.getTheaterName(), "Scotiabank Theatre Winnipeg");
        assertEquals(theater_normal_data.getTheaterAddress(), "817 St.James Street");

        assertEquals(theater_alt_data.getTheaterName(), "Cineplex Odeon McGillivray Cinemas");
        assertEquals(theater_alt_data.getTheaterAddress(), "2190 McGillivray Blvd");

        //test equivalent cases
        assertEquals(theater_normal_data.getTheaterName(), theater_equivalent_data.getTheaterName());
        assertEquals(theater_normal_data.getTheaterAddress(), theater_equivalent_data.getTheaterAddress());

        //test empty data field cases
        assertNull(theater_no_name.getTheaterName());
        assertNull(theater_no_name.getTheaterAddress());

        assertNull(theater_no_address.getTheaterAddress());
        assertNull(theater_no_address.getTheaterName());

        assertNull(theater_empty.getTheaterName());
        assertNull(theater_empty.getTheaterAddress());
    }
    @Test
    public void testToString() throws Exception
    {
        //test normal cases
        assertEquals(theater_normal_data.toString(), "Scotiabank Theatre Winnipeg\nAddress: 817 St.James Street");
        assertEquals(theater_alt_data.toString(), "Cineplex Odeon McGillivray Cinemas\nAddress: 2190 McGillivray Blvd");

        //test empty cases
        assertNull(theater_empty.toString());
        assertNull(theater_no_address.toString());
        assertNull(theater_no_name.toString());

    }
    @Test
    public void testComparisons() throws Exception
    {
        //test equivalent and equal cases
        assertTrue(theaterNameComp.compare(theater_normal_data,theater_normal_data) == 0);
        assertTrue(theaterNameComp.compare(theater_normal_data,theater_equivalent_data) == 0);
        assertTrue(theaterNameComp.compare(theater_alt_data, theater_alt_data) == 0);

        //test normal comparisons
        assertTrue(theaterNameComp.compare(theater_normal_data, theater_alt_data) > 0);
        assertTrue(theaterNameComp.compare(theater_alt_data, theater_normal_data) < 0);

        //test empty data fields
        assertTrue(theaterNameComp.compare(theater_normal_data, theater_empty) > 0); //compare normal vs empty
        assertTrue(theaterNameComp.compare(theater_alt_data, theater_empty) > 0);    //compare alt data vs empty
        assertTrue(theaterNameComp.compare(theater_empty, theater_normal_data) < 0); //compare empty vs normal
        assertTrue(theaterNameComp.compare(theater_empty, theater_empty) == 0);      //compare empty vs empty
        assertTrue(theaterNameComp.compare(theater_normal_data, theater_no_name) > 0); //compare normal vs no name
        assertTrue(theaterNameComp.compare(theater_alt_data, theater_no_name) > 0); //compare alt vs no name
        assertTrue(theaterNameComp.compare(theater_normal_data, theater_no_address) > 0); //compare normal vs no address
        assertTrue(theaterNameComp.compare(theater_alt_data, theater_no_address) > 0); //compare alt vs no address
        assertTrue(theaterNameComp.compare(theater_no_name, theater_no_address) == 0); //compare no name vs no address
    }
}