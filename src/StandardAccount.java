public class StandardAccount implements IAccount{
    private int accountNumber;
    private double creditLimit;
    private double balance;

    public StandardAccount(int accountNumber, double creditLimit){
        this.accountNumber = accountNumber;
        if (creditLimit > 0) {
            this.creditLimit = 0;
        } else {
            this.creditLimit = -Math.abs(creditLimit);
        }
        this.balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if (amount > balance + Math.abs(creditLimit)) {
            amount = balance + Math.abs(creditLimit);
        }
        balance -= amount;
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}
