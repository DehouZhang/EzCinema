package comp3350.ezcinema.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Seat implements Serializable
{
    String movie;
    String theater;
    String showtime;
    Boolean[][] seatTable;


    public Seat(String movie, String theater, String showtime)
    {
        this.movie=movie;
        this.theater=theater;
        this.showtime=showtime;
        seatTable=new Boolean[5][5];
    }


}
