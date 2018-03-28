package comp3350.ezcinema.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import comp3350.ezcinema.business.AccessSeat;
import comp3350.ezcinema.tests.business.AccessMTTest;
import comp3350.ezcinema.tests.business.AccessMovieTest;
import comp3350.ezcinema.tests.business.AccessSeatsTest;
import comp3350.ezcinema.tests.business.AccessTheaterTest;
import comp3350.ezcinema.tests.business.CalculateTaxTest;
import comp3350.ezcinema.tests.business.ManageTicketsTest;
import comp3350.ezcinema.tests.business.SortMovieTest;
import comp3350.ezcinema.tests.business.SortTheaterTest;
import comp3350.ezcinema.tests.integration.BusinessPersistenceSeamTest;
import comp3350.ezcinema.tests.objects.MTTest;
import comp3350.ezcinema.tests.objects.MovieTest;
import comp3350.ezcinema.tests.objects.TheaterTest;
import comp3350.ezcinema.tests.objects.MTTest;
import comp3350.ezcinema.tests.objects.TicketTest;
import comp3350.ezcinema.tests.persistence.DataAccessTest;


public class AllTests
{
    public static TestSuite suite;

    public static Test suite()
    {
        suite = new TestSuite("All tests");
        testObjects();
        testBusiness();
        testPersistence();
        testIntegration();
        return suite;
    }

    private static void testObjects()
    {
        suite.addTestSuite(MovieTest.class);
        suite.addTestSuite(MTTest.class);
        suite.addTestSuite(TheaterTest.class);
        suite.addTestSuite(TicketTest.class);


        //write seat test
    }

    private static void testBusiness()
    {
        suite.addTestSuite(AccessMovieTest.class);
        suite.addTestSuite(AccessTheaterTest.class);
        suite.addTestSuite(AccessMTTest.class);
        suite.addTestSuite(SortTheaterTest.class);
        suite.addTestSuite(SortMovieTest.class);
        suite.addTestSuite(CalculateTaxTest.class);
        suite.addTestSuite(ManageTicketsTest.class);
        suite.addTestSuite(AccessSeatsTest.class);
        //need valid input test

    }

    private static void testIntegration()
    {
        suite.addTestSuite(BusinessPersistenceSeamTest.class);
    }



    private static void testPersistence()
    {
        suite.addTestSuite(DataAccessTest.class);
    }
}
