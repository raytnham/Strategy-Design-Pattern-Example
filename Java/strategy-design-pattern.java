/* 
	File: /Strategy-Design-Pattern/Java/strategy-design-pattern.java
	Description: This example demonstrates a simple example of strategy pattern design.
	Author: Ray Nham (ray@raydeveloperonline.com)
	Date: 25/02/2018
	Blog post: https://raydeveloperonline.com/2018/02/25/strategy-design-pattern/
 */

// Create the strategy interface.
public interface FlyStrategy{
    public void fly();
}

// The first concrete strategy class.
public class FlyStrategy1 implements FlyStrategy{
    @Override
    public void fly(){
        System.out.println("I can fly.");
    }
}

// The second concrete strategy class.
public class FlyStrategy2 implements FlyStrategy{
    @Override
    public void fly(){
        System.out.println("I cannot fly.");
    }
}

// Create the Context class.
public class Vehicle{
    // This member field specifies which strategy to implement.
    protected FlyStrategy strategy;
    // Define the constructor.
    public Vehicle (FlyStrategy strategy){
        this.strategy = strategy;
    }
    // Define a method to print which strategy the object has.
    public void tryToFly(){
        strategy.fly();
    }
    // Define a method to change the object's strategy.
    public void setFlyStrategy(FlyStrategy strategy){
        this.strategy = strategy;
    }
}

// Define the child classes.
public class Plane extends Vehicle{
    public Plane(){
        super(new FlyStrategy1());
    }
}
public class Car extends Vehicle{
    public Car(){
        super(new FlyStrategy2());
    }
}

// If we have another child class that has the same behaviour with 
// either the two classes above, we will not need to duplicate the code 
// again.
// aka. Our codes are resusable.
public class Aircraft extends Vehicle{
    public Aircraft(){
        super(new FlyStrategy1());
    }
}

public static void main(String[] args) {
    // For example we have a car and a plane object.
    Vehicle mCar = new Car();
    Vehicle mPlane = new Plane();

    System.out.print("Car object: ");
    mCar.tryToFly();
    System.out.print("Plane object: ");
    mPlane.tryToFly();
    /* Output:
        $ Car object: I cannot fly.
        $ Plane object: I can fly.
    */
    
    // Assume Tesla has completed their flying car project,
    //      we want to change the strategy of our Car object to FlyStrategy2.
    mCar.setFlyStrategy(new FlyStrategy2());

    System.out.print("Car object: ");
    mCar.tryToFly();
    /* Output:
        $ Car object: I can fly.
    */

    // Similarly, if the Plane object's engine is faulty, then we'd like to
    //      its strategy to "I cannot fly" (FlyStrategy1).
    mPlane.setFlyStrategy(new FlyStrategy1());

    System.out.print("Plane object: ");
    mPlane.tryToFly();
    /* Output:
        $ Plane object: I cannot fly.
    */
}
