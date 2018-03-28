package comp3350.ezcinema.objects;

public class Ticket
{
    private String movieName;
    private String theaterName;
    private String showTime;
    private int seatRow;
    private int seatCol;

    public Ticket(String movieName, String theaterName, String showTime, int row, int col)
    {


        if (movieName.equals("") || theaterName.equals("") || showTime.equals("") || row <0 || row >4 || col <0 || col >4) {

            this.movieName = null;
            this.theaterName = null;
            this.showTime = null;
            this.seatRow = -1;
            this.seatCol = -1;
        }
        else
        {
            this.movieName = movieName;
            this.theaterName = theaterName;
            this.showTime = showTime;
            this.seatRow = row;
            this.seatCol = col;
        }
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
    public String toString() {
        if (movieName == null || theaterName == null || showTime == null || seatRow == -1 || seatCol == -1) {
            return null;
        }
        else
        {
            return movieName + "\t" + showTime + "\n" + theaterName + "\nSeat:" + (seatRow + 1) + ", " + (seatCol + 1);
        }
    }
}

