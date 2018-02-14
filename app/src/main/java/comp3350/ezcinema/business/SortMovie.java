package comp3350.ezcinema.business;

import java.util.ArrayList;
import java.util.Collections;


import comp3350.ezcinema.objects.Movie;


public class SortMovie {

    public static ArrayList<Movie> sortByName(ArrayList<Movie> databaseList){

        ArrayList<Movie> sortedList;
        sortedList = (ArrayList<Movie>)databaseList.clone();

        Collections.sort(sortedList, Movie.MovieNameComparator);

        return sortedList;
    }


    public static ArrayList<Movie> sortByRating (ArrayList<Movie> databaseList){

        ArrayList<Movie> sortedList;
        sortedList = (ArrayList<Movie>)databaseList.clone();

        Collections.sort(sortedList, Movie.MovieRatingComparator);

        return sortedList;
    }


    public static ArrayList<Movie>  sortByGenre (ArrayList<Movie> databaseList, String givenGenre){

        ArrayList<Movie> filteredList = new ArrayList<>();

        for (Movie m: databaseList){
            if(m.getGenre().equals(givenGenre)){
                filteredList.add(m);
            }

        }
    return filteredList;

    }
}
