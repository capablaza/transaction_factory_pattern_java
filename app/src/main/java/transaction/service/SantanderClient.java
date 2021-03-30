package transaction.service;

public class SantanderClient implements Client {
    @Override
    public boolean verifyAccount(Operation operation) {
        return operation.bank().equals(Bank.SANTANDER.name());
    }

    @Override
    public ApiClientResponse send(ApiClientRequest request) {
        if (request.originBank().equals(Bank.SANTANDER.name())) {
            return new ApiClientResponse(200, "Ok from santander");
        }
        return new ApiClientResponse(500, "Bank not valid");
    }
}
