package comp3350.ezcinema.business;

/**
 * Created by Dehou on 2/12/2018.
 */
import java.util.ArrayList;
import java.util.Collections;

import comp3350.ezcinema.objects.Theater;
public class SortTheater {
    //sort by name
    public ArrayList<Theater> sortByName(ArrayList<Theater> databaseList){

        ArrayList<Theater> sortedList;
        sortedList = (ArrayList<Theater>)databaseList.clone();

        Collections.sort(sortedList, Theater.TheaterNameComparator);

        return sortedList;
    }


    //sort by Address
    public ArrayList<Theater> sortByAddress(ArrayList<Theater> databaseList){

        ArrayList<Theater> sortedList;
        sortedList = (ArrayList<Theater>)databaseList.clone();

        Collections.sort(sortedList, Theater.TheaterAddressComparator);

        return sortedList;
    }

}
