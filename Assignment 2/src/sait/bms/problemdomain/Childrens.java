package sait.bms.problemdomain;

public class Childrens extends Book {
	final String P = "Picture Book";
	final String E = "Early Readers";
	final String C = "Chapter Book";
	final String N = "None";
	private String format;

	public Childrens(String isbn, String call, int avail, int tot, String tit, String auth, String format) {
		super(isbn, call, avail, tot, tit, auth);
		this.format = format;
	}

	@Override
	public String toString() {
		String str = super.toString();
		str += String.format("%-25s", "Format:");
		if (this.format.equalsIgnoreCase("P"))
			str += String.format("%s\n", this.P);
		else if (this.format.equalsIgnoreCase("E"))
			str += String.format("%s\n", this.E);
		else if (this.format.equalsIgnoreCase("C"))
			str += String.format("%s\n", this.C);
		else
			str += String.format("%s\n", this.N);

		return str;
	}

	public String getFormat() {
		return format;
	}
}
