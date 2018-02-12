package comp3350.ezcinema.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.objects.Movie;
import comp3350.ezcinema.objects.Theater;

public class DataAccessStub
{
	private String dbName;
	private String dbType = "stub";

	private ArrayList<Movie> movies;
	private ArrayList<Theater> theaters;

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

		movies = new ArrayList<Movie>();
		movie = new Movie("1", "Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship..", "Porn?", 3.4);//TODO change genre before handin
		movies.add(movie);
		movie = new Movie("2", "Peter Rabbit", "Feature adaptation of Beatrix Potter's classic tale of a rebellious rabbit trying to sneak into a farmer's vegetable garden.", "Family", 5.6);
		movies.add(movie);
		movie = new Movie("3", "Jumangi: Welcome to the Jungle", "our teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game.", "Thriller", 5.8);
		movies.add(movie);
		movie = new Movie("4", "Winchester", "Ensconced in her sprawling California mansion, eccentric firearm heiress Sarah Winchester believes she is haunted by the souls of people killed by the Winchester repeating rifle.", "Horror", 2.8 );
		movies.add(movie);

		theaters = new ArrayList<Theater>();
		theater = new Theater("1", "Scotiabank Theatre Winnipeg","817 St. James Street");
		theaters.add(theater);
		theater = new Theater("3", "Famous Players Kildonan Place Cinemas","1555 Regent Avenue West,");
		theaters.add(theater);
		theater = new Theater("2", "Cinema City Northgate","1399 McPhillips Street");
		theaters.add(theater);
		theater = new Theater("4", "SilverCity St. Vital Cinemas","160-1225 St. Mary's Road, Winnipeg");
		theaters.add(theater);

		System.out.println("Opened " +dbType +" database " +dbName);
	}

	public void close()
	{
		System.out.println("Closed " +dbType +" database " +dbName);
	}

	public String getMoviesSequential(ArrayList<Movie> movieResult)
	{
        movieResult.addAll(movies);
		return null;
	}



	public ArrayList<Movie> getStudentRandom(Movie currentMovie)
	{
		ArrayList<Movie> newMovies;
		int index;
		
		newMovies = new ArrayList<Movie>();
		index = movies.indexOf(currentMovie);
		if (index >= 0)
		{
			newMovies.add(movies.get(index));
		}
		return newMovies;
	}



	public String insertStudent(Movie currentMovie)
	{
		// don't bother checking for duplicates
		movies.add(currentMovie);
		return null;
	}




	public String updateStudent(Movie currentMovie)
	{
		int index;
		
		index = movies.indexOf(currentMovie);
		if (index >= 0)
		{
			movies.set(index, currentMovie);
		}
		return null;
	}



	public String deleteStudent(Movie currentMovie)
	{
		int index;
		
		index = movies.indexOf(currentMovie);
		if (index >= 0)
		{
			movies.remove(index);
		}
		return null;
	}


	public String getTheaterSequential(List<Theater> theaterResult)
	{
        theaterResult.addAll(theaters);
		return null;
	}



	public ArrayList<Theater> getCourseRandom(Theater currentTheater)
	{
		ArrayList<Theater> newCours;
		int index;
		
		newCours = new ArrayList<Theater>();
		index = theaters.indexOf(currentTheater);
		if (index >= 0)
		{
			newCours.add(theaters.get(index));
		}
		return newCours;
	}

	public String insertCourse(Theater currentTheater)
	{
		// don't bother checking for duplicates
		theaters.add(currentTheater);
		return null;
	}

	public String updateCourse(Theater currentTheater)
	{
		int index;
		
		index = theaters.indexOf(currentTheater);
		if (index >= 0)
		{
			theaters.set(index, currentTheater);
		}
		return null;
	}

	public String deleteCourse(Theater currentTheater)
	{
		int index;
		
		index = theaters.indexOf(currentTheater);
		if (index >= 0)
		{
			theaters.remove(index);
		}
		return null;
	}


}
