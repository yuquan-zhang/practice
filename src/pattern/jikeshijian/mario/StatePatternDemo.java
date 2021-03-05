package pattern.jikeshijian.mario;

/**
 * @author zhangyong created on 2020/12/17
 **/
public class StatePatternDemo {

    public static void main(String[] args) {
        SuperMarioStateMachine stateMachine = new SuperMarioStateMachine();
        System.out.println(stateMachine.getCurrentState().getName());
        System.out.println(stateMachine.getScore());
        stateMachine.obtainMushRoom();
        System.out.println(stateMachine.getCurrentState().getName());
        System.out.println(stateMachine.getScore());
        stateMachine.obtainCape();
        System.out.println(stateMachine.getCurrentState().getName());
        System.out.println(stateMachine.getScore());
        stateMachine.meetMonster();
        System.out.println(stateMachine.getCurrentState().getName());
        System.out.println(stateMachine.getScore());
        stateMachine.obtainFireFlower();
        System.out.println(stateMachine.getCurrentState().getName());
        System.out.println(stateMachine.getScore());
        stateMachine.meetMonster();
        stateMachine.obtainIce();
        System.out.println(stateMachine.getCurrentState().getName());
        System.out.println(stateMachine.getScore());
    }

    public static void test() {
        SuperMarioStateMachine stateMachine = new SuperMarioStateMachine();
        String event = "MushRoom";
//        if (event.equals("MushRoom") && stateMachine.getCurrentState().getName().equals("Small")) {
//            stateMachine.setCurrentState(new SuperMario());
//        } else if ()
    }

}

class SuperMarioStateMachine {
    private int score;
    private IMario currentState;

    public SuperMarioStateMachine() {
        this.score = 0;
        this.currentState = new SmallMario();
    }

    void obtainMushRoom() {
        currentState.obtainMushRoom(this);
    }

    void obtainCape() {
        currentState.obtainCape(this);
    }

    void obtainFireFlower(){
        currentState.obtainFireFlower(this);
    }

    void meetMonster() {
        currentState.meetMonster(this);
    }

    void obtainIce() {
        currentState.obtainIce(this);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}

abstract class IMario {
    String getName() {
        return "";
    }

    void obtainMushRoom(SuperMarioStateMachine stateMachine) {

    }

    void obtainCape(SuperMarioStateMachine stateMachine) {

    }

    void obtainFireFlower(SuperMarioStateMachine stateMachine) {

    }

    void meetMonster(SuperMarioStateMachine stateMachine) {

    }

    void obtainIce(SuperMarioStateMachine stateMachine) {

    }
}

class SmallMario extends IMario {

    @Override
    public String getName() {
        return "Small";
    }

    @Override
    public void obtainMushRoom(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(100);
        stateMachine.setCurrentState(new SuperMario());
    }

    @Override
    public void obtainCape(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(200);
        stateMachine.setCurrentState(new CapeMario());
    }

    @Override
    public void obtainFireFlower(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(300);
        stateMachine.setCurrentState(new FireMario());
    }

    @Override
    void obtainIce(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(400);
        stateMachine.setCurrentState(new IceMario());
    }
}

class SuperMario extends IMario {

    @Override
    public String getName() {
        return "Super";
    }

    @Override
    public void obtainCape(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(200);
        stateMachine.setCurrentState(new CapeMario());
    }

    @Override
    public void obtainFireFlower(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(300);
        stateMachine.setCurrentState(new FireMario());
    }

    @Override
    public void meetMonster(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(-100);
        stateMachine.setCurrentState(new SmallMario());
    }

    @Override
    void obtainIce(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(400);
        stateMachine.setCurrentState(new IceMario());
    }
}

class CapeMario extends IMario {

    @Override
    public String getName() {
        return "Cape";
    }

    @Override
    public void meetMonster(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(-200);
        stateMachine.setCurrentState(new SmallMario());
    }
}

class FireMario extends IMario {

    @Override
    public String getName() {
        return "Fire";
    }

    @Override
    public void meetMonster(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(-300);
        stateMachine.setCurrentState(new SmallMario());
    }
}

class IceMario extends IMario {
    @Override
    String getName() {
        return "Ice";
    }

    @Override
    void meetMonster(SuperMarioStateMachine stateMachine) {
        stateMachine.setScore(-400);
        stateMachine.setCurrentState(new SmallMario());
    }
}


