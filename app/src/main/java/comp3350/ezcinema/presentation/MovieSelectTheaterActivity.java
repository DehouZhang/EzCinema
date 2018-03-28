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
import comp3350.ezcinema.business.AccessMT;
import comp3350.ezcinema.business.AccessMovie;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;

public class MovieSelectTheaterActivity extends AppCompatActivity
{

    //Data
    private Movie movie;
    private ArrayList<Theater> theaterList;
    private AccessMT accessMT;
    private ArrayList<MT> MTList;
    private ArrayAdapter<MT> MTListArrayAdapter;

    //Views
    TextView textViewMovieTitle;
    TextView textViewMovieInfo;
    ListView listViewTheaterList;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_select_theater);

        initializeData();
        initializeViews();
        showMovieDesc();
        showTheaterOptions();
        clickOnTheaters();
    }

    private void initializeData()
    {
        //get passed movie and theaterList
        movie = (Movie)getIntent().getExtras().getSerializable("MoviePassed");
        theaterList = (ArrayList<Theater>)getIntent().getExtras().getSerializable("TheaterList");

        //initialize access to MT
        accessMT = new AccessMT();

        //initilize MTList
        MTList = getMTList(movie,theaterList);
    }

    private ArrayList<MT> getMTList(Movie movie, ArrayList<Theater> theaterList)
    {
        ArrayList<MT> list = new ArrayList<>();
        MT newMT;
        Theater theater;

        for (int i =0; i< theaterList.size(); i++)
        {
            theater = theaterList.get(i);
            newMT = accessMT.getMT(movie,theater);

            if(newMT != null) {
                list.add(newMT);
            }
        }
        return list;
    }

    private void initializeViews()
    {
        textViewMovieTitle = (TextView)findViewById(R.id.textViewMovieTitle);
        textViewMovieInfo = (TextView)findViewById(R.id.textViewMovieInfo);
        listViewTheaterList = (ListView)findViewById(R.id.listViewTheaterList);
    }

    private void showMovieDesc()
    {
        //setup textViews
        setTextView();
    }

    private void setTextView()
    {
        textViewMovieTitle.setText(movie.getMovieName());
        textViewMovieInfo.setText("Genre: "+movie.getGenre()+"\nDescription: "+movie.getMovieDescription()+"\nRating: "+movie.getMovieRating());
    }

    private void showTheaterOptions()
    {
        MTListArrayAdapter = new MovieSelectTheaterAdapter(this,MTList);
        listViewTheaterList.setAdapter(MTListArrayAdapter);
    }

    private void clickOnTheaters()
    {

        listViewTheaterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //pass selected MT to ConfirmationActivity
                Intent intent = new Intent(MovieSelectTheaterActivity.this, ConfirmationActivity.class);
                Bundle extras = new Bundle();

                extras.putSerializable("MTSelected",MTList.get(i));
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

}
