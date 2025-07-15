package abstracts;

public abstract class Person {
    private String pin;
    private String firstName;
    private String lastName;

    public Person(String pin, String firstName, String lastName) {
        this.pin = pin;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPin() {
        return pin;
    }

    public Person setPin(String pin) {
        this.pin = pin;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
