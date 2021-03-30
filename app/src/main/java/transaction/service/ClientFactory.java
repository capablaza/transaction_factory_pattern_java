package transaction.service;

public class ClientFactory {

    public static Client build(String bank) throws ClientError {

        switch (Bank.valueOf(bank)){
            case SANTANDER:
                return new SantanderClient();
            case BCI:
                return new BCIClient();
            default:
                throw new ClientError();
        }
    }
}
