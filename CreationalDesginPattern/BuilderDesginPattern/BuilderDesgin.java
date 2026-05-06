package CreationalDesginPattern.BuilderDesginPattern;
class User {

    // Required fields
    private final String name;
    private final String email;

    // Optional fields
    private final int age;
    private final String address;
    private final String company;

    // Private constructor
    private User(Builder builder) {

        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.address = builder.address;
        this.company = builder.company;
    }

    // Show Data
    public void display() {

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Company: " + company);
    }

    // Static Builder Class
    public static class Builder {

        // Required fields
        private final String name;
        private final String email;

        // Optional fields
        private int age;
        private String address;
        private String company;

        // Constructor for required fields
        public Builder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        // Setter-style methods

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        // Final build method
        public User build() {
            return new User(this);
        }
    }
}
public class BuilderDesgin {
    public static void main(String[] args) {
        User user = new User.Builder("John Doe", "john.doe@example.com")
                .setAge(30)
                .setAddress("123 Main St")
                .setCompany("ABC Corp")
                .build();
        user.display();
    }
}
