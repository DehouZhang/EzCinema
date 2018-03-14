package comp3350.ezcinema.tests.objects;


import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;

import comp3350.ezcinema.objects.MT;

public class MTTest extends TestCase
{
    private MT mt1,mt2,mt3,mt4,mt5,mt6,mt7,mt8,mt9,mt10;
    private ArrayList<String> showtime1, showtime2,showtime3,showtime4, showtime5, emptyShowtime;

    @Test
    public void setUp() throws Exception
    {
        showtime1 = new ArrayList<>();  //normal list
        showtime1.add("9:00");
        showtime1.add("10:00");

        showtime2 = new ArrayList<>();  //another normal list
        showtime2.add("21:00");
        showtime2.add("22:00");

        showtime3 = new ArrayList<>();  //longer list
        showtime3.add("9:00");
        showtime3.add("10:00");
        showtime3.add("21:00");

        showtime4 = new ArrayList<>();  //shorter list
        showtime4.add("9:00");

        showtime5 = new ArrayList<>();  //list with same contents
        showtime5.add("9:00");
        showtime5.add("10:00");

        emptyShowtime = new ArrayList<>();  //empty list


        mt1 = new MT("aMovie","aTheater",showtime1);     //normal data
        mt2 = new MT("bMovie","bTheater",showtime2);     //another normal data
        mt3 = new MT("","",emptyShowtime);               //empty data
        mt4 = new MT("","aTheater",showtime1);           //missing movie name
        mt5 = new MT("aMovie","",showtime1);             //missing theater name
        mt6 = new MT("aMovie","aTheater",emptyShowtime); //empty showtime list
        mt7 = new MT("aMovie","aTheater",showtime2);     //same names with different showtime list

        mt8 = new MT("bMovie","bTheater",showtime3);    //longer list
        mt9 = new MT("bMovie","bTheater",showtime4);    //shorter list
        mt10 = new MT("bMovie","bTheater",showtime5);   //list with same content
    }

    @Test
    public  void testGetMethods() throws Exception
    {
        //test normal data
        assertEquals("aMovie",mt1.getMovieName());
        assertEquals("aTheater",mt1.getTheaterName());
        assertEquals(showtime1,mt1.getShowtime());

        //test another normal data
        assertNotSame(mt1.getMovieName(),mt2.getMovieName());
        assertNotSame(mt1.getTheaterName(),mt2.getTheaterName());
        assertNotSame(mt1.getShowtime(),mt2.getShowtime());

        //test empty data
        assertNull(mt3.getMovieName());
        assertNull(mt3.getTheaterName());
        assertEquals(mt3.getShowtime().size(),0,0);

        //test missing movie name
        assertNull(mt4.getMovieName());
        assertNull(mt4.getTheaterName());
        assertEquals(mt4.getShowtime().size(),0,0);

        //test missing theater name
        assertNull(mt5.getMovieName());
        assertNull(mt5.getTheaterName());
        assertEquals(mt5.getShowtime().size(),0,0);

        //test empty showtime list
        assertNull(mt6.getMovieName());
        assertNull(mt6.getTheaterName());
        assertEquals(mt6.getShowtime().size(),0,0);

        //test same names with different showtime list
        assertEquals(mt7.getMovieName(),mt1.getMovieName());
        assertEquals(mt7.getTheaterName(),mt1.getTheaterName());
        assertNotSame(mt7.getShowtime(),mt1.getShowtime());

    }

    @Test
    public void testToString() throws Exception
    {
        //test normal data
        assertEquals(mt1.toString(),"aMovie in aTheater\nShow Times:\t9:00\t10:00\t");

        //test another normal data
        assertNotSame(mt1.toString(),mt2.toString());

        //test empty data
        assertNull(mt3.toString());

        //test missing movie name
        assertNull(mt4.toString());

        //test missing theater name
        assertNull(mt5.toString());

        //test empty showtime list
        assertNull(mt6.toString());

        //test same names with different showtime list
        assertNotSame(mt7.toString(),mt1.toString());
    }

    @Test
    public void testShowTimeToString() throws Exception
    {
        //test normal list
        assertEquals(mt1.showtimeToString(),showtime1.get(0)+"\t"+showtime1.get(1)+"\t");
        //test another normal list
        assertNotSame(mt1.showtimeToString(),mt2.showtimeToString());
        //test longer list
        assertTrue(mt1.showtimeToString().length() < mt8.showtimeToString().length());
        //test shorter list
        assertTrue(mt1.showtimeToString().length() > mt9.showtimeToString().length());
        //test list with same contents
        assertTrue(mt1.showtimeToString().equals(mt10.showtimeToString()));
        //test empty list
        assertNull(mt3.showtimeToString());
    }
}
