package comp3350.ezcinema.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.business.AccessMovie;
import comp3350.ezcinema.business.SortMovie;
import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity
{
    //Data
    private ArrayList<Movie> movieList;
    private ArrayList<Movie> sortedList;
    private AccessMovie accessMovie;
    private SortMovie sortedMovie;
    private ArrayAdapter<Movie> movieArrayAdapter;

    //views
    private ListView listView;
    private Button sortNameBtn;
    private Button sortRatingBtn;
    private Button sortGenreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        initializeView();
        updateList();
    }

    private void initializeView()
    {
        //initialize data
        movieList = new ArrayList<Movie>();
        accessMovie = new AccessMovie();
        //accessMovie.getMovieSequential(movieList);      //transfer items in the db into movieList
        sortedMovie = new SortMovie();

        //sample data --------------------------------------------------------- todo <movieList> only contains sample data, delete this block after database is implemented
        Movie movie1 = new Movie("1","Batman","the batman movie",1.00);
        Movie movie2 = new Movie("2","X-men","the X-men movie",2.00);
        Movie movie3 = new Movie("3","SuperMan","the SuperMan movie",3.00);
        Movie movie4 = new Movie("4","SpiderMan","the SpiderMan movie",4.00);
        Movie movie5 = new Movie("5","IronMan","the IronMan movie",5.00);
        Movie movie6 = new Movie("6","DragonBall","the DragonBall movie",6.00);

        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie6);
        movieList.add(movie5);
        movieList.add(movie1);
        movieList.add(movie4);
        //------------------------------------------------------------------------


        //initialize views
        listView = (ListView)findViewById(R.id.list_view);
        sortNameBtn = (Button)findViewById(R.id.sortNameBtn);
        sortRatingBtn = (Button)findViewById(R.id.sortRatingBtn);
        sortGenreBtn = (Button)findViewById(R.id.sortGenreBtn);

        //launch view of list
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, movieList);
        listView.setAdapter(movieArrayAdapter);

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

        sortRatingBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                sortByRating();
            }
        });

        sortGenreBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                sortByGenre();
            }
        });
    }

    private void sortByGenre()
    {
        //todo <sortByGenre()> currently works as reset to launch view
        sortedMovie.sortByGenre(movieList);
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, movieList);
        listView.setAdapter(movieArrayAdapter);
    }

    private void sortByRating()
    {
        sortedList = (ArrayList<Movie>) sortedMovie.sortByRating(movieList);
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, sortedList);
        listView.setAdapter(movieArrayAdapter);
    }

    private void sortByName()
    {
        sortedList = (ArrayList<Movie>)sortedMovie.sortByName(movieList);
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, sortedList);
        listView.setAdapter(movieArrayAdapter);
    }

}
