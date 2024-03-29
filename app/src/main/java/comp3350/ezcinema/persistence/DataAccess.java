package comp3350.ezcinema.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.objects.MT;

public interface DataAccess
{
    void open(String string);

    void close();

    String getMovieSequential(List<Movie> movieResult);

    String getTheaterSequential(List<Theater> theaterResult);

    ArrayList<String>getShowtimeList(Movie movie, Theater theater);

    String getTheaterAddress(String theaterName);
}
