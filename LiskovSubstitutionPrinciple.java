// Superclass: Bird
public class Bird {
    public void fly() {
        System.out.println("Flying high in the sky!");
    }
}

// Subclass: Penguin (violating LSP)
public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly!");
    }
}

// Main class to demonstrate the issue
public class Main {
    public static void main(String[] args) {
        Bird sparrow = new Bird();
        sparrow.fly();  // Correct: Outputs "Flying high in the sky!"

        Bird penguin = new Penguin();
        penguin.fly();  // Problem: Throws UnsupportedOperationException
    }
}


// How to write code that dont violates Liskovs Substitution Principle

// Superclass: Bird (general bird behaviors)
public class Bird {
    public void eat() {
        System.out.println("Bird is eating.");
    }
}

// Interface: FlyingBird for birds that can fly
public interface FlyingBird {
    void fly();
}

// Subclass: Sparrow (a flying bird)
public class Sparrow extends Bird implements FlyingBird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying.");
    }
}

// Subclass: Penguin (non-flying bird)
public class Penguin extends Bird {
    public void swim() {
        System.out.println("Penguin is swimming.");
    }
}

// Main class to demonstrate the fix
public class Main {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        sparrow.eat();  // Outputs: "Bird is eating."

        // Check if the bird can fly before calling fly()
        if (sparrow instanceof FlyingBird) {
            ((FlyingBird) sparrow).fly();  // Outputs: "Sparrow is flying."
        }

        Bird penguin = new Penguin();
        penguin.eat();  // Outputs: "Bird is eating."
        if (penguin instanceof FlyingBird) {
            ((FlyingBird) penguin).fly();  // Won't execute because Penguin doesn't fly
        } else {
            System.out.println("Penguin cannot fly, but it can swim!");
        }
    }
}
