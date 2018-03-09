/* 
	File: /Strategy-Design-Pattern/Java/traditional-implementation.java
	Description: This example demonstrates a simple example of traditional approach.
	Author: Ray Nham (ray@raydeveloperonline.com)
	Date: 25/02/2018
	Blog post: https://raydeveloperonline.com/2018/02/25/strategy-design-pattern/
 */

public interface Flyable{
	// Required method of this interface.
	public void fly();
}

public abstract class Vehicle implements Flyable{
	// Member variables and abstract methods go here.
}

public class Car extends Vehicle{
	// Concrete implementation for Flyable interface.
	public void fly(){
		System.out.println("I cannot fly.");
	}
}

public class Car extends Plane{
	// Concrete implementation for Flyable interface.
	public void fly(){
		System.out.println("I can fly.");
	}
}
