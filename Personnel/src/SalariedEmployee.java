// A class that represent Employees payed that are paid a yearly salary. Extends Employees.

import java.io.Serializable;

public class SalariedEmployee extends Employee implements Serializable
{
        private double salary;

        public SalariedEmployee(String name, double wage)
        {
                super(name, wage);
                salary = wage;
                wage = (wage/52)/40;
        }

        public void setWage(double salary)
        {
                this.salary = salary;
        }

        public double getWage()
        {
                return salary;
        }

// Weekly pay is computed by simply dividing yearly salary by 52.
        public double computePay(double hours)
        {
                double result = salary/52;
                return result;
        }

        public String toString()
        {
                String result = (getName() + "                $" + getWage()+ "0/year");
                return result;
        }
        
        public boolean isHourly()
        {
        	return false;
        }
        
}
