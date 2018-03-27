package comp3350.ezcinema.AcceptanceTests;


import com.robotium.solo.Solo;
import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import comp3350.ezcinema.presentation.HomeActivity;




public class TicketReservationTest extends ActivityInstrumentationTestCase2<HomeActivity> {
    private Solo solo;

    public TicketReservationTest() {
        super(HomeActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testMovieSelect()
    {
        solo.waitForActivity("HomeActivity");
        solo.clickOnButton("Movie");
        solo.waitForActivity("MovieActivity");

        solo.clickInList(1);
        solo.waitForActivity("MovieSelectTheaterActivity");
        solo.assertCurrentActivity("Expected activity: MovieSelectTheaterActivity", "MovieSelectTheaterActivity");

        solo.clickInList(1);
        solo.assertCurrentActivity("Expected activity: ConfirmationActivity", "ConfirmationActivity");
        solo.waitForActivity("ConfirmationActivity");

        solo.pressSpinnerItem(0,0);
        assertTrue(solo.isSpinnerTextSelected("10:40"));

        solo.enterText(0, "2");

        solo.clickOnText("Confirm");
        solo.waitForActivity("SeatSelectActivity");
        solo.assertCurrentActivity("Exepected activity: SeatSelectActivity", "SeatSelectActivity");

        solo.clickOnText("3,3");
        solo.clickOnText("3,4");
        solo.clickOnText("Confirm");

        solo.waitForActivity("CheckoutActivity");
        solo.assertCurrentActivity("Expected activity: CheckoutActivity", "CheckoutActivity");

        solo.clickOnRadioButton(0);
        solo.waitForFragmentByTag("FragmentCredit");

        assertTrue(solo.searchText("Card No"));
        assertTrue(solo.searchText("Expiry"));
        assertTrue(solo.searchText("CVV"));

        solo.enterText(2, "1582 3654 2478 6987");
        solo.enterText(1, "10/21");
        solo.enterText(0,"222");

        solo.clickOnButton("Purchase");

        solo.waitForActivity("TicketActivity");
        solo.assertCurrentActivity("Expected activity: TicketActivity", "TicketActivity");

        solo.clickOnButton("Home");


        solo.waitForActivity("HomeActivity");
        solo.assertCurrentActivity("Expected activity: HomeActivity", "HomeActivity");

        solo.clickOnButton("Movie");
        solo.waitForActivity("MovieActivity");

        solo.clickInList(3);
        solo.waitForActivity("MovieSelectTheaterActivity");
        solo.assertCurrentActivity("Expected activity: MovieSelectTheaterActivity", "MovieSelectTheaterActivity");

        solo.clickInList(2);
        solo.assertCurrentActivity("Expected activity: ConfirmationActivity", "ConfirmationActivity");
        solo.waitForActivity("ConfirmationActivity");

        solo.pressSpinnerItem(0,2);
        assertTrue(solo.isSpinnerTextSelected("20:25"));

        solo.enterText(0, "1");

        solo.clickOnText("Confirm");
        solo.waitForActivity("SeatSelectActivity");
        solo.assertCurrentActivity("Exepected activity: SeatSelectActivity", "SeatSelectActivity");

        solo.clickOnText("2,4");
        solo.clickOnText("Confirm");

        solo.waitForActivity("CheckoutActivity");
        solo.assertCurrentActivity("Expected activity: CheckoutActivity", "CheckoutActivity");

        solo.clickOnRadioButton(1);
        solo.waitForFragmentByTag("FragmentPaypal");

        assertTrue(solo.searchText("Email"));
        assertTrue(solo.searchText("Password"));

        solo.enterText(1, "name@mail.com");
        solo.enterText(0,"123456");

        solo.clickOnButton("Purchase");

        solo.waitForActivity("TicketActivity");
        solo.assertCurrentActivity("Expected activity: TicketActivity", "TicketActivity");

        solo.clickOnButton("Home");

        solo.waitForActivity("HomeActivity");
        solo.assertCurrentActivity("Expected activity: HomeActivity", "HomeActivity");

    }
}