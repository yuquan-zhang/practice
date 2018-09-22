package pattern;

interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}

interface ComputerPartVisitor {
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Computer computer);
}

class Mouse implements ComputerPart {
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Keyboard implements ComputerPart {
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Monitor implements ComputerPart {
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

class Computer implements ComputerPart {
    private ComputerPart[] parts = new ComputerPart[] {
            new Mouse(),new Keyboard(),new Monitor()
    };
    public void accept(ComputerPartVisitor visitor) {
        for(ComputerPart part : parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }
}

class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying mouse");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying keyboard");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying monitor");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying computer");
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
