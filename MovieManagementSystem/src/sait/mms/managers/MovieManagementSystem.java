package sait.mms.managers;


/**
 * MovieManagementSystem
 */
import java.util.*;
import java.io.*;

public class MovieManagementSystem {
	private int movieDuration;
	private String movieName;
	private int movieYear;
	Scanner in = new Scanner(System.in);
	File file = new File("movies.txt");

	ArrayList<String> movieList = new ArrayList<>();
	ArrayList<String> output = new ArrayList<>();

	public void displayMenu() throws IOException {
		boolean exit = false;
		int choice = 0;
		while (!exit) {
			System.out.println("Movie Management System");
			System.out.println("1     Add New Movie and Save");
			System.out.println("2     Generate List of Movies Released in a Year");
			System.out.println("3     Generate List of Random Movies");
			System.out.println("4     Exit");
			choice = in.nextInt();

			if (choice == 1) {
				System.out.print("Enter movie duration: ");
				movieDuration = in.nextInt();
				System.out.print("Enter movie name: ");
				movieName = in.next();
				System.out.print("Enter movie year: ");
				movieYear = in.nextInt();

				addMovie(movieDuration, movieName, movieYear);

			} else if (choice == 2) {
				generateMovieInYear();
				output.clear();

			} else if (choice == 3) {
				generateRandomMovie();
				output.clear();

			} else if (choice == 4) {
				exit = true;
			}
		}

	}

	public void addMovie(int d, String n, int y) {
		movieList.add(d + "," + n + "," + y);
	}

	public void loadMovie() throws FileNotFoundException {
		Scanner fileScan = new Scanner(file);

		while (fileScan.hasNext()) {
			String movies = fileScan.nextLine();
			movieList.add(movies);
		}

		System.out.println(movieList.size() + " entities loaded.");

		fileScan.close();
	}

	public ArrayList<String> generateMovieInYear() throws IOException {
		System.out.print("Enter in year: ");
		String year = in.next();
		int i = 0;
		while (i < movieList.size()) {
			if ((movieList.get(i)).contains(year)) {
				output.add(movieList.get(i));
			}
			i++;
		}
		System.out.println(output);
		return output;
	}

	public ArrayList<String> generateRandomMovie() throws IOException {
		System.out.print("Enter number of movies: ");
		int noMovies = in.nextInt();
		int i = 0;
		Collections.shuffle(movieList);
		while (i < noMovies) {
			output.add(movieList.get(i));
			i++;
		}
		System.out.println(output);
		return output;
	}

//	@Override
//	public String toString() {
//		System.out.printf("Release date: %d%nDuration: %d%nTitle: %s", output.getMovieYear(), output.getMovieDuration(), output.getMovieName());
//	}

}