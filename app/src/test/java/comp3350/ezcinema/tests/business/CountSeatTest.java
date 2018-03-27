package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.business.AccessMT;
import comp3350.ezcinema.business.getSeatsTable;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.persistence.DataAccess;


public class CountSeatTest extends TestCase {


    private AccessMT accessorMT;
    private getSeatsTable accessorST;
    private DataAccess dataAccess;
    private MT testMT;

    public void setUp() throws Exception {
        Main.startUp();

        accessorMT = new AccessMT();
        accessorST = new getSeatsTable();
        dataAccess = Services.getDataAccess(Main.dbName);


        testMT = accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
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

}