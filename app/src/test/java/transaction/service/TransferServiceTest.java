package transaction.service;

import org.junit.Assert;
import org.junit.Test;

public class TransferServiceTest {

    @Test
    public void shouldReturn200WhenOriginAndDestinyAreCorrects() {

        Storage storage = new StorageDummy();
        TransferService service = new TransferService(storage);

        Operation opOrigin = new Operation(10092, Bank.SANTANDER.name(), 50400);
        Operation opDestiny = new Operation(98128, Bank.BCI.name(), 90500);

        TransferResponse response = service.transfer(opOrigin, opDestiny);

        Assert.assertEquals(200, response.code());
    }

    @Test
    public void shouldReturn509WhenBankOriginIsNotFound(){
        Storage storage = new StorageDummy();
        TransferService service = new TransferService(storage);

        Operation opOrigin = new Operation(10092, "bbva", 50400);
        Operation opDestiny = new Operation(98128, Bank.SANTANDER.name(), 90500);

        TransferResponse response = service.transfer(opOrigin, opDestiny);

        Assert.assertEquals(ClientError.BANK_NOT_FOUND, response.code());
    }

}
