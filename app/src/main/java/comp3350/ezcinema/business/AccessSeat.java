package comp3350.ezcinema.business;

import java.util.List;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Seat;
import comp3350.ezcinema.persistence.DataAccess;

public class AccessSeat {

    private DataAccess dataAccess;

    public AccessSeat()
    {
        dataAccess =Services.getDataAccess(Main.dbName);
    }

    public int countRemainingSeats(Seat seat)
    {
        return dataAccess.countRemain(seat);
    }

    public int[][] getSeatTable(Seat seat)
    {
        int [][] table = new int [5][5];
        for(int row=0;row<5;row++)
        {
            for(int col=0;col<5;col++)
            {
                table[row][col]=dataAccess.checkStatus(seat,row,col);
            }
        }
        return table;
    }

    public String updateSeatStatus(Seat seat, int row, int col)
    {
        return dataAccess.updateStatus(seat,row,col);
    }
}
