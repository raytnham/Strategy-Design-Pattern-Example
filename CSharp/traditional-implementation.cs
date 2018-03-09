using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy_Design_Pattern
{
    // Create the behaviour interface.
    public interface IFlyable
    {
        void Fly();
    }
    // Create the Context class.
    public abstract class Vehicle
    {
        // member variables and abstract methods goes here.
    }
    // Define the child classes.
    public class Plane : Vehicle, IFlyable
    {
        // Concrete implementation for Flyable interface.
        public void Fly()
        {
            Console.WriteLine("I can fly.");
        }
    }
    public class Car : Vehicle, IFlyable
    {
        // Concrete implementation for Flyable interface.
        public void Fly()
        {
            Console.WriteLine("I cannot fly.");
        }
    }
    
    // Main program.
    class Program
    {
        static void Main(string[] args)
        {
            Console.ReadLine();
        }
    }
}
