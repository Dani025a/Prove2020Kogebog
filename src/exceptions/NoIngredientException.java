package exceptions;

public class NoIngredientException extends Exception {
    public NoIngredientException(String errorMessage) {
        super(errorMessage);
    }
}
