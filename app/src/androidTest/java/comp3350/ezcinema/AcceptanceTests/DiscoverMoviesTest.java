package comp3350.ezcinema.AcceptanceTests;

import com.robotium.solo.Solo;
import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import comp3350.ezcinema.presentation.HomeActivity;

public class DiscoverMoviesTest extends ActivityInstrumentationTestCase2<HomeActivity>
{
    private Solo solo;

    public DiscoverMoviesTest() { super(HomeActivity.class); }

    public void setUp() throws Exception
    {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
        super.tearDown();
    }


    public void testUsingMoviesPage()
    {
        solo.waitForActivity("HomeActivity");

        solo.clickOnButton("Movie");
        solo.assertCurrentActivity("Expected activity: MovieActivity", "MovieActivity");

        solo.clickInList(1);
        solo.assertCurrentActivity("Expected activity: MovieSelectTheaterActivity", "MovieSelectTheaterActivity");

        solo.waitForActivity("MovieSelectTheaterActivity");

        assertTrue(solo.searchText("Ferdinand"));
        assertTrue(solo.searchText("Description: After Ferdinand"));
        assertTrue(solo.searchText("Genre: Family"));
        assertTrue(solo.searchText("Rating: 6.7"));

        solo.goBack();

        solo.waitForActivity("MovieActivity");
        solo.assertCurrentActivity("Expected activity: MovieActivity", "MovieActivity");

        solo.clickInList(3);
        solo.assertCurrentActivity("Expected activity: MovieSelectTheaterActivity", "MovieSelectTheaterActivity");
        solo.waitForActivity("MovieSelectTheaterActivity");

        assertTrue(solo.searchText("Jumangi: Welcome to the Jungle"));
        assertTrue(solo.searchText("Description: Four teenagers"));
        assertTrue(solo.searchText("Genre: Thriller"));
        assertTrue(solo.searchText("Rating: 5.8"));

        solo.goBack();
        solo.goBack();
    }

    public void testUsingTheaterPage()
    {
        solo.waitForActivity("HomeActivity");

        solo.clickOnButton("Theater");
        solo.waitForActivity("TheaterActivity");

        solo.clickOnText("Cinema City Northgate");
        solo.waitForActivity("TheaterSelectMovieActivity");

        solo.clickOnText("Ferdinand");
        solo.waitForActivity("ConfirmationActivity");

        assertTrue(solo.searchText("Ferdinand"));

        solo.goBack();
        solo.waitForActivity("TheaterSelectMovieActivity");

        solo.clickOnText("Fifty Shades Freed");
        solo.waitForActivity("ConfirmationActivity");

        assertTrue(solo.searchText("Fifty Shades Freed"));
    }
}
