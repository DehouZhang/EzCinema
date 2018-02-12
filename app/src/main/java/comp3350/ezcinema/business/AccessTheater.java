package comp3350.ezcinema.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.persistence.DataAccessStub;

/**
 * Created by RandallUser on 2018-02-11.
 */

public class AccessTheater {


        private DataAccessStub dataAccess;
        private ArrayList<Theater> theaters;
        private Theater theater;


        public AccessTheater()
        {
            dataAccess = Services.getDataAccess(Main.dbName);
            theaters = null;
            theater = null;
        }

        //returns the list of movies from the database
        public String getTheaters(List<Theater> theaters)
        {
            theaters.clear();
            return dataAccess.getTheatersSequential(theaters);
        }

}
