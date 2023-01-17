import java.util.ArrayList;

import project.Car.Dealer;

public class Customer {
	private String name;
	private int age;
	private double money;
	private ArrayList<Car> cars = new ArrayList<Car>();
	private ArrayList<Race> races = new ArrayList<Race>();

	public Customer(String name, int age) { // constructor for customer
		super();
		this.name = name;
		this.age = age;
		money = 20000;
	}

	// setter and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public ArrayList<Race> getRaces() {
		return races;
	}

	public void setRaces(ArrayList<Race> races) {
		this.races = races;
	}

	// add a race to races ArrayList
	public void addRace(Race r) {
		races.add(r);
	}

	public void buyCar(int i) {// how a customer can buy a car
		Car c = Dealer.getInventory().get(i - 1);
		if (c.getTotalPrice() > money) {// customer doesn't have enough money
			System.out.println("Not enough funds. Tax may be the reason. Transaction invalid.");
		} else {// they have enough so transaction is happening
			Dealer.setTotalMoney(Dealer.getTotalMoney() + c.getPrice());// dealer gets subtotal from sale
			money -= c.getTotalPrice();// customer pays for whole thing including tax
			money = Math.round(money * 100.0) / 100.0; // rounding to make it look better
			cars.add(c);// customer gets the new car
			Receipt r = new Receipt(c); // receipt is created - automatically added to dealer ArrayList of receipts
			System.out.println("Congrats on buying a " + c + "\nSubtotal: $" + c.getPrice() + "\nTax: $"
					+ c.getTaxPrice() + "\nTotal: $" + c.getTotalPrice() + "\nYour balance is: $" + money);
			Dealer.removeCar(i);// dealer loses the car that was sold
		}
	}

	public void displayCars() {// customer's cars are displayed
		if (cars == null) {
			System.out.println("You own no cars. Please buy one first to view it.");
		} else {
			int i = 1;
			for (Car c : cars) {
				System.out.println("Car #" + i + "\n" + c);
				System.out.println();
				i++;
			}
		}
	}

	public void displayRaces() { // customer's races are displayed
		if (races == null) {
			System.out.println("You have not raced yet. Please race first to view it.");
		} else {
			int i = 1;
			for (Race r : races) {
				System.out.println("Race #" + i + "\n" + r);
				System.out.println();
				i++;
			}
		}
	}

	@Override
	public String toString() {
		return "Name:" + name + "\nAge: " + age + "\nBalance: " + money + "\nCars: " + cars;
	}

}
