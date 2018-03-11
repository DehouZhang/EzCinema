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
    private String showtime;

    public MT(String movieName, String theaterName, String showtime)
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

    public String getShowtime() {
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
}
