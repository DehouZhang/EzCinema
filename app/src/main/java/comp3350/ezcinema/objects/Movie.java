package comp3350.ezcinema.objects;

/**
 * Created by 杨 on 2018/2/11.
 */
import java.util.Comparator;

public class Movie
{
    private String movieID;
    private String movieName;
    private String description;
    private double rating;
    private String genre;

    public Movie(String newID)
    {
        movieID = newID;
        movieName = null;
    }

    public Movie(String newID, String newMovieName, String newDescription, String newGenre, double newRating)
    {
        movieID = newID;
        movieName = newMovieName;
        description = newDescription;
        rating = newRating;
        genre = newGenre;
    }

    public String getMovieID()
    {
        return (movieID);
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
        return "Movie: " + movieName + "\n" + description +"\n" + rating;
    }

    public boolean equals(Object object)
    {
        boolean result;
        Movie c;

        result = false;

        if (object instanceof Movie)
        {
            c = (Movie) object;
            if (((c.movieID == null) && (movieID == null)) || (c.movieID.equals(movieID)))
            {
                result = true;
            }
        }
        return result;
    }


    //used to compare the attributes of the Movie ArrayList items


    public static Comparator<Movie> MovieNameComparator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {
            String MovieName1 = m1.getMovieName().toUpperCase();
            String MovieName2 = m2.getMovieName().toUpperCase();

            //ascending order
            return MovieName1.compareTo(MovieName2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};


    public static Comparator<Movie> MovieRatingComparator = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {

            //For ascending order
            if (m1.getMovieRating() < m2.getMovieRating()) return -1;
            if (m1.getMovieRating() > m2.getMovieRating()) return 1;
            return 0;

        }};

}
