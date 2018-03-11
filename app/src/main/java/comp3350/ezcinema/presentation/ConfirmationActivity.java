package comp3350.ezcinema.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;

public class ConfirmationActivity extends AppCompatActivity {

    //data
    //todo should be one movie-theater relation object
    private Movie movie;
    private Theater theater;
    private String[] showtimes;
    private ArrayAdapter<String> showtimeAdapter;
    private int amount;

    //views
    TextView textViewInfo;
    Spinner spinnerShowTime;
    Button buttonConfirm;
    EditText editTextAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        initializeData();
        initializeViews();
        confirmClicked();
    }


    private void initializeData() {
        movie  = (Movie)getIntent().getExtras().getSerializable("MoviePassed");
        theater = (Theater)getIntent().getExtras().getSerializable("TheaterSelected");
        showtimes = new String[]{"8:30","9:30","10:30","22:00"};
        amount = -1;
    }

    private void initializeViews() {
        textViewInfo = (TextView)findViewById(R.id.textViewInfo);
        spinnerShowTime = (Spinner)findViewById(R.id.spinnerShowTime);
        buttonConfirm = (Button)findViewById(R.id.buttonConfirm);
        editTextAmount = (EditText)findViewById(R.id.editTextAmount);

        setTextInfo();
        setSpinner();
    }

    private void setTextInfo() {
        textViewInfo.setText("\n\n"+movie.getMovieName()+"\n\nAt: \n"+theater.getTheaterName()+"\n"+theater.getTheaterAddress());
    }

    private void setSpinner() {
        showtimeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, showtimes);
        spinnerShowTime.setAdapter(showtimeAdapter);
    }

    private void confirmClicked() {
        //todo go to payment page (maybe update database for reservation) pass the amount of ticket customer choose
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passAmount();
            }
        });
    }

    private void passAmount(){
        if(!isValid(editTextAmount)) {
            amount = Integer.parseInt(editTextAmount.getText().toString());
            Log.d("AMOUNT", "" + amount);   //todo delete later
        }
        else {
            Toast.makeText(this, "Please Enter the amount of ticket you want to order.(1 to 150)", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValid(EditText editText) {
        boolean result = true;
        String text = editText.getText().toString().trim();
        if (text.length() >0 && Integer.parseInt(text) <= 150)
            result = false;
        return result;
    }


}
