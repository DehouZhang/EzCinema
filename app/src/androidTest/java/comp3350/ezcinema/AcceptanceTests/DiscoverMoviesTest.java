package comp3350.ezcinema.AcceptanceTests;

import com.robotium.solo.Solo;
import junit.framework.Assert;

import comp3350.ezcinema.presentation.HomeActivity;
import comp3350.ezcinema.presentation.MovieActivity;

import android.test.ActivityInstrumentationTestCase2;


public class DiscoverMoviesTest extends ActivityInstrumentationTestCase2<HomeActivity>
{
    private Solo solo;

    public DiscoverMoviesTest() { super(HomeActivity.class); }

    public void setUp() throws Exception
    {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
    }

    public void testSelectMovies
    {
        solo.waitForActivity("HomeActivity");
        solo.clickOnButton("Movie");
        solo.assertCurrentActivity("Expected activity: MovieActivity", "MovieActivity");

        solo.clickInList(2);
        solo.waitForActivity("MovieActivity");
        solo.assertCurrentActivity("Expected activity: MovieSelectTheaterActivity", "MovieSelectTheaterActivity");
        solo.
    }
}
