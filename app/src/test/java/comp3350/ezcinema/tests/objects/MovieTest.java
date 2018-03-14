package comp3350.ezcinema.tests.objects;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import comp3350.ezcinema.objects.Movie;
import static org.junit.Assert.*;


public class MovieTest extends TestCase{


    private Movie movie1, movie2, movie3;
    private Comparator<Movie> movieNameComp;
    private Comparator<Movie> movieRatingComp;

    @Before
    public void setUp() throws Exception {
        movie_normal_data = new Movie( "SuperBad", "3 teens try to have a party", "Comedy", 10.0);              //normal data
        movie_same_content = new Movie( "SuperBad", "3 teens try to have a party", "Comedy", 10.0);             //same content
        movie_another_normal_data = new Movie( "Another", "Another description", "Horror", 6.5);                //another normal data

        movie_empty_data = new Movie( "", "", "", 0.0);                                                         //empty movie
        movie_invalid_rating = new Movie( "SuperBad", "3 teens try to have a party", "Comedy", 100.0);          //invalid rating
        movie_missing_name = new Movie( "", "3 teens try to have a party", "Comedy", 10.0);                     //missing name
        movie_missing_description =  new Movie( "SuperBad", "", "Comedy", 10.0);                                //missing description
        movie_missing_genre =  new Movie( "SuperBad", "3 teens try to have a party", "", 10.0);                 //missing genre

        movie_name_case_sensitivity = new Movie( "SUPERBAD", "3 teens try to have a party", "Comedy", 10.0);    //movie name case sensitivity
        movie_same_name_diff_rating = new Movie( "SuperBad", "3 teens try to have a party", "Comedy", 5.5);     //same name different rating
        movie_same_rating_diff_name = new Movie( "Good", "3 teens try to have a party", "Comedy", 10.0);        //same rating different name

        movieNameComp = Movie.MovieNameComparator;
        movieRatingComp = Movie.MovieRatingComparator;

    }
    @Test
    public void testGetMethods() throws Exception {
        //test normal data
        assertEquals("SuperBad", movie_normal_data.getMovieName());
        assertEquals("3 teens try to have a party", movie_normal_data.getMovieDescription());
        assertEquals(10.0, movie_normal_data.getMovieRating(), 0);
        assertEquals("Comedy", movie_normal_data.getGenre());

        //test same content
        assertEquals(movie_normal_data.getMovieName(),movie_same_content.getMovieName());
        assertEquals(movie_normal_data.getMovieDescription(),movie_same_content.getMovieDescription());
        assertEquals(movie_normal_data.getMovieRating(),movie_same_content.getMovieRating(),0);
        assertEquals(movie_normal_data.getGenre(),movie_same_content.getGenre());

        //test another normal data
        assertNotEquals(movie_normal_data.getMovieName(),movie_another_normal_data.getMovieName());
        assertNotEquals(movie_normal_data.getMovieDescription(),movie_another_normal_data.getMovieDescription());
        assertNotEquals(movie_normal_data.getGenre(),movie_another_normal_data.getGenre());

        //test empty data
        assertNull( movie_empty_data.getMovieName());
        assertNull( movie_empty_data.getMovieDescription());
        assertEquals(-1.0, movie_empty_data.getMovieRating(), 0);
        assertNull( movie_empty_data.getGenre());

        //test missing name
        assertNull( movie_missing_name.getMovieName());
        assertNull( movie_missing_name.getMovieDescription());
        assertEquals(-1.0, movie_missing_name.getMovieRating(), 0);
        assertNull( movie_missing_name.getGenre());

        //test missing description
        assertNull( movie_missing_description.getMovieName());
        assertNull( movie_missing_description.getMovieDescription());
        assertEquals(-1.0, movie_missing_description.getMovieRating(), 0);
        assertNull( movie_missing_description.getGenre());

        //test missing genre
        assertNull( movie_missing_genre.getMovieName());
        assertNull( movie_missing_genre.getMovieDescription());
        assertEquals(-1.0, movie_missing_genre.getMovieRating(), 0);
        assertNull( movie_missing_genre.getGenre());

        //test invalid rating
        assertNull( movie_invalid_rating.getMovieName());
        assertNull( movie_invalid_rating.getMovieDescription());
        assertEquals(-1.0, movie_invalid_rating.getMovieRating(), 0);
        assertNull( movie_invalid_rating.getGenre());

        //test movie name case sensitivity
        assertNotEquals(movie_normal_data.getMovieName(),movie_name_case_sensitivity.getMovieName());
        assertEquals(movie_normal_data.getMovieDescription(),movie_name_case_sensitivity.getMovieDescription());
        assertEquals(movie_normal_data.getMovieRating(),movie_name_case_sensitivity.getMovieRating(),0);
        assertEquals(movie_normal_data.getGenre(),movie_name_case_sensitivity.getGenre());

        //test same name different rating
        assertEquals(movie_normal_data.getMovieName(),movie_same_name_diff_rating.getMovieName());
        assertEquals(movie_normal_data.getMovieDescription(),movie_same_name_diff_rating.getMovieDescription());
        assertNotEquals(movie_normal_data.getMovieRating(),movie_same_name_diff_rating.getMovieRating(),0);
        assertEquals(movie_normal_data.getGenre(),movie_same_name_diff_rating.getGenre());

        //test same rating different name
        assertNotEquals(movie_normal_data.getMovieName(),movie_same_rating_diff_name.getMovieName());
        assertEquals(movie_normal_data.getMovieDescription(),movie_same_rating_diff_name.getMovieDescription());
        assertEquals(movie_normal_data.getMovieRating(),movie_same_rating_diff_name.getMovieRating(),0);
        assertEquals(movie_normal_data.getGenre(),movie_same_rating_diff_name.getGenre());
    }

