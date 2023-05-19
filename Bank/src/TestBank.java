public class TestBank {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Account tommi = new Account(55, "Tommi");
        Account nico = new Account(45, "nic", 123);
        bank.addAccount(tommi);
        bank.addAccount(nico);

        bank.printOperations(55);
        bank.printOperations(45);

        bank.deposito(55, 123);
        bank.preleva(45, 23);

        bank.printOperations(55);
        bank.printOperations(45);

    }
}
