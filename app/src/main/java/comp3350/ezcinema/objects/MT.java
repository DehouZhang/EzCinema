package comp3350.ezcinema.objects;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Comparator;
/**
 * Created by Dehou on 3/10/2018.
 */

public class MT implements Serializable{
    private String movieName;
    private String theaterName;
    private ArrayList<String> showtimes;

    public MT(String movieName, String theaterName, ArrayList<String> showtimes)
    {
        this.movieName=movieName;
        this.theaterName=theaterName;
        this.showtimes=showtimes;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public ArrayList<String> getShowtimes() {
        return showtimes;
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
                    && (((mt.theaterName == null)  && (theaterName == null))  || ((mt.theaterName != null)  && (mt.theaterName.equals(theaterName)))))
            {
                result = true;
            }
        }
        return result;
    }
}
