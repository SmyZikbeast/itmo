package Exceptions;

public class MissionFailedException extends RuntimeException {
    public MissionFailedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Миссия провалена, " + super.getMessage();
    }
}
