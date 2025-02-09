/*The decorator design pattern is used to modify the functionality of an object at runtime. 
other instances of the same class will not be affected by this, so the individual object gets the modified behavior.

Where It’s Used in Real Projects?
1.	Java I/O Streams (BufferedInputStream, DataInputStream)
2.	Spring Security (HttpServletRequestWrapper)
3.	Spring’s HandlerInterceptor for logging requests/responses
4.	Java’s java.util.Collections.synchronizedList(List<T>) for thread safety
5.	Spring Security (UsernamePasswordAuthenticationToken) to wrap authentication details

This pattern is useful when you need to add features dynamically (like logging, security, or validation) without modifying the core class.


you have a service class that processes user requests, but you want to add logging functionality dynamically without modifying the existing service class. The Decorator Pattern allows you to wrap the original service with a logging decorator.

 */

// Step 1: Define the base interface
interface UserService {
    void createUser(String username);
}

// Step 2: Concrete implementation of the service
class BasicUserService implements UserService {
    @Override
    public void createUser(String username) {
        System.out.println("User " + username + " created successfully.");
    }
}

// Step 3: Abstract Decorator class
abstract class UserServiceDecorator implements UserService {
    protected UserService userService;

    public UserServiceDecorator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser(String username) {
        userService.createUser(username);
    }
}

// Step 4: Concrete Decorator adding logging functionality
class LoggingUserService extends UserServiceDecorator {
    public LoggingUserService(UserService userService) {
        super(userService);
    }

    @Override
    public void createUser(String username) {
        System.out.println("LOG: Creating user " + username);
        super.createUser(username);
        System.out.println("LOG: User " + username + " created.");
    }
}

// Step 5: Client Code using Decorators
public class DecoratorPatternExample {
    public static void main(String[] args) {
        UserService userService = new BasicUserService();
        
        System.out.println("Without Logging:");
        userService.createUser("Alice");
        
        System.out.println("\nWith Logging:");
        UserService loggedUserService = new LoggingUserService(userService);
        loggedUserService.createUser("Bob");
    }
}
