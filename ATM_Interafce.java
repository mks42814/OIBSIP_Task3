import java.util.Scanner;


    class ATM_Interface{


    public static void main(String[]args){
        //database
        int user1_id=2023, login_id;
        String user1_password = "letmein", login_password;
        int balance = 10000;


        Scanner input = new Scanner(System.in);

        int choice=-1;


        String [][] transactions = {{"15/03/2023","Laptop Buy","DR","Flipkart","-25000"},
                                    {"16/03/2023","Salary","CR","XYZ Company","+50000"},
                                    {"17/03/2023","Dinner","DR","Foodiz Cart","-2500"}};

        do{
            System.out.println("Enter your user id: ");
            login_id = input.nextInt();

        //    System.out.println("User1 id" + user1_id);
        //    System.out.println("login id" + login_id);

            System.out.println("Please enter your password: ");
            login_password = input.next();

            if(login_id == user1_id){
                if(login_password.equals(user1_password)){
                    System.out.println("Logged in successfully !");
                    System.out.println("========================= * Welcome * =========================");
                    System.out.println("=================== *          to        * ====================");
                    System.out.println("================ * 21 Din Me Paisa Double Bank * ==============\n");

                }else{
                    System.out.println("Error! Incorrect password");
                    System.out.println("Please try again.");
                }
            }else{
                System.out.println("Error! No a/c found with userID " + login_id);
            }

        }while(user1_id != login_id );


        while (user1_password.equals(login_password)) {
            System.out.println("");
            System.out.println("Services provided by our bank: ");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Logout");

            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            System.out.println("You choose: " + choice + "\n");


            switch (choice) {
                case 1:
                    System.out.println("== = Transaction history = ==");
                    System.out.println("Date ~ Particulars ~ DR/CR ~ From ~ Amount");

                    for (String[] transaction : transactions) {
                        for (int j = 0; j < transaction.length; ++j) {
                            System.out.print( transaction[j] + "\t");
                        }
                        System.out.println();
                    }
                    login_password = null;
                    break;

                case 2:
                    System.out.println("Enter the amount (multiples of 500): ");
                    int withdrawAmt = input.nextInt();

                    if(withdrawAmt > balance){
                        System.out.println("Enough balance is not available!");
                    }
                    else if(withdrawAmt % 500 == 0){
                        balance -= withdrawAmt;
                        byte availableBalanceScreen;
                        System.out.println("Transaction Complete!\nPlease Collect your cash: "+ withdrawAmt  + "Rs.\n");

                        System.out.print("Enter 1 to know your available balance: ");

                        availableBalanceScreen = input.nextByte();
                        if(availableBalanceScreen == 1){
                            System.out.println("Available balance: " + balance + "Rs.");
                        }
                    }else{
                        System.out.println("Invalid Amount Entered!");
                        System.out.println("Please try again.");
                    }
                  login_password = null;
                    break;

                case 3:
                    System.out.println("Enter the amount to deposit: ");
                    int depositAmount = input.nextInt();
                    balance += depositAmount;
                    System.out.println("Amount deposited: " + depositAmount + "Rs.");
                    System.out.println("Available Balance: " + balance + "Rs.");
                    login_password = null;

                    break;

                case 4:
                    System.out.println("Enter the beneficiary userID: ");
                    int beneficiaryUserID = input.nextInt();
                    System.out.println("Enter the amount to transfer: ");
                    int transferAmt = input.nextInt();
                    if(transferAmt <= balance){
                        balance -= transferAmt;
                        System.out.println("Amount transferred to " + beneficiaryUserID + " Rs. : " + transferAmt);
                    } else if (transferAmt > balance) {
                        System.out.println("Not enough balance available to transfer");
                    }

                    break;

                case 5:
                    System.out.println("Thanks for visiting! Logging Out!");
                    login_password = null;

                    break;

                default:
                    System.out.println("Error! Please check your input.");
                    break;

            }
        }

        System.out.println("\n\nThank You !!!");


    }
}

