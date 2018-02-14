package comp3350.ezcinema.business;

import java.util.List;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.persistence.DataAccessStub;


public class AccessMovie {

    private DataAccessStub dataAccess;

    public AccessMovie()
    {
        dataAccess =(DataAccessStub) Services.getDataAccess(Main.dbName);
    }

    //returns the list of movies from the database
    public String getMovies(List<Movie> movies)
    {
        movies.clear();
       return dataAccess.getMoviesSequential(movies);
    }




}
