package comp3350.ezcinema.tests.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Seat;
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
    private ArrayList<Seat> seats;

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
        Seat seat;

        movies = new ArrayList<Movie>();
        movie = new Movie("Ferdinand","After Ferdinand, a bull with a big heart, is mistaken for a dangerous beast, he is captured and torn from his home. Determined to return to his family, he rallies a misfit team on the ultimate adventure.","Family" ,6.7);
        movies.add(movie);
        movie = new Movie( "Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4);
        movies.add(movie);
        movie = new Movie("Jumangi: Welcome to the Jungle", "our teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game.", "Thriller", 5.8);
        movies.add(movie);
        movie = new Movie( "Peter Rabbit", "Feature adaptation of Beatrix Potter's classic tale of a rebellious rabbit trying to sneak into a farmer's vegetable garden.", "Family", 5.6);
        movies.add(movie);
        movie = new Movie("Red Sparrow","Ballerina Dominika Egorova is recruited to Sparrow School, a Russian intelligence service where she is forced to use her body as a weapon. Her first mission, targeting a C.I.A. agent, threatens to unravel the security of both nations.","Horror" ,6.7);
        movies.add(movie);
        movie = new Movie("Tomb Raider","Lara Croft, the fiercely independent daughter of a missing adventurer, must push herself beyond her limits when she finds herself on the island where her father disappeared.","Thriller",8.9);
        movies.add(movie);
        movie = new Movie("Unforgettable","The mysterious disappearance of a young woman leads her boyfriend on a journey for truth and perhaps his own unknown reality in this dark, hypnotic mystery that transcends the limitations of traditional narrative.","Thriller" ,5.0);
        movies.add(movie);
        movie = new Movie( "Winchester", "Ensconced in her sprawling California mansion, eccentric firearm heiress Sarah Winchester believes she is haunted by the souls of people killed by the Winchester repeating rifle.", "Horror", 2.8 );
        movies.add(movie);

        theaters = new ArrayList<Theater>();
        theater = new Theater( "Cinema City Northgate","1399 McPhillips Street");
        theaters.add(theater);
        theater = new Theater("Cineplex Odeon McGillivray Cinemas","2190 McGillivray Blvd");
        theaters.add(theater);
        theater = new Theater( "Famous Players Kildonan Place Cinemas","1555 Regent Avenue West");
        theaters.add(theater);
        theater = new Theater("Scotiabank Theatre Winnipeg","817 St.James Street");
        theaters.add(theater);
        theater = new Theater("SilverCity St.Vital Cinemas","160-1225 St.Mary's Road, Winnipeg");
        theaters.add(theater);


        MTs = new ArrayList<MT>();
        ArrayList<String> temp1 = new ArrayList<>();
        temp1.add("14:40");
        temp1.add("18:00");
        temp1.add("21:20");
        mt = new MT("Fifty Shades Freed","Scotiabank Theatre Winnipeg",temp1);
        MTs.add(mt);

        ArrayList<String> temp2=new ArrayList<>();
        temp2.add("13:30");
        temp2.add("17:40");
        temp2.add("20:25");
        mt= new MT("Fifty Shades Freed","Famous Players Kildonan Place Cinemas",temp2);
        MTs.add(mt);

        ArrayList<String> temp3=new ArrayList<>();
        temp3.add("13:20");
        temp3.add("16:50");
        temp3.add("19:10");
        temp3.add("22:00");
        mt= new MT("Fifty Shades Freed","Cinema City Northgate",temp3);
        MTs.add(mt);

        ArrayList<String> temp4=new ArrayList<>();
        temp4.add("14:00");
        temp4.add("17:40");
        temp4.add("20:30");
        temp4.add("23:40");
        mt= new MT("Fifty Shades Freed","SilverCity St.Vital Cinemas",temp4);
        MTs.add(mt);

        ArrayList<String> temp5=new ArrayList<>();
        temp5.add("12:00");
        temp5.add("15:20");
        temp5.add("19:40");
        mt= new MT("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas",temp5);
        MTs.add(mt);

        ArrayList<String> temp6=new ArrayList<>();
        temp6.add("13:20");
        temp6.add("16:50");
        temp6.add("19:10");
        temp6.add("22:00");
        mt= new MT("Peter Rabbit","Scotiabank Theatre Winnipeg",temp6);
        MTs.add(mt);

        ArrayList<String> temp7=new ArrayList<>();
        temp7.add("12:00");
        temp7.add("15:20");
        temp7.add("19:40");
        mt= new MT("Peter Rabbit","Famous Players Kildonan Place Cinemas",temp7);
        MTs.add(mt);

        ArrayList<String> temp8=new ArrayList<>();
        temp8.add("14:40");
        temp8.add("18:00");
        temp8.add("21:20");
        mt= new MT("Peter Rabbit","Cinema City Northgate",temp8);
        MTs.add(mt);

        ArrayList<String> temp9=new ArrayList<>();
        temp9.add("13:30");
        temp9.add("17:40");
        temp9.add("20:25");
        mt= new MT("Peter Rabbit","SilverCity St.Vital Cinemas",temp9);
        MTs.add(mt);

        ArrayList<String> temp10=new ArrayList<>();
        temp10.add("14:40");
        temp10.add("17:40");
        temp10.add("20:30");
        temp10.add("23:40");
        mt= new MT("Peter Rabbit","Cineplex Odeon McGillivray Cinemas",temp10);
        MTs.add(mt);

        ArrayList<String> temp11=new ArrayList<>();
        temp11.add("14:40");
        temp11.add("18:00");
        temp11.add("21:20");
        mt= new MT("Jumangi: Welcome to the Jungle","Scotiabank Theatre Winnipeg",temp11);
        MTs.add(mt);

        ArrayList<String> temp12=new ArrayList<>();
        temp12.add("14:00");
        temp12.add("17:40");
        temp12.add("20:30");
        temp12.add("23:40");
        mt= new MT("Jumangi: Welcome to the Jungle","Famous Players Kildonan Place Cinemas",temp12);
        MTs.add(mt);

        ArrayList<String> temp13=new ArrayList<>();
        temp13.add("13:20");
        temp13.add("16:50");
        temp13.add("19:10");
        temp13.add("22:00");
        mt= new MT("Jumangi: Welcome to the Jungle","Cinema City Northgate",temp13);
        MTs.add(mt);

        ArrayList<String> temp14=new ArrayList<>();
        temp14.add("12:00");
        temp14.add("15:20");
        temp14.add("19:40");
        mt= new MT("Jumangi: Welcome to the Jungle","SilverCity St.Vital Cinemas",temp14);
        MTs.add(mt);

        ArrayList<String> temp15=new ArrayList<>();
        temp15.add("13:30");
        temp15.add("17:40");
        temp15.add("20:25");
        mt= new MT("Jumangi: Welcome to the Jungle","Cineplex Odeon McGillivray Cinemas",temp15);
        MTs.add(mt);

        ArrayList<String> temp16=new ArrayList<>();
        temp16.add("13:30");
        temp16.add("17:40");
        temp16.add("20:25");
        mt= new MT("Winchester","Scotiabank Theatre Winnipeg",temp16);
        MTs.add(mt);

        ArrayList<String> temp17=new ArrayList<>();
        temp17.add("13:20");
        temp17.add("16:50");
        temp17.add("19:10");
        temp17.add("22:00");
        mt= new MT("Winchester","Famous Players Kildonan Place Cinemas",temp17);
        MTs.add(mt);

        ArrayList<String> temp18=new ArrayList<>();
        temp18.add("14:00");
        temp18.add("17:40");
        temp18.add("20:30");
        temp18.add("23:40");
        mt= new MT("Winchester","Cinema City Northgate",temp18);
        MTs.add(mt);

        ArrayList<String> temp19=new ArrayList<>();
        temp19.add("12:00");
        temp19.add("15:20");
        temp19.add("19:40");
        mt= new MT("Winchester","SilverCity St.Vital Cinemas",temp19);
        MTs.add(mt);

        ArrayList<String> temp20=new ArrayList<>();
        temp20.add("14:40");
        temp20.add("18:00");
        temp20.add("21:20");
        mt= new MT("Winchester","Cineplex Odeon McGillivray Cinemas",temp20);
        MTs.add(mt);

        ArrayList<String> temp21=new ArrayList<>();
        temp21.add("13:30");
        temp21.add("14:20");
        temp21.add("20:45");
        mt= new MT("Tomb Raider","Scotiabank Theatre Winnipeg",temp21);
        MTs.add(mt);

        ArrayList<String> temp22=new ArrayList<>();
        temp22.add("14:40");
        temp22.add("19:20");
        temp22.add("23:30");
        mt= new MT("Tomb Raider","Famous Players Kildonan Place Cinemas",temp22);
        MTs.add(mt);

        ArrayList<String> temp23=new ArrayList<>();
        temp23.add("12:00");
        temp23.add("16:30");
        temp23.add("20:50");
        mt= new MT("Tomb Raider","Cinema City Northgate",temp23);
        MTs.add(mt);

        ArrayList<String> temp24=new ArrayList<>();
        temp24.add("15:45");
        temp24.add("18:30");
        temp24.add("21:40");
        mt= new MT("Tomb Raider","SilverCity St.Vital Cinemas",temp24);
        MTs.add(mt);

        ArrayList<String> temp25=new ArrayList<>();
        temp25.add("14:20");
        temp25.add("17:50");
        temp25.add("21:20");
        mt= new MT("Tomb Raider","Cineplex Odeon McGillivray Cinemas",temp25);
        MTs.add(mt);

        ArrayList<String> temp26=new ArrayList<>();
        temp26.add("15:00");
        temp26.add("18:10");
        temp26.add("21:50");
        mt= new MT("Red Sparrow","Scotiabank Theatre Winnipeg",temp26);
        MTs.add(mt);

        ArrayList<String> temp27=new ArrayList<>();
        temp27.add("13:40");
        temp27.add("17:00");
        temp27.add("23:10");
        mt= new MT("Red Sparrow","Famous Players Kildonan Place Cinemas",temp27);
        MTs.add(mt);

        ArrayList<String> temp28=new ArrayList<>();
        temp28.add("11:10");
        temp28.add("14:20");
        temp28.add("20:30");
        mt= new MT("Red Sparrow","SilverCity St.Vital Cinemas",temp28);
        MTs.add(mt);

        ArrayList<String> temp29=new ArrayList<>();
        temp29.add("14:10");
        temp29.add("19:50");
        temp29.add("22:30");
        mt= new MT("Red Sparrow","Cinema City Northgate",temp29);
        MTs.add(mt);

        ArrayList<String> temp30=new ArrayList<>();
        temp30.add("15:30");
        temp30.add("19:50");
        temp30.add("21:30");
        mt= new MT("Red Sparrow","Cineplex Odeon McGillivray Cinemas",temp30);
        MTs.add(mt);

        ArrayList<String> temp31=new ArrayList<>();
        temp31.add("12:30");
        temp31.add("16:20");
        temp31.add("21:00");
        mt= new MT("Unforgettable","Scotiabank Theatre Winnipeg",temp31);
        MTs.add(mt);

        ArrayList<String> temp32=new ArrayList<>();
        temp32.add("13:00");
        temp32.add("18:00");
        temp32.add("21:00");
        mt= new MT("Unforgettable","Famous Players Kildonan Place Cinemas",temp32);
        MTs.add(mt);

        ArrayList<String> temp33=new ArrayList<>();
        temp33.add("14:50");
        temp33.add("18:40");
        temp33.add("21:50");
        mt= new MT("Unforgettable","SilverCity St.Vital Cinemas",temp33);
        MTs.add(mt);

        ArrayList<String> temp34=new ArrayList<>();
        temp34.add("12:20");
        temp34.add("15:30");
        temp34.add("18:10");
        mt= new MT("Unforgettable","Cinema City Northgate",temp34);
        MTs.add(mt);

        ArrayList<String> temp35=new ArrayList<>();
        temp35.add("13:00");
        temp35.add("17:30");
        temp35.add("21:20");
        mt= new MT("Unforgettable","Cineplex Odeon McGillivray Cinemas",temp35);
        MTs.add(mt);

        ArrayList<String> temp36=new ArrayList<>();
        temp36.add("13:00");
        temp36.add("16:40");
        temp36.add("21:30");
        mt= new MT("Ferdinand","Scotiabank Theatre Winnipeg",temp36);
        MTs.add(mt);

        ArrayList<String> temp37=new ArrayList<>();
        temp37.add("15:30");
        temp37.add("19:20");
        temp37.add("22:50");
        mt= new MT("Ferdinand","Famous Players Kildonan Place Cinemas",temp37);
        MTs.add(mt);

        ArrayList<String> temp38=new ArrayList<>();
        temp38.add("14:50");
        temp38.add("18:30");
        temp38.add("21:50");
        mt= new MT("Ferdinand","SilverCity St.Vital Cinemas",temp38);
        MTs.add(mt);

        ArrayList<String> temp39=new ArrayList<>();
        temp39.add("10:40");
        temp39.add("14:20");
        temp39.add("19:50");
        mt= new MT("Ferdinand","Cinema City Northgate",temp39);
        MTs.add(mt);

        ArrayList<String> temp40=new ArrayList<>();
        temp40.add("11:25");
        temp40.add("15:40");
        temp40.add("19:35");
        mt= new MT("Ferdinand","Cineplex Odeon McGillivray Cinemas",temp40);
        MTs.add(mt);

        seats= new ArrayList<Seat>();
        seat=new Seat("Ferdinand","Cinema City Northgate","10:40");
        seats.add(seat);

        seat=new Seat("Ferdinand","Cinema City Northgate","14:20");
        seats.add(seat);

        seat=new Seat("Ferdinand","Cinema City Northgate","19:50");
        seats.add(seat);

        seat=new Seat("Ferdinand","Cineplex Odeon McGillivray Cinemas","11:25");
        seats.add(seat);

        seat=new Seat("Ferdinand","Cineplex Odeon McGillivray Cinemas","15:40");
        seats.add(seat);

        seat=new Seat("Ferdinand","Cineplex Odeon McGillivray Cinemas","19:35");
        seats.add(seat);

        seat=new Seat("Ferdinand","Famous Players Kildonan Place Cinemas","15:30");
        seats.add(seat);

        seat=new Seat("Ferdinand","Famous Players Kildonan Place Cinemas","19:20");
        seats.add(seat);

        seat=new Seat("Ferdinand","Famous Players Kildonan Place Cinemas","22:50");
        seats.add(seat);

        seat=new Seat("Ferdinand","Scotiabank Theatre Winnipeg","13:30");
        seats.add(seat);

        seat=new Seat("Ferdinand","Scotiabank Theatre Winnipeg","16:40");
        seats.add(seat);

        seat=new Seat("Ferdinand","Scotiabank Theatre Winnipeg","21:30");
        seats.add(seat);

        seat=new Seat("Ferdinand","SilverCity St.Vital Cinemas","14:50");
        seats.add(seat);

        seat=new Seat("Ferdinand","SilverCity St.Vital Cinemas","18:30");
        seats.add(seat);

        seat=new Seat("Ferdinand","SilverCity St.Vital Cinemas","21:50");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Cinema City Northgate","13:20");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Cinema City Northgate","16:50");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Cinema City Northgate","19:10");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Cinema City Northgate","22:00");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","12:00");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","15:20");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Cineplex Odeon McGillivray Cinemas","19:40");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Famous Players Kildonan Place Cinemas","13:30");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Famous Players Kildonan Place Cinemas","17:40");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Famous Players Kildonan Place Cinemas","20:25");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Scotiabank Theatre Winnipeg","14:40");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Scotiabank Theatre Winnipeg","18:00");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","Scotiabank Theatre Winnipeg","21:20");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","SilverCity St.Vital Cinemas","14:00");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","SilverCity St.Vital Cinemas","17:40");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","SilverCity St.Vital Cinemas","20:30");
        seats.add(seat);

        seat=new Seat("Fifty Shades Freed","SilverCity St.Vital Cinemas","23:40");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Cinema City Northgate","13:20");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Cinema City Northgate","16:50");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Cinema City Northgate","19:10");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Cinema City Northgate","22:00");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Cineplex Odeon McGillivray Cinemas","13:30");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Cineplex Odeon McGillivray Cinemas","17:40");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Cineplex Odeon McGillivray Cinemas","20:25");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Famous Players Kildonan Place Cinemas","14:00");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Famous Players Kildonan Place Cinemas","17:40");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Famous Players Kildonan Place Cinemas","20:30");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Famous Players Kildonan Place Cinemas","23:40");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Scotiabank Theatre Winnipeg","14:40");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Scotiabank Theatre Winnipeg","18:00");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","Scotiabank Theatre Winnipeg","21:20");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","SilverCity St.Vital Cinemas","12:00");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","SilverCity St.Vital Cinemas","15:20");
        seats.add(seat);

        seat=new Seat("Jumangi: Welcome to the Jungle","SilverCity St.Vital Cinemas","19:40");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Cinema City Northgate","14:40");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Cinema City Northgate","18:00");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Cinema City Northgate","21:20");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Cineplex Odeon McGillivray Cinemas","14:40");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Cineplex Odeon McGillivray Cinemas","17:40");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Cineplex Odeon McGillivray Cinemas","20:30");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Cineplex Odeon McGillivray Cinemas","23:40");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Famous Players Kildonan Place Cinemas","12:00");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Famous Players Kildonan Place Cinemas","15:20");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Famous Players Kildonan Place Cinemas","19:40");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Scotiabank Theatre Winnipeg","13:20");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Scotiabank Theatre Winnipeg","16:50");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Scotiabank Theatre Winnipeg","19:10");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","Scotiabank Theatre Winnipeg","22:00");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","SilverCity St.Vital Cinemas","13:30");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","SilverCity St.Vital Cinemas","17:40");
        seats.add(seat);

        seat=new Seat("Peter Rabbit","SilverCity St.Vital Cinemas","20:25");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Cinema City Northgate","14:10");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Cinema City Northgate","19:50");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Cinema City Northgate","22:30");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Cineplex Odeon McGillivray Cinemas","15:30");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Cineplex Odeon McGillivray Cinemas","19:50");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Cineplex Odeon McGillivray Cinemas","21:30");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Famous Players Kildonan Place Cinemas","13:40");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Famous Players Kildonan Place Cinemas","17:00");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Famous Players Kildonan Place Cinemas","23:10");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Scotiabank Theatre Winnipeg","15:00");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Scotiabank Theatre Winnipeg","18:10");
        seats.add(seat);

        seat=new Seat("Red Sparrow","Scotiabank Theatre Winnipeg","21:50");
        seats.add(seat);

        seat=new Seat("Red Sparrow","SilverCity St.Vital Cinemas","11:10");
        seats.add(seat);

        seat=new Seat("Red Sparrow","SilverCity St.Vital Cinemas","14:20");
        seats.add(seat);

        seat=new Seat("Red Sparrow","SilverCity St.Vital Cinemas","20:30");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Cinema City Northgate","12:00");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Cinema City Northgate","16:30");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Cinema City Northgate","20:50");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Cineplex Odeon McGillivray Cinemas","14:20");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Cineplex Odeon McGillivray Cinemas","17:50");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Cineplex Odeon McGillivray Cinemas","21:20");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Famous Players Kildonan Place Cinemas","14:40");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Famous Players Kildonan Place Cinemas","19:20");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Famous Players Kildonan Place Cinemas","23:30");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Scotiabank Theatre Winnipeg","13:30");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Scotiabank Theatre Winnipeg","14:20");
        seats.add(seat);

        seat=new Seat("Tomb Raider","Scotiabank Theatre Winnipeg","20:45");
        seats.add(seat);

        seat=new Seat("Tomb Raider","SilverCity St.Vital Cinemas","15:45");
        seats.add(seat);

        seat=new Seat("Tomb Raider","SilverCity St.Vital Cinemas","18:30");
        seats.add(seat);

        seat=new Seat("Tomb Raider","SilverCity St.Vital Cinemas","21:40");
        seats.add(seat);

        seat=new Seat("Unforgettable","Cinema City Northgate","12:20");
        seats.add(seat);

        seat=new Seat("Unforgettable","Cinema City Northgate","15:30");
        seats.add(seat);

        seat=new Seat("Unforgettable","Cinema City Northgate","18:10");
        seats.add(seat);

        seat=new Seat("Unforgettable","Cineplex Odeon McGillivray Cinemas","13:00");
        seats.add(seat);

        seat=new Seat("Unforgettable","Cineplex Odeon McGillivray Cinemas","17:30");
        seats.add(seat);

        seat=new Seat("Unforgettable","Cineplex Odeon McGillivray Cinemas","21:20");
        seats.add(seat);

        seat=new Seat("Unforgettable","Famous Players Kildonan Place Cinemas","13:00");
        seats.add(seat);

        seat=new Seat("Unforgettable","Famous Players Kildonan Place Cinemas","18:00");
        seats.add(seat);

        seat=new Seat("Unforgettable","Famous Players Kildonan Place Cinemas","21:00");
        seats.add(seat);

        seat=new Seat("Unforgettable","Scotiabank Theatre Winnipeg","12:30");
        seats.add(seat);

        seat=new Seat("Unforgettable","Scotiabank Theatre Winnipeg","16:20");
        seats.add(seat);

        seat=new Seat("Unforgettable","Scotiabank Theatre Winnipeg","21:00");
        seats.add(seat);

        seat=new Seat("Unforgettable","SilverCity St.Vital Cinemas","14:50");
        seats.add(seat);

        seat=new Seat("Unforgettable","SilverCity St.Vital Cinemas","18:40");
        seats.add(seat);

        seat=new Seat("Unforgettable","SilverCity St.Vital Cinemas","21:50");
        seats.add(seat);

        seat=new Seat("Winchester","Cinema City Northgate","14:00");
        seats.add(seat);

        seat=new Seat("Winchester","Cinema City Northgate","17:40");
        seats.add(seat);

        seat=new Seat("Winchester","Cinema City Northgate","20:30");
        seats.add(seat);

        seat=new Seat("Winchester","Cinema City Northgate","23:40");
        seats.add(seat);

        seat=new Seat("Winchester","Cineplex Odeon McGillivray Cinemas","14;40");
        seats.add(seat);

        seat=new Seat("Winchester","Cineplex Odeon McGillivray Cinemas","18:00");
        seats.add(seat);

        seat=new Seat("Winchester","Cineplex Odeon McGillivray Cinemas","21:20");
        seats.add(seat);

        seat=new Seat("Winchester","Famous Players Kildonan Place Cinemas","13:20");
        seats.add(seat);

        seat=new Seat("Winchester","Famous Players Kildonan Place Cinemas","16:50");
        seats.add(seat);

        seat=new Seat("Winchester","Famous Players Kildonan Place Cinemas","19:10");
        seats.add(seat);

        seat=new Seat("Winchester","Famous Players Kildonan Place Cinemas","22:00");
        seats.add(seat);

        seat=new Seat("Winchester","Scotiabank Theatre Winnipeg","13:30");
        seats.add(seat);

        seat=new Seat("Winchester","Scotiabank Theatre Winnipeg","17:40");
        seats.add(seat);

        seat=new Seat("Winchester","Scotiabank Theatre Winnipeg","20:25");
        seats.add(seat);

        seat=new Seat("Winchester","SilverCity St.Vital Cinemas","12:00");
        seats.add(seat);

        seat=new Seat("Winchester","SilverCity St.Vital Cinemas","15:20");
        seats.add(seat);

        seat=new Seat("Winchester","SilverCity St.Vital Cinemas","19:40");
        seats.add(seat);

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
    public ArrayList<String> getShowtimeList(Movie movie, Theater theater)
    {
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
    public String getTheaterAddress(String theaterName)
    {
        for(int i=0;i<theaters.size();i++)
        {
            if (theaters.get(i).getTheaterName().equals(theaterName))
            {
                return theaters.get(i).getTheaterAddress();
            }
        }
        return null; //if cannot find the theater
    }

    @Override
    public String updateStatus(MT seat, String time, int row, int col)
    {
        String result=null;
        if(checkStatus( seat, time, row, col) == 0)
        {
            for(int i=0; i<seats.size(); i++)
            {
                if(seat.getMovieName()==seats.get(i).getMovieName() && seat.getTheaterName()==seats.get(i).getTheaterName() && time==seats.get(i).getShowtime()) {
                    seats.get(i).getTable()[row][col] = 1;
                }
            }

        }else {
            if (checkStatus(seat, time, row, col) == 1)
                result = "Seat already claimed";
            else {
                result = "Error: Doesn't exist";
            }
        }
        return result;
    }


    @Override
    public int countRemain(MT seat, String time)
    {
        int result=0;
        int[][] table;

        if(seat != null && time != null ) {
            for (int i = 0; i < seats.size(); i++) {
                if (seat.getMovieName() == seats.get(i).getMovieName() && seat.getTheaterName() == seats.get(i).getTheaterName() && time == seats.get(i).getShowtime()) {
                    table = seats.get(i).getTable();
                    for (int m = 0; m < table.length; m++) {
                        for (int n = 0; n < table[m].length; n++) {
                            if (table[m][n] == 0) {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        else
        {
            result = -1;
        }

        return result;
    }

    @Override
    public int checkStatus(MT seat, String time, int row, int col)
    {
        int result=-1;
        if(seat != null && time != null && row >= 0 && row < 5 && col >= 0 && col < 5) {
            for (int i = 0; i < seats.size(); i++) {
                if (seat.getMovieName() == seats.get(i).getMovieName() && seat.getTheaterName() == seats.get(i).getTheaterName() && time == seats.get(i).getShowtime()) {
                    if (seats.get(i).getTable()[row][col] == 0)
                        result = 0;
                    else
                        result = 1;
                }
            }
        }
        return result;
    }
}