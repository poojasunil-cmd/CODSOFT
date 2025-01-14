import java.util.Scanner;

class BankAccount {

    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 50000f;
    int transactions = 0;
    StringBuilder transactionHistory = new StringBuilder();

    public void register(Scanner sc) {
        System.out.println("\nEnter your Name: ");
        this.name = sc.nextLine();
        System.out.println("\nEnter your Username: ");
        this.userName = sc.nextLine();
        System.out.println("\nEnter your Password: ");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration Successful. Please Log in to your Bank Account.");
    }

    public boolean login(Scanner sc) {
        boolean isLogin = false;
        while (!isLogin) {
            System.out.println("\nEnter your username: ");
            String Username = sc.nextLine();
            if (Username.equals(userName)) {
                while (!isLogin) {
                    System.out.println("\nEnter your password: ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogin Successful.");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password.");
                    }
                }
            } else {
                System.out.println("\nUsername not found.");
            }
        }
        return isLogin;
    }

    public void withdraw(Scanner sc) {
        System.out.println("\nEnter Amount to Withdraw: ");
        float amount = sc.nextFloat();
        sc.nextLine(); // Clear buffer
        if (amount > 0 && balance >= amount) {
            transactions++;
            balance -= amount;
            System.out.println("\nWithdrawal Successful.");
            transactionHistory.append(amount).append(" Rs Withdrawn\n");
        } else {
            System.out.println("\nInsufficient Balance or Invalid Amount.");
        }
    }

    public void deposit(Scanner sc) {
        System.out.println("\nEnter Amount to Deposit: ");
        float amount = sc.nextFloat();
        sc.nextLine(); // Clear buffer
        if (amount > 0 && amount <= 10000f) {
            transactions++;
            balance += amount;
            System.out.println("\nDeposit Successful.");
            transactionHistory.append(amount).append(" Rs Deposited\n");
        } else {
            System.out.println("\nInvalid Amount or Deposit Limit Exceeded.");
        }
    }

    public void checkBalance() {
        System.out.println("\n" + balance + " Rs");
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("No Transactions happened.");
        } else {
            System.out.print("\n" + transactionHistory);
        }
    }
}

public class ATMInterface {

    public static int takenIntegerInput(Scanner sc, int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                input = sc.nextInt();
                sc.nextLine(); // Clear buffer
                if (input > 0 && input <= limit) {
                    flag = true;
                } else {
                    System.out.println("Choose a number between 1 and " + limit + ".");
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value.");
                sc.nextLine(); // Clear invalid input
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nHello!! Welcome to Pooja's ATM Interface.");
        System.out.println("\n1. Register \n2. Exit");
        System.out.println("Choose one option: ");
        int choose = takenIntegerInput(sc, 2);

        if (choose == 1) {
            BankAccount b = new BankAccount();
            b.register(sc);
            while (true) {
                System.out.println("\n1. Login \n2. Exit");
                System.out.println("Enter your choice: ");
                int ch = takenIntegerInput(sc, 2);
                if (ch == 1) {
                    if (b.login(sc)) {
                        System.out.println("\nWELCOME BACK, " + b.name);
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Exit");
                            System.out.println("Enter your choice: ");
                            int c = takenIntegerInput(sc, 6);
                            switch (c) {
                                case 1:
                                    b.withdraw(sc);
                                    break;
                                case 2:
                                    b.deposit(sc);
                                    break;
                                case 3:
                                    System.out.println("\nTransfer feature not implemented yet!");
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                                default:
                                    System.out.println("\nInvalid option. Try again.");
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}




