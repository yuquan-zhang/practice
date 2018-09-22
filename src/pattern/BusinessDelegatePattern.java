package pattern;

interface BusinessService {
    void doProcessing();
}

class EJBService implements BusinessService {
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB service.");
    }
}

class JMSService implements BusinessService {
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS service.");
    }
}

class BusinessLookup {
    public BusinessService getBusinessService(String serviceType) {
        if(serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        }else {
            return new JMSService();
        }
    }
}

class BusinessDelegate {
    private BusinessLookup businessLookup = new BusinessLookup();
    private BusinessService businessService;
    private String serviceType;
    public void setBusinessType(String serviceType) {
        this.serviceType = serviceType;
    }
    public void doTask() {
        businessService = businessLookup.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}

class Client {
    private BusinessDelegate businessDelegate;
    public Client(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }
    public void doTask() {
        businessDelegate.doTask();
    }
}

public class BusinessDelegatePattern {
    public static void main(String[] args) {
        BusinessDelegate delegate = new BusinessDelegate();
        delegate.setBusinessType("EJB");
        Client client = new Client(delegate);
        client.doTask();
        delegate.setBusinessType("JMS");
        client.doTask();
    }
}
