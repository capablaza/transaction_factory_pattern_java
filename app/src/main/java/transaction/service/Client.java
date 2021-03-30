package transaction.service;

public interface Client {

    boolean verifyAccount(Operation operation);

    ApiClientResponse send(ApiClientRequest request);
}
