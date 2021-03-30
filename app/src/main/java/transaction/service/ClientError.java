package transaction.service;

public class ClientError extends Exception{

    public static int BANK_NOT_FOUND = 509;

    public ClientError() {
    }

    public ClientError(String message) {
        super(message);
    }

    public ClientError(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientError(Throwable cause) {
        super(cause);
    }

    protected ClientError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
