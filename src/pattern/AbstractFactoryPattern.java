package pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Bank {
    String getBankName();
}

class HDFC implements Bank {
    private final String BNAME;
    public HDFC() {
        BNAME = "HDFC BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}

class ICICI implements Bank {
    private final String BNAME;
    public ICICI() {
        BNAME = "ICICI BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}

class SBI implements Bank {
    private final String BNAME;
    public SBI() {
        BNAME = "SBI BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}

abstract class Loan {
    protected double rate;
    abstract void getInterestRate(double rate);
    public void calculateLoanPayment(double loanAmount,int years) {
        double EMI;
        int n;

        n = years * 12;
        rate = rate/1200;
        EMI = ((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanAmount;
        System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanAmount+" you have borrowed");
    }
}

class HomeLoan extends Loan {
    public void getInterestRate(double r) {
        rate = r;
    }
}

class BusinessLoad extends Loan {
    public void getInterestRate(double r) {
        rate = r;
    }
}

class EducationLoan extends Loan {
    public void getInterestRate(double r) {
        rate = r;
    }
}

abstract class AbstractFactory {
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}

class BankFactory extends AbstractFactory {
    public Bank getBank(String bank) {
        if(bank == null) return null;
        else if(bank.equalsIgnoreCase("HDFC")) {
            return new HDFC();
        }else if(bank.equalsIgnoreCase("ICICI")) {
            return new ICICI();
        }else if(bank.equalsIgnoreCase("SBI")) {
            return new SBI();
        }
        return null;
    }

    public Loan getLoan(String loan) {
        return null;
    }
}

class LoanFactory extends AbstractFactory {
    public Bank getBank(String bank) {
        return null;
    }

    public Loan getLoan(String loan) {
        if(loan == null) return null;
        else if(loan.equalsIgnoreCase("Home")) {
            return new HomeLoan();
        }else if(loan.equalsIgnoreCase("Business")) {
            return new BusinessLoad();
        }else if(loan.equalsIgnoreCase("Education")) {
            return new EducationLoan();
        }
        return null;
    }
}

class FactoryCreator {
    public static AbstractFactory getFactory(String choice) {
        if(choice == null) return null;
        else if(choice.equalsIgnoreCase("bank")) {
            return new BankFactory();
        }else if(choice.equalsIgnoreCase("loan")) {
            return new LoanFactory();
        }
        return null;
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the name of Bank from where you want to take loan amount: ");
        String bankName=br.readLine();

        System.out.print("\n");
        System.out.print("Enter the type of loan e.g. home loan or business loan or education loan : ");

        String loanName=br.readLine();
        AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");
        Bank b=bankFactory.getBank(bankName);

        System.out.print("\n");
        System.out.print("Enter the interest rate for "+b.getBankName()+ ": ");

        double rate=Double.parseDouble(br.readLine());
        System.out.print("\n");
        System.out.print("Enter the loan amount you want to take: ");

        double loanAmount=Double.parseDouble(br.readLine());
        System.out.print("\n");
        System.out.print("Enter the number of years to pay your entire loan amount: ");
        int years=Integer.parseInt(br.readLine());

        System.out.print("\n");
        System.out.println("you are taking the loan from "+ b.getBankName());

        AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");
        Loan l=loanFactory.getLoan(loanName);
        l.getInterestRate(rate);
        l.calculateLoanPayment(loanAmount,years);
    }
}
