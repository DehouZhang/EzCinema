package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.ezcinema.application.Main;

import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.business.AccessMT;
import comp3350.ezcinema.business.ManageTickets;
import comp3350.ezcinema.business.UpdateSeat;

import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.persistence.DataAccess;

import static org.junit.Assert.*;


public class UpdateSeatTest extends TestCase {

    private UpdateSeat accessorUD;
    private AccessMT accessorMT;
    private ManageTickets accessorManage;
    private DataAccess dataAccess;

    public void setUp() throws Exception {
        Main.startUp();

        accessorUD = new UpdateSeat();
        accessorMT = new AccessMT();
        accessorManage = new ManageTickets();
        dataAccess = Services.getDataAccess(Main.dbName);
    }


    public void testUpdateSeatStatus(){


        ///try with improper details
            //bad showtime
            assertEquals("Error: Doesn't exist",dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater( "Cinema City Northgate","1399 McPhillips Street")),"0",0,0));

            //bad theater name
            assertEquals("Error: Doesn't exist",dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater("bad","2190 McGillivray Blvd")),"12:00",0,0));

            //bad movie name
            assertEquals("Error: Doesn't exist",dataAccess.updateStatus(accessorMT.getMT(new Movie("bad", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater("Scotiabank Theatre Winnipeg","817 St.James Street")),"14:40",0,0));

            //bad seat location
            assertEquals("Error: Doesn't exist",dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater("SilverCity St.Vital Cinemas","160-1225 St.Mary's Road, Winnipeg")),"14:00",7,7));




        //Update the avaliable seats
        assertEquals(null,dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater( "Cinema City Northgate","1399 McPhillips Street")),"13:20",0,0));

        assertEquals(null,dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater("Cineplex Odeon McGillivray Cinemas","2190 McGillivray Blvd")),"12:00",0,0));

        assertEquals(null,dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater( "Famous Players Kildonan Place Cinemas","1555 Regent Avenue West")),"13:30",0,0));

        assertEquals(null,dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater("Scotiabank Theatre Winnipeg","817 St.James Street")),"14:40",0,0));

        assertEquals(null,dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater("SilverCity St.Vital Cinemas","160-1225 St.Mary's Road, Winnipeg")),"14:00",0,0));



        //attempt to update them again
        assertEquals("Seat already claimed",dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater( "Cinema City Northgate","1399 McPhillips Street")),"13:20",0,0));

        assertEquals("Seat already claimed",dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater("Cineplex Odeon McGillivray Cinemas","2190 McGillivray Blvd")),"12:00",0,0));

        assertEquals("Seat already claimed",dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater( "Famous Players Kildonan Place Cinemas","1555 Regent Avenue West")),"13:30",0,0));

        assertEquals("Seat already claimed",dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater("Scotiabank Theatre Winnipeg","817 St.James Street")),"14:40",0,0));

        assertEquals("Seat already claimed",dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater("SilverCity St.Vital Cinemas","160-1225 St.Mary's Road, Winnipeg")),"14:00",0,0));



    }



}