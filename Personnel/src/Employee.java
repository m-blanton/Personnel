// Abstract class that HourlyEmployee and SalariedEmployee inherit from

import java.io.Serializable;

public abstract class Employee implements Serializable
{
        private String name;
        private double wage;

        protected Employee(String name, double wage)
        {
                this.name = name;
                this.wage = wage;
        }

        public String getName()
        {
                return name;
        }

        public double getWage()
        {
                return wage;
        }

        public void setName(String name)
        {
                this.name = name;
        }

        public void setWage(double wage)
        {
                this.wage = wage;
        }

        public abstract double computePay(double hours);
        
        public abstract boolean isHourly();
        

}
