package comp3350.ezcinema.business;

import java.util.ArrayList;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.Ticket;
import comp3350.ezcinema.persistence.*;

public class ManageTickets
{
    private DataAccess dataAccess;

    public ManageTickets()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public int createTicket(String movieName, String theaterName, String showTime, int row, int col)
    {
        return dataAccess.insertTicket(movieName, theaterName, showTime, row, col);
    }
    public void getTicketsSequential(ArrayList<Ticket> tickets)
    {
        dataAccess.getTicketsSequential(tickets);
    }
}
