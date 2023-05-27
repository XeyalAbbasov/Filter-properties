package az.khayal.springrestfiltering.exception;

public class EmailRepitionException extends  RuntimeException{

    public EmailRepitionException(String message) {

        super(message);
    }
}
