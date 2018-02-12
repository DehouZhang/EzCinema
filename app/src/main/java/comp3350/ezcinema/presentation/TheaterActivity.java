package comp3350.ezcinema.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.business.AccessTheater;
import comp3350.ezcinema.business.SortTheater;
import java.util.ArrayList;

public class TheaterActivity extends AppCompatActivity
{
    //Data
    private ArrayList<Theater> theaterList;
    private ArrayList<Theater> sortedList;
    private AccessTheater accessTheater;
    private SortTheater sortedTheater;
    private ArrayAdapter<Theater> TheaterArrayAdapter;

    //views
    private ListView listView;
    private Button sortNameBtn;
    private Button sortAddressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);

        initializeView();
        updateList();
    }

    private void initializeView()
    {
        //initialize data
        theaterList = new ArrayList<Theater>();
        accessTheater = new AccessTheater();
        //accessTheater.getTheaterSequential(theaterList);      //transfer items in the db into theaterList
        sortedTheater = new SortTheater();

        //sample data --------------------------------------------------------- todo <theaterList> only contains sample data, delete this block after database is implemented
        Theater theater1 = new Theater(1,"Eglinton Theatre","C Road");
        Theater theater2 = new Theater(2,"Corona Theatre","M Road");
        Theater theater3 = new Theater(3,"Royal Cinema","H Road");
        Theater theater4 = new Theater(4,"Rex Theatre","A Road");
        Theater theater5 = new Theater(5,"Mobile Cinema","V Road");
        Theater theater6 = new Theater(6,"Astor Theater","W Road");

        theaterList.add(theater2);
        theaterList.add(theater3);
        theaterList.add(theater6);
        theaterList.add(theater5);
        theaterList.add(theater1);
        theaterList.add(theater4);
        //------------------------------------------------------------------------


        //initialize views
        listView = (ListView)findViewById(R.id.list_view);
        sortNameBtn = (Button)findViewById(R.id.sortNameBtn);
        sortAddressBtn = (Button)findViewById(R.id.sortAddressBtn);

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

        sortAddressBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                sortByAddress();
            }
        });
    }

    private void sortByAddress()
    {
        sortedList = (ArrayList<Theater>) sortedTheater.sortByAddress(theaterList);
        TheaterArrayAdapter = new ArrayAdapter<Theater>(this,android.R.layout.simple_list_item_1,android.R.id.text1, sortedList);
        listView.setAdapter(TheaterArrayAdapter);
    }

    private void sortByName()
    {
        sortedList = (ArrayList<Theater>)sortedTheater.sortByName(theaterList);
        TheaterArrayAdapter = new ArrayAdapter<Theater>(this,android.R.layout.simple_list_item_1,android.R.id.text1, sortedList);
        listView.setAdapter(TheaterArrayAdapter);
    }

}
