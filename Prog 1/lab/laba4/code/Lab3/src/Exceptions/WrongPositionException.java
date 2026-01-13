package Exceptions;

public class WrongPositionException extends RuntimeException {
    public WrongPositionException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "Герой находится не в подходящей локации для этого действия: " + super.getMessage();
    }
}
