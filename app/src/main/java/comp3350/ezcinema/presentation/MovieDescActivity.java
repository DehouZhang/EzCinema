package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

import java.util.ArrayList;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Movie;

public class MovieDescActivity extends AppCompatActivity {

    //Data
    private Movie movie;

    //Views
    TextView textViewTitle;
    TextView textViewContent;
    TextView textViewRating;
    TextView buttonCheckout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_desc);

        showMovieDesc();
    }

    private void showMovieDesc() {
        //initialize Data
        movie = (Movie)getIntent().getSerializableExtra("DisplayMovie");

        //initialize View
        textViewTitle = (TextView)findViewById(R.id.textViewTitle);
        textViewContent = (TextView)findViewById(R.id.textViewContent);
        textViewRating = (TextView)findViewById(R.id.textViewRating);
        buttonCheckout = (TextView)findViewById(R.id.buttonCheckout);

        //setup textViews
        setTextView();
    }

    private void setTextView()
    {
        textViewTitle.setText(movie.getMovieName()+"\n");
        textViewContent.setText("Genere: "+movie.getGenre()+"\n\n\t"+movie.getMovieDescription());
        textViewRating.setText("Rating: "+movie.getMovieRating());
        buttonCheckout.setText("Checkout");
    }

    public void buttonCheckoutOnClick(View v)
    {
        Intent checkoutIntent = new Intent(MovieDescActivity.this, CheckoutActivity.class);
        checkoutIntent.putExtra("DisplayMovie", movie);
        MovieDescActivity.this.startActivity(checkoutIntent);
    }
}
