package comp3350.ezcinema.objects;

import java.io.Serializable;

public class Seat implements Serializable{
    String movieName;
    String theaterName;
    String showtime;
    int [][] table;

    public Seat (String movie, String theater, String showtime)
    {
        movieName=movie;
        theaterName=theater;
        this.showtime=showtime;
        table=new int[5][5];
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

}
