package exception;

import entities.User;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() { super(); }

    public UserNotFoundException(User user) {
        super("user " + user + " not found");
    }
}