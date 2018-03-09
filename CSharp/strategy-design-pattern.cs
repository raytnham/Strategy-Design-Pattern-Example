/* 
	File: /Strategy-Design-Pattern/CSharp/strategy-design-pattern.java
	Description: This example demonstrates a simple example of strategy pattern design.
	Author: Ray Nham (ray@raydeveloperonline.com)
	Date: 25/02/2018
	Blog post: https://raydeveloperonline.com/2018/02/25/strategy-design-pattern/
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy_Design_Pattern
{
    // Create the strategy interface.
    public interface IFlyStrategy
    {
        void Fly();
    }
    //The first concrete strategy class.
    public class FlyStrategy1 : IFlyStrategy
    {
        public void Fly()
        {
            Console.WriteLine("I can fly.");
        }
    }
    // The second concrete strategy class.
    public class FlyStrategy2 : IFlyStrategy
    {
        public void Fly()
        {
            Console.WriteLine("I cannot fly.");
        }
    }
    // Create the Context class.
    public class Vehicle
    {
        // This member field specifies which strategy to implement.
        protected IFlyStrategy Strategy;
        // Constructor.
        public Vehicle(IFlyStrategy strategy)
        {
            this.Strategy = strategy;
        }
        // Method to print the object's strategy.
        public void TryToFly()
        {
            this.Strategy.Fly();
        }
        // Method to change the object's strategy.
        public void SetFlyStrategy(IFlyStrategy strategy)
        {
            this.Strategy = strategy;
        }
    }
    // Define the child classes.
    public class Plane : Vehicle
    {
        public Plane() : base(new FlyStrategy1()) { }
    }
    public class Car : Vehicle
    {
        public Car() : base(new FlyStrategy2()) { }
    }
    
    // Main program.
    class Program
    {
        static void Main(string[] args)
        {
            // Initiations.
            Vehicle mCar = new Car();
            Vehicle mPlane = new Plane();

            Console.Write("Car object: ");
            mCar.TryToFly();
            Console.Write("Plane object: ");
            mPlane.TryToFly();
            /* Output:
                $ Car object: I cannot fly.
                $ Plane object: I can fly.
            */

            mCar.SetFlyStrategy(new FlyStrategy2());
            Console.Write("Car object: ");
            mCar.TryToFly();
            /* Output:
                $ Car object: I can fly.
            */

            mPlane.SetFlyStrategy(new FlyStrategy1());
            Console.Write("Plane object: ");
            mPlane.TryToFly();
            /* Output:
                $ Car object: I cannot fly.
            */

            Console.ReadLine();
        }
    }
}