package transaction.service;

public class TransferService {
    private Storage storage;

    public TransferService(Storage storage) {
        this.storage = storage;
    }

    public TransferResponse transfer(Operation opOrigin, Operation opDestiny) {
        try{
            Client clientOrigin = ClientFactory.build(opOrigin.bank());
            Client clientDestiny = ClientFactory.build(opDestiny.bank());

            boolean originResponse = clientOrigin.verifyAccount(opOrigin);
            boolean destinyResponse = clientDestiny.verifyAccount(opDestiny);

            if (originResponse && destinyResponse) {

                ApiClientRequest clientRequest = new ApiClientRequest(opOrigin, opDestiny);
                ApiClientResponse responseApi = clientOrigin.send(clientRequest);

                storage.save(responseApi.message());

                return new TransferResponse(responseApi.code(), responseApi.message());
            }
            return new TransferResponse(501, "The accounts aren't corrects");
        }catch (Exception ex){
            return new TransferResponse(ClientError.BANK_NOT_FOUND, "Bank not found");
        }
    }
}
