package transaction.service;

public class TransferService {
    private Storage storage;

    public TransferService(Storage storage) {
        this.storage = storage;
    }

    public TransferResponse transfer(Operation opOrigin, Operation opDestiny) {
        Client clientOrigin = new SantanderClient();
        Client clientDestiny = new BCIClient();

        boolean originResponse = clientOrigin.verifyAccount(opOrigin);
        boolean destinyResponse = clientDestiny.verifyAccount(opDestiny);

        if (originResponse && destinyResponse) {

            ApiClientRequest clientRequest = new ApiClientRequest(opOrigin, opDestiny);
            ApiClientResponse responseApi = clientOrigin.send(clientRequest);

            storage.save(responseApi.message());

            return new TransferResponse(responseApi.code(), responseApi.message());
        }
        return new TransferResponse(501, "The accounts aren't corrects");
    }
}
