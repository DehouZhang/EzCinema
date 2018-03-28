package comp3350.ezcinema.AcceptanceTests;

import com.robotium.solo.Solo;
import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import comp3350.ezcinema.presentation.HomeActivity;



public class ViewTicketsTest extends ActivityInstrumentationTestCase2<HomeActivity> {
    private Solo solo;

    public ViewTicketsTest() {
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


}