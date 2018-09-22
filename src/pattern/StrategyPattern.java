package pattern;

interface Strategy {
    int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class StrategyContext {
    private Strategy strategy;
    public StrategyContext(Strategy strategy) {
        setStrategy(strategy);
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return this.strategy.doOperation(num1,num2);
    }

}

public class StrategyPattern {
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext(new OperationAdd());
        System.out.println(context.executeStrategy(12,4));
        context.setStrategy(new OperationSubtract());
        System.out.println(context.executeStrategy(12,4));
        context.setStrategy(new OperationMultiply());
        System.out.println(context.executeStrategy(12,4));
    }
}
