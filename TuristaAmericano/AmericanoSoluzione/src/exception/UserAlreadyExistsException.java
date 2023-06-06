package exception;

import entities.User;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(User user) {
        super("user " + user + " already exists");
    }
}