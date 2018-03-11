package comp3350.ezcinema.business;

import java.util.List;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.persistence.DataAccess;


public class AccessTheater {

        private DataAccess dataAccess;

        public AccessTheater()
        {
            dataAccess = Services.getDataAccess(Main.dbName);
        }

        //returns the list of movies from the database
        public String getTheaters(List<Theater> theaters)
        {
            theaters.clear();
            return dataAccess.getTheaterSequential(theaters);
        }

}
