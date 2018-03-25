package comp3350.ezcinema.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
        TextView noTickets = (TextView)findViewById(R.id.noTicketsTag);
        tickets = new ArrayList<>();

        ticketManager.getTicketsSequential(tickets);

        if(!tickets.isEmpty())
        {
            noTickets.setVisibility(View.INVISIBLE);
            ticketList.setVisibility(View.VISIBLE);
            ticketArrayAdapter = new ArrayAdapter<Ticket>(this, android.R.layout.simple_list_item_1, android.R.id.text1, tickets);
            ticketList.setAdapter(ticketArrayAdapter);
        }
        else
        {
            ticketList.setVisibility(View.INVISIBLE);
            noTickets.setVisibility(View.VISIBLE);
        }
    }
}
