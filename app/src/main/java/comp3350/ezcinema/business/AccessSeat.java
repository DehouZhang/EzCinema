package comp3350.ezcinema.business;

import java.util.List;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Seat;
import comp3350.ezcinema.persistence.DataAccess;

public class AccessSeat
{
    private DataAccess dataAccess;

    public AccessSeat()
    {
        dataAccess =Services.getDataAccess(Main.dbName);
    }

    public String updateSeat(Seat seat, int row, int col)
    {
        seat.updateRemain();
        return dataAccess.updateSeat(seat,row,col);
    }
}
