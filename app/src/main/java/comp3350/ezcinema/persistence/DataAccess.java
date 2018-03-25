package comp3350.ezcinema.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.objects.Ticket;

public interface DataAccess
{
    void open(String string);

    void close();

    String getMovieSequential(List<Movie> movieResult);

    String getTheaterSequential(List<Theater> theaterResult);

    ArrayList<String>getShowtimeList(Movie movie, Theater theater);

    String getTheaterAddress(String theaterName);

    String updateStatus(MT seat,String time, int row, int col);

    int countRemain(MT seat,String time);

    int checkStatus(MT seat,String time,int row,int col);

    void insertTicket(String movieName, String theaterName, String showTime, int row, int col);

    void getTicketsSequential(ArrayList<Ticket> tickets);

    void deleteTicket(String movieName, String theaterName, String showTime);
}
