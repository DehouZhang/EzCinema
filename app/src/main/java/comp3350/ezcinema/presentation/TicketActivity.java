package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Movie;

public class TicketActivity extends AppCompatActivity {
    //Data
    private String movieName;
    private String theaterName;
    private int amount;
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

        initializeView();
    }

    private void initializeView()
    {
        movieName = (String)getIntent().getSerializableExtra("MovieNamePassed");
        theaterName = (String)getIntent().getSerializableExtra("TheaterNamePassed");
        amount = (int)getIntent().getSerializableExtra("AmountPassed");

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
    }

    public void buttonHomeOnClick(View v)
    {
        Intent checkoutIntent = new Intent(TicketActivity.this, HomeActivity.class);
        TicketActivity.this.startActivity(checkoutIntent);
    }

}
