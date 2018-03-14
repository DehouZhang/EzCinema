package comp3350.ezcinema.business;

import java.util.ArrayList;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.persistence.DataAccess;

public class AccessMT
{
    private DataAccess dataAccess;

    public AccessMT()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    //returns the list of movies from the database
    public MT getMT(Movie movie, Theater theater)
    {
        MT newMT = null;

        if(movie != null && theater != null)
        {
            ArrayList<String> showtimes;
            showtimes = dataAccess.getShowtimeList(movie, theater);
            if (showtimes.size() > 0)
            {
                newMT = new MT(movie.getMovieName(), theater.getTheaterName(), showtimes);
            }
        }
        return newMT;
    }
}
