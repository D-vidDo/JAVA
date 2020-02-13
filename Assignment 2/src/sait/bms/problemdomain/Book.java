package sait.bms.problemdomain;

/**
 * @author 605712
 *
 */
public class Book {
	private long isbn;
	private String callNum;
	private int available;
	private int total;
	private String title;
	private String authors;
	
	public Book()
	{
		this.isbn = 0;
		this.callNum = "";
		this.available = 0;
		this.total = 0;
		this.title = "";
		this.authors = "";
	}
	
	public Book(long isbn, String call, int avail, int tot, String tit, String auth) 
	{
		this.isbn = isbn;
		this.callNum = call;
		this.available = avail;
		this.total = tot;
		this.title = tit;
		this.authors = auth;
	}

	public long getIsbn() {
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

	public String toString()
	{
		String str = String.format("%s20%d\n","ISBN:",this.isbn);
		str += String.format("%s20%s","Call Number\n",this.callNum);
		str += String.format("%s20%d","Available\n",this.available);
		str += String.format("%s20%d","Total:\n",this.total);
		str += String.format("%s20%s","Call Number\n",this.title);
		return str;
	}
	
}
