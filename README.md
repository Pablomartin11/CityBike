# CityBike
This project was made for Object-Oriented Programming subject at University of Valladolid in the Computer Science
grade. The main objective was to design a tree of classes to learn the herence and represent different Objects which are the classes.

The practical case we were presented consists on a (not real) proposal made for the city council of an eco-friendly system for bike renting that we had to design.

The [classes](src/uva/poo/CityBike) we had to design and connect are the following ones:
* ```CityBikeSystem``` which is the class that represents the main system of CityBike.
* ```CityBikeParkingPoint``` as its name implies, the parking point where the bikes rests.
These main classes has different functionalities we were asked to implement like, the payment system, the proccess to rent a bike, add a new bike to the parking point, etc.

In addition to that, we were asked to implement different types of services such as ```Bike``` with its different types, and ```Pack``` of bikes, these two had to be implemented by an interface class ```Resource``` basically because they have the same payment method.

Obviusly, we had to implement as well, different bike types with its own differences such as:
* ```ChildBike```
* ```AdultBike```
* ```ElectricBike```

Last but not least, we were asked to check if the work we done was correct, so we implemented the [TestClasses](Test/uva/poo/CityBike) for the classes previously named.