    @Test
    public void testToString() throws Exception{
        //test normal data
        assertEquals("SuperBad\nDescription:\n3 teens try to have a party\nRating:  10.0",movie_normal_data.toString());

        //test same content
        assertEquals(movie_normal_data.toString(),movie_same_content.toString());

        //test another normal data
        assertNotEquals(movie_normal_data.toString(),movie_another_normal_data.toString());

        //test empty data
        assertNull(movie_empty_data.toString());

        //test missing name
        assertNull(movie_missing_name.toString());

        //test missing description
        assertNull(movie_missing_description.toString());

        //test missing genre
        assertNull(movie_missing_genre.toString());

        //test invalid rating
        assertNull(movie_invalid_rating.toString());

        //test movie name case sensitivity
        assertNotEquals(movie_normal_data.toString(),movie_name_case_sensitivity.toString());

        //test same name different rating
        assertNotEquals(movie_normal_data.toString(),movie_same_name_diff_rating.toString());

        //test same rating different name
        assertNotEquals(movie_normal_data.toString(),movie_same_rating_diff_name.toString());

    }

    @Test
    public void testNameCompares() throws Exception{
        //test normal data compare to other cases
        assertTrue(movieNameComp.compare(movie_normal_data,movie_same_content) == 0);           //compare to same content
        assertTrue(movieNameComp.compare(movie_normal_data,movie_another_normal_data) > 0);     //compare to another normal data
        assertTrue(movieNameComp.compare(movie_normal_data,movie_empty_data) > 0);              //compare to empty data
        assertTrue(movieNameComp.compare(movie_normal_data,movie_missing_name) > 0);            //compare to missing name
        assertTrue(movieNameComp.compare(movie_normal_data,movie_missing_description) > 0);     //compare to missing description
        assertTrue(movieNameComp.compare(movie_normal_data,movie_missing_genre) > 0);           //compare to missing genre
        assertTrue(movieNameComp.compare(movie_normal_data,movie_invalid_rating) > 0);          //compare to invalid rating
        assertTrue(movieNameComp.compare(movie_normal_data,movie_name_case_sensitivity) > 0);   //compare to movie name case sensitivity
        assertTrue(movieNameComp.compare(movie_normal_data,movie_same_name_diff_rating) == 0);   //compare to same name different rating
        assertTrue(movieNameComp.compare(movie_normal_data,movie_same_rating_diff_name) > 0);   //compare to same rating different name

        //test empty data compare to other cases
        assertTrue(movieNameComp.compare(movie_empty_data,movie_normal_data) < 0);                 //compare to normal data
        assertTrue(movieNameComp.compare(movie_empty_data,movie_another_normal_data) < 0);         //compare to another normal data
        assertTrue(movieNameComp.compare(movie_empty_data,movie_missing_name) == 0);             //compare to missing name
        assertTrue(movieNameComp.compare(movie_empty_data,movie_missing_description) == 0);     //compare to missing description
        assertTrue(movieNameComp.compare(movie_empty_data,movie_missing_genre) == 0);           //compare to missing genre
        assertTrue(movieNameComp.compare(movie_empty_data,movie_invalid_rating) == 0);          //compare to invalid rating
        assertTrue(movieNameComp.compare(movie_empty_data,movie_name_case_sensitivity) < 0);   //compare to movie name case sensitivity
        assertTrue(movieNameComp.compare(movie_empty_data,movie_same_name_diff_rating) < 0);   //compare to same name different rating
        assertTrue(movieNameComp.compare(movie_empty_data,movie_same_rating_diff_name) < 0);   //compare to same rating different name

        //test missing name compare to other cases
        assertTrue(movieNameComp.compare(movie_missing_name,movie_normal_data) < 0);                 //compare to normal data
        assertTrue(movieNameComp.compare(movie_missing_name,movie_another_normal_data) < 0);         //compare to another normal data
        assertTrue(movieNameComp.compare(movie_missing_name,movie_empty_data) == 0);             //compare to empty data
        assertTrue(movieNameComp.compare(movie_missing_name,movie_missing_description) == 0);     //compare to missing description
        assertTrue(movieNameComp.compare(movie_missing_name,movie_missing_genre) == 0);           //compare to missing genre
        assertTrue(movieNameComp.compare(movie_missing_name,movie_invalid_rating) == 0);          //compare to invalid rating
        assertTrue(movieNameComp.compare(movie_missing_name,movie_name_case_sensitivity) < 0);   //compare to movie name case sensitivity
        assertTrue(movieNameComp.compare(movie_missing_name,movie_same_name_diff_rating) < 0);   //compare to same name different rating
        assertTrue(movieNameComp.compare(movie_missing_name,movie_same_rating_diff_name) < 0);   //compare to same rating different name

        //test missing description compare to other cases
        assertTrue(movieNameComp.compare(movie_missing_description,movie_normal_data) < 0);                 //compare to normal data
        assertTrue(movieNameComp.compare(movie_missing_description,movie_another_normal_data) < 0);         //compare to another normal data
        assertTrue(movieNameComp.compare(movie_missing_description,movie_empty_data) == 0);             //compare to empty data
        assertTrue(movieNameComp.compare(movie_missing_description,movie_missing_name) == 0);           //compare to missing name
        assertTrue(movieNameComp.compare(movie_missing_description,movie_missing_genre) == 0);           //compare to missing genre
        assertTrue(movieNameComp.compare(movie_missing_description,movie_invalid_rating) == 0);          //compare to invalid rating
        assertTrue(movieNameComp.compare(movie_missing_description,movie_name_case_sensitivity) < 0);   //compare to movie name case sensitivity
        assertTrue(movieNameComp.compare(movie_missing_description,movie_same_name_diff_rating) < 0);   //compare to same name different rating
        assertTrue(movieNameComp.compare(movie_missing_description,movie_same_rating_diff_name) < 0);   //compare to same rating different name

        //test missing genre compare to other cases
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_normal_data) < 0);                 //compare to normal data
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_another_normal_data) < 0);         //compare to another normal data
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_empty_data) == 0);             //compare to empty data
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_missing_name) == 0);           //compare to missing name
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_missing_description) == 0);     //compare to missing description
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_invalid_rating) == 0);          //compare to invalid rating
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_name_case_sensitivity) < 0);   //compare to movie name case sensitivity
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_same_name_diff_rating) < 0);   //compare to same name different rating
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_same_rating_diff_name) < 0);   //compare to same rating different name

        //test invalid rating compare to other cases
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_normal_data) < 0);                 //compare to normal data
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_another_normal_data) < 0);         //compare to another normal data
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_empty_data) == 0);             //compare to empty data
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_missing_name) == 0);           //compare to missing name
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_missing_description) == 0);     //compare to missing description
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_missing_genre) == 0);           //compare to missing genre
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_name_case_sensitivity) < 0);   //compare to movie name case sensitivity
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_same_name_diff_rating) < 0);   //compare to same name different rating
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_same_rating_diff_name) < 0);   //compare to same rating different name

        //test movie name case sensitivity compare to other cases
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_normal_data) < 0);                 //compare to normal data
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_same_content) < 0);           //compare to same content
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_another_normal_data) > 0);     //compare to another normal data
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_empty_data) > 0);              //compare to empty data
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_missing_name) > 0);            //compare to missing name
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_missing_description) > 0);     //compare to missing description
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_missing_genre) > 0);           //compare to missing genre
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_invalid_rating) > 0);          //compare to invalid rating
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_same_name_diff_rating) < 0);   //compare to same name different rating
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_same_rating_diff_name) > 0);   //compare to same rating different name

        //test same name different rating compare to other cases
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_normal_data) == 0);                 //compare to normal data
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_same_content) == 0);           //compare to same content
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_another_normal_data) > 0);     //compare to another normal data
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_empty_data) > 0);              //compare to empty data
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_missing_name) > 0);            //compare to missing name
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_missing_description) > 0);     //compare to missing description
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_missing_genre) > 0);           //compare to missing genre
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_invalid_rating) > 0);          //compare to invalid rating
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_name_case_sensitivity) > 0);   //compare to movie name case sensitivity
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_same_rating_diff_name) > 0);   //compare to same rating different name

        //test same rating different name compare to other cases
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_normal_data) < 0);                 //compare to normal data
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_same_content) < 0);           //compare to same content
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_another_normal_data) > 0);     //compare to another normal data
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_empty_data) > 0);              //compare to empty data
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_missing_name) > 0);            //compare to missing name
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_missing_description) > 0);     //compare to missing description
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_missing_genre) > 0);           //compare to missing genre
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_invalid_rating) > 0);          //compare to invalid rating
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_name_case_sensitivity) < 0);           //compare to movie name case sensitivity
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_same_name_diff_rating) < 0);   //compare to same name different rating

        //test same case comparison
        assertTrue(movieNameComp.compare(movie_normal_data,movie_normal_data) == 0);
        assertTrue(movieNameComp.compare(movie_same_content,movie_same_content) == 0);
        assertTrue(movieNameComp.compare(movie_another_normal_data,movie_another_normal_data) == 0);
        assertTrue(movieNameComp.compare(movie_empty_data,movie_empty_data) == 0);
        assertTrue(movieNameComp.compare(movie_missing_name,movie_missing_name) == 0);
        assertTrue(movieNameComp.compare(movie_missing_description,movie_missing_description) == 0);
        assertTrue(movieNameComp.compare(movie_missing_genre,movie_missing_genre) == 0);
        assertTrue(movieNameComp.compare(movie_invalid_rating,movie_invalid_rating) == 0);
        assertTrue(movieNameComp.compare(movie_name_case_sensitivity,movie_name_case_sensitivity) == 0);
        assertTrue(movieNameComp.compare(movie_same_name_diff_rating,movie_same_name_diff_rating) == 0);
        assertTrue(movieNameComp.compare(movie_same_rating_diff_name,movie_same_rating_diff_name) == 0);
    }

    @Test
    public void testRatingCompares() throws Exception {
        //test normal data compare to other cases
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_same_content) == 0);           //compare to same content
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_another_normal_data) < 0);     //compare to another normal data
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_empty_data) < 0);              //compare to empty data
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_missing_name) < 0);            //compare to missing name
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_missing_description) < 0);     //compare to missing description
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_missing_genre) < 0);           //compare to missing genre
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_invalid_rating) < 0);          //compare to invalid rating
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_name_case_sensitivity) == 0);   //compare to movie name case sensitivity
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_same_name_diff_rating) < 0);   //compare to same name different rating
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_same_rating_diff_name) == 0);   //compare to same rating different name

        //test empty data compare to other cases
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_normal_data) > 0);                 //compare to normal data
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_another_normal_data) > 0);         //compare to another normal data
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_missing_name) == 0);             //compare to missing name
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_missing_description) == 0);     //compare to missing description
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_missing_genre) == 0);           //compare to missing genre
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_invalid_rating) == 0);          //compare to invalid rating
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_name_case_sensitivity) > 0);   //compare to movie name case sensitivity
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_same_name_diff_rating) > 0);   //compare to same name different rating
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_same_rating_diff_name) > 0);   //compare to same rating different name

        //test missing name compare to other cases
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_normal_data) > 0);                 //compare to normal data
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_another_normal_data) > 0);         //compare to another normal data
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_empty_data) == 0);             //compare to empty data
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_missing_description) == 0);     //compare to missing description
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_missing_genre) == 0);           //compare to missing genre
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_invalid_rating) == 0);          //compare to invalid rating
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_name_case_sensitivity) > 0);   //compare to movie name case sensitivity
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_same_name_diff_rating) > 0);   //compare to same name different rating
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_same_rating_diff_name) > 0);   //compare to same rating different name

        //test missing description compare to other cases
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_normal_data) > 0);                 //compare to normal data
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_another_normal_data) > 0);         //compare to another normal data
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_empty_data) == 0);             //compare to empty data
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_missing_name) == 0);           //compare to missing name
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_missing_genre) == 0);           //compare to missing genre
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_invalid_rating) == 0);          //compare to invalid rating
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_name_case_sensitivity) > 0);   //compare to movie name case sensitivity
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_same_name_diff_rating) > 0);   //compare to same name different rating
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_same_rating_diff_name) > 0);   //compare to same rating different name

        //test missing genre compare to other cases
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_normal_data) > 0);                 //compare to normal data
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_another_normal_data) > 0);         //compare to another normal data
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_empty_data) == 0);             //compare to empty data
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_missing_name) == 0);           //compare to missing name
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_missing_description) == 0);     //compare to missing description
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_invalid_rating) == 0);          //compare to invalid rating
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_name_case_sensitivity) > 0);   //compare to movie name case sensitivity
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_same_name_diff_rating) > 0);   //compare to same name different rating
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_same_rating_diff_name) > 0);   //compare to same rating different name

        //test invalid rating compare to other cases
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_normal_data) > 0);                 //compare to normal data
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_another_normal_data) > 0);         //compare to another normal data
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_empty_data) == 0);             //compare to empty data
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_missing_name) == 0);           //compare to missing name
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_missing_description) == 0);     //compare to missing description
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_missing_genre) == 0);           //compare to missing genre
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_name_case_sensitivity) > 0);   //compare to movie name case sensitivity
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_same_name_diff_rating) > 0);   //compare to same name different rating
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_same_rating_diff_name) > 0);   //compare to same rating different name

        //test movie name case sensitivity compare to other cases
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_normal_data) == 0);                 //compare to normal data
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_same_content) == 0);           //compare to same content
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_another_normal_data) < 0);     //compare to another normal data
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_empty_data) < 0);              //compare to empty data
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_missing_name) < 0);            //compare to missing name
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_missing_description) < 0);     //compare to missing description
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_missing_genre) < 0);           //compare to missing genre
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_invalid_rating) < 0);          //compare to invalid rating
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_same_name_diff_rating) < 0);   //compare to same name different rating
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_same_rating_diff_name) == 0);   //compare to same rating different name

        //test same name different rating compare to other cases
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_normal_data) > 0);                 //compare to normal data
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_same_content) > 0);           //compare to same content
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_another_normal_data) > 0);     //compare to another normal data
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_empty_data) < 0);              //compare to empty data
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_missing_name) < 0);            //compare to missing name
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_missing_description) < 0);     //compare to missing description
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_missing_genre) < 0);           //compare to missing genre
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_invalid_rating) < 0);          //compare to invalid rating
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_name_case_sensitivity) > 0);   //compare to movie name case sensitivity
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_same_rating_diff_name) > 0);   //compare to same rating different name

        //test same rating different name compare to other cases
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_normal_data) == 0);                 //compare to normal data
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_same_content) == 0);           //compare to same content
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_another_normal_data) < 0);     //compare to another normal data
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_empty_data) < 0);              //compare to empty data
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_missing_name) < 0);            //compare to missing name
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_missing_description) < 0);     //compare to missing description
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_missing_genre) < 0);           //compare to missing genre
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_invalid_rating) < 0);          //compare to invalid rating
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_name_case_sensitivity) == 0);           //compare to movie name case sensitivity
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_same_name_diff_rating) < 0);   //compare to same name different rating

        //test same case comparison
        assertTrue(movieRatingComp.compare(movie_normal_data,movie_normal_data) == 0);
        assertTrue(movieRatingComp.compare(movie_same_content,movie_same_content) == 0);
        assertTrue(movieRatingComp.compare(movie_another_normal_data,movie_another_normal_data) == 0);
        assertTrue(movieRatingComp.compare(movie_empty_data,movie_empty_data) == 0);
        assertTrue(movieRatingComp.compare(movie_missing_name,movie_missing_name) == 0);
        assertTrue(movieRatingComp.compare(movie_missing_description,movie_missing_description) == 0);
        assertTrue(movieRatingComp.compare(movie_missing_genre,movie_missing_genre) == 0);
        assertTrue(movieRatingComp.compare(movie_invalid_rating,movie_invalid_rating) == 0);
        assertTrue(movieRatingComp.compare(movie_name_case_sensitivity,movie_name_case_sensitivity) == 0);
        assertTrue(movieRatingComp.compare(movie_same_name_diff_rating,movie_same_name_diff_rating) == 0);
        assertTrue(movieRatingComp.compare(movie_same_rating_diff_name,movie_same_rating_diff_name) == 0);
    }

}