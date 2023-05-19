public class Bank {
    private int numAccounts;
    private final int TOTAL_ACCOUNTS = 100;
    private Account[] accounts;

    public Bank(){
        accounts = new Account[TOTAL_ACCOUNTS];
        this.numAccounts = 0;
    }

    public void addAccount(Account account){
        if(numAccounts < TOTAL_ACCOUNTS){
            accounts[numAccounts] = account;
            numAccounts++;
            System.out.println("Account creato");
        } else {
            System.out.println("Non c'è più spazio nella banca");
        }
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void deposito(int idAccount, double amount){
        for(Account account : accounts){
            if(account!=null){
                if(account.getAccountID() == idAccount){
                    account.deposit(amount);
                }
            }

        }
    }

    public void preleva(int idAccount, double amount){
        for(Account account : accounts){
            if(account != null){
                if(account.getAccountID() == idAccount){
                    account.withdraw(amount);
                }
            }
        }
    }

    public void printOperations(int accountNumber){
        for(Account account : accounts){
            if(account != null){
                if(account.getAccountID() == accountNumber){
                    account.printOperations();
                }
            }
        }
    }

}
