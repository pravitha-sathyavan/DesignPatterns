/* Builder design pattern

User Class: Contains private fields for user details. The constructor is private and takes a UserBuilder object.
UserBuilder Class: Provides a constructor for required fields (username, email) and setter methods for optional fields. Each setter returns this for method chaining.
Build Method: Constructs a User instance using the builder.
This design pattern provides flexibility in creating User objects with varying levels of detail while keeping the construction logic organized.

*/

public class User {
    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final Integer age;

    private User(UserBuilder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    // UserBuilder Class
    public static class UserBuilder {
        private final String username;
        private final String email;
        private String firstName;
        private String lastName;
        private Integer age;

        public UserBuilder(String username, String email) {
            this.username = username;
            this.email = email;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        User user = new User.UserBuilder("johndoe", "johndoe@example.com")
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(30)
                .build();

        System.out.println(user);
    }
}
