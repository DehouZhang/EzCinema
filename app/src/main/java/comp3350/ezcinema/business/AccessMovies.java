package comp3350.ezcinema.business;

import java.util.ArrayList;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.persistence.DataAccessStub;

/**
 * Created by RandallUser on 2018-02-11.
 */

public class AccessMovies {


    private DataAccessStub dataAccess;
    private ArrayList<Movie> movies;
    private Movie movie;


    public AccessMovies()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
        movies = null;
        movie = null;
    }

    //returns the list of movies from the database
    public String getMovies(ArrayList<Movie> movies)
    {
        movies.clear();
        return dataAccess.getMoviesSequential(movies);
    }



}
