package pattern;

import java.util.ArrayList;
import java.util.List;

interface Service {
    String getName();
    void execute();
}

class Service1 implements Service {
    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service1.");
    }
}

class Service2 implements Service {
    @Override
    public String getName() {
        return "Service2";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service2.");
    }
}

class InitialContext {
    public Object lookup(String jndiName) {
        if(jndiName.equalsIgnoreCase("service1")) {
            System.out.println("Looking up and creating a new Service1 object.");
            return new Service1();
        }else if(jndiName.equalsIgnoreCase("service2")) {
            System.out.println("Looking up and creating a new Service2 object.");
            return new Service2();
        }
        return null;
    }
}

class Cache {
    private List<Service> services;
    public Cache() {
        services = new ArrayList<>();
    }

    public Service getService(String serviceName) {
        for (Service service : services) {
            if(serviceName.equalsIgnoreCase(service.getName())) {
                System.out.println("Returning cached " + serviceName + " object.");
                return service;
            }
        }
        return null;
    }

    public void addService(Service newService) {
        boolean exists = false;
        for(Service service : services) {
            if(service.getName().equalsIgnoreCase(newService.getName())) {
                exists = true;
            }
        }
        if(!exists){
            services.add(newService);
        }
    }

}

class ServiceLocator {
    private static Cache cache;
    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName) {
        Service service = cache.getService(jndiName);
        if(service != null) {
            return service;
        }
        InitialContext context = new InitialContext();
        service = (Service)context.lookup(jndiName);
        cache.addService(service);
        return service;
    }
}

public class ServiceLocatorPattern {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("service1");
        service.execute();
        service = ServiceLocator.getService("service2");
        service.execute();
        service = ServiceLocator.getService("service1");
        service.execute();
        service = ServiceLocator.getService("service2");
        service.execute();
    }
}
