package sait.bms.problemdomain;

public class Cookbook extends Book {
	final String D = "Diabetic";
	final String V = "Vegetarian";
	final String G = "Gluten-free";
	final String I = "International";
	final String N = "None";
	private String diet;

	public Cookbook(String isbn, String call, int avail, int tot, String tit, String auth, String diet) {
		super(isbn, call, avail, tot, tit, auth);
		this.diet = diet;
	}

	public String toString() {
		String str = super.toString();
		str += String.format("%-25s", "Diet:");
		if (this.diet.equalsIgnoreCase("d"))
			str += String.format("%s\n", this.D);
		else if (this.diet.equalsIgnoreCase("V"))
			str += String.format("%s\n", this.V);
		else if (this.diet.equalsIgnoreCase("G"))
			str += String.format("%s\n", this.G);
		else if (this.diet.equalsIgnoreCase("I"))
			str += String.format("%s\n", this.I);
		else
			str += String.format("%s\n", this.N);

		return str;
	}

	public String getDiet() {
		return this.diet;
	}
}
