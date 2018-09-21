package pattern;

abstract class AbstractCustomer {
    protected String name;
    public abstract String getName();
    public abstract boolean isNil();
}

class RealCustomer extends AbstractCustomer {
    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNil() {
        return false;
    }
}

class NullCustomer extends AbstractCustomer {

    @Override
    public String getName() {
        return "Not available in customer database.";
    }

    @Override
    public boolean isNil() {
        return true;
    }
}

class CustomerFactory {
    public static final String[] names = new String[]{"bob","jack","rio"};
    public static AbstractCustomer getCustomer(String name) {
        for (String s : names) {
            if(s.equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}


public class NullObjectPattern {
    public static void main(String[] args) {
        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}
