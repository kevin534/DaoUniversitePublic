package exceptions;
public class NotFoundException extends Exception{
    public NotFoundException() {
        super("Entity not found");
    }
}
