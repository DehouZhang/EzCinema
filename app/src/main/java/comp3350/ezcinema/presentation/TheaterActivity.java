package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import comp3350.ezcinema.R;
import comp3350.ezcinema.business.AccessMovie;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.business.AccessTheater;
import comp3350.ezcinema.business.SortTheater;
import java.util.ArrayList;

public class TheaterActivity extends AppCompatActivity
{
    //Data
    private ArrayList<Theater> theaterList;
    private ArrayList<Theater> sortedList;


    private ArrayList<Movie> movieList;
    private AccessMovie accessMovie;

    private AccessTheater accessTheater;
    private ArrayAdapter<Theater> TheaterArrayAdapter;

    //views
    private ListView listView;
    private Button sortNameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);

        initializeView();
        updateList();
        listItemClicked();
    }

    private void initializeView()
    {
        //initialize data
        theaterList = new ArrayList<Theater>();
        accessTheater = new AccessTheater();
        accessTheater.getTheaters(theaterList);      //transfer items in the db into theaterList


        movieList = new ArrayList<Movie>();
        accessMovie = new AccessMovie();
        accessMovie.getMovies(movieList);
        sortedList = theaterList;

        //initialize views
        listView = (ListView)findViewById(R.id.list_view);
        sortNameBtn = (Button)findViewById(R.id.sortNameBtn);

        //launch view of list
        TheaterArrayAdapter = new ArrayAdapter<Theater>(this,android.R.layout.simple_list_item_1,android.R.id.text1, theaterList);
        listView.setAdapter(TheaterArrayAdapter);

    }

    private void updateList()
    {
        sortNameBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                sortByName();
            }
        });
    }

    private void sortByName()
    {
        sortedList = (ArrayList<Theater>)SortTheater.sortByName(theaterList);
        TheaterArrayAdapter = new ArrayAdapter<Theater>(this,android.R.layout.simple_list_item_1,android.R.id.text1, sortedList);
        listView.setAdapter(TheaterArrayAdapter);
    }

    private void listItemClicked()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TheaterActivity.this, TheaterSelectMovieActivity.class);
                Bundle extras = new Bundle();

                Theater theater = sortedList.get(i);
                extras.putSerializable("TheaterPassed",theater);
                extras.putSerializable("MovieList",movieList);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

}
