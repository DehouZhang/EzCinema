package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;

public class MovieSelectTheaterActivity extends AppCompatActivity {

    //Data
    private Movie movie;
    private ArrayList<Theater> theaterList;
    private ArrayAdapter<Theater> TheaterArrayAdapter;

    //Views
    TextView textViewMovieInfo;
    ListView listViewTheaterList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_select_theater);

        initilizeData();
        initializeViews();
        showMovieDesc();
        showTheaterOptions();
        clickOnTheaters();
    }

    private void initilizeData() {
        //initialize Data
        movie = (Movie)getIntent().getExtras().getSerializable("DisplayMovie");
        //todo change after implement DB
        theaterList = (ArrayList<Theater>)getIntent().getExtras().getSerializable("TheaterList");
        //todo---------------
    }

    private void initializeViews() {
        textViewMovieInfo = (TextView)findViewById(R.id.textViewMovieInfo);
        listViewTheaterList = (ListView)findViewById(R.id.listViewTheaterList);
    }

    private void showMovieDesc() {
        //setup textViews
        setTextView();
    }

    private void setTextView()
    {
        textViewMovieInfo.setText(movie.getMovieName()+ "\nGenere: "+movie.getGenre()+"\nDescription:  "+movie.getMovieDescription()+"\nRating: "+movie.getMovieRating());
    }

    private void showTheaterOptions() {
        TheaterArrayAdapter = new ArrayAdapter<Theater>(this,android.R.layout.simple_list_item_1,android.R.id.text1, theaterList);
        listViewTheaterList.setAdapter(TheaterArrayAdapter);
    }

    private void clickOnTheaters() {
        listViewTheaterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //todo will be changed for this whole method, should pass a movie-theater realtion object to another activity
                Intent intent = new Intent(MovieSelectTheaterActivity.this, ConfirmationActivity.class);
                Bundle extras = new Bundle();

                extras.putSerializable("MoviePassed",movie);
                extras.putSerializable("TheaterSelected",theaterList.get(i));
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

}
