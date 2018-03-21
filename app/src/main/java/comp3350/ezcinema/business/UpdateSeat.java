package comp3350.ezcinema.business;


import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.persistence.DataAccess;

public class UpdateSeat
{
    private DataAccess dataAccess;

    public UpdateSeat()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String updateSeatStatus(MT seat, String time, int row, int col)
    {
        return dataAccess.updateStatus(seat,time,row,col);
    }
}
