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

public class TheaterSelectMovieActivity extends AppCompatActivity {

    //data
    private Theater theater;
    private ArrayList<Movie> movieList;
    private ArrayAdapter<Movie> movieListAdapter;

    //view
    TextView textViewTheaterInfo;
    ListView listViewMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater_select_movie);

        initializeData();
        initializeView();
        listItemClick();
    }

    private void initializeData() {
        //initialize Data
        theater = (Theater) getIntent().getExtras().getSerializable("TheaterPassed");
        //todo change after implement DB
        movieList = (ArrayList<Movie>)getIntent().getExtras().getSerializable("MovieList");
        //todo---------------
    }

    private void initializeView() {
        textViewTheaterInfo = (TextView)findViewById(R.id.textViewTheaterInfo);
        listViewMovieList = (ListView)findViewById(R.id.listViewMovieList);

        setText();
        setListView();
    }

    private void setText() {
        textViewTheaterInfo.setText(theater.getTheaterName()+"\n"+theater.getTheaterAddress());
    }

    private void setListView() {
        movieListAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, movieList);
        listViewMovieList.setAdapter(movieListAdapter);
    }

    private void listItemClick() {
        listViewMovieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //todo will be changed for this whole method, should pass a movie-theater realtion object to another activity
                Intent intent = new Intent(TheaterSelectMovieActivity.this, ConfirmationActivity.class);
                Bundle extras = new Bundle();

                extras.putSerializable("MoviePassed",movieList.get(i));
                extras.putSerializable("TheaterSelected",theater);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
