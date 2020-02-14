package sait.bms.problemdomain;

/**
 * @author 605712
 *
 */
public class Book {
	private String isbn;
	private String callNum;
	private int available;
	private int total;
	private String title;
	private String authors;

	public Book() {
		this.isbn = "";
		this.callNum = "";
		this.available = 0;
		this.total = 0;
		this.title = "";
		this.authors = "";
	}

	public Book(String isbn, String call, int avail, int tot, String tit, String auth) {
		this.isbn = isbn;
		this.callNum = call;
		this.available = avail;
		this.total = tot;
		this.title = tit;
		this.authors = auth;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getCallNum() {
		return callNum;
	}

	public int getAvailable() {
		return available;
	}

	public int getTotal() {
		return total;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthors() {
		return authors;
	}

	public String toString() {
		String str = String.format("%-25s%s\n", "ISBN:", getIsbn()); 
		str += String.format("%-25s%s\n", "Call Number:", getCallNum());
		str += String.format("%-25s%d\n", "Available", getAvailable());
		str += String.format("%-25s%d\n", "Total:", getTotal());
		str += String.format("%-25s%s\n", "Title:", getTitle());
		return str;
	}

}




















