// Subsystem Class 1
class SubsystemA {
    public void operationA() {
        System.out.println("Subsystem A: Operation A");
    }
}

// Subsystem Class 2
class SubsystemB {
    public void operationB() {
        System.out.println("Subsystem B: Operation B");
    }
}

// Subsystem Class 3
class SubsystemC {
    public void operationC() {
        System.out.println("Subsystem C: Operation C");
    }
}

// Facade Class
class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;

    public Facade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    // Simplified methods that delegate to subsystems
    public void doOperation1() {
        System.out.println("Facade: Coordinating Operation 1");
        subsystemA.operationA();
        subsystemB.operationB();
    }

    public void doOperation2() {
        System.out.println("Facade: Coordinating Operation 2");
        subsystemC.operationC();
    }
}

// Client Code
public class FacadePatternDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doOperation1();  // Facade simplifies interaction with subsystems
        facade.doOperation2();
    }
}
