package eco.com.spring.mcsv.newapi.exception;

public class InternalServerException extends Exception {

    public InternalServerException() {
    }

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "InternalServerException: "+getMessage();
    }

}