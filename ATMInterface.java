import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    /**
 * This method handles the deposit operation in the ATM.
 * It prompts the user to enter the amount to deposit,
 * validates the input, and updates the account balance.
 *
 * @throws java.util.InputMismatchException if the user enters a non-numeric value.
 */
private void deposit() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the amount to deposit: ");
    double amount = scanner.nextDouble();

    // Perform deposit operation
    account.deposit(amount);

    // Close the scanner to prevent resource leak
    scanner.close();
}

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
        scanner.close();
    }
}

// Main class to run the ATM program
public class ATMInterface {
    public static void main(String[] args) {
        // Initial balance for the bank account
        BankAccount account = new BankAccount(1000.0);

        // Create ATM with the bank account
        ATM atm = new ATM(account);

        // Show the ATM menu
        atm.showMenu();
    }
}
