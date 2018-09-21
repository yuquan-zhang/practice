package pattern;

import java.util.Date;

class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + "[" + user.getName() + "]:" + message);
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this,message);
    }
}


public class MediatorPattern {
    public static void main(String[] args) {
        User robbert = new User("robbert");
        User jack = new User("jack");
        robbert.sendMessage("hello, I'm robbert");
        jack.sendMessage("hello, I'm jack");
    }
}
