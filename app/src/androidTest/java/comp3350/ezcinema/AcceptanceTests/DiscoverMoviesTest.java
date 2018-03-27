package comp3350.ezcinema.AcceptanceTests;

import com.robotium.solo.Solo;
import junit.framework.Assert;

import comp3350.ezcinema.presentation.HomeActivity;
import comp3350.ezcinema.presentation.MovieActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;


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
        TextView onScreenText;
        String testString;

        solo.waitForActivity("HomeActivity");
        solo.clickOnButton("Movie");
        solo.assertCurrentActivity("Expected activity: MovieActivity", "MovieActivity");

        solo.clickOnText("Jumanji");
        solo.assertCurrentActivity("Expected activity: MovieSelectTheaterActivity", "MovieSelectTheaterActivity");

        assertTrue(solo.searchText("Jumanji"));
        assertTrue(solo.searchText("Description: Four teenagers"));
        assertTrue(solo.searchText("Genre: Thriller"));
        assertTrue(solo.searchText("Rating: 5.8"));

        solo.goBack();

        solo.waitForActivity("MovieActivity");
        solo.assertCurrentActivity("Expected activity: MovieActivity", "MovieActivity");

        solo.clickOnText("Ferdinand");
        solo.assertCurrentActivity("Expected activity: MovieSelectTheaterActivity", "MovieSelectTheaterActivity");

        assertTrue(solo.searchText("Ferdinand"));
        assertTrue(solo.searchText("Description: After Ferdinand"));
        assertTrue(solo.searchText("Genre: Family"));
        assertTrue(solo.searchText("Rating: 6.7"));

        solo.goBack();
        solo.goBack();
        solo.waitForActivity("HomeActivity");

        solo.clickOnButton("Theaters");
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
