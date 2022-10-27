import java.util.Scanner;
class Accountholder{
	private int userid = 0;
    private int userpin = 0;
    public void userdetails() {
    	System.out.println("Welcome to ABC Bank ATM");
        Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the userid: ");
	    userid = sc.nextInt();
	    System.out.println("Enter the userpin: ");
	    userpin = sc.nextInt();
	  
       if(userid==12345678 && userpin==1234){
    	   System.out.println("Login successfull");      
           
       }
       else if(userid==23456789 && userpin==2345) {
           System.out.println("Login successfull");
       } 
       else {
       	   System.out.println("Invalid userid or userpin");
           System.exit(0);
       }
      
}
}
class Account extends Accountholder{
	protected double checkingBalance = 1000;
	protected double savingBalance = 500;
	public double amount;  
	Scanner sc = new Scanner(System.in); 
	   public double CheckingBalance() {
		   return checkingBalance;
		}

		public double SavingBalance() {
			return savingBalance;
		}

		public double CheckingWithdraw(double amount) {
			checkingBalance = (checkingBalance - amount);
			return checkingBalance;
		}

		public double SavingWithdraw(double amount) {
			savingBalance = (savingBalance - amount);
			return savingBalance;
		}

		public double CheckingDeposit(double amount) {
			checkingBalance = (checkingBalance + amount);
			return checkingBalance;
		}

		public double SavingDeposit(double amount) {
			savingBalance = (savingBalance + amount);
			return savingBalance;
		}

		public void CheckingWithdrawInput() {
			System.out.println("Checking Account Balance: " +checkingBalance);
			System.out.print("Amount you want to withdraw from Checking Account: ");
			amount = sc.nextDouble();

			if ((checkingBalance - amount) >= 0) {
				CheckingWithdraw(amount);
				System.out.println("New Checking Account balance: " +checkingBalance + "\n");
			} else {
				System.out.println("Balance cannot be negative." + "\n");
			}
		}

		public void SavingWithdrawInput() {
			System.out.println("Saving Account Balance: " +savingBalance);
			System.out.print("Amount you want to withdraw from Saving Account: ");
		    amount = sc.nextDouble();

			if ((savingBalance - amount) >= 0) {
				SavingWithdraw(amount);
				System.out.println("New Saving Account balance: " + savingBalance + "\n");
			} else {
				System.out.println("Balance cannot be negative." + "\n");
			}
		}

		public void CheckingDepositInput() {
			System.out.println("Checking Account Balance: " +checkingBalance);
			System.out.print("Amount you want to deposit from Checking Account: ");
		    amount = sc.nextDouble();

			if ((checkingBalance + amount) >= 0) {
				CheckingDeposit(amount);
				System.out.println("New Checking Account balance: " + checkingBalance + "\n");
			} else {
				System.out.println("Balance cannot be negative." + "\n");
			}
		}

		public void SavingDepositInput() {
			System.out.println("Saving Account Balance: " +savingBalance);
			System.out.print("Amount you want to deposit from Saving Account: ");
		    amount = sc.nextDouble();

			if ((savingBalance + amount) >= 0) {
				SavingDeposit(amount);
				System.out.println("New Saving Account balance: " + savingBalance + "\n");
			} else {
				System.out.println("Balance cannot be negative." + "\n");
			}
		}
	}

class Banktransaction extends Account{
   	 Scanner s = new Scanner(System.in);
	
	 public void AccountType() {
			System.out.println("Select the Account you want to access: ");
			System.out.println("Type 1 - Checking Account");
			System.out.println("Type 2 - Saving Account");
			System.out.println("Type 3 - Exit");
			System.out.print("Choice: ");

			selection = s.nextInt();

			switch (selection) {
			case 1:
				Checking();
				break;

			case 2:
				Saving();
				break;

			case 3:
				System.out.println("Thank You for using this ATM, bye.");
				break;

			default:
				System.out.println("\n" + "Invalid Choice." + "\n");
				AccountType();
			}
		}

		public void Checking() {
			System.out.println("Checking Account: ");
			System.out.println("Type 1 - View Balance");
			System.out.println("Type 2 - Withdraw Funds");
			System.out.println("Type 3 - Deposit Funds");
			System.out.println("Type 4 - Exit");
			System.out.print("Choice: ");

			selection = s.nextInt();

			switch (selection) {
			case 1:
				System.out.println("Checking Account Balance: " +checkingBalance+ "\n");
				AccountType();
				break;

			case 2:
				CheckingWithdrawInput();
				AccountType();
				break;

			case 3:
				CheckingDepositInput();
				AccountType();
				break;

			case 4:
				System.out.println("Thank You for using this ATM, bye.");
				break;

			default:
				System.out.println("\n" + "Invalid choice." + "\n");
				Checking();
			}
		}

		public void Saving() {
			System.out.println("Saving Account: ");
			System.out.println("Type 1 - View Balance");
			System.out.println("Type 2 - Withdraw Funds");
			System.out.println("Type 3 - Deposit Funds");
			System.out.println("Type 4 - Exit");
			System.out.print("Choice: ");

			selection = s.nextInt();

			switch (selection) {
			case 1:
				System.out.println("Saving Account Balance: " +savingBalance+ "\n");
				AccountType();
				break;

			case 2:
				SavingWithdrawInput();
				AccountType();
				break;

			case 3:
				SavingDepositInput();
				AccountType();
				break;

			case 4:
				System.out.println("Thank You for using this ATM, bye.");
				break;

			default:
				System.out.println("\n" + "Invalid choice." + "\n");
				Saving();
			}
		}

		int selection;
	}

public class AtmInterface extends Banktransaction {

	public static void main(String[] args) {
		Banktransaction bt = new Banktransaction();
		bt.userdetails();
		bt.AccountType();

	}

}
