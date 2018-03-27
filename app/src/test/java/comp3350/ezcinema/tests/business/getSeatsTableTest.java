package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.business.AccessMT;
import comp3350.ezcinema.business.ManageTickets;
import comp3350.ezcinema.business.UpdateSeat;
import comp3350.ezcinema.business.getSeatsTable;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.persistence.DataAccess;

public class getSeatsTableTest extends TestCase {


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


    public void testGetSeatTable(){


        //if either of the fields is null
        assertEquals(null, accessorST.getSeatTable(null,"13:20" ));
        assertEquals(null, accessorST.getSeatTable(testMT,null ));

        //if the table doesn't exist, in the case of a wrong show time
        assertEquals(null, accessorST.getSeatTable(testMT,"Wrong" ));
        assertEquals(null, accessorST.getSeatTable(testMT,"13:21" ));
        assertEquals(null, accessorST.getSeatTable(testMT,"#%@#@%" ));



        //check the entries as they are, 0
        int [][] testTable = accessorST.getSeatTable(testMT,"13:20" );

        for(int row=0;row<5;row++)
        {
            for(int col=0;col<5;col++)
            {
                assertEquals(0,testTable[row][col]);
            }
        }


        //update all the entries, then check again
        for(int row=0;row<5;row++)
        {
            for(int col=0;col<5;col++)
            {
                dataAccess.updateStatus(testMT,"13:20",row,col);
            }
        }
        testTable = accessorST.getSeatTable(testMT,"13:20" );

        for(int row=0;row<5;row++)
        {
            for(int col=0;col<5;col++)
            {
                assertEquals(1,testTable[row][col]);
            }
        }
    }
















}