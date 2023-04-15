package in.ineuron.main;

import java.util.Scanner;


/*
 * author  Himanshu Sharma
 * company ineuron.ai
 * version 1.8
 */

public class MainClass {

	public static void main(String[] args) {
		
		//AtmOperationImpl object created
		IAtmOperation op = new AtmOperationImpl();

		int atmNumber = 67890;
		int atmPin = 890;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome TO Tech ATM!!!!!");
		System.out.print("Enter Atm Number :");
		int number = in.nextInt();
		System.out.println("Enter Atm Pin :");
		int pin = in.nextInt();
		
		if((atmNumber==number) && (atmPin==pin)) {
			System.out.println("Verification done");
			while (true) {
				System.out.println("\n1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View MiniStatement\n5.Exit ");
			    System.out.println("Enter the choice:");
			    int ch = in.nextInt();
			    if(ch==1) {
			    	op.viewBalance();
			    }
			    else if (ch==2) {
					System.out.println("Enter amount to Withdraw:");
					double withdrawAmount = in.nextDouble();
					op.withdrawAmount(withdrawAmount);
				}
			    else if(ch==3) {
			    	System.out.println("Enter Amount to Deposit :");
			    	double depositAmount = in.nextDouble();
			    	op.depositAmount(depositAmount );
			    }
			    else if (ch==4) {
					op.viewMIniStatement();
				}
			    else if (ch==5) {
					System.out.println("Collect your ATM card");
					System.out.println("Thanks for using our ATM..... ");
				    System.exit(0);
			    }
			    else {
			    	System.out.println("Please enter correct number");
			    }
			}
		}
		else {
			System.out.println("Incorrect Atm number or Atm pin");
			System.exit(0);
		}
	}

}
