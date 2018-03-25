package comp3350.ezcinema.objects;

import comp3350.ezcinema.objects.*;

public class Ticket
{
    private String movieName;
    private String theaterName;
    private String showTime;
    private int seatRow;
    private int seatCol;

    public Ticket(String movieName, String theaterName, String showTime, int row, int col)
    {
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.showTime = showTime;
        this.seatRow = row;
        this.seatCol = col;
    }

    public String getMovieName()
    {
        return movieName;
    }
    public String getTheaterName()
    {
        return theaterName;
    }
    public String getShowTime() { return showTime; }
    public int[] getSeatLocation()
    {
        int[] seatLocation = {seatRow, seatCol};
        return seatLocation;
    }
    public String toString()
    {
        return movieName + "\t" + showTime + "\n" + theaterName + "\nSeat:" + seatRow + ", " + seatCol;
    }
}
