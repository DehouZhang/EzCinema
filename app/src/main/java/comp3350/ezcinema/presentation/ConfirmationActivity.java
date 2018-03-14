package comp3350.ezcinema.presentation;

import android.content.Intent;
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

import java.util.ArrayList;

import comp3350.ezcinema.R;
import comp3350.ezcinema.business.AccessTheater;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;

public class ConfirmationActivity extends AppCompatActivity
{

    //data
    private MT passedMT;
    private ArrayList<String> showtimes;
    private ArrayAdapter<String> showtimeAdapter;
    private AccessTheater accessTheater;
    private int amount;
    private  String selectedShowTime;

    //views
    TextView textViewInfo;
    Spinner spinnerShowTime;
    Button buttonConfirm;
    EditText editTextAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        initializeData();
        initializeViews();
        confirmClicked();
    }


    private void initializeData()
    {
        passedMT  = (MT)getIntent().getExtras().getSerializable("MTSelected");
        showtimes = passedMT.getShowtime();

        accessTheater = new AccessTheater();
    }

    private void initializeViews()
    {
        textViewInfo = (TextView)findViewById(R.id.textViewInfo);
        spinnerShowTime = (Spinner)findViewById(R.id.spinnerShowTime);
        buttonConfirm = (Button)findViewById(R.id.buttonConfirm);
        editTextAmount = (EditText)findViewById(R.id.editTextAmount);

        setTextInfo();
        setSpinner();
    }

    private void setTextInfo()
    {
        textViewInfo.setText("\n\n"+passedMT.getMovieName()+"\n\nAt: \n"+passedMT.getTheaterName()+"\n"+accessTheater.getTheaterAddr(passedMT.getTheaterName()));
    }

    private void setSpinner()
    {
        showtimeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, showtimes);
        spinnerShowTime.setAdapter(showtimeAdapter);
        selectedShowTime = spinnerShowTime.getSelectedItem().toString();
    }

    private void confirmClicked()
    {

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passAmount();
            }
        });
    }

    private void passAmount()
    {
        if(!isValid(editTextAmount))
        {
            amount = Integer.parseInt(editTextAmount.getText().toString());

            Intent intent = new Intent(ConfirmationActivity.this, CheckoutActivity.class);
            Bundle extras = new Bundle();
            extras.putSerializable("MovieNamePassed",passedMT.getMovieName());
            extras.putSerializable("TheaterNamePassed",passedMT.getTheaterName());
            extras.putSerializable("ShowTimePassed",selectedShowTime);
            extras.putSerializable("AmountPassed",amount);
            intent.putExtras(extras);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Please Enter the amount of ticket you want to order.(1 to 150)", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValid(EditText editText)
    {
        boolean result = true;
        String text = editText.getText().toString().trim();
        if (text.length() >0 && Integer.parseInt(text) <= 150)
            result = false;
        return result;
    }


}
