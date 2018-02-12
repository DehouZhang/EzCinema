package comp3350.ezcinema.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.Theater;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void buttonMovieOnClick(View v)
    {
        Intent movieIntent = new Intent(HomeActivity.this, MovieActivity.class);
        HomeActivity.this.startActivity(movieIntent);
    }

    public void buttonTheaterOnClick(View v)
    {
        Intent theaterIntent = new Intent(HomeActivity.this, TheaterActivity.class);
        HomeActivity.this.startActivity(theaterIntent);
    }

}
