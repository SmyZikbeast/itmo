package Exceptions;

public class ActionNotFoundException extends Exception {
    public ActionNotFoundException() {
        super();
    }
    @Override
    public String getMessage(){
        return "Не найдено действие у персонажа";
    }
}
