package pattern;

class HomeView {
    public void show() {
        System.out.println("Displaying home page.");
    }
}

class TeacherView {
    public void show() {
        System.out.println("Displaying teacher page.");
    }
}

class Dispatcher {
    private HomeView homeView;
    private TeacherView teacherView;
    public Dispatcher() {
        this.homeView = new HomeView();
        this.teacherView = new TeacherView();
    }
    public void dispatch(String request) {
        if(request.equalsIgnoreCase("teacher")) {
            this.teacherView.show();
        }else {
            this.homeView.show();
        }
    }
}

class FrontController {
    private Dispatcher dispatcher;
    public FrontController() {
        this.dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser() {
        System.out.println("User is authenticated successfully.");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request) {
        trackRequest(request);
        if(isAuthenticUser()) {
            this.dispatcher.dispatch(request);
        }
    }
}

public class FrontControllerPattern {
    public static void main(String[] args) {
        FrontController controller = new FrontController();
        controller.dispatchRequest("teacher");
        controller.dispatchRequest("home");
    }
}
