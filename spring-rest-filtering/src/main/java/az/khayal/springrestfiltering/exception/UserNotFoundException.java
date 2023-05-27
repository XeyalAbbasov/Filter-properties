package az.khayal.springrestfiltering.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {

        super(message);
    }
}
