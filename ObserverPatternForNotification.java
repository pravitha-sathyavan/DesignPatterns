// Using Observer design pattern implement Notify Me option of amazon which notifies users when the product becomes avaible using email or sms 

// Observer Interface
public interface Observer {
    void update(String availability);
}

// Concrete Observer for Email notification
public class EmailNotification implements Observer {
    private String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void update(String availability) {
        System.out.println("Notifying " + email + " via Email: Product is now " + availability);
    }
}

// Concrete Observer for SMS notification
public class SMSNotification implements Observer {
    private String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String availability) {
        System.out.println("Notifying " + phoneNumber + " via SMS: Product is now " + availability);
    }
}


// Subject Interface
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}


// Concrete Subject (Product)
import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private List<Observer> observers;
    private String productName;
    private String availability;

    public Product(String productName) {
        this.productName = productName;
        this.observers = new ArrayList<>();
        this.availability = "Out of Stock";
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(availability);
        }
    }

    public void setAvailability(String availability) {
        this.availability = availability;
        System.out.println(productName + " availability changed to: " + availability);
        notifyObservers();  // Notify all registered users when the product becomes available
    }
}


public class Main {
    public static void main(String[] args) {
        // Create a product (Subject)
        Product product = new Product("Amazon Echo");

        // Create Observers
        Observer emailUser = new EmailNotification("user1@example.com");
        Observer smsUser = new SMSNotification("+1234567890");

        // Register observers
        product.registerObserver(emailUser);
        product.registerObserver(smsUser);

        // Simulate product availability change
        product.setAvailability("In Stock"); // Notify all users that the product is available
    }
}
