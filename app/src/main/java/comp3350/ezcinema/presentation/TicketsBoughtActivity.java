package comp3350.ezcinema.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Ticket;
import comp3350.ezcinema.business.ManageTickets;

public class TicketsBoughtActivity extends AppCompatActivity {

    private ManageTickets ticketManager;
    ArrayList<Ticket> tickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_bought);

        ticketManager = new ManageTickets();
        initializeView();
    }

    private void initializeView()
    {
        ArrayAdapter<Ticket> ticketArrayAdapter;
        ListView ticketList = (ListView)findViewById(R.id.ticketList);
        tickets = new ArrayList<>();
        ticketManager.getTicketsSequential(tickets);
        ticketArrayAdapter = new ArrayAdapter<Ticket>(this,android.R.layout.simple_list_item_1,android.R.id.text1, tickets);
        ticketList.setAdapter(ticketArrayAdapter);

    }
}
