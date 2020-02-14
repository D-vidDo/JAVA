package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.Childrens;
import sait.bms.problemdomain.Cookbook;

public class Manager {

	private ArrayList<Book> books;
	private ArrayList<Childrens> childrensBooks = new ArrayList<Childrens>();
	private ArrayList<Cookbook> cookBooks = new ArrayList<Cookbook>();
	// private ArrayList<Paperbacks> paperbackBooks;
	// private ArrayList<Periodicals> periodicalBooks;

	Scanner user = new Scanner(System.in);

	public void menu() throws FileNotFoundException {
		loadBooks();
		boolean exit = false;

		int choice = 0;

		while (!exit) {

			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.printf("%1d	Checkout Book\n", 1);
			System.out.printf("%1d	Find Books by Title\n", 2);
			System.out.printf("%1d	Display Books by Type\n", 3);
			System.out.printf("%1d	Produce Random Book List\n", 4);
			System.out.printf("%1d	Save & Exit\n\n", 5);
			System.out.print("Enter option: ");
			choice = user.nextInt();
//			if (choice == 1) {
//				System.out.print("CHOICE ONE");
//			} else if (choice == 2) {
//				System.out.print("CHOICE TWO");
//			} else if (choice == 3) {
//				displayType();
//			} else if (choice == 4) {
//				randomBook();
//			} else if (choice == 5) {
//				exit = true;
//				user.close();
//			}
			choiceHandler(choice, user);
		}
	}

	private boolean choiceHandler(int choice, Scanner user) {
		switch (choice) {
		case 1:
			System.out.print("PLACEHOLDER FOR CHRIS\n");
			return false;
		case 2:
			System.out.print("PLACEHOLDER FOR CHRIS\n");
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
		char type = bookArray[0].charAt(bookArray[0].length() - 1);

		if (type == '0' || type == '1')
			childrensBooks.add(new Childrens(bookArray[0], bookArray[1], Integer.parseInt(bookArray[2]),
					Integer.parseInt(bookArray[3]), bookArray[4], bookArray[5], bookArray[6]));// Child's Book

		else if (type == '2' || type == '3')
			cookBooks.add(new Cookbook(bookArray[0], bookArray[1], Integer.parseInt(bookArray[2]),
					Integer.parseInt(bookArray[3]), bookArray[4], bookArray[5], bookArray[6]));// CookBooks

//		else if (type == 4 || type == 7)
//			this.books.add(new Book(bookArray[0], bookArray[1], Integer.parseInt(bookArray[2]),
//					Integer.parseInt(bookArray[3]), bookArray[4], bookArray[5]));// Paper backs
//		
//		else if (type == 8 || type == 9)
//			this.books.add(new Book(bookArray[0], bookArray[1], Integer.parseInt(bookArray[2]),
//					Integer.parseInt(bookArray[3]), bookArray[4], bookArray[5]));// Periodicals

	}

	private void displayType() {
		int in;
		char format = 'm';
		System.out.print("#	Type\r\n" + "1	Children's Books\r\n" + "2	Cookbooks\r\n" + "3	Paperbacks\r\n"
				+ "4	Periodicals\r\n" + "");
		System.out.print("Enter type of book: ");
		in = user.nextInt();

		if (in == 1) {
			System.out.print("Enter a format (P for Picture Book, E for Early Learners, C for Chapter Book): ");
			format = user.next().charAt(0);

			for (Childrens childBook : childrensBooks) {
				if (childBook.getIsbn().endsWith("0") || childBook.getIsbn().endsWith("1")) {
					if (childBook.getFormat().equals(String.valueOf(format).toUpperCase())) {
						System.out.println(childBook.toString());
					}
				}
			}
		} else if (in == 2) {
			System.out.print(
					"Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-Free, I for International, N for None): ");
			format = user.next().charAt(0);

			for (Cookbook cookingBook : cookBooks) {
				if (cookingBook.getIsbn().endsWith("2") || cookingBook.getIsbn().endsWith("3")) {
					if (cookingBook.getDiet().equals(String.valueOf(format).toUpperCase())) {
						System.out.println(cookingBook.toString());
					}
				}
			}
		}
		else if (in == 3) {
//			System.out.print("Enter a genre PLACEHOLDER STUFF: ");
//			format = user.next().charAt(0);
//
//			for (PLACEHOLDER PLACEHOLDER : PLACEHOLDER) {
//				if (PLACEHOLDER.getIsbn().endsWith("4") || PLACEHOLDER.getIsbn().endsWith("7")) {
//					if (PLACEHOLDER.getGenre().equals(String.valueOf(format).toUpperCase())) {
//						System.out.println(PLACEHOLDER.toString());
//					}
//				}
//			}
		} else if (in == 4) {
//			System.out.print("Enter a frequency PLACEHOLDER STUFF: ");
//			format = user.next().charAt(0);
//
//			for (PLACEHOLDER PLACEHOLDER : PLACEHOLDER) {
//				if (PLACEHOLDER.getIsbn().endsWith("8") || PLACEHOLDER.getIsbn().endsWith("9")) {
//					if (PLACEHOLDER.getFrequency().equals(String.valueOf(format).toUpperCase())) {
//						System.out.println(PLACEHOLDER.toString());
//					}
//				}
//			}
		}
	}

	private void randomBook() {
		books.addAll(childrensBooks);
		books.addAll(cookBooks);
//		books.addAll(PLACEHOLDER);
//		books.addAll(PLACEHOLDER);
		int in;
		System.out.print("Enter number of books: ");
		in = user.nextInt();
		Collections.shuffle(books);
		for (int i = 0; i < in; i++) {
			System.out.print(books.get(i) + "\n");
		}
	}

}
