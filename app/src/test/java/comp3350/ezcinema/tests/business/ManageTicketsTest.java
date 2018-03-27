package comp3350.ezcinema.tests.business;


import junit.framework.TestCase;
import java.util.ArrayList;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.business.ManageTickets;
import comp3350.ezcinema.objects.Ticket;

public class ManageTicketsTest extends TestCase {

    private ManageTickets accessorMT;

    private Ticket ticket,testTicket;
    private ArrayList tickets,listoftickets;


    public void setUp() throws Exception {
        Main.startUp();

        accessorMT = new ManageTickets();
        tickets = new ArrayList<Ticket>();
        listoftickets = new ArrayList<Ticket>();

        listoftickets.add(new Ticket("Fifty Shades Freed","Cinema City Northgate","13:20",0,0));
        listoftickets.add(new Ticket("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","12:00",0,0));
        listoftickets.add(new Ticket("Fifty Shades Freed","Famous Players Kildonan Place Cinemas","13:30",0,0));
        listoftickets.add(new Ticket("Fifty Shades Freed","Scotiabank Theatre Winnipeg","14:40",0,0));
        listoftickets.add(new Ticket("Fifty Shades Freed","SilverCity St.Vital Cinemas","14:00",0,0));



    }


    //test passing the database good and bad ticket creation info
    public void testcreateTicket() throws Exception
    {

        //test empty ticket
        assertEquals(0,accessorMT.createTicket(null, null, null, 0, 0));

        //test tickets missing info
        assertEquals(0,accessorMT.createTicket(null,"Cinema City Northgate","10:40",0,0));
        assertEquals(0,accessorMT.createTicket("Ferdinand",null,"10:40",0,0));
        assertEquals(0,accessorMT.createTicket("Ferdinand","Cinema City Northgate",null,0,0));
        assertEquals(0,accessorMT.createTicket(null,null,"10:40",0,0));
        assertEquals(0,accessorMT.createTicket("Ferdinand",null,null,0,0));
        assertEquals(0,accessorMT.createTicket(null,"Cinema City Northgate",null,0,0));



        //test incorrect info
            //movie name
            assertEquals(0,accessorMT.createTicket("Fifty Shades Freed","Cinema City Northgate","10:40",0,0));
            assertEquals(0,accessorMT.createTicket("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","11:25",0,0));
            assertEquals(0,accessorMT.createTicket("Fifty Shades Freed","Famous Players Kildonan Place Cinemas","15:30",0,0));
            assertEquals(0,accessorMT.createTicket("Fifty Shades Freed","Scotiabank Theatre Winnipeg","13:30",0,0));
            assertEquals(0,accessorMT.createTicket("Fifty Shades Freed","SilverCity St.Vital Cinemas","14:50",0,0));


            //Theater name
            assertEquals(0,accessorMT.createTicket("Ferdinand","Cineplex Odeon McGillivray Cinemas","10:40",0,0));
            assertEquals(0,accessorMT.createTicket("Ferdinand","Famous Players Kildonan Place Cinemas","11:25",0,0));
            assertEquals(0,accessorMT.createTicket("Ferdinand","Scotiabank Theatre Winnipeg","15:30",0,0));
            assertEquals(0,accessorMT.createTicket("Ferdinand","SilverCity St.Vital Cinemas","13:30",0,0));
            assertEquals(0,accessorMT.createTicket("Ferdinand","Cinema City Northgate","14:50",0,0));

            //showtime
            assertEquals(0,accessorMT.createTicket("Ferdinand","Cinema City Northgate","11:40",0,0));
            assertEquals(0,accessorMT.createTicket("Ferdinand","Cineplex Odeon McGillivray Cinemas","12:25",0,0));
            assertEquals(0,accessorMT.createTicket("Ferdinand","Famous Players Kildonan Place Cinemas","17:30",0,0));
            assertEquals(0,accessorMT.createTicket("Ferdinand","Scotiabank Theatre Winnipeg","14:30",0,0));
            assertEquals(0,accessorMT.createTicket("Ferdinand","SilverCity St.Vital Cinemas","12:50",0,0));

            //row & col
            assertEquals(0,accessorMT.createTicket("Ferdinand","Cinema City Northgate","10:40",5,5));
            assertEquals(0,accessorMT.createTicket("Ferdinand","Cineplex Odeon McGillivray Cinemas","11:25",6,6));
            assertEquals(0,accessorMT.createTicket("Ferdinand","Famous Players Kildonan Place Cinemas","15:30",4,7));
            assertEquals(0,accessorMT.createTicket("Ferdinand","Scotiabank Theatre Winnipeg","13:30",7,4));
            assertEquals(0,accessorMT.createTicket("Ferdinand","SilverCity St.Vital Cinemas","14:50",-1,-1));


        //test normal tickets, create 5 then grab them
        assertEquals(1,accessorMT.createTicket("Ferdinand","Cinema City Northgate","10:40",0,0));
        assertEquals(1,accessorMT.createTicket("Ferdinand","Cineplex Odeon McGillivray Cinemas","11:25",0,0));
        assertEquals(1,accessorMT.createTicket("Ferdinand","Famous Players Kildonan Place Cinemas","15:30",0,0));
        assertEquals(1,accessorMT.createTicket("Ferdinand","Scotiabank Theatre Winnipeg","13:30",0,0));
        assertEquals(1,accessorMT.createTicket("Ferdinand","SilverCity St.Vital Cinemas","14:50",0,0));




        //creating a ticket that's already there
        assertEquals(0,accessorMT.createTicket("Ferdinand","Cinema City Northgate","10:40",0,0));

    }



    public void testGetTicketsSequential()
    {
        assertEquals(1,accessorMT.createTicket("Fifty Shades Freed","Cinema City Northgate","13:20",0,0));
        assertEquals(1,accessorMT.createTicket("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","12:00",0,0));
        assertEquals(1,accessorMT.createTicket("Fifty Shades Freed","Famous Players Kildonan Place Cinemas","13:30",0,0));
        assertEquals(1,accessorMT.createTicket("Fifty Shades Freed","Scotiabank Theatre Winnipeg","14:40",0,0));
        assertEquals(1,accessorMT.createTicket("Fifty Shades Freed","SilverCity St.Vital Cinemas","14:00",0,0));


        accessorMT.getTicketsSequential(tickets);

        int [] testTicketLocation ;
        int [] ticketLocation;
        for (int i = 0; i < listoftickets.size(); i++)
        {
                ticket = (Ticket)tickets.get(i);
                testTicket = (Ticket)listoftickets.get(i);

                assertEquals(testTicket.getMovieName(), ticket.getMovieName());
                assertEquals(testTicket.getTheaterName(), ticket.getTheaterName());
                assertEquals(testTicket.getShowTime(), ticket.getShowTime());

                testTicketLocation = testTicket.getSeatLocation();
                ticketLocation = ticket.getSeatLocation();

                assertEquals(testTicketLocation[0], ticketLocation[0]);
                assertEquals(testTicketLocation[1], ticketLocation[1]);
        }
    }








}