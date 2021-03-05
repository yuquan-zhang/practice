package pattern.jikeshijian.mario;

/**
 * @author zhangyong created on 2020/12/17
 **/

enum State {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private final int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        //TODO
        if (!currentState.equals(State.SMALL)) return;
        score += 100;
        currentState = State.SUPER;
    }

    public void obtainCape() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            score += 200;
            currentState = State.CAPE;
        }
    }

    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            score += 300;
            currentState = State.FIRE;
        }
    }

    public void meetMonster() {
        switch (currentState) {
            case CAPE:
                score -= 200;
                break;
            case FIRE:
                score -= 300;
                break;
            case SUPER:
                score -= 100;
                break;
            default:
                break;
        }
        currentState = State.SMALL;
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}

public class ApplicationDemo {
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score: " + score + "; state: " + state);
    }
}
