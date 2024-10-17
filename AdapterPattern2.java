// Interface for notification system
interface Notification {
    void sendNotification(String message);
}

// Android notification implementation
class AndroidNotification {
    public void notifyUser(String message) {
        System.out.println("Android notification: " + message);
    }
}

// iOS notification implementation
class IOSNotification {
    public void alertUser(String message) {
        System.out.println("iOS alert: " + message);
    }
}

// Adapter for Android notifications
class AndroidNotificationAdapter implements Notification {
    private AndroidNotification androidNotification;

    public AndroidNotificationAdapter(AndroidNotification androidNotification) {
        this.androidNotification = androidNotification;
    }

    @Override
    public void sendNotification(String message) {
        androidNotification.notifyUser(message); // Adapting the call
    }
}

// Adapter for iOS notifications
class IOSNotificationAdapter implements Notification {
    private IOSNotification iosNotification;

    public IOSNotificationAdapter(IOSNotification iosNotification) {
        this.iosNotification = iosNotification;
    }

    @Override
    public void sendNotification(String message) {
        iosNotification.alertUser(message); // Adapting the call
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Notification androidNotification = new AndroidNotificationAdapter(new AndroidNotification());
        Notification iosNotification = new IOSNotificationAdapter(new IOSNotification());

        androidNotification.sendNotification("Hello, Android User!");
        iosNotification.sendNotification("Hello, iOS User!");
    }
}
