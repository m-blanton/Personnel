import java.io.Serializable;

public class HourlyEmployee extends Employee implements Serializable
{
        private double hours;
        private double hourlyWage;
        private boolean hourly;

        public HourlyEmployee(String name, double wage)
        {
                super(name, wage);
                hourlyWage = wage;
        }

        public double computePay(double hours)
        {
                double standard = 0;
                double overtime = 0;
                double pay = 0;

                if(hours <= 40)
                {
                        pay = hours * hourlyWage;
                        return pay;
                }
                else
                {
                        standard = 40;
                        overtime = hours - 40;
                        pay = (standard * hourlyWage) + (overtime * (hourlyWage * 1.5));
                        return pay;
                }
        }

        public String toString()
        {
                String result = (getName() + "                $" + getWage() + "0/hour");
                return result;
        }
        
        public boolean isHourly()
        {
        	return true;
        }
        
}
