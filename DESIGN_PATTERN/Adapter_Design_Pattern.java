/*
The Adapter Pattern is a structural design pattern that allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting the interface of a class into another interface that a client expects.



Imagine a scenario where your application is using a custom logging system, but you want to integrate a third-party logging framework (e.g., ThirdPartyLogger). Since their interfaces don't match, you need an adapter to bridge the gap.

*/
// Step 1: Define the expected logging interface
interface ApplicationLogger {
    void log(String message);
}

// Step 2: Third-party logging system with a different method signature
class ThirdPartyLogger {
    void logMessage(String msg) {
        System.out.println("Third-Party Logger: " + msg);
    }
}

// Step 3: Adapter class that bridges the third-party logger with our interface
class LoggerAdapter implements ApplicationLogger {
    private ThirdPartyLogger thirdPartyLogger;

    public LoggerAdapter(ThirdPartyLogger thirdPartyLogger) {
        this.thirdPartyLogger = thirdPartyLogger;
    }

    @Override
    public void log(String message) {
        thirdPartyLogger.logMessage(message); // Adapting method call
    }
}

// Step 4: Client code using the application’s expected logging interface
public class AdapterPatternExample {
    public static void main(String[] args) {
        ThirdPartyLogger thirdPartyLogger = new ThirdPartyLogger();
        ApplicationLogger logger = new LoggerAdapter(thirdPartyLogger);

        // Client uses the standard logging interface
        logger.log("This is an important log message.");
    }
}

/*Explanation:
ApplicationLogger → Defines the expected logging interface.
ThirdPartyLogger → Represents an external logging framework with a different method (logMessage(String)).
LoggerAdapter → Implements ApplicationLogger and adapts ThirdPartyLogger to match the expected interface.
Client Code uses the ApplicationLogger interface without worrying about the third-party implementation.
*/
