package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.business.AccessTheater;

/**
 * Created by Dow on 13/02/2018.
 */
public class AccessTheaterTest extends TestCase{
    private AccessTheater accessor;
    private ArrayList list;

    @Before
    public void setUp() throws Exception {
        Main.startUp();
        accessor = new AccessTheater();
        list = new ArrayList<Theater>();
        accessor.getTheaters(list);
    }

    @Test
    public void testGetTheaters() throws Exception{
        assertNotNull(list);
    }

}