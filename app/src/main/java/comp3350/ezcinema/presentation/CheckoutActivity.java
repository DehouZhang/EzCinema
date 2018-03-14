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

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Movie;

public class CheckoutActivity extends AppCompatActivity {
    //Data
    private String movieName = "test";
    private int amount;
    private String theaterName;
    private String selectedShowTime;
    //todo price for tickets is currently hard-coded
    private double price = 10.00;

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
        movieName = (String)getIntent().getSerializableExtra("MovieNamePassed");
        theaterName = (String)getIntent().getSerializableExtra("TheaterNamePassed");
        amount = (int)getIntent().getSerializableExtra("AmountPassed");
        selectedShowTime = (String)getIntent().getSerializableExtra("ShowTimePassed");

        textViewTitle = (TextView)findViewById(R.id.textViewTitle);
        textViewSubtotal = (TextView)findViewById(R.id.textViewSubtotal);
        textViewTotal = (TextView)findViewById(R.id.textViewTotal);
        buttonPurchase = (Button)findViewById(R.id.buttonPurchase);

        setTextView();

    }

    private void setTextView()
    {
        textViewTitle.setText(movieName+" # of Tickets\n");
        textViewSubtotal.setText("Subtotal: "+price+" per ticket");//add subtotal
        textViewTotal.setText("Total: "+amount+"*"+price+"\n= $"+amount*price);//add total
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_credit:
                if (checked) {
                    FragmentCredit creditFragment = new FragmentCredit();
                    fragmentTransaction.replace(R.id.fragment_container,creditFragment);
                    fragmentTransaction.commit();
                    break;
                }
            case R.id.radio_paypal:
                if (checked) {
                    FragmentPaypal paypalFragment = new FragmentPaypal();
                    fragmentTransaction.replace(R.id.fragment_container,paypalFragment);
                    fragmentTransaction.commit();
                    break;
                }
            case R.id.radio_scene:
                if (checked) {
                    FragmentScene sceneFragment = new FragmentScene();
                    fragmentTransaction.replace(R.id.fragment_container,sceneFragment);
                    fragmentTransaction.commit();
                    break;
                }
        }
    }

    private void confirmClicked() {

        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passAmount();
            }
        });
    }

    private void passAmount(){

            Intent intent = new Intent(CheckoutActivity.this, TicketActivity.class);
            Bundle extras = new Bundle();
            extras.putSerializable("MovieNamePassed", movieName);
            extras.putSerializable("TheaterNamePassed", theaterName);
            extras.putSerializable("ShowTimePassed", selectedShowTime);
            extras.putSerializable("AmountPassed",amount);
            intent.putExtras(extras);
            startActivity(intent);

    }

}
