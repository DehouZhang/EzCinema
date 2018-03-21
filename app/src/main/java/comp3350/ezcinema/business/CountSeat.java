package comp3350.ezcinema.business;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.persistence.DataAccess;



public class CountSeat
{
    private DataAccess dataAccess;

    public CountSeat()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public int countRemainingSeats(MT seat,String time)
    {
        return dataAccess.countRemain(seat,time);
    }

}
