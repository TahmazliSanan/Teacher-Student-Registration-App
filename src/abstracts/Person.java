package abstracts;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String pin;
    private String firstName;
    private String lastName;

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
