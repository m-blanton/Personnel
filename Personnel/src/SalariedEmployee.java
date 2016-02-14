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
