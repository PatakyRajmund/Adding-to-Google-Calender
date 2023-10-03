package main.java.org.example;

public class NotEnoughDataException extends Exception {
    NotEnoughDataException(String errorMassage) {
        super(errorMassage);
    }
}
