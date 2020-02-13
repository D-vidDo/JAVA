package sait.mms.problemdomain;


/**
 * Movie
 */
import java.util.*;

public class Movie {
	private String movieName;
	private int movieYear;
	private int movieDuration;
	Scanner in = new Scanner(System.in);

	public Movie(int d, String n, int y) {
		movieDuration = d;
		movieName = n;
		movieYear = y;
	}

	public int setMovieDuration() {
		movieDuration = in.nextInt();
		return movieDuration;
	}

	public String getMovieName() {
		return movieName;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public String toString() {
		String x = String.format("%s %f %f", movieDuration, movieName, movieYear);
		return x;
	}

}
