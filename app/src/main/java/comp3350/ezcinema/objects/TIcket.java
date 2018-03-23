package comp3350.ezcinema.objects;

import comp3350.ezcinema.objects.*;

public class Ticket
{
    private String movieName;
    private String theaterName;
    private String showTime;
    public Ticket(MT movie)
    {
        this.movieName = movie.getMovieName();
        this.theaterName = movie.getTheaterName();
        this.showTime = movie.showtimeToString();
    }
}
