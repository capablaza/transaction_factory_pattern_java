package transaction.service;

public class TransferResponse {
    private int code;
    private String message;

    public TransferResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }
}
