import java.util.Scanner;

class BankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 15000f;
    int transactions = 0;
    String transactionHestory = "";

    /* Registation Function */

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter your Name: ");
        this.name = sc.nextLine();

        System.out.println("\n Enter your UserName: ");
        this.userName = sc.nextLine();

        System.out.println("\n Enter your Password: ");
        this.password = sc.nextLine();

        System.out.println("\n Enter your Account Number: ");
        this.accountNo = sc.nextLine();

        System.out.println("\n Registration Successfull. \n please Login  your Bank Account");
    }
    /* Login Fuction */

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.println("Enter Your userName: ");
            String UserName = sc.nextLine();
            if (UserName.equals(userName)) {
                while (!isLogin) {
                    System.out.println("Enter your Password");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\n Login Successfull");
                        isLogin = true;
                    } else {
                        System.out.println("\n Incorrect Password");
                    }
                }
            } else {
                System.out.println("\n Username not found");
            }
        }
        return isLogin;
    }
    /* Withdraw Function */

    public void withdraw() {
        System.out.println("Enter your ammount");
        Scanner sc = new Scanner(System.in);
        float ammount = sc.nextFloat();
        try {
            if (balance >= ammount) {
                transactions++;
                balance -= ammount;
                System.out.println("\n Withdraw  Successfull ");
                String str = ammount + "Rs Withdrawn \n";
                transactionHestory = transactionHestory.concat(str);
            } else {
                System.out.println("\n Insufficient Balance ");
            }
        } catch (Exception e) {

        }

    }
    /* Diposit Function */

    public void diposit() {
        System.out.println("Enter your to Diposit");
        Scanner sc = new Scanner(System.in);
        float ammount = sc.nextFloat();
        try {
            if (ammount <= 10000f) {
                transactions++;
                balance += ammount;
                System.out.println("\n Diposit  Successfull ");
                String str = ammount + "Rs Diposited \n";
                transactionHestory = transactionHestory.concat(str);
            } else {
                System.out.println("\n Insufficient Balance ");
            }
        } catch (Exception e) {

        }
    }

    /* Transfer Function */
    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Receipent's Name: ");
        String receipent = sc.nextLine();
        System.out.println("Enter Amount to transfer: ");
        float ammount = sc.nextFloat();
        try {
            if (balance >= ammount) {
                if (ammount <= 50000f) {
                    transactions++;
                    balance -= ammount;
                    System.out.println("\n Successfull Transferred " + receipent);
                    String str = ammount + "Rs tranferred to " + receipent + "\n";
                    transactionHestory = transactionHestory.concat(str);
                } else {
                    System.out.println("\n Sorry. The limit is 50000.");
                }
            } else {
                System.out.println("\n Insufficient Balance.");
            }
        } catch (Exception e) {

        }
    }

    /* check Balance Function */
    public void checkBalance() {
        System.out.println(balance + "Rs ");
    }

    /* Transaction History Fucntion */
    public void transHistory() {
        if (transactions == 0) {
            System.out.println("No Transctions happend");
        } else {
            System.out.println("\n" + transactionHestory);
        }
    }

}

public class ATM_Interface {
    public static int takenIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value.");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("**************** Welcome To Bijili Naveen ATM INTERFACE **************");
        System.out.println("1.Register \n 2.Exit");
        System.out.println("Choose one Option: ");
        int choose = takenIntegerInput(2);

        if (choose == 1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("1.Login \n 2.Exit");
                System.out.println("Enter your choice: ");
                int ch = takenIntegerInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("*************** WELCOME BACk " + b.name + " *********");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println(
                                    "\n1.withdraw \n2.Deposit \n3.Transfer \n4.check balance \n5.Transaction History \n6.Exit");
                            System.out.println("Enter your choice: ");
                            int c = takenIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.diposit();
                                    break;
                                case 3:
                                    b.transfer();
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
