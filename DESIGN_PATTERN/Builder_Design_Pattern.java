/*
The Builder Pattern is a creational design pattern used to construct complex objects. It provides a flexible way to create objects without many constructor parameters.

Usage in Real Projects:
Spring Boot's Builder for configuring services (e.g., RestTemplateBuilder).
Lombok’s @Builder annotation for generating builder pattern automatically.
Configuring AWS SDK clients (S3Client.builder()).

In Spring Boot, RestTemplateBuilder follows the Builder Pattern to configure and create RestTemplate instances. */

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;

public class RestTemplateBuilderExample {
    public static void main(String[] args) {
        // Using RestTemplateBuilder to configure RestTemplate
        RestTemplate restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(5)) // Set connection timeout
                .setReadTimeout(Duration.ofSeconds(10))   // Set read timeout
                .defaultHeader("Authorization", "Bearer some-token") // Add default header
                .build(); // Build the RestTemplate instance

        // Making an API request (Example)
        String response = restTemplate.getForObject("https://api.example.com/data", String.class);
        System.out.println("Response: " + response);
    }
}

/*
2. Using Lombok’s @Builder Annotation
Lombok simplifies the Builder Pattern by automatically generating a builder using @Builder.*/

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
class User {
    private String name;
    private int age;
    private String email;
}

public class LombokBuilderExample {
    public static void main(String[] args) {
        // Using the generated builder to create a User object
        User user = User.builder()
                .name("John Doe")
                .age(30)
                .email("john.doe@example.com")
                .build();

        // Output user details
        System.out.println("User Name: " + user.getName());
        System.out.println("User Age: " + user.getAge());
        System.out.println("User Email: " + user.getEmail());
    }
}

// ***************** Manual Example ********************

// Step 1: Define the DatabaseConfig class
class DatabaseConfig {
    private String host;
    private int port;
    private String databaseName;
    private String username;
    private String password;

    // Private constructor to enforce the use of the builder
    private DatabaseConfig(DatabaseConfigBuilder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.databaseName = builder.databaseName;
        this.username = builder.username;
        this.password = builder.password;
    }

    // Step 2: Define the Builder class
    public static class DatabaseConfigBuilder {
        private String host = "localhost"; // Default value
        private int port = 3306; // Default MySQL port
        private String databaseName;
        private String username;
        private String password;

        public DatabaseConfigBuilder(String databaseName) { // Mandatory field
            this.databaseName = databaseName;
        }

        public DatabaseConfigBuilder host(String host) {
            this.host = host;
            return this;
        }

        public DatabaseConfigBuilder port(int port) {
            this.port = port;
            return this;
        }

        public DatabaseConfigBuilder username(String username) {
            this.username = username;
            return this;
        }

        public DatabaseConfigBuilder password(String password) {
            this.password = password;
            return this;
        }

        public DatabaseConfig build() {
            return new DatabaseConfig(this);
        }
    }

    // Step 3: Display the configuration (for demonstration)
    public void connect() {
        System.out.println("Connecting to Database:");
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Database: " + databaseName);
        System.out.println("Username: " + (username != null ? username : "Not Set"));
    }
}

// Step 4: Client code using the Builder
public class BuilderPatternExample {
    public static void main(String[] args) {
        DatabaseConfig dbConfig = new DatabaseConfig.DatabaseConfigBuilder("mydb")
                .host("192.168.1.10")
                .port(5432)
                .username("admin")
                .password("securepassword")
                .build();

        dbConfig.connect();
    }
}
