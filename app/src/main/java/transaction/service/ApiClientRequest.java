package transaction.service;

public class ApiClientRequest {

    private int originAccount;
    private String originBank;
    private int originAmount;
    private int destinyAccount;
    private String destinyBank;
    private int destinyAmount;

    public ApiClientRequest(Operation origin, Operation destiny){
        this.originAccount = origin.account();
        this.originBank = origin.bank();
        this.originAmount = origin.amount();

        this.destinyAccount = destiny.account();
        this.destinyBank = destiny.bank();
        this.destinyAmount = destiny.amount();
    }

    public String originBank() {
        return this.originBank;
    }
}
