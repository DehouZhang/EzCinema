package comp3350.ezcinema.objects;

import java.io.Serializable;

public class Seat implements Serializable{
    String movieName;
    String theaterName;
    String showtime;
    int [][] table;

    public Seat (String movie, String theater, String showtime)
    {
        if(movie == null || theater == null || showtime == null)
        {
            movieName = null;
            theater = null;
            showtime = null;
            table = new int[0][0];
            //table[0][0] = -1;

        }
        else
        {
            movieName = movie;
            theaterName = theater;
            this.showtime = showtime;
            table = new int[5][5];
        }
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public String getShowtime() {
        return showtime;
    }

    public int[][] getTable() {
        return table;
    }
}
