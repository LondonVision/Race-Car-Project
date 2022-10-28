# Race-Car-Project
The user can buy a car object and then use that car to race to try and earn money. The car has its own rating based on how good all of its parts are which in turn, contributes to how well it performs in races. This shows my use of subclasses, object oriented programming, and implementing an interface. 
You cannot race without purchsing a car first 
You also have to input a valid age that could have a license (16)
Structure of Project:
•	Main Class
    Menu
        Stats
        Buy car
        Race
            This is how user gains money to buy more cars
       Dealership data
            Password: password123
    Car creations
•	Customer Class
    ArrayList of owned cars
    ArrayList of races that it has participated in
    Buy car method
•	Car Class – implements Comparable
	  Calculates price based on goodness of engine and tires
	  Dealer Class
	      ArrayList of inventory
	      ArrayList of Receipts
	  Private Engine Class
	      Goodness level out of 30 possible points
	  Private Tires Class
	      Goodness level out of 30 possible points
•	Receipt Class
	  Car sold
	  Time of sale
•	Race Class
	  Car used
	  Certain chance of winning based on overall goodness of the car – the better the car, the better the chances of winning are
	  Time of race
