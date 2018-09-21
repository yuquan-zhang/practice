package pattern;

abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    public void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("the game Cricket is initializing...");
    }

    @Override
    void startPlay() {
        System.out.println("the game Cricket is started.");
    }

    @Override
    void endPlay() {
        System.out.println("the game Cricket is stopped.");
    }
}

class FootBall extends Game {
    @Override
    void initialize() {
        System.out.println("the game FootBall is initializing...");
    }

    @Override
    void startPlay() {
        System.out.println("the game FootBall is started.");
    }

    @Override
    void endPlay() {
        System.out.println("the game FootBall is stopped.");
    }
}

public class TemplatePattern {
    public static void main(String[] args) {
        Game cricket = new Cricket();
        cricket.play();
        Game footBall = new FootBall();
        footBall.play();
    }
}
