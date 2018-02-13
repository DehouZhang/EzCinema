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
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.business.AccessMovie;
import comp3350.ezcinema.business.SortMovie;
import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    //Data
    private ArrayList<Movie> movieList;
    private ArrayList<Movie> sortedList;
    private AccessMovie accessMovie;
    private SortMovie sortedMovie;
    private ArrayAdapter<String> genreArrayAdapter;
    private ArrayAdapter<Movie> movieArrayAdapter;

    private ArrayList<String> genreList;    //may improve logic

    //views
    private ListView listView;
    private Button sortNameBtn;
    private Button sortRatingBtn;

    private Spinner genreSpinner;   //spinner for filtering movie by genre

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        initializeGenreList();
        initializeView();
        updateList();
        listItemClicked();
    }

    private void initializeGenreList() {
        genreList = new ArrayList<>();

        genreList.add("All");   //default selection

        genreList.add("Family");
        genreList.add("Thriller");
        genreList.add("Horror");

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
        genreSpinner = (Spinner)findViewById(R.id.genreSpinner);

        //launch view of list
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, movieList);
        listView.setAdapter(movieArrayAdapter);

        //view of spinner
        genreArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, genreList);
        genreSpinner.setAdapter(genreArrayAdapter);

    }

    private void updateList()
    {
        genreSpinner.setOnItemSelectedListener(this);

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
    }

    private void listItemClicked()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent movieDescIntent = new Intent(MovieActivity.this, MovieDescActivity.class);

                Movie displayMovie = sortedList.get(i);
                movieDescIntent.putExtra("DisplayMovie",displayMovie);    //pass displayMovie into MovieDescActivity

                startActivity(movieDescIntent);

            }
        });
    }

    private void sortByRating()
    {
        sortedList = (ArrayList<Movie>) sortedMovie.sortByRating(sortedList);
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, sortedList);
        listView.setAdapter(movieArrayAdapter);
    }

    private void sortByName()
    {
        sortedList = (ArrayList<Movie>)sortedMovie.sortByName(sortedList);
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, sortedList);
        listView.setAdapter(movieArrayAdapter);
    }

    private void sortByGenre(int i) {
        String genreType = genreList.get(i);
        if(genreType.equals("All"))
        {
            sortedList = movieList;
        }else{
            sortedList = sortedMovie.sortByGenre(movieList,genreType);

        }
        movieArrayAdapter = new ArrayAdapter<Movie>(this,android.R.layout.simple_list_item_1,android.R.id.text1, sortedList);
        listView.setAdapter(movieArrayAdapter);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        sortByGenre(pos);
    }

    public void onNothingSelected(AdapterView<?> parent)
    {
        // Another interface callback
    }
}
