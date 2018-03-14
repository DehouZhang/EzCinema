package comp3350.ezcinema.objects;

import android.app.Activity;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Comparator;

import comp3350.ezcinema.presentation.MovieSelectTheaterActivity;
import comp3350.ezcinema.presentation.TheaterSelectMovieActivity;



public class MT implements Serializable
{
    private String movieName;
    private String theaterName;
    private ArrayList<String> showtime;

    public MT(String movieName, String theaterName, ArrayList<String> showtime)
    {
        if (movieName.equals("") || theaterName.equals("") || showtime.size() == 0)
        {
            this.movieName=null;
            this.theaterName=null;
            this.showtime=new ArrayList<>();
        } else
            {
            this.movieName=movieName;
            this.theaterName=theaterName;
            this.showtime=showtime;
            }
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


    @Override
    public String toString()
    {
        if (movieName==null || theaterName==null || showtime.size() == 0){
            return null;
        }else
            {
            return movieName + " in " + theaterName + "\nShow Times:\t" + showtimeToString();
            }
    }

    public String showtimeToString()
    {
        String result = "";
        for (int i =0; i<showtime.size(); i++)
        {
            result += showtime.get(i)+"\t";
        }
        if (result == ""
                ){
            return null;
        }
        return result;
    }
}
