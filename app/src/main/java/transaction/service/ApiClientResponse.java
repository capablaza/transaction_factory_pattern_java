package transaction.service;

public class ApiClientResponse {

    private int code;
    private String message;

    public ApiClientResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String message() {
        return this.message;
    }

    public int code() {
        return this.code;
    }
}
