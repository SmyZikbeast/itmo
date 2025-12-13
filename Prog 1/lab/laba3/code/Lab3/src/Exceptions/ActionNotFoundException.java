package Exceptions;

public class ActionNotFoundException extends Exception {
    public ActionNotFoundException(String message) {
        super(message);
    }
    @Override
    public String getMessage(){
        return "Не найдено действие у персонажа";
    }
}
