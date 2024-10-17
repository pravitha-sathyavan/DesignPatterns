// Abstract Product: DatabaseConnection
public interface DatabaseConnection {
    void connect();
}

// Abstract Product: DatabaseCursor
public interface DatabaseCursor {
    void executeQuery(String query);
}


// Abstract Factory: DatabaseFactory
public interface DatabaseFactory {
    DatabaseConnection createConnection();
    DatabaseCursor createCursor();
}


// MySQL Connection and Cursor
public class MySQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database...");
    }
}

public class MySQLCursor implements DatabaseCursor {
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing query on MySQL: " + query);
    }
}

// PostgreSQL Connection and Cursor
public class PostgreSQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL database...");
    }
}

public class PostgreSQLCursor implements DatabaseCursor {
    @Override
    public void executeQuery(String query) {
        System.out.println("Executing query on PostgreSQL: " + query);
    }
}


// MySQL Factory
public class MySQLFactory implements DatabaseFactory {
    @Override
    public DatabaseConnection createConnection() {
        return new MySQLConnection();
    }

    @Override
    public DatabaseCursor createCursor() {
        return new MySQLCursor();
    }
}

// PostgreSQL Factory
public class PostgreSQLFactory implements DatabaseFactory {
    @Override
    public DatabaseConnection createConnection() {
        return new PostgreSQLConnection();
    }

    @Override
    public DatabaseCursor createCursor() {
        return new PostgreSQLCursor();
    }
}


// DatabaseManager class
public class DatabaseManager {
    private DatabaseConnection connection;
    private DatabaseCursor cursor;

    // Constructor to accept a factory and initialize connection and cursor
    public DatabaseManager(DatabaseFactory factory) {
        this.connection = factory.createConnection();
        this.cursor = factory.createCursor();
    }

    // Method to connect to the database
    public void connectToDatabase() {
        connection.connect();
    }

    // Method to execute a query
    public void runQuery(String query) {
        cursor.executeQuery(query);
    }
}


public class Client {
    public static void main(String[] args) {
        // Using MySQL database through DatabaseManager
        DatabaseFactory mysqlFactory = new MySQLFactory();
        DatabaseManager mysqlManager = new DatabaseManager(mysqlFactory);
        
        mysqlManager.connectToDatabase();
        mysqlManager.runQuery("SELECT * FROM users");

        // Using PostgreSQL database through DatabaseManager
        DatabaseFactory postgresqlFactory = new PostgreSQLFactory();
        DatabaseManager postgresqlManager = new DatabaseManager(postgresqlFactory);

        postgresqlManager.connectToDatabase();
        postgresqlManager.runQuery("SELECT * FROM employees");
    }
}
