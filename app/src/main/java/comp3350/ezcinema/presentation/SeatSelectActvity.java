package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.MT;

public class SeatSelectActvity extends AppCompatActivity {

    //data
    int[][] seats;
    int numTicket;
    int count;
    int[] rc;
    ArrayList<int[]> temptable;

    MT mtPassed;
    String showtime;
    getSeatsTable table;

    //view
    GridView seatGridView;
    Button confrimButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_select_actvity);

        initializeData();
        initializeView();
        setUpGridView();
        confrimation();
    }

    private void initializeData(){
        table = new getSeatsTable();

        temptable = new ArrayList<>();

        mtPassed = (MT) getIntent().getExtras().getSerializable("MTPassed");
        showtime = (String) getIntent().getExtras().getSerializable("ShowTimePassed");
        numTicket = (int)getIntent().getExtras().getSerializable("AmountPassed");

        count = numTicket;
        seats = table.getSeatTable(mtPassed,showtime);

    }

    private void initializeView(){
        seatGridView = (GridView)findViewById(R.id.seatGridView);
        confrimButton = (Button)findViewById(R.id.confrimButton);

    }

    private void setUpGridView(){

        //setup adapter
        SeatAdapter seatAdapter = new SeatAdapter(getApplicationContext(),seats);
        seatGridView.setAdapter(seatAdapter);

        seatGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(count > 0) {
                    //update seat table in activity
                    seats[i / 5][i % 5] = 1;

                    //store temporary table for confirm to update database
                    rc = new int[2];
                    rc[0] = i/5;
                    rc[1] = i%5;
                    temptable.add(rc);

                    SeatAdapter newAdapter = new SeatAdapter(getApplicationContext(), seats);
                    seatGridView.setAdapter(newAdapter);
                    count--;
                }
            }
        });
    }

    private void confrimation() {
        confrimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selection();
            }
        });
    }

    private void selection() {
        if(count == 0) {

            //pass data
            Intent intent = new Intent(SeatSelectActvity.this, CheckoutActivity.class);
            Bundle extras = new Bundle();
            extras.putSerializable("MTPassed",mtPassed);
            extras.putSerializable("ShowTimePassed",showtime);
            extras.putSerializable("AmountPassed",numTicket);
            extras.putSerializable("TempTablePassed",temptable);
            intent.putExtras(extras);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Please select "+count+" more Seat!", Toast.LENGTH_SHORT).show();
        }
    }




}
