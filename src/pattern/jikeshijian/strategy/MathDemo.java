package pattern.jikeshijian.strategy;

import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式
 * @author zhangyong created on 2020/12/18
 **/
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(calc2(Op.ADD,45, 89));
    }

    public static long calc(char op, long a, long b) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else if (op == '/') {
            return a / b;
        }
        return 0;
    }

    public static long calc2(Op op, long a, long b) {
        Operation operation = OperationFactory.getOperationByOp(op);
        return operation.operate(a,b);
    }
}

interface Operation {
    long operate(long a, long b);
}

@Operate(Op.ADD)
class AddOperation implements Operation {

    @Override
    public long operate(long a, long b) {
        return a + b;
    }
}

@Operate(Op.SUB)
class SubOperation implements Operation {

    @Override
    public long operate(long a, long b) {
        return a - b;
    }
}

@Operate(Op.MUL)
class MulOperation implements Operation {

    @Override
    public long operate(long a, long b) {
        return a * b;
    }
}

@Operate(Op.DIV)
class DivOperation implements Operation {

    @Override
    public long operate(long a, long b) {
        return a / b;
    }
}

@Operate(Op.MOD)
class ModOperation implements Operation {

    @Override
    public long operate(long a, long b) {
        return a % b;
    }
}

class OperationFactory {
    private static final Map<Op, Operation> operations = new HashMap<>();

    static {
        operations.putIfAbsent(Op.ADD,new AddOperation());
        operations.putIfAbsent(Op.SUB,new SubOperation());
        operations.putIfAbsent(Op.MUL,new MulOperation());
        operations.putIfAbsent(Op.DIV,new DivOperation());
        operations.putIfAbsent(Op.MOD,new ModOperation());
        // 通过读取class文件和反射，获取到所有含有@Operate注解且实现接口Operation的类。

    }

    public static Operation getOperationByOp(Op op) {
        return operations.get(op);
    }
}

enum Op {
    ADD,SUB,MUL,DIV,MOD
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@interface Operate {
    Op value();
}
