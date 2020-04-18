package sait.frs.problemdomain;

public final class Flights {
	// variables
	public static final int RECORD_SIZE = 82;
	private String code;
	private String airline;
	private String from;
	private String to;
	private String weekday;
	private String time;
	private int seats;
	private double costPerSeat;

	// flights constructor
	public Flights(final String code, final String from, final String to, final String weekday, final String time,
			final int seats, final double costPerSeat) {
		this.code = code;
		this.from = from;
		this.to = to;
		this.weekday = weekday;
		this.time = time;
		this.seats = seats;
		this.costPerSeat = costPerSeat;
	}

	public String getCode() {
		return this.code;
	}

	public String getAirline() {
		return this.airline;
	}

	public String getFrom() {
		return this.from;
	}

	public String getTo() {
		return this.to;
	}

	public boolean isDomestic() {
		return this.getFrom().charAt(0) == 'Y' && this.getTo().charAt(0) == 'Y';
	}

	public String getWeekday() {
		return this.weekday;
	}

	public String getTime() {
		return this.time;
	}

	public int getSeats() {
		return this.seats;
	}

	public double getCostPerSeat() {
		return this.costPerSeat;
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof Flights)) {
			return false;
		}
		final Flights other = (Flights) obj;
		return this.getCode().equals(other.getCode());
	}

	@Override
	public String toString() {
		return String.valueOf(this.getCode()) + ", From: " + this.getFrom() + ", To: " + this.getTo() + ", Day: "
				+ this.getWeekday() + ", Cost: " + String.format("%.2f", this.getCostPerSeat());
	}
}