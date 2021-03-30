package transaction.service;

public class Operation {
    private int account;
    private String bank;
    private int amount;

    public Operation(int account, String bank, int amount) {
        this.account = account;
        this.bank = bank;
        this.amount = amount;
    }

    public String bank() {
        return this.bank;
    }

    public int account() {
        return this.account;
    }

    public int amount() {
        return this.amount;
    }
}
