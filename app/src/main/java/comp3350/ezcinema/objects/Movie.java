package comp3350.ezcinema.objects;

import java.io.Serializable;
import java.util.Comparator;

public class Movie implements Serializable
{
    private String movieName;
    private String description;
    private double rating;
    private String genre;


    public Movie(String newMovieName, String newDescription, String newGenre, double newRating)
    {
        if (newMovieName.equals("") || newDescription.equals("") || newGenre.equals("") || newRating <0.0 || newRating>10.0)
        {
            movieName = null;
            description = null;
            rating = -1.0;
            genre = null;
        }
        else
        {
            movieName = newMovieName;
            description = newDescription;
            rating = newRating;
            genre = newGenre;
        }
    }

    public String getMovieName()
    {
        return (movieName);
    }

    public String getMovieDescription() { return (description);}

    public double getMovieRating() { return (rating); }

    public String getGenre() { return (genre); }

    public String toString()
    {
        if (movieName == null || description == null || genre == null || rating == -1.0)
        {
            return null;
        }
        else
        {
            return movieName + "\nDescription:\n" + description + "\nRating:  " + rating;
        }
    }

    public boolean equals(Object object)
    {
        boolean result;
        Movie c;

        result = false;

        if (object instanceof Movie)
        {
            c = (Movie) object;
            if (((c.movieName == null) && (movieName == null)) || (c.movieName.equals(movieName)))
            {
                result = true;
            }
        }
        return result;
    }

    //used to compare the attributes of the Movie ArrayList items
    public static Comparator<Movie> MovieNameComparator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {
            String MovieName1 = m1.getMovieName();
            String MovieName2 = m2.getMovieName();

            if (MovieName1 == null && MovieName2 != null) {
                return -1;
            }
            else if (MovieName2 == null && MovieName1 != null) {
                return 1;
            }
            else if (MovieName1 == null && MovieName2 == null) {
                return 0;
            }
            else {
                //ascending order
                return MovieName1.compareTo(MovieName2);
            }
        }};


    public static Comparator<Movie> MovieRatingComparator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {

            //For descending order
            if (m1.getMovieRating() > m2.getMovieRating()) return -1;
            if (m1.getMovieRating() < m2.getMovieRating()) return 1;
            return 0;

        }};

}
