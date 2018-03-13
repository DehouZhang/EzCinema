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
    private Movie movieName;
    //views
    TextView textViewTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        initializeView();
    }

    private void initializeView()
    {
        //movieName = (String)getIntent().getSerializableExtra("MovieNamePassed");

        textViewTitle = (TextView)findViewById(R.id.textViewTitle);

        setTextView();

    }

    private void setTextView()
    {
        //textViewTitle.setText(movie.getMovieName());
    }

    public void buttonHomeOnClick(View v)
    {
        Intent checkoutIntent = new Intent(TicketActivity.this, HomeActivity.class);
        TicketActivity.this.startActivity(checkoutIntent);
    }

}
