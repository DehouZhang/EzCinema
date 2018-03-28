package comp3350.ezcinema.AcceptanceTests;


import com.robotium.solo.Solo;
import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import comp3350.ezcinema.presentation.HomeActivity;

public class SavedTicketsTest extends ActivityInstrumentationTestCase2<HomeActivity>
{

    private Solo solo;

    public SavedTicketsTest() { super(HomeActivity.class); }


    public void setUp() throws Exception
    {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        //buys tickets
        solo.waitForActivity("HomeActivity");
        solo.clickOnButton("Movie");
        solo.waitForActivity("MovieActivity");
        solo.clickOnText("Winchester");
        solo.waitForActivity("MovieSelectTheaterActivity");
        solo.clickOnText("SilverCity");
        solo.enterText(0, "2");
        solo.clickOnText("Confirm");
        solo.waitForActivity("SeatSelectActivity");
        solo.clickOnText("3,3");
        solo.clickOnText("3,4");
        solo.clickOnText("Confirm");
        solo.waitForActivity("CheckoutActivity");
        solo.clickOnRadioButton(0);
        solo.waitForFragmentByTag("FragmentCredit");
        solo.enterText(2, "1582 3654 2478 6987");
        solo.enterText(1, "10/21");
        solo.enterText(0,"222");
        solo.clickOnButton("Purchase");
        solo.waitForActivity("TicketActivity");
        solo.clickOnButton("Home");

        solo.waitForActivity("HomeActivity");
        solo.clickOnButton("Movie");
        solo.waitForActivity("MovieActivity");
        solo.clickOnText("Red Sparrow");
        solo.waitForActivity("MovieSelectTheaterActivity");
        solo.clickOnText("Kildonan Place");
        solo.enterText(0, "2");
        solo.clickOnText("Confirm");
        solo.waitForActivity("SeatSelectActivity");
        solo.clickOnText("3,3");
        solo.clickOnText("3,4");
        solo.clickOnText("Confirm");
        solo.waitForActivity("CheckoutActivity");
        solo.clickOnRadioButton(0);
        solo.waitForFragmentByTag("FragmentCredit");
        solo.enterText(2, "1582 3654 2478 6987");
        solo.enterText(1, "10/21");
        solo.enterText(0,"222");
        solo.clickOnButton("Purchase");
        solo.waitForActivity("TicketActivity");
        solo.clickOnButton("Home");
        solo.waitForActivity("HomeActivity");
    }

    @Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
        super.tearDown();
    }


    public void testSeeTickets()
    {
        solo.waitForActivity("HomeActivity");
        solo.clickOnButton(2);

        solo.waitForActivity("TicketsBoughtActivity");
        solo.assertCurrentActivity("Expected activity: TicketsBoughtActivity", "TicketsBoughtActivity");

        solo.clickInList(3);
        solo.assertCurrentActivity("Expected activity: TicketActivity", "TicketActivity");

        solo.goBack();

        solo.clickInList(1);
        solo.assertCurrentActivity("Expected activity: TicketActivity", "TicketActivity");
    }
}
