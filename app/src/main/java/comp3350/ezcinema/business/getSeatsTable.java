package comp3350.ezcinema.business;


import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.persistence.DataAccess;

public class getSeatsTable
{
    private DataAccess dataAccess;

    public getSeatsTable()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public int[][] getSeatTable(MT seat, String showtime)
    {

        if(seat != null && showtime != null) {

            int[][] table = new int[5][5];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {

                    if(dataAccess.checkStatus(seat, showtime, row, col) != -1) {
                        table[row][col] = dataAccess.checkStatus(seat, showtime, row, col);
                    }
                    else
                        return null;

                }
            }
            return table;

        }
        else
            return null;

        }
}
