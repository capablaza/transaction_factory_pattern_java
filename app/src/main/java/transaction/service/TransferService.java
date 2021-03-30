package transaction.service;

public class TransferService {
    private Storage storage;

    public TransferService(Storage storage) {
        this.storage = storage;
    }

    public TransferResponse transfer(Operation opOrigin, Operation opDestiny) {
        ApiClient client = new ApiClient();

        boolean originResponse = client.verifyAccount(opOrigin);
        boolean destinyResponse = client.verifyAccount(opDestiny);

        if (originResponse && destinyResponse) {

            ApiClientRequest clientRequest = new ApiClientRequest(opOrigin, opDestiny);
            ApiClientResponse responseApi = client.send(clientRequest);

            storage.save(responseApi.message());

            return new TransferResponse(responseApi.code(), responseApi.message());
        }
        return new TransferResponse(501, "The accounts aren't corrects");
    }
}
