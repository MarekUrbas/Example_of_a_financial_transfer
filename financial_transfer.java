import java.util.Currency;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private Currency currency;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, Currency currency, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.currency = currency;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class FinancialTransfer {
    private BankAccount senderAccount;
    private BankAccount recipientAccount;
    private double amount;

    public FinancialTransfer(BankAccount senderAccount, BankAccount recipientAccount, double amount) {
        this.senderAccount = senderAccount;
        this.recipientAccount = recipientAccount;
        this.amount = amount;
    }

    public void execute() {
        // Perform financial transfer logic here

        // Deduct amount from sender's account
        double senderBalance = senderAccount.getBalance();
        senderAccount.setBalance(senderBalance - amount);

        // Add amount to recipient's account
        double recipientBalance = recipientAccount.getBalance();
        recipientAccount.setBalance(recipientBalance + amount);

        // Print transaction details
        System.out.println("Transfer of " + amount + " " + senderAccount.getCurrency().getCurrencyCode()
                + " from " + senderAccount.getAccountHolderName() + " to " + recipientAccount.getAccountHolderName()
                + " is completed.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage
        BankAccount senderAccount = new BankAccount("1234567890", "John Doe", Currency.getInstance("USD"), 1000.0);
        BankAccount recipientAccount = new BankAccount("9876543210", "Jane Smith", Currency.getInstance("USD"), 500.0);

        FinancialTransfer transfer = new FinancialTransfer(senderAccount, recipientAccount, 200.0);
        transfer.execute();
    }
}
