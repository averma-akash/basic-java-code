/*
Factory design pattern belongs to the category of Creational Design Patterns. Here, the objects are created without exposing the logic of creation to the client. The objects refer to the common interface.

The advantages of a factory design pattern are:

This pattern allows hiding the creation logic of the application by using interfaces and factory classes.
It lets to test the seamlessness of the application by using mock or stubs.
Introduces loose coupling in the application by allowing flexibility in the implementation of methods when new classes are introduced.

Where It’s Used in Real Projects?

Spring Framework’s BeanFactory & ApplicationContext
JDBC’s DriverManager.getConnection()
Loggers (LoggerFactory.getLogger(ClassName.class))
Android ViewModelProvider.Factory for creating ViewModels */

// Step 1: Define the Notification Interface
interface Notification {
    void notifyUser();
}

// Step 2: Concrete Implementations
class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Email Notification...");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS Notification...");
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Push Notification...");
    }
}

// Step 3: Factory Class to Create Notification Objects
class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        throw new IllegalArgumentException("Unknown notification type");
    }
}

// Step 4: Client Code Using Factory
public class FactoryPatternExample {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification("EMAIL");
        notification.notifyUser();  // Output: Sending Email Notification...
    }
}
