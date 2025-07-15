package models;

import java.io.Serializable;

public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String pin;
    private String name;

    public String getPin() {
        return pin;
    }

    public Subject setPin(String pin) {
        this.pin = pin;
        return this;
    }

    public String getName() {
        return name;
    }

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "PIN: " + pin + "\nName: " + name;
    }
}
