// A program to create a list of Employees. Employees can be either salaried or hourly, and information about their wages
// is stored according to what type each Employee is. Calculates weekly paychecks, as well as offering the option to raise wages
// by a specified percentage.

import java.util.*;
import java.util.Scanner;

public class Personnel
{
        // Initializes an ArrayList to hold Employees
        private static ArrayList<Employee> arr =  new ArrayList<Employee>();

        public static void main (String[] args)
        {
                runMenu();
        }

        // Prints a simple menu 
        public static void printMenu()
        {
                System.out.println("----------------------------------");
                System.out.println("|Commands: n - New employee      |");
                System.out.println("|          c - Compute paychecks |");
                System.out.println("|          p - Print records     |");
                System.out.println("|          r - Rasie Wages       |");
                System.out.println("|          q - quit              |");
                System.out.println("----------------------------------");
        }

        // Prompts the user to select an option from the menu, then exectutes the selection
        public static void runMenu()
        {
                Scanner in = new Scanner(System.in);
                String input = null;
                printMenu();
                System.out.print("Enter command: ");
                input = in.nextLine();

                if(input.equalsIgnoreCase("n"))
                        runN();
                else if(input.equalsIgnoreCase("c"))
                        runC();
                else if(input.equalsIgnoreCase("r"))
                        runR();
                else if(input.equalsIgnoreCase("p"))
                        runP();
                else if(input.equalsIgnoreCase("q"))
                        runQ();
                else
                {
                        System.out.println("Command not recognized; please try again.");
                        in.nextLine();
                        runMenu();
                }
        }

        // Creates a new Employee
        public static void runN()
        {
                Scanner in = new Scanner(System.in);
                String empName;
                double empWage;
                String type;

                System.out.print("Enter the name of new employee: ");
                empName = in.nextLine();
                System.out.print("Hourly (h) or salaried (s): ");
                type = in.nextLine();
                if(type.equalsIgnoreCase("h"))
                        System.out.print("Enter hourly wage: ");
                else if(type.equalsIgnoreCase("s"))
                        System.out.print("Enter annual salary: ");
                else
                {
                        System.out.print("Must chose 'h' or 's'. Try again");
                        in.nextLine();
                        runN();
                }
                empWage = in.nextDouble();

                if(type.equalsIgnoreCase("h"))
                {
                        HourlyEmployee emp = new HourlyEmployee(empName, empWage);
                        arr.add(emp);
                }
                else
                {
                        SalariedEmployee emp = new SalariedEmployee(empName, empWage);
                        arr.add(emp);
                }

                System.out.println("Your employee has been added. Hit any key to continue");
                in.nextLine();
                in.nextLine();
                runMenu();
        }

        // Returns the weekly paycheck of each Employee
        public static void runC()
        {
                Scanner in = new Scanner(System.in);
                double hr = 0;
                double result;

                for(int i = 0; i<arr.size(); i++)
                {
                	if(arr.get(i).isHourly())
                	{
                       System.out.println("Enter number of hours worked by " + arr.get(i).getName());
                       hr = in.nextDouble();
                       System.out.println("Pay for " + arr.get(i).getName() + ": $" + arr.get(i).computePay(hr) + "0 this week");
                	}
                	else
                	{
                		result = arr.get(i).computePay(hr);
                		result = Math.round(result * 100d) / 100d;
                		System.out.println("Pay for " + arr.get(i).getName() +  ": $" + result + " per week");
                	}
                }

                System.out.println("Hit any key to continue");
                in.nextLine();
                in.nextLine();
                runMenu();
        }

        // Raises each Employee's wage by a specified percentage
        public static void runR()
        {
                Scanner in = new Scanner(System.in);
                double result;

                System.out.println("Enter percentage increase: ");
                double per = in.nextDouble();
                for(int i = 0; i < arr.size(); i++)
                {
                        result = arr.get(i).getWage() * (per/100) + arr.get(i).getWage();
                        System.out.println(arr.get(i).getName() + "                $" + result);
                        arr.get(i).setWage(result);
                }

                System.out.println("Hit any key to continue");
                in.nextLine();
                in.nextLine();
                runMenu();
        }

        // Prints each Employee and their wage information
        public static void runP()
        {
                Scanner in = new Scanner(System.in);

                for(int i = 0; i < arr.size(); i++)
                {
                        System.out.println(arr.get(i).toString());
                }

                System.out.println("Hit any key to continue");
                in.nextLine();
                runMenu();
        }

        // Exits the program
        public static void runQ()
        {
                System.exit(0);
        }
}
