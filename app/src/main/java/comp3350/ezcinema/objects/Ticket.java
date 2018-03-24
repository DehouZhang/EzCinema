package comp3350.ezcinema.objects;

import comp3350.ezcinema.objects.*;

public class Ticket
{
    private String movieName;
    private String theaterName;
    private String showTime;
    private String ticketPrice;

    public Ticket(String movieName, String theaterName, String showTime, String price)
    {
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.showTime = showTime;
        this.ticketPrice = price;
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
    public String getTicketPrice() { return ticketPrice; }
}
