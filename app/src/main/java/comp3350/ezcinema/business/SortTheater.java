package comp3350.ezcinema.business;

import java.util.ArrayList;
import java.util.Collections;


import comp3350.ezcinema.objects.Theater;


public class SortTheater {

    public ArrayList<Theater> sortByName(ArrayList<Theater> databaseList){

        ArrayList<Theater> sortedList;
        sortedList = (ArrayList<Theater>)databaseList.clone();

        Collections.sort(sortedList, Theater.TheaterNameComparator);

        return sortedList;
    }

}
