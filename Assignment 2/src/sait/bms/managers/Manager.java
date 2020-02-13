package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sait.bms.problemdomain.Book;

public class Manager {

	private ArrayList<Book> books;

	public void menu() throws FileNotFoundException {
		loadBooks();
		boolean exit = false;
		Scanner user = new Scanner(System.in);
		int choice = 0;

		while (!exit) {

			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.printf("%1d	Checkout Book\n", 1);
			System.out.printf("%1d	Find Books by Title\n", 2);
			System.out.printf("%1d	Display Books by Type\n", 3);
			System.out.printf("%1d	Display Books by Type\n", 4);
			System.out.printf("%1d	Save & Exit\n\n", 5);
			System.out.print("Enter option: ");

			choice = user.nextInt();

			exit = choiceHandler(choice, user);
		}
	}

	private boolean choiceHandler(int choice, Scanner user) {
		switch (choice) {
		case 1:
			System.out.print("Enter ISBN of book: ");

			return false;
		case 2:
			System.out.print("Enter title to search for: ");
			return false;
		case 3:
			displayType();
			return false;
		case 4:
			randomBook();
			return false;

		case 5:
			return true;
		default:
			return false;
		}
	}

	private void loadBooks() throws FileNotFoundException {
		Scanner bookScanner = new Scanner(new File("res/books.txt"));
		this.books = new ArrayList<Book>();
		String book;
		while (bookScanner.hasNextLine()) {
			book = bookScanner.nextLine();
			String[] bookSplit = book.split(";");
			bookType(bookSplit);
		}
		bookScanner.close();
	}

	private void bookType(String[] bookArray) {
		int type = bookArray[0].charAt(bookArray[0].length() - 1);

		if (type >= 0 || type <= 1)
			this.books.add(new Book(Long.parseLong(bookArray[0]), bookArray[1], Integer.parseInt(bookArray[2]),
					Integer.parseInt(bookArray[3]), bookArray[4], bookArray[5]));// Childs Book
		else if (type >= 2 || type <= 3)
			this.books.add(new Book(Long.parseLong(bookArray[0]), bookArray[1], Integer.parseInt(bookArray[2]),
					Integer.parseInt(bookArray[3]), bookArray[4], bookArray[5]));// CookBooks
		else if (type >= 4 || type <= 7)
			this.books.add(new Book(Long.parseLong(bookArray[0]), bookArray[1], Integer.parseInt(bookArray[2]),
					Integer.parseInt(bookArray[3]), bookArray[4], bookArray[5]));// Paper backs
		else if (type >= 8 || type <= 9)
			this.books.add(new Book(Long.parseLong(bookArray[0]), bookArray[1], Integer.parseInt(bookArray[2]),
					Integer.parseInt(bookArray[3]), bookArray[4], bookArray[5]));// Periodicals

	}
	
	private void displayType() {
		
	}
	
	private void randomBook() {
		
	}

}
