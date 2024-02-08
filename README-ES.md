# CityBike
Este proyecto fue realizado para la asignatura de Programación Orientada a Objetos en la Universidad de Valladolid, dentro de la carrera de Ciencias de la Computación. El objetivo principal era diseñar un árbol de clases para aprender la herencia y representar diferentes objetos que son las clases.

El caso práctico que se nos presentó consistía en una propuesta (no real) realizada para el ayuntamiento de una sistema ecológico de alquiler de bicicletas que teníamos que diseñar.

Las [clases](src/uva/poo/CityBike) que tuvimos que diseñar y conectar son las siguientes:

* ```CityBikeSystem```, que es la clase que representa el sistema principal de CityBike.
* ```CityBikeParkingPoint```, como su nombre indica, es el punto de estacionamiento donde descansan las bicicletas. Estas clases principales tienen diferentes funcionalidades que se nos pidió implementar, como el sistema de pago, el proceso para alquilar una bicicleta, agregar una nueva bicicleta al punto de estacionamiento, etc.

Además de eso, se nos pidió implementar diferentes tipos de servicios, como ```Bike``` con sus diferentes tipos, y ```Pack``` de bicicletas. Estos dos debían ser implementados por una clase de interfaz llamada ```Resource```, básicamente porque comparten el mismo método de pago.

Por supuesto, también tuvimos que implementar diferentes tipos de bicicletas con sus propias diferencias, como:

* ```ChildBike```
* ```AdultBike```
* ```ElectricBike```

Por último, pero no menos importante, se nos pidió verificar si el trabajo que hicimos era correcto, así que implementamos las [TestClasses](Test/uva/poo/CityBike) para las clases mencionadas anteriormente.
