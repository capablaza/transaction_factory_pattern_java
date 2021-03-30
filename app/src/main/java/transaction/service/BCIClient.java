package transaction.service;

public class BCIClient implements Client {
    @Override
    public boolean verifyAccount(Operation operation) {
        return Bank.BCI.name().equals(operation.bank());
    }

    @Override
    public ApiClientResponse send(ApiClientRequest request) {
        if (Bank.BCI.name().equals(request.originBank())) {
            return new ApiClientResponse(200, "Ok from bci");
        }
        return new ApiClientResponse(500, "Bank not valid");
    }
}
