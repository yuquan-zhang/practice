package pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Plan {
    protected double rate;

    abstract void getRate();

    public void calculateBill(int units) {
        System.out.println(units * rate);
    }
}

class DomesticPlan extends Plan {
    public void getRate() {
        rate = 3.5;
    }
}

class CommercialPlan extends Plan {
    public void getRate() {
        rate = 7.5;
    }
}

class InstitutionalPlan extends Plan {
    public void getRate() {
        rate = 5.5;
    }
}

class GetPlanFactory {
    public static Plan getPlan(String planType){
        if(planType == null) return null;
        try{
            Class clazz = Class.forName(planType);
            return (Plan)clazz.newInstance();
        }catch (ClassNotFoundException e) {
            System.out.println("Class " + planType + " is not exist.");
            return null;
        }catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

        /*if(planType.equalsIgnoreCase("DomesticPlan")) {
            return new DomesticPlan();
        }else if(planType.equalsIgnoreCase("CommercialPlan")) {
            return new CommercialPlan();
        }else if(planType.equalsIgnoreCase("InstitutionalPlan")) {
            return new InstitutionalPlan();
        }*/
//        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the name of plan for which the bill will generated: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planName = reader.readLine();
        System.out.println("Enter the number of units for bill will be calculated: ");
        int units = Integer.parseInt(reader.readLine());
        Plan plan = GetPlanFactory.getPlan(planName);
        if(plan == null) System.out.println("Plan is not exist.");
        else {
            System.out.print("Bill amount for " + planName + " of " + units + " unit is:");
            plan.getRate();
            plan.calculateBill(units);
        }
    }
}
