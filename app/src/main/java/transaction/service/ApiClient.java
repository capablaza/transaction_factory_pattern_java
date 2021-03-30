package transaction.service;

public class ApiClient {

    public boolean verifyAccount(Operation operation) {
        if (operation.bank().equals("santander")) {
            return true;
        } else if (operation.bank().equals("bci")) {
            return true;
        }
        return false;
    }

    public ApiClientResponse send(ApiClientRequest request) {

        switch (request.originBank()) {
            case "santander":
                return new ApiClientResponse(200, "Ok from santander");
            case "bci":
                return new ApiClientResponse(200, "Ok from bci");
            case "bbva":
                return new ApiClientResponse(200, "Ok from bbva");
            default:
                return new ApiClientResponse(500, "Bank not valid");
        }
    }
}
