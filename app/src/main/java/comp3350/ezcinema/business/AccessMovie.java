package comp3350.ezcinema.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.persistence.DataAccessStub;

/**
 * Created by RandallUser on 2018-02-11.
 */

public class AccessMovie {


    private DataAccessStub dataAccess;
    private List<Movie> movies;
    private Movie movie;


    public AccessMovie()
    {
        dataAccess =(DataAccessStub) Services.getDataAccess(Main.dbName);
        movies = null;
        movie = null;
    }

    //returns the list of movies from the database
    public String getMovies(List<Movie> movies)
    {
        movies.clear();
       return dataAccess.getMoviesSequential(movies);
    }




}
