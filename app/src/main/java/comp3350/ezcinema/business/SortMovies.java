package comp3350.ezcinema.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

import comp3350.ezcinema.objects.Movie;

/**
 * Created by RandallUser on 2018-02-10.
 */

public class SortMovies {



    //Pass lists you want sorted



    //sort by name
    public static ArrayList<Movie> sortByName(ArrayList<Movie> databaseList){

        ArrayList<Movie> sortedList;
        sortedList = (ArrayList<Movie>)databaseList.clone();

        Collections.sort(sortedList, Movie.MovieNameComparator);

        return sortedList;
    }


    //sort by rating
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
