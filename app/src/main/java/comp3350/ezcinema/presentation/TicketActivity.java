package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.ezcinema.R;
import comp3350.ezcinema.business.ManageTickets;
import comp3350.ezcinema.objects.Movie;

public class TicketActivity extends AppCompatActivity
{
    //Data
    private String movieName;
    private String theaterName;
    private String showTimeSelected;
    private int amount;
    private ArrayList<int[]> seatsChosen;
    //views
    TextView textViewMovieTitle;
    TextView textViewTheaterTitle;
    TextView textViewShowTime;
    TextView textViewTicketQty;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        movieName = (String)getIntent().getSerializableExtra("MovieNamePassed");
        theaterName = (String)getIntent().getSerializableExtra("TheaterNamePassed");
        amount = (int)getIntent().getSerializableExtra("AmountPassed");
        showTimeSelected = (String)getIntent().getSerializableExtra("ShowTimePassed");
        seatsChosen = (ArrayList)getIntent().getSerializableExtra("TempTablePassed");

        initializeView();

        int[] rowCol;

        ManageTickets manager = new ManageTickets();
        for(int i =0; i< amount; i++){
            rowCol = (int[])seatsChosen.get(i);
            manager.createTicket(movieName, theaterName, showTimeSelected, rowCol[0], rowCol[1]);
        }
    }

    private void initializeView()
    {

        textViewMovieTitle = (TextView)findViewById(R.id.textViewMovieTitle);
        textViewTheaterTitle = (TextView)findViewById(R.id.textViewTheaterTitle);
        textViewShowTime = (TextView)findViewById(R.id.textViewShowTime);
        textViewTicketQty = (TextView)findViewById(R.id.textViewTicketQty);

        setTextView();

    }

    private void setTextView()
    {
        textViewMovieTitle.setText(movieName);
        textViewTheaterTitle.setText(theaterName);
        textViewTicketQty.setText("Number of Tickets: "+amount);
        textViewShowTime.setText(showTimeSelected);
    }

    public void buttonHomeOnClick(View v)
    {
        Intent checkoutIntent = new Intent(TicketActivity.this, HomeActivity.class);
        TicketActivity.this.startActivity(checkoutIntent);
    }

}
