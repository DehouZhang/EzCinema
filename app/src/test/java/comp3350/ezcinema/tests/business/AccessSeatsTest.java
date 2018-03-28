package comp3350.ezcinema.tests.business;


import junit.framework.TestCase;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.business.AccessMT;
import comp3350.ezcinema.business.AccessSeat;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.persistence.DataAccess;

public class AccessSeatsTest extends TestCase {
    private AccessMT accessorMT;
    private AccessSeat accessorST;
    private DataAccess dataAccess;
    private MT testMT,testMT2;
    //private ManageTickets accessorManage;

    public void setUp() throws Exception {
        Main.startUp();

        accessorMT = new AccessMT();
        accessorST = new AccessSeat();
       // accessorManage = new ManageTickets();
        dataAccess = Services.getDataAccess(Main.dbName);

        testMT = accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                ,new Theater( "Cinema City Northgate","1399 McPhillips Street"));

        testMT2 = accessorMT.getMT(new Movie("Jumangi: Welcome to the Jungle", "Four teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game.", "Thriller", 5.8)
                ,new Theater( "Cinema City Northgate","1399 McPhillips Street"));

    }

    public void testCountRemainingSeats(){


        //check with null info
        assertEquals(-1,dataAccess.countRemain(null,"13:20"));
        assertEquals(-1,dataAccess.countRemain(testMT,null));
        assertEquals(-1,dataAccess.countRemain(null,null));


        //if the  information is Wrong  (improve the error handling of he sql in the method)
        assertEquals(0,dataAccess.countRemain(testMT,"wrong"));


        //count the current seats, all empty
        assertEquals(25,dataAccess.countRemain(testMT,"13:20"));


        //update 2 seats separately and check
        dataAccess.updateStatus(testMT,"13:20",0,0);
        assertEquals(24,dataAccess.countRemain(testMT,"13:20"));

        dataAccess.updateStatus(testMT,"13:20",4,4);
        assertEquals(23,dataAccess.countRemain(testMT,"13:20"));


        //update all of them, making no seats avaliable
        for(int row=0;row<5;row++)
        {
            for(int col=0;col<5;col++)
            {
                dataAccess.updateStatus(testMT,"13:20",row,col);
            }
        }

        assertEquals(0,dataAccess.countRemain(testMT,"13:20"));


    }

    ///FIX SQL ERRORS*********************************************************************
    public void testGetSeatTable() {

        //if either of the fields is null
        assertEquals(null, accessorST.getSeatTable(null, "13:20"));
        assertEquals(null, accessorST.getSeatTable(testMT, null));

        //if the table doesn't exist, in the case of a wrong show time
        assertEquals(null, accessorST.getSeatTable(testMT2, "Wrong"));
        assertEquals(null, accessorST.getSeatTable(testMT2, "13:21"));
        assertEquals(null, accessorST.getSeatTable(testMT2, "#%@#@%"));


        //check the entries as they are, 0
        int[][] testTable = accessorST.getSeatTable(testMT2, "13:20");

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                assertEquals(0, testTable[row][col]);
            }
        }


        //update all the entries, then check again
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                dataAccess.updateStatus(testMT2, "13:20", row, col);
            }
        }
        testTable = accessorST.getSeatTable(testMT2, "13:20");

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                assertEquals(1, testTable[row][col]);
            }
        }
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
                ,new Theater( "Cinema City Northgate","1399 McPhillips Street")),"16:50",0,0));

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
                ,new Theater( "Cinema City Northgate","1399 McPhillips Street")),"16:50",0,0));

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
