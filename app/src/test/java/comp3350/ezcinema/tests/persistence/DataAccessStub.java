package comp3350.ezcinema.tests.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.persistence.DataAccess;

public class DataAccessStub implements DataAccess
{
    private String dbName;
    private String dbType = "stub";

    private ArrayList<Movie> movies;
    private ArrayList<Theater> theaters;
    private ArrayList<MT> MTs;
    private ArrayList<String> showtimes = new ArrayList<>();

    public DataAccessStub(String dbName)
    {
        this.dbName = dbName;
    }

    public DataAccessStub()
    {
        this(Main.dbName);
    }


    public void open(String dbName)
    {
        Movie movie;
        Theater theater;
        MT mt;

        movies = new ArrayList<Movie>();
        movie = new Movie( "Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship..", "Family", 6.4);
        movies.add(movie);
        movie = new Movie( "Peter Rabbit", "Feature adaptation of Beatrix Potter's classic tale of a rebellious rabbit trying to sneak into a farmer's vegetable garden.", "Family", 5.6);
        movies.add(movie);
        movie = new Movie("Jumangi: Welcome to the Jungle", "our teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game.", "Thriller", 5.8);
        movies.add(movie);
        movie = new Movie( "Winchester", "Ensconced in her sprawling California mansion, eccentric firearm heiress Sarah Winchester believes she is haunted by the souls of people killed by the Winchester repeating rifle.", "Horror", 2.8 );
        movies.add(movie);
        movie = new Movie("Tomb Raider","Lara Croft, the fiercely independent daughter of a missing adventurer, must push herself beyond her limits when she finds herself on the island where her father disappeared.","Thriller",8.9);
        movies.add(movie);
        movie = new Movie("Red Sparrow","Ballerina Dominika Egorova is recruited to Sparrow School, a Russian intelligence service where she is forced to use her body as a weapon. Her first mission, targeting a C.I.A. agent, threatens to unravel the security of both nations.","Horror" ,6.7);
        movies.add(movie);
        movie = new Movie("Unforgettable","The mysterious disappearance of a young woman leads her boyfriend on a journey for truth and perhaps his own unknown reality in this dark, hypnotic mystery that transcends the limitations of traditional narrative.","Thriller" ,5.0);
        movies.add(movie);
        movie = new Movie("Ferdinand","After Ferdinand, a bull with a big heart, is mistaken for a dangerous beast, he is captured and torn from his home. Determined to return to his family, he rallies a misfit team on the ultimate adventure.","Family" ,6.7);
        movies.add(movie);

        theaters = new ArrayList<Theater>();
        theater = new Theater("Scotiabank Theatre Winnipeg","817 St. James Street");
        theaters.add(theater);
        theater = new Theater( "Famous Players Kildonan Place Cinemas","1555 Regent Avenue West");
        theaters.add(theater);
        theater = new Theater( "Cinema City Northgate","1399 McPhillips Street");
        theaters.add(theater);
        theater = new Theater("SilverCity St. Vital Cinemas","160-1225 St. Mary's Road, Winnipeg");
        theaters.add(theater);
        theater = new Theater("Cineplex Odeon McGillivray Cinemas","2190 McGillivray Blvd");
        theaters.add(theater);

        MTs = new ArrayList<MT>();
        showtimes.clear();
        showtimes.add("14:40");
        showtimes.add("18:00");
        showtimes.add("21:20");
        mt = new MT("Fifty Shades Freed","Scotiabank Theatre Winnpeg",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:30");
        showtimes.add("17:40");
        showtimes.add("20:25");
        mt= new MT("Fifty Shades Freed","Famous Players Kildonan Place Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:20");
        showtimes.add("16:50");
        showtimes.add("19:10");
        showtimes.add("22:00");
        mt= new MT("Fifty Shades Freed","Cinema City Northgate",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:00");
        showtimes.add("17:40");
        showtimes.add("20:30");
        showtimes.add("23:40");
        mt= new MT("Fifty Shades Freed","SilverCity St.Vital Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("12:00");
        showtimes.add("15:20");
        showtimes.add("19:40");
        mt= new MT("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:20");
        showtimes.add("16:50");
        showtimes.add("19:10");
        showtimes.add("22:00");
        mt= new MT("Peter Rabbit","Scotiabank Theatre Winnpeg",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("12:00");
        showtimes.add("15:20");
        showtimes.add("19:40");
        mt= new MT("Peter Rabbit","Famous Players Kildonan Place Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:40");
        showtimes.add("18:00");
        showtimes.add("21:20");
        mt= new MT("Peter Rabbit","Cinema City Northgate",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:30");
        showtimes.add("17:40");
        showtimes.add("20:25");
        mt= new MT("Peter Rabbit","SilverCity St.Vital Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:40");
        showtimes.add("17:40");
        showtimes.add("20:30");
        showtimes.add("23:40");
        mt= new MT("Peter Rabbit","Cineplex Odeon McGillivray Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:40");
        showtimes.add("18:00");
        showtimes.add("21:20");
        mt= new MT("Jumangi: Welcome to the Jungle","Scotiabank Theatre Winnpeg",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:00");
        showtimes.add("17:40");
        showtimes.add("20:30");
        showtimes.add("23:40");
        mt= new MT("Jumangi: Welcome to the Jungle","Famous Players Kildonan Place Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:20");
        showtimes.add("16:50");
        showtimes.add("19:10");
        showtimes.add("22:00");
        mt= new MT("Jumangi: Welcome to the Jungle","Cinema City Northgate",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("12:00");
        showtimes.add("15:20");
        showtimes.add("19:40");
        mt= new MT("Jumangi: Welcome to the Jungle","SilverCity St.Vital Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:30");
        showtimes.add("17:40");
        showtimes.add("20:25");
        mt= new MT("Jumangi: Welcome to the Jungle","Cineplex Odeon McGillivray Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:30");
        showtimes.add("17:40");
        showtimes.add("20:25");
        mt= new MT("Winchester","Scotiabank Theatre Winnpipeg",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:20");
        showtimes.add("16:50");
        showtimes.add("19:10");
        showtimes.add("22:00");
        mt= new MT("Winchester","Famous Players Kildonan Place Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:00");
        showtimes.add("17:40");
        showtimes.add("20:30");
        showtimes.add("23:40");
        mt= new MT("Winchester","Cinema City Northgate",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("12:00");
        showtimes.add("15:20");
        showtimes.add("19:40");
        mt= new MT("Winchester","SilverCity St.Vital Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:40");
        showtimes.add("18:00");
        showtimes.add("21:20");
        mt= new MT("Winchester","Cineplex Odeon McGillivray Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:30");
        showtimes.add("14:20");
        showtimes.add("20:45");
        mt= new MT("Tomb Raider","Scotiabank Theatre Winnpipeg",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:40");
        showtimes.add("19:20");
        showtimes.add("23:30");
        mt= new MT("Tomb Raider","Famous Players Kildonan Place Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("12:00");
        showtimes.add("16:30");
        showtimes.add("20:50");
        mt= new MT("Tomb Raider","Cinema City Northgate",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("15:45");
        showtimes.add("18:30");
        showtimes.add("21:40");
        mt= new MT("Tomb Raider","SilverCity St.Vital Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:20");
        showtimes.add("17:50");
        showtimes.add("21:20");
        mt= new MT("Tomb Raider","Cineplex Odeon McGillivray Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("15:00");
        showtimes.add("18:10");
        showtimes.add("21:50");
        mt= new MT("Red Sparrow","Scotiabank Theatre Winnpipeg",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:40");
        showtimes.add("17:00");
        showtimes.add("23:10");
        mt= new MT("Red Sparrow","Famous Players Kildonan Place Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("11:10");
        showtimes.add("14:20");
        showtimes.add("20:30");
        mt= new MT("Red Sparrow","SilverCity St.Vital Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:10");
        showtimes.add("19:50");
        showtimes.add("22:30");
        mt= new MT("Red Sparrow","Cinema City Northgate",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("15:30");
        showtimes.add("19:50");
        showtimes.add("21:30");
        mt= new MT("Red Sparrow","Cineplex Odeon McGillivray Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("12:30");
        showtimes.add("16:20");
        showtimes.add("21:00");
        mt= new MT("Unforgettable","Scotiabank Theatre Winnpipeg",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:00");
        showtimes.add("18:00");
        showtimes.add("21:00");
        mt= new MT("Unforgettable","Famous Player Kildonan Place Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:50");
        showtimes.add("18:40");
        showtimes.add("21:50");
        mt= new MT("Unforgettable","SilverCity St.Vital Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("12:20");
        showtimes.add("15:30");
        showtimes.add("18:10");
        mt= new MT("Unforgettable","Cinema City Northgate",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:00");
        showtimes.add("17:30");
        showtimes.add("21:20");
        mt= new MT("Unforgettable","Cineplex Odeon McGillivray Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("13:00");
        showtimes.add("16:40");
        showtimes.add("21:30");
        mt= new MT("Ferdinand","Scotiabank Theatre Winnpipeg",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("15:30");
        showtimes.add("19:20");
        showtimes.add("22:50");
        mt= new MT("Ferdinand","Famous Player Kildonan Place Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("14:50");
        showtimes.add("18:30");
        showtimes.add("21:50");
        mt= new MT("Ferdinand","SilverCity St.Vital Cinemas",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("10:40");
        showtimes.add("14:20");
        showtimes.add("19:50");
        mt= new MT("Ferdinand","Cinema City Northgate",showtimes);
        MTs.add(mt);

        showtimes.clear();
        showtimes.add("11:25");
        showtimes.add("15:40");
        showtimes.add("19:35");
        mt= new MT("Ferdinand","Cineplex Odeon McGillivray Cinemas",showtimes);
        MTs.add(mt);

        System.out.println("Opened " +dbType +" database " +dbName);
    }

    public void close()
    {
        System.out.println("Closed " +dbType +" database " +dbName);
    }

    public String getMovieSequential(List<Movie> movieResult)
    {
        movieResult.addAll(movies);
        return null;
    }

    public String getTheaterSequential(List<Theater> theaterResult)
    {
        theaterResult.addAll(theaters);
        return null;
    }

    @Override
    public ArrayList<String> getShowtimeList(Movie movie, Theater theater) {
        for(int i=0;i<MTs.size();i++)
        {
            if(movie.getMovieName().equals(MTs.get(i).getMovieName()) && theater.getTheaterName().equals(MTs.get(i).getTheaterName()))
            {
                return MTs.get(i).getShowtime();
            }
        }
        return null;    //if cannot find the movie and the theater
    }

    @Override
    public String getTheaterAddress(String theaterName) {
        for(int i=0;i<theaters.size();i++)
        {
            if (theaters.get(i).getTheaterName().equals(theaterName))
            {
                return theaters.get(i).getTheaterName();
            }
        }
        return null; //if cannot find the theater
    }
}