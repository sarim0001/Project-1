import java.util.Scanner;

public class SarimBankSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int option;

        do {
            System.out.println("\n===== Sarim Bank =====");
            System.out.println("1. Add Account");
            System.out.println("2. Add Balance");
            System.out.println("3. Transfer Funds");
            System.out.println("4. Display Account Info");
            System.out.println("5. Exit");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    addBankAccount();
                    break;
                case 2:
                    addBalance();
                    break;
                case 3:
                    transferFunds();
                    break;
                case 4:
                    displayAccountInfo();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        } while (option != 5);
    }

    public static void addBankAccount() {
        System.out.print("Enter bank branch: ");
        String bankBranch = sc.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = sc.nextLine();

        System.out.print("Enter account number: ");
        long accountNumber = sc.nextLong();
        sc.nextLine();  // Consume the newline

        System.out.print("Enter account type: ");
        String accountType = sc.nextLine();

        System.out.print("Enter account balance: ");
        float accountBalance = sc.nextFloat();
        sc.nextLine();

        SarimBank newAccount = new SarimBank(bankBranch, accountHolderName, accountNumber, accountType, accountBalance);
        SarimBank.accounts.add(newAccount);

        System.out.println("Account added successfully!");
    }

    public static void addBalance() {
        System.out.print("Enter account number to add funds: ");
        long accountNumber = sc.nextLong();
        sc.nextLine();

        SarimBank currentAccount = null;
        for (SarimBank account : SarimBank.accounts) {
            if (account.Getacnumber() == accountNumber) {
                currentAccount = account;
                break;
            }
        }

        if (currentAccount == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount to add: ");
        float amount = sc.nextFloat();
        currentAccount.Setacbalance(currentAccount.Getacbalance() + amount);
        System.out.println("Balance added successfully!");
    }

    public static void transferFunds() {
        System.out.print("Enter account number to transfer from: ");
        long fromAccountNumber = sc.nextLong();

        System.out.print("Enter account number to transfer to: ");
        long toAccountNumber = sc.nextLong();

        SarimBank fromAccount = null, toAccount = null;
        for (SarimBank account : SarimBank.accounts) {
            if (account.Getacnumber() == fromAccountNumber) {
                fromAccount = account;
            }
            if (account.Getacnumber() == toAccountNumber) {
                toAccount = account;
            }
        }

        if (fromAccount == null) {
            System.out.println("Sender account not found!");
            return;
        }

        if (toAccount == null) {
            System.out.println("Receiver account not found!");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        float amount = sc.nextFloat();

        if (fromAccount.Getacbalance() < amount) {
            System.out.println("Insufficient funds!");
            return;
        }

        fromAccount.Setacbalance(fromAccount.Getacbalance() - amount);
        toAccount.Setacbalance(toAccount.Getacbalance() + amount);
        System.out.println("Transaction successful!");
    }

    public static void displayAccountInfo() {
        System.out.print("Enter account number: ");
        long accountNumber = sc.nextLong();

        SarimBank currentAccount = null;
        for (SarimBank account : SarimBank.accounts) {
            if (account.Getacnumber() == accountNumber) {
                currentAccount = account;
                break;
            }
        }

        if (currentAccount == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.println("Account Holder Name: " + currentAccount.Getacholder());
        System.out.println("Bank Branch: " + currentAccount.Getbbranch());
        System.out.println("Account Number: " + currentAccount.Getacnumber());
        System.out.println("Account Type: " + currentAccount.Getactype());
        System.out.println("Account Balance: " + currentAccount.Getacbalance());
    }
}