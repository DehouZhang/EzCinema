package comp3350.ezcinema.persistence;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

import comp3350.ezcinema.objects.MT;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;

public class DataAccessObject implements DataAccess
{
    private Statement st1,st2,st3,st4,st5;
    private Connection c1;
    private ResultSet rs2,rs3,rs4,rs5,rs6,rs7;

    private String dbName;
    private String dbType;

    private ArrayList<Movie> movies;
    private ArrayList<Theater> theaters;
    private ArrayList<String> showtimes;

    private String cmdString;
    private int updateCount;
    private String result;
    private static String EOF="  ";

    public DataAccessObject(String dbName)
    {
        this.dbName=dbName;
    }

    public void open(String dbPath)
    {
        String url;
        try
        {
            // Setup for HSQL
            dbType = "HSQL";
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            url = "jdbc:hsqldb:file:" + dbPath; // stored on disk mode
            c1 = DriverManager.getConnection(url, "SA", "");
            st1 = c1.createStatement();
            st2 = c1.createStatement();
            st3 = c1.createStatement();
            st4 = c1.createStatement();
        }
        catch (Exception e)
        {
            processSQLError(e);
        }
        System.out.println("Opened " +dbType +" database " +dbPath);
    }

    @Override
    public void close()
    {
        try
        {	// commit all changes to the database
            cmdString = "shutdown compact";
            rs2 = st1.executeQuery(cmdString);
            c1.close();
        }
        catch (Exception e)
        {
            processSQLError(e);
        }
        System.out.println("Closed " +dbType +" database " +dbName);
    }

    @Override
    public String getMovieSequential(List<Movie> movieResult)
    {
        Movie movie;
        String myMovieName,myDescription,myGenre;
        myMovieName = EOF;
        myDescription = EOF;
        myGenre = EOF;
        double myRating=0;

        result=null;
        try
        {
            cmdString = "Select * from Movies";
            rs2 = st1.executeQuery(cmdString);
        }
        catch (Exception e)
        {
            processSQLError(e);
        }
        try
        {
            while (rs2.next())
            {
                myMovieName = rs2.getString("MovieName");
                myDescription=rs2.getString("Description");
                myRating=rs2.getDouble("Rating");
                myGenre=rs2.getString("Genre");
                movie= new Movie(myMovieName,myDescription,myGenre,myRating);
                movieResult.add(movie);
            }
            rs2.close();
        }
        catch (Exception e)
        {
            result = processSQLError(e);
        }
        return result;
    }


    @Override
    public String getTheaterSequential(List<Theater> theaterResult)
    {
        Theater theater;
        String myTheaterName,myAddress;
        myTheaterName=EOF;
        myAddress=EOF;

        result=null;
        try
        {
            cmdString = "Select * from Theaters";
            rs3=st2.executeQuery(cmdString);
            while(rs3.next())
            {
                myTheaterName=rs3.getString("TheaterName");
                myAddress=rs3.getString("Address");
                theater=new Theater(myTheaterName,myAddress);
                theaterResult.add(theater);
            }
            rs3.close();
        }
        catch (Exception e)
        {
            result = processSQLError(e);
        }
        return result;
    }

    public ArrayList<String> getShowtimeList(Movie movie, Theater theater)
    {
        String showtime;
        showtimes=new ArrayList<String>();
        try
        {
            cmdString="Select Distinct Showtime from MovieTheaters where MovieName='"+movie.getMovieName()+"' and TheaterName='"+theater.getTheaterName()+"'";
            rs4=st3.executeQuery(cmdString);
            while (rs4.next())
            {
                showtime=rs4.getString("Showtime");
                showtimes.add(showtime);
            }
            rs4.close();
        }
        catch (Exception e)
        {
            processSQLError(e);
        }
        return showtimes;
    }

    public String getTheaterAddress(String theaterName)
    {
        //todo implement this

        String addr = "";
        try
        {
            cmdString="Select Address from Theaters where TheaterName='"+theaterName+"'";
            rs5=st4.executeQuery(cmdString);

            while (rs5.next())
            {
                addr=rs5.getString("Address");
            }

            rs5.close();
        }
        catch (Exception e)
        {
            processSQLError(e);
        }
        return addr;
    }

    public String updateStatus(MT seat,String time, int row, int col)
    {
        String values;
        String where;

        result=null;
        try
        {
            values="Status="+1;
            where="where MovieName='"+seat.getMovieName()+"' and TheaterName='"+seat.getTheaterName()+"' and Showtime='"+time+"' and Row="+row+" and Col="+col;
            cmdString= "Update MovieTheaters "+" Set "+values+" "+where;
            updateCount = st5.executeUpdate(cmdString);
            result = checkWarning(st5, updateCount);
        }
        catch (Exception e)
        {
            result=processSQLError(e);
        }
        return result;
    }

    public int countRemain(MT seat,String time)
    {
        int result=-1;
        String where;

        try
        {
            where="where MovieName='"+seat.getMovieName()+"' and TheaterName='"+seat.getTheaterName()+"' and Showtime='"+time+"' and Status=0";
            cmdString="Select Count (*) from MovieTheaters"+where;
            rs6=st5.executeQuery(cmdString);
            rs6.next();
            result=rs6.getInt(1);
        }
        catch (Exception e)
        {
            processSQLError(e);
        }

        return result;
    }

    public int checkStatus(MT seat, String time, int row, int col)
    {
        int result=-1;
        String where;
        try
        {
            where="where MovieName='"+seat.getMovieName()+"' and TheaterName='"+seat.getTheaterName()+"' and Showtime='"+time+"' and Row="+row+" and Col="+col;
            cmdString="Select Status From MovieTheaters "+where;
            rs7=st5.executeQuery(cmdString);
            rs7.next();
            result=rs7.getInt(1);
        }
        catch (Exception e)
        {
            processSQLError(e);
        }
        return result;
    }

    public String processSQLError(Exception e)
    {
        String result = "*** SQL Error: " + e.getMessage();

        // Remember, this will NOT be seen by the user!
        e.printStackTrace();

        return result;
    }

    public String checkWarning(Statement st, int updateCount)
    {
        String result;

        result = null;
        try
        {
            SQLWarning warning = st.getWarnings();
            if (warning != null)
            {
                result = warning.getMessage();
            }
        }
        catch (Exception e)
        {
            result = processSQLError(e);
        }
        if (updateCount != 1)
        {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }
}
