import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Race {
	private boolean result;
	private int entryFee, profit;
	private Car car;
	LocalDateTime dateTime;
	String timeOfRace;

	public Race(int entryFee, Car car) {
		super();
		this.entryFee = entryFee;
		this.car = car;

		// time and date
		dateTime = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");// date and time formatted
																							// better
		timeOfRace = dateTime.format(myFormatObj);

		// car total goodness is a number out of 60 so the bigger the goodness, the
		// better chance there is to win
		int chanceToWin = (int) (Math.random() * ((60 * 2) + 1));

		if (chanceToWin <= car.getTotalGoodness()) {
			result = true;
		}

		if (result) {// if users wins then they get 10 times their bet
			profit = (entryFee * 11) - entryFee;
		} else {// if they lose, they lose their bet
			profit = -entryFee;
		}
	}

	// getters and setters
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getTimeOfRace() {
		return timeOfRace;
	}

	public void setTimeOfRace(String timeOfRace) {
		this.timeOfRace = timeOfRace;
	}

	@Override
	public String toString() {
		if (result) {// race won
			return timeOfRace + " | Result: Won | Entry Fee: " + entryFee + " | Net Profit: " + profit + "\nUsed: "
					+ car.getYear() + " " + car.getMake() + " " + car.getModel();
		}
		// race lost
		return timeOfRace + " | Result: Lost | Entry Fee: " + entryFee + " | Net Profit: " + profit + "\nUsed: "
				+ car.getYear() + " " + car.getMake() + " " + car.getModel();
	}

}
