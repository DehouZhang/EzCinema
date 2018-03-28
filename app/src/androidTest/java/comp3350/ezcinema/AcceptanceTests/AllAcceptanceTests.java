package comp3350.ezcinema.AcceptanceTests;

import junit.framework.Test;
import junit.framework.TestSuite;

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
