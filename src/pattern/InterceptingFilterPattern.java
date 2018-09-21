package pattern;

import java.util.ArrayList;
import java.util.List;

interface Filter {
    void execute(String request);
}

class AuthenticationFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request " + request);
    }
}

class DebugFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("request log: " + request);
    }
}

class Target {
    public void execute(String request) {
        System.out.println("Execute request: " + request);
    }
}

class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private Target target;
    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for(Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}

class FilterManager {
    FilterChain filterChain;
    public FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }
    public void filterRequest(String request) {
        filterChain.execute(request);
    }
}

class FilterClient {
    FilterManager filterManager;
    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }
    public void sendRequest(String request) {
        filterManager.filterRequest(request);
    }
}

public class InterceptingFilterPattern {
    public static void main(String[] args) {
        FilterManager manager = new FilterManager(new Target());
        manager.setFilter(new AuthenticationFilter());
        manager.setFilter(new DebugFilter());
        FilterClient client = new FilterClient();
        client.setFilterManager(manager);
        client.sendRequest("first request from user.");
    }
}
