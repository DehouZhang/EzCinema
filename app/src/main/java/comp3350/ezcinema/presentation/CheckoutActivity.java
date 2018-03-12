package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.Serializable;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Movie;

public class CheckoutActivity extends AppCompatActivity {
    //Data
    private Movie movie;
    //views
    TextView textViewTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        initializeView();
    }

    private void initializeView()
    {
        movie = (Movie)getIntent().getSerializableExtra("DisplayMovie");

        textViewTitle = (TextView)findViewById(R.id.textViewTitle);

        setTextView();

    }

    private void setTextView()
    {
        textViewTitle.setText(movie.getMovieName()+" # of Tickets\n");
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
                    credit creditFragment = new credit();
                    fragmentTransaction.replace(R.id.fragment_container,creditFragment);
                    fragmentTransaction.commit();
                    break;
                }
            case R.id.radio_paypal:
                if (checked) {
                    paypal paypalFragment = new paypal();
                    fragmentTransaction.replace(R.id.fragment_container,paypalFragment);
                    fragmentTransaction.commit();
                    break;
                }
            case R.id.radio_scene:
                if (checked) {
                    scene sceneFragment = new scene();
                    fragmentTransaction.replace(R.id.fragment_container,sceneFragment);
                    fragmentTransaction.commit();
                    break;
                }
        }
    }

}
