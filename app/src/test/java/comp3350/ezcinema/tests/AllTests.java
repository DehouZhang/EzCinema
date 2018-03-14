package comp3350.ezcinema.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import comp3350.ezcinema.tests.business.AccessMTTest;
import comp3350.ezcinema.tests.business.AccessMovieTest;
import comp3350.ezcinema.tests.business.AccessTheaterTest;
import comp3350.ezcinema.tests.business.SortMovieTest;
import comp3350.ezcinema.tests.business.SortTheaterTest;
import comp3350.ezcinema.tests.objects.MovieTest;
import comp3350.ezcinema.tests.objects.TheaterTest;

/**
 * Created by Dehou on 2/13/2018.
 */

public class AllTests {
    public static TestSuite suite;

    public static Test suite()
    {
        suite = new TestSuite("All tests");
        testObjects();
        testBusiness();
        return suite;
    }

    private static void testObjects()
    {
        suite.addTestSuite(MovieTest.class);
        suite.addTestSuite(TheaterTest.class);
    }

    private static void testBusiness()
    {
        suite.addTestSuite(AccessMovieTest.class);
        suite.addTestSuite(AccessTheaterTest.class);
        suite.addTestSuite(AccessMTTest.class);
        suite.addTestSuite(SortTheaterTest.class);
        suite.addTestSuite(SortMovieTest.class);

    }
}
