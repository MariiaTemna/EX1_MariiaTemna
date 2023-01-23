import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank{

    private List<IAccount> accounts;

    public Bank() {
        accounts = new ArrayList<IAccount>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for (IAccount account: accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() < 0) {
                    System.out.println("Account is not closed due to debt");
                    return;
                }
                accounts.remove(account);
                return;
            }
        }

    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return accounts;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> inDebtAccounts = new ArrayList<IAccount>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance()< 0) {
                inDebtAccounts.add(account);
            }
        }
        return inDebtAccounts;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
       List<IAccount> accountsWithBalance = new ArrayList<IAccount>();
       for (IAccount account : accounts) {
           if (account.GetCurrentBalance() > balanceAbove) {
               accountsWithBalance.add(account);
           }
       }
       return accountsWithBalance;
    }
}
