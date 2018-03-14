package comp3350.ezcinema.objects;

import java.io.Serializable;
import java.util.Comparator;

public class Theater implements Serializable
{
    private String theaterName;
    private String theaterAddress;

    public Theater(String newTheaterName, String newTheaterAddress)
    {
        if(newTheaterName == "" || newTheaterAddress == "")
        {
            theaterName = null;
            theaterAddress = null;
        }
        else
        {
            theaterName = newTheaterName;
            theaterAddress = newTheaterAddress;
        }
    }

    public String getTheaterName()
    {
        return (theaterName);
    }

    public String getTheaterAddress()
    {
        return (theaterAddress);
    }

    public String toString()
    {
        if(theaterName == null || theaterAddress == null)
        {
            return null;
        }
        else {
            return theaterName + "\nAddress: " + theaterAddress;
        }
    }

    public static Comparator<Theater> TheaterNameComparator = new Comparator<Theater>()
    {
        public int compare(Theater theater1, Theater theater2)
        {
            String theaterName1 = theater1.getTheaterName();
            String theaterName2 = theater2.getTheaterName();

            if(theaterName1 == null && theaterName2 != null)
            {
                return -1;
            }
            else if(theaterName1 != null && theaterName2 == null)
            {
                return 1;
            }
            else if(theaterName1 == null && theaterName2 == null)
            {
                return 0;
            }
            else
            {
                return theaterName1.compareTo(theaterName2);
            }
        }
    };
}