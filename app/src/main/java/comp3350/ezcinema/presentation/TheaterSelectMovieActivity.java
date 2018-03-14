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
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;

public class TheaterSelectMovieActivity extends AppCompatActivity
{

    //data
    private Theater theater;
    private ArrayList<Movie> movieList;
    private AccessMT accessMT;
    private ArrayList<MT> MTList;
    private ArrayAdapter<MT> MTListArrayAdapter;

    //view
    TextView textViewTheaterInfo;
    ListView listViewMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater_select_movie);

        initializeData();
        initializeView();
        listItemClick();
    }

    private void initializeData()
    {
        //get MovieList from
        theater = (Theater) getIntent().getExtras().getSerializable("TheaterPassed");
        movieList = (ArrayList<Movie>)getIntent().getExtras().getSerializable("MovieList");

        //initialize access to MT
        accessMT = new AccessMT();

        //initialize MTList
        MTList = getMTList(theater,movieList);
    }

    private ArrayList<MT> getMTList(Theater theater, ArrayList<Movie> movieList)
    {
        ArrayList<MT> list = new ArrayList<>();
        MT newMT;
        Movie movie;

        for (int i =0; i< movieList.size(); i++){
            movie = movieList.get(i);
            newMT = accessMT.getMT(movie,theater);

            if(newMT != null) {
                list.add(newMT);
            }
        }
        return list;
    }

    private void initializeView()
    {
        textViewTheaterInfo = (TextView)findViewById(R.id.textViewTheaterInfo);
        listViewMovieList = (ListView)findViewById(R.id.listViewMovieList);

        setText();
        setListView();
    }

    private void setText()
    {
        textViewTheaterInfo.setText(theater.getTheaterName()+"\n"+theater.getTheaterAddress());
    }

    private void setListView()
    {
        MTListArrayAdapter = new TheaterSelectMovieAdapter(this, MTList);
        listViewMovieList.setAdapter(MTListArrayAdapter);
    }

    private void listItemClick()
    {
        listViewMovieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(TheaterSelectMovieActivity.this, ConfirmationActivity.class);
                Bundle extras = new Bundle();

                extras.putSerializable("MTSelected",MTList.get(i));
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
