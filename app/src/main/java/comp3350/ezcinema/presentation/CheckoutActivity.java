package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.ArrayList;

import comp3350.ezcinema.R;
import comp3350.ezcinema.business.CalculateTax;
import comp3350.ezcinema.business.ValidateInput;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.business.AccessSeat;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;

public class CheckoutActivity extends AppCompatActivity
{
    //Data
    private String movieName;
    private int amount;
    private String theaterName;
    private String showtime;
    private ArrayList<int[]> temptable;

    private double price = 10.00;
    DecimalFormat money = new DecimalFormat("$0.00");
    private CalculateTax tax;
    private double afterTax;
    private ValidateInput isValid;
    private boolean creditCheck;
    private boolean paypalCheck;
    private boolean sceneCheck;

    private MT mtPassed;
    private AccessSeat updates;

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

        updates = new AccessSeat();

        tax = new CalculateTax();
        isValid = new ValidateInput();

        price = amount*price;
        afterTax = tax.priceWithTax((price));

        creditCheck = false;
        paypalCheck = false;
        sceneCheck = false;



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
                    creditCheck = true;
                    paypalCheck = false;
                    sceneCheck = false;
                    break;
                }
            case R.id.radio_paypal:
                if (checked)
                {
                    FragmentPaypal paypalFragment = new FragmentPaypal();
                    fragmentTransaction.replace(R.id.fragment_container,paypalFragment);
                    fragmentTransaction.commit();
                    creditCheck = false;
                    paypalCheck = true;
                    sceneCheck = false;
                    break;
                }
            case R.id.radio_scene:
                if (checked)
                {
                    FragmentScene sceneFragment = new FragmentScene();
                    fragmentTransaction.replace(R.id.fragment_container,sceneFragment);
                    fragmentTransaction.commit();
                    creditCheck = false;
                    paypalCheck = false;
                    sceneCheck = true;
                    break;
                }
        }
    }

    private void confirmClicked()
    {

        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInput();
            }
        });
    }

    private void checkInput()
    {
        boolean validated;
        String message;
        EditText editText1;
        EditText editText2;
        EditText editText3;

        message = "";
        validated = false;


        if(creditCheck)
        {
            editText1 = (EditText)findViewById(R.id.editTextCredit);
            editText2 = (EditText)findViewById(R.id.editTextExpiry);
            editText3 = (EditText)findViewById(R.id.editTextCvv);

            String creditText = editText1.getText().toString().trim();
            String dateText = editText2.getText().toString().trim();
            String cvvText = editText3.getText().toString().trim();

            validated = isValid.isValidCredit(creditText,dateText,cvvText);

            if(validated)
            {
                passAmount();
            }
            else
            {
                message = isValid.specificMessage();
                Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
            }
        }
        else if(paypalCheck)
        {
            editText1 = (EditText)findViewById(R.id.editTextEmail);
            editText2 = (EditText)findViewById(R.id.editTextPassword);

            String emailText = editText1.getText().toString().trim();
            String passwordText = editText2.getText().toString().trim();

            validated = isValid.isValidPaypal(emailText,emailText);

            if(validated)
            {
                passAmount();
            }
            else
            {
                message = isValid.specificMessage();
                Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();;
            }
        }
        else if(sceneCheck)
        {
            editText1 = (EditText)findViewById(R.id.editTextScene);
            editText2 = (EditText)findViewById(R.id.editTextPin);

            validated = isValid.isValidScene(editText1,editText2);

            if(validated)
            {
                passAmount();
            }
            else
            {
                message = isValid.specificMessage();
                Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Payment Method Not Selected", Toast.LENGTH_SHORT).show();
        }
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

    private void updateDB(ArrayList<int[]> list, AccessSeat update){
        //update database
        int row,col,index;
        for (index = 0; index <list.size();index++){
            row = list.get(index)[0];
            col = list.get(index)[1];
            update.updateSeatStatus(mtPassed,showtime,row,col);
        }
    }

}
