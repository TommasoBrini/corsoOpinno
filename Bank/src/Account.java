import java.util.Arrays;

public class Account {
    private int accountID;
    private String nome;
    private int nOperations;
    private double balance;
    private final int TOTAL_OPERATIONS = 100;
    private OperationType[] operation = new OperationType[TOTAL_OPERATIONS];

    public Account(int accID, String name) {
        this(accID, name, 0);
    }

    public Account(int accountID, String nome, double balance) {
        this.accountID = accountID;
        this.nome = nome;
        this.balance = balance;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNOperations() {
        return nOperations;
    }

    public void setNOperations(int nOperations) {
        this.nOperations = nOperations;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void printOperations(){
        System.out.println(Arrays.toString(operation));
    }

    public void deposit(double amount){
        if(nOperations < TOTAL_OPERATIONS){
            balance += amount;
            operation[nOperations] = OperationType.D;
            nOperations++;
        }
    }

    public void withdraw(double amount){
        if(balance < amount || nOperations > TOTAL_OPERATIONS){
            System.out.println("NON PUOI PRELEVARE");
        } else {
            balance -= amount;
            operation[nOperations] = OperationType.W;
            nOperations++;
        }
    }

}
