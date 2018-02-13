package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        listItemClicked();
    }

    private void initializeView()
    {
        //initialize data
        movieList = new ArrayList<Movie>();
        accessMovie = new AccessMovie();

        accessMovie.getMovies(movieList);      //transfer items in the db into movieList
        sortedMovie = new SortMovie();


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

    private void listItemClicked()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent movieDescIntent = new Intent(MovieActivity.this, MovieDescActivity.class);

                Movie displayMovie = movieList.get(i);
                movieDescIntent.putExtra("DisplayMovie",displayMovie);    //pass displayMovie into MovieDescActivity

                startActivity(movieDescIntent);

            }
        });
    }

    private void sortByGenre()
    {
        //todo <sortByGenre()> currently works as reset to launch view
        //sortedMovie.sortByGenre(movieList, String);
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, movieList);
        listView.setAdapter(movieArrayAdapter);
    }

    private void sortByRating()
    {
        movieList = (ArrayList<Movie>) sortedMovie.sortByRating(movieList);
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, movieList);
        listView.setAdapter(movieArrayAdapter);
    }

    private void sortByName()
    {
        movieList = (ArrayList<Movie>)sortedMovie.sortByName(movieList);
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, movieList);
        listView.setAdapter(movieArrayAdapter);
    }

}
