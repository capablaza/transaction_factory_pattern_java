package transaction.service;

public class BCIClient implements Client {
    @Override
    public boolean verifyAccount(Operation operation) {
        return operation.bank().equals("bci");
    }

    @Override
    public ApiClientResponse send(ApiClientRequest request) {
        if (request.originBank().equals("bci")) {
            return new ApiClientResponse(200, "Ok from bci");
        }
        return new ApiClientResponse(500, "Bank not valid");
    }
}
