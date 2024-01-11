/*The Proxy Pattern is a structural design pattern that provides placeholder for another object to control access to it. This pattern involves creating a new class (the proxy) that acts as an intermediary between a client and the real object. The proxy controls access to the real object, allowing you to add extra functionality such as lazy loading, access control, logging, etc.

scenario related to accessing sensitive data through a security proxy. In this example, we'll create an interface representing the sensitive data, a real object that provides access to the actual data, and a proxy object that controls and restricts access based on the user's authorization level.*/

// Subject interface
interface SensitiveData {
    void accessData();
}

// RealSensitiveData class (RealObject)
class RealSensitiveData implements SensitiveData {
    @Override
    public void accessData() {
        System.out.println("Accessing sensitive data...");
    }
}

// ProxySensitiveData class (Proxy)
class ProxySensitiveData implements SensitiveData {
    private RealSensitiveData realSensitiveData;
    private String userRole;

    public ProxySensitiveData(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void accessData() {
        // Check user's role before allowing access to sensitive data
        if ("admin".equalsIgnoreCase(userRole)) {
            // Lazy initialization: Create the real object only when needed
            if (realSensitiveData == null) {
                realSensitiveData = new RealSensitiveData();
            }

            // Delegate the access to the real object
            realSensitiveData.accessData();
        } else {
            System.out.println("Unauthorized access. Insufficient privileges.");
        }
    }
}

// Client code
public class ProxyPatternRealTimeExample {
    public static void main(String[] args) {
        // Simulating access to sensitive data through a proxy
        SensitiveData adminProxy = new ProxySensitiveData("admin");
        SensitiveData userProxy = new ProxySensitiveData("user");

        // Admin can access sensitive data
        adminProxy.accessData();

        // User is not authorized to access sensitive data
        userProxy.accessData();
    }
}

/*
In this example:

SensitiveData is the interface representing the subject.
RealSensitiveData is the real object that performs the actual access to sensitive data.
ProxySensitiveData is the proxy that controls access to RealSensitiveData. It checks the user's role and allows access only if the user has the "admin" role.
When you run the client code, you'll see that the admin is able to access sensitive data, while the user is denied access due to insufficient privileges. This simulates how a proxy can control access to sensitive resources based on certain conditions.
*/