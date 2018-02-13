package comp3350.ezcinema.objects;

import java.io.Serializable;
import java.util.Comparator;

public class Theater implements Serializable
{
    private String theaterID;
    private String theaterName;
    private String theaterAddress;

    public Theater(String newID)
    {
        theaterID = newID;
        theaterName = null;
        theaterAddress = null;
    }

    public Theater(String newID, String newTheaterName, String newTheaterAddress)
    {
        theaterID = newID;
        theaterName = newTheaterName;
        theaterAddress = newTheaterAddress;
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
        return theaterName +"\nAddress: " +theaterAddress;
    }

    public boolean equals(Object object)
    {
        boolean result;
        Theater t;

        result = false;

        if (object instanceof Theater)
        {
            t = (Theater) object;
            if  (t.theaterID == theaterID)
            {
                result = true;
            }
        }
        return result;
    }

    public static Comparator<Theater> TheaterNameComparator = new Comparator<Theater>() {

        public int compare(Theater m1, Theater m2) {
            String TheaterName1 = m1.getTheaterName().toUpperCase();
            String TheaterName2 = m2.getTheaterName().toUpperCase();

            //ascending order
            return TheaterName1.compareTo(TheaterName2);
        }};


    public static Comparator<Theater> TheaterAddressComparator = new Comparator<Theater>() {

        public int compare(Theater m1, Theater m2) {

            //For ascending order
            String TheaterName1 = m1.getTheaterAddress().toUpperCase();
            String TheaterName2 = m2.getTheaterAddress().toUpperCase();

            return TheaterName1.compareTo(TheaterName2);

        }};
}