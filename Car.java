import java.util.ArrayList;
import java.util.Collections;

public class Car implements Comparable<Car> {
	private String make, model;
	private int year, totalGoodness;
	private double price, taxPrice, totalPrice, tax = 0.0875;
	private double engineMultConst = 5.0 / 30.0, tiresMultConst = 1.25 / 30.0;// used to calculate price
	private Engine engine;
	private Tires tires;

	public Car(String make, String model, int year, boolean automatic, double displacement, int cylinders, int diameter,
			int condition, double psi) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		engine = new Engine(automatic, displacement, cylinders);
		tires = new Tires(diameter, condition, psi);
		totalGoodness = tires.getGoodness() + engine.getGoodness();

		price = 10000;// base price for all cars is 10000
		price *= (Math.pow(((double) tires.getGoodness() * tiresMultConst), 2));// tires calculated in first
		price *= (Math.pow(((double) engine.getGoodness() * engineMultConst), 2)); // engine calculated in next
		price = Math.round(price * 100.0) / 100.0; // rounding to make it look better

		taxPrice = Math.round(price * tax * 100.0) / 100.0; // tax calculated
		totalPrice = price + taxPrice;// total price
		Dealer.addCar(this);// newly created cars are automatically added to dealer
	}

	@Override
	public int compareTo(Car c) { // compare cars by price
		if (this.getPrice() > c.getPrice()) {
			return 1;
		} else if (this.getPrice() < c.getPrice()) {
			return -1;
		}
		return 0;
	}

	// getters and setters
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}

	public double getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(double taxPrice) {
		this.taxPrice = taxPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public int getTotalGoodness() {
		return totalGoodness;
	}

	public void setTotalGoodness(int totalGoodness) {
		this.totalGoodness = totalGoodness;
	}

	@Override
	public String toString() {
		return year + " " + make + " " + model + ": $" + price + "\nEngine: " + engine + "\nTires: " + tires;
	}

	public static class Dealer {
		private static ArrayList<Car> inventory = new ArrayList<Car>();
		private static ArrayList<Receipt> receipts = new ArrayList<Receipt>();
		private static double totalMoney;

		public static void sortCarsIncreasing() { // sort cars by price
			Collections.sort(inventory);
		}

		// method to add cars to the inventory ArrayList
		public static void addCar(Car car) {
			inventory.add(car);
		}

		// add receipt to receipts ArrayList
		public static void addReceipt(Receipt r) {
			receipts.add(r);
		}

		// remove car from inventory ArrayList
		public static void removeCar(int num) {
			if (num > 0) {
				inventory.remove(num - 1);
			} else {
				System.out.println("A car does not exist at that position.");
			}
		}

		// Display all cars in the inventory ArrayList
		public static void displayInventory() {
			int i = 1;
			for (Car c : inventory) {
				System.out.println("Car #" + i + "\n" + c);
				System.out.println();
				i++;
			}
		}

		// display receipts
		public static void displayReceipts() {
			int i = 1;
			for (Receipt r : receipts) {
				System.out.println("Receipt #" + i + "\n" + r);
				System.out.println();
				i++;
			}
		}

		// setters and getters
		public static ArrayList<Car> getInventory() {
			return inventory;
		}

		public static void setInventory(ArrayList<Car> inventory) {
			Dealer.inventory = inventory;
		}

		public static ArrayList<Receipt> getReceipts() {
			return receipts;
		}

		public static void setReceipts(ArrayList<Receipt> receipts) {
			Dealer.receipts = receipts;
		}

		public static double getTotalMoney() {
			return totalMoney;
		}

		public static void setTotalMoney(double newTotalMoney) {
			totalMoney = newTotalMoney;
		}

	}

	private class Engine {
		private boolean automatic;
		private double displacement;
		private int cylinders, goodness = 0;

		// Engine constructor
		public Engine(boolean automatic, double displacement, int cylinders) {
			super();
			double indvDisplacement = displacement / ((double) cylinders);
			this.automatic = automatic;
			this.displacement = displacement;
			this.cylinders = cylinders;

			// engine goodness calculations
			// transmition
			if (automatic) {// automatic is best
				goodness += 10;
			} else {
				goodness += 5;
			}
			// cylinders
			if (cylinders == 16) {// 16 cylinders is best
				goodness += 10;
			} else if (cylinders < 16 && cylinders >= 8) {
				goodness += 6;
			} else if (cylinders < 8 && cylinders >= 6) {
				goodness += 3;
			} else {
				goodness += 1;
			}
			// displacement divided by cylinders
			if (indvDisplacement == 0.5) {
				goodness += 10;
			} else if (indvDisplacement > 0.4 && indvDisplacement < 0.6) {
				goodness += 7;
			} else {
				goodness += 2;
			}

		}

		// setters and getters for engine's data
		public boolean isAutomatic() {
			return automatic;
		}

		public void setAutomatic(boolean automatic) {
			this.automatic = automatic;
		}

		public double getDisplacement() {
			return displacement;
		}

		public void setDisplacement(double displacement) {
			this.displacement = displacement;
		}

		public int getCylinders() {
			return cylinders;
		}

		public void setCylinders(int cylinders) {
			this.cylinders = cylinders;
		}

		public int getGoodness() {
			return goodness;
		}

		public void setGoodness(int goodness) {
			this.goodness = goodness;
		}

		// Engine toString
		@Override
		public String toString() {
			return displacement + "L displacement | " + cylinders + " cylinders | Automatic transmition: " + automatic;
		}
	}

	private class Tires {
		int diameter, condition, goodness = 0; // condition is a scale between 0-10. 0 being worst, 10 being best
		// diameter is in inches
		double psi;

		public Tires(int diameter, int condition, double psi) {
			super();
			this.diameter = diameter;
			this.condition = condition;
			this.psi = psi;

			// condition
			goodness += condition;
			// diameter
			if (diameter == 18) {
				goodness += 10;
			} else if (diameter < 18 && diameter >= 15 || diameter > 18 && diameter <= 21) {
				goodness += 5;
			}
			// psi
			if (psi >= 32 && psi <= 35) {
				goodness += 10;
			} else if (psi >= 30 && psi <= 40) {
				goodness += 5;
			}
		}

		// setters and getters
		public int getDiameter() {
			return diameter;
		}

		public void setDiameter(int diameter) {
			this.diameter = diameter;
		}

		public int getCondition() {
			return condition;
		}

		public void setCondition(int condition) {
			this.condition = condition;
		}

		public double getPsi() {
			return psi;
		}

		public void setPsi(double psi) {
			this.psi = psi;
		}

		public int getGoodness() {
			return goodness;
		}

		public void setGoodness(int goodness) {
			this.goodness = goodness;
		}

		@Override
		public String toString() {
			return diameter + "\" diameter" + " | Condition: " + condition + "/10" + " | Psi: " + psi;
		}

	}

}
