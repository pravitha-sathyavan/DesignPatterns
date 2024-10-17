// Abstract Product: Compiler
public interface Compiler {
    void compile(String code);
}

// Abstract Product: IDE
public interface IDE {
    void writeCode();
    void debugCode();
}

// Abstract Factory: DevelopmentFactory
public interface DevelopmentFactory {
    Compiler createCompiler();
    IDE createIDE();
}

// Concrete Product: JavaCompiler
public class JavaCompiler implements Compiler {
    @Override
    public void compile(String code) {
        System.out.println("Compiling Java code: " + code);
    }
}

// Concrete Product: JavaIDE
public class JavaIDE implements IDE {
    @Override
    public void writeCode() {
        System.out.println("Writing Java code in IntelliJ...");
    }

    @Override
    public void debugCode() {
        System.out.println("Debugging Java code in IntelliJ...");
    }
}

// Concrete Product: PythonCompiler
public class PythonCompiler implements Compiler {
    @Override
    public void compile(String code) {
        System.out.println("Compiling Python code: " + code);
    }
}

// Concrete Product: PythonIDE
public class PythonIDE implements IDE {
    @Override
    public void writeCode() {
        System.out.println("Writing Python code in PyCharm...");
    }

    @Override
    public void debugCode() {
        System.out.println("Debugging Python code in PyCharm...");
    }
}

// Concrete Factory: JavaDevelopmentFactory
public class JavaDevelopmentFactory implements DevelopmentFactory {
    @Override
    public Compiler createCompiler() {
        return new JavaCompiler();
    }

    @Override
    public IDE createIDE() {
        return new JavaIDE();
    }
}

// Concrete Factory: PythonDevelopmentFactory
public class PythonDevelopmentFactory implements DevelopmentFactory {
    @Override
    public Compiler createCompiler() {
        return new PythonCompiler();
    }

    @Override
    public IDE createIDE() {
        return new PythonIDE();
    }
}

public class Client {
    public static void main(String[] args) {
        // Using JavaDevelopmentFactory to work with Java tools
        DevelopmentFactory javaFactory = new JavaDevelopmentFactory();
        useDevelopmentTools(javaFactory, "public class HelloWorld { }");

        // Using PythonDevelopmentFactory to work with Python tools
        DevelopmentFactory pythonFactory = new PythonDevelopmentFactory();
        useDevelopmentTools(pythonFactory, "print('Hello, World')");
    }

    // Method to use both Compiler and IDE
    public static void useDevelopmentTools(DevelopmentFactory factory, String code) {
        Compiler compiler = factory.createCompiler();
        IDE ide = factory.createIDE();

        ide.writeCode();
        ide.debugCode();
        compiler.compile(code);
    }
}
