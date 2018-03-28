package comp3350.ezcinema.AcceptanceTests;

import junit.framework.Test;
import junit.framework.TestSuite;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.persistence.DataAccess;

public class AllAcceptanceTests
{
    private static TestSuite suite;

    public static Test suite()
    {
        suite = new TestSuite("Acceptance tests");
        suite.addTestSuite(DiscoverMoviesTest.class);
        suite.addTestSuite(DiscoverTheaterTest.class);
        suite.addTestSuite(TicketReservationTest.class);
        suite.addTestSuite(SavedTicketsTest.class);
        return suite;
    }
}
