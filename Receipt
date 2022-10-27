import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import project.Car.Dealer;

public class Receipt {
	LocalDateTime dateTime;
	String timeOfSale;
	Car carSold;

	public Receipt(Car carSold) {
		super();
		this.carSold = carSold;

		dateTime = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"); // date and time formatted
																							// better
		timeOfSale = dateTime.format(myFormatObj);
		Dealer.addReceipt(this);// automatically added to Dealer
	}

	// setters and getters
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getTimeOfSale() {
		return timeOfSale;
	}

	public void setTimeOfSale(String timeOfSale) {
		this.timeOfSale = timeOfSale;
	}

	public Car getCarSold() {
		return carSold;
	}

	public void setCarSold(Car carSold) {
		this.carSold = carSold;
	}

	@Override
	public String toString() {
		return carSold + "\nSold: " + timeOfSale + "\nSubtotal: $" + carSold.getPrice() + "\nTax: $"
				+ carSold.getTaxPrice() + "\nTotal: $" + carSold.getTotalPrice();
	}

}
