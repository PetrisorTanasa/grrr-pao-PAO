package main.java.proiect.exceptions;

public class CustomException extends Exception {

    /**
     * create a custom exception with a relevant error message
     */
    public CustomException(String message) {
        super(message);
    }

    /**
     * Use this overloaded constructor if the exception root cause is important
     */
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}