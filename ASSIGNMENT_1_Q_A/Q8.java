// Q8. Write a Java program that illustrates the concepts of interfaces, method overriding, and 
// method overloading. Begin by defining an interface named Vehicle with two abstract methods: 
// accelerate() and brake(). Then, create two classes, Car and Bicycle, both of which implement 
// the Vehicle interface. In the Car class, override the accelerate() and brake() methods to print 
// appropriate messages indicating the acceleration and braking actions for a car. Similarly, in the 
// Bicycle class, override the same methods to display messages specific to a bicycle's 
// acceleration and braking. Additionally, implement method overloading in both classes by 
// providing multiple versions of the accelerate() method, each accepting different parameters 
// such as speed and duration. Finally, create a Main class to instantiate objects of both Car and 
// Bicycle classes, test their overridden methods, and demonstrate method overloading by 
// invoking different versions of the accelerate() method.

interface Vehicle {
    void accelerate();

    void brake();
}

class Car implements Vehicle {
    public void accelerate() {
        System.out.println("Car is accelerating.");
    }

    public void brake() {
        System.out.println("Car is braking.");
    }

    public void accelerate(int speed) {
        System.out.println("Car is accelerating at " + speed + " km/h.");
    }

    public void accelerate(int speed, int duration) {
        System.out.println("Car is accelerating at " + speed + " km/h for " + duration + " seconds.");
    }
}

class Bicycle implements Vehicle {
    public void accelerate() {
        System.out.println("Bicycle is accelerating.");
    }

    public void brake() {
        System.out.println("Bicycle is braking.");
    }

    public void accelerate(int speed) {
        System.out.println("Bicycle is accelerating at " + speed + " km/h.");
    }

    public void accelerate(int speed, int duration) {
        System.out.println("Bicycle is accelerating at " + speed + " km/h for " + duration + " seconds.");
    }
}

// Main.java
public class Q8 {
    public static void main(String[] args) {
        Car car = new Car();
        Bicycle bicycle = new Bicycle();

        car.accelerate();
        car.brake();
        car.accelerate(60);
        car.accelerate(80, 10);

        bicycle.accelerate();
        bicycle.brake();
        bicycle.accelerate(20);
        bicycle.accelerate(30, 5);
    }
}
// Output
// Car is accelerating.
// Car is braking.
// Car is accelerating at 60 km/h.
// Car is accelerating at 80 km/h for 10 seconds.
// Bicycle is accelerating.
// Bicycle is braking.
// Bicycle is accelerating at 20 km/h.
// Bicycle is accelerating at 30 km/h for 5 seconds.