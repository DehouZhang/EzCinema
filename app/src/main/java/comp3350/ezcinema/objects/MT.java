package comp3350.ezcinema.objects;

import android.app.Activity;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Comparator;

import comp3350.ezcinema.presentation.MovieSelectTheaterActivity;
import comp3350.ezcinema.presentation.TheaterSelectMovieActivity;

/**
 * Created by Dehou on 3/10/2018.
 */

public class MT implements Serializable{
    private String movieName;
    private String theaterName;
    private ArrayList<String> showtime;

    public MT(String movieName, String theaterName, ArrayList<String> showtime)
    {
        this.movieName=movieName;
        this.theaterName=theaterName;
        this.showtime=showtime;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public ArrayList<String> getShowtime() {
        return showtime;
    }

    public boolean equals(Object object)
    {
        boolean result;
        MT mt;

        result=false;

        if(object instanceof MT)
        {
            mt =(MT)object;
            if ((((mt.movieName == null) && (movieName == null)) || ((mt.movieName != null) && (mt.movieName.equals(movieName))))
                    && (((mt.theaterName == null)  && (theaterName == null))  || ((mt.theaterName != null)  && (mt.theaterName.equals(theaterName))))
                    &&(((mt.showtime == null)  && (showtime == null))  || ((mt.showtime != null)  && (mt.showtime.equals(showtime)))))
            {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return movieName + " in " + theaterName + "\nShow Times:\t" + showtimeToString();
    }

    public String showtimeToString(){
        String result = "";
        for (int i =0; i<showtime.size(); i++){
            result += showtime.get(i)+"\t";
        }
        return result;
    }
}