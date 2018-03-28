package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;

import java.text.DecimalFormat;
import java.util.ArrayList;

import comp3350.ezcinema.R;
import comp3350.ezcinema.business.CalculateTax;
import comp3350.ezcinema.business.UpdateSeat;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;

public class CheckoutActivity extends AppCompatActivity
{
    //Data
    private String movieName;
    private int amount;
    private String theaterName;
    private String showtime;
    private ArrayList<int[]>  temptable;
    private double price = 10.00;
    DecimalFormat money = new DecimalFormat("$0.00");
    private CalculateTax tax;
    private double afterTax;

    private MT mtPassed;
    UpdateSeat updates;

    //views
    TextView textViewTitle;
    TextView textViewSubtotal;
    TextView textViewTotal;
    Button buttonPurchase;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        initializeView();
        confirmClicked();
    }

    private void initializeView()
    {
        mtPassed = (MT)getIntent().getSerializableExtra("MTPassed");
        amount = (int)getIntent().getSerializableExtra("AmountPassed");
        showtime = (String)getIntent().getSerializableExtra("ShowTimePassed");
        temptable = (ArrayList<int[]>)getIntent().getSerializableExtra("TempTablePassed");

        movieName = mtPassed.getMovieName();
        theaterName = mtPassed.getTheaterName();
        updates = new UpdateSeat();
        tax = new CalculateTax();
        price = amount*price;
        afterTax = tax.calcTax((price));

        textViewTitle = (TextView)findViewById(R.id.textViewTitle);
        textViewSubtotal = (TextView)findViewById(R.id.textViewSubtotal);
        textViewTotal = (TextView)findViewById(R.id.textViewTotal);
        buttonPurchase = (Button)findViewById(R.id.buttonPurchase);

        setTextView();

    }

    private void setTextView()
    {
        textViewTitle.setText(movieName+", # of Tickets: "+amount);
        textViewSubtotal.setText("Subtotal: "+money.format(price));
        textViewTotal.setText("Total: "+money.format(afterTax));
    }

    public void onRadioButtonClicked(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // Check which radio button was clicked
        switch(view.getId())
        {
            case R.id.radio_credit:
                if (checked)
                {
                    FragmentCredit creditFragment = new FragmentCredit();
                    fragmentTransaction.replace(R.id.fragment_container,creditFragment);
                    fragmentTransaction.commit();
                    break;
                }
            case R.id.radio_paypal:
                if (checked)
                {
                    FragmentPaypal paypalFragment = new FragmentPaypal();
                    fragmentTransaction.replace(R.id.fragment_container,paypalFragment);
                    fragmentTransaction.commit();
                    break;
                }
            case R.id.radio_scene:
                if (checked)
                {
                    FragmentScene sceneFragment = new FragmentScene();
                    fragmentTransaction.replace(R.id.fragment_container,sceneFragment);
                    fragmentTransaction.commit();
                    break;
                }
        }
    }

    private void confirmClicked()
    {

        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passAmount();
            }
        });
    }

    private void passAmount()
    {
            updateDB(temptable,updates);
            Intent intent = new Intent(CheckoutActivity.this, TicketActivity.class);
            Bundle extras = new Bundle();
            extras.putSerializable("MovieNamePassed", movieName);
            extras.putSerializable("TheaterNamePassed", theaterName);
            extras.putSerializable("ShowTimePassed", showtime);
            extras.putSerializable("AmountPassed",amount);
            extras.putSerializable("TempTablePassed",temptable);
            intent.putExtras(extras);
            startActivity(intent);

    }

    private void updateDB(ArrayList<int[]> list, UpdateSeat update){
        //update database
        int row,col,index;
        for (index = 0; index <list.size();index++){
            row = list.get(index)[0];
            col = list.get(index)[1];
            update.updateSeatStatus(mtPassed,showtime,row,col);
        }
    }

}
