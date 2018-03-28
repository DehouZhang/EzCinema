package comp3350.ezcinema.AcceptanceTests;

import com.robotium.solo.Solo;
import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import comp3350.ezcinema.presentation.HomeActivity;

public class DiscoverTheaterTest extends ActivityInstrumentationTestCase2<HomeActivity>
{
    private Solo solo;

    public DiscoverTheaterTest() { super(HomeActivity.class); }

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

    public void testTheaterView()
    {
        solo.waitForActivity("HomeActivity");
        solo.clickOnButton("Theater");

        solo.waitForActivity("TheaterActivity");
        solo.assertCurrentActivity("Expected activity: TheaterActivity", "TheaterActivity");

        solo.clickInList(1);
        solo.waitForActivity("TheaterSelectMovieActivity");
        solo.assertCurrentActivity("Expected activity: TheaterSelectMovieActivity", "TheaterSelectMovieActivity");

        assertTrue(solo.searchText("Cinema City Northgate"));
        assertTrue(solo.searchText("1399 McPhillips Street"));

        solo.goBack();

        solo.waitForActivity("TheaterActivity");
        solo.clickInList(3);
        solo.waitForActivity("TheaterSelectMovieActivity");
        solo.assertCurrentActivity("Expected activity: TheaterSelectMovieActivity", "TheaterSelectMovieActivity");

        assertTrue(solo.searchText("Famous Players Kildonan Place Cinemas"));
        assertTrue(solo.searchText("1555 Regent Avenue West"));
    }

}
