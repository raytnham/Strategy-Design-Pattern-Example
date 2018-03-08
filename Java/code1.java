// Create the strategy interface.
public interface FlyStrategy{
    public void fly();
}

// The first concrete strategy class.
public class FlyStrategy1 implements Flyable{
    @Override
    public void fly(){
        System.out.println("I can fly.");
    }
}

// The second concrete strategy class.
public class FlyStrategy2 implements Flyable{
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
    public boolean setFlyStrategy(FlyStrategy strategy){
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
// aka. Resusability has been improved.
public class Aircraft extends Vehicle{
    public Aircraft(){
        super(new FlyStrategy1());
    }
}