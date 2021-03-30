package transaction.service;

public class SantanderClient implements Client {
    @Override
    public boolean verifyAccount(Operation operation) {
        return operation.bank().equals("santander");
    }

    @Override
    public ApiClientResponse send(ApiClientRequest request) {
        if (request.originBank().equals("santander")) {
            return new ApiClientResponse(200, "Ok from santander");
        }
        return new ApiClientResponse(500, "Bank not valid");
    }
}
