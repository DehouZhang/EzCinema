package comp3350.ezcinema.business;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.application.Services;
import comp3350.ezcinema.objects.Ticket;
import comp3350.ezcinema.persistence.DataAccess;

public class ManageTickets
{
    private DataAccess dataAccess;

    public ManageTickets()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public void createTicket(String movieName, String theaterName, String showTime)
    {
        Ticket newTicket = new Ticket(movieName, theaterName, showTime);

    }

}
