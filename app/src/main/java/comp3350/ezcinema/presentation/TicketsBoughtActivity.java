package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    ListView ticketList;
    TextView noTickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_bought);

        ticketManager = new ManageTickets();
        ticketList = (ListView)findViewById(R.id.ticketList);
        noTickets = (TextView)findViewById(R.id.noTicketsTag);
        tickets = new ArrayList<>();

        initializeView();
        ticketListClicked();
    }

    private void initializeView()
    {
        ArrayAdapter<Ticket> ticketArrayAdapter;



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

    private void ticketListClicked()
    {
        ticketList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int amountOfTickets = 1;
                Ticket clickedTicket = tickets.get(i);
                ArrayList<int[]> seatLocn = new ArrayList<int[]>();
                seatLocn.add(clickedTicket.getSeatLocation());

                Intent intent = new Intent(TicketsBoughtActivity.this, TicketActivity.class);
                Bundle extras = new Bundle();


                extras.putSerializable("MovieNamePassed",clickedTicket.getMovieName());
                extras.putSerializable("TheaterNamePassed", clickedTicket.getTheaterName());
                extras.putSerializable("ShowTimePassed", clickedTicket.getShowTime());
                extras.putSerializable("AmountPassed", amountOfTickets);
                extras.putSerializable("TempTablePassed", seatLocn);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
