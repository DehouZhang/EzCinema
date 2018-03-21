package comp3350.ezcinema.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Seat implements Serializable
{
    String movie;
    String theater;
    String showtime;
    Boolean[][] seatTable;
    int remain;


    public Seat(String movie, String theater, String showtime)
    {
        this.movie=movie;
        this.theater=theater;
        this.showtime=showtime;
        seatTable=new Boolean[5][5];
        remain=25;
    }

    public String getMovie() {
        return movie;
    }

    public String getTheater() {
        return theater;
    }

    public String getShowtime() {
        return showtime;
    }

    public void updateRemain()
    {
        remain--;
    }
}
