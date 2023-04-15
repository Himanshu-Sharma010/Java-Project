package in.ineuron.main;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements IAtmOperation {

	ATM atm = new ATM();
	Map<Double, String> miniStmt = new HashMap<>();
	
	
	@Override
	public void viewBalance() {

		System.out.println("Available Balance is :"+atm.getBalance());
	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		if(withdrawAmount%500==0) {
         if(withdrawAmount<=atm.getBalance())
		{
        	 miniStmt.put(withdrawAmount, " Amount WithDrawn!!");
        	 System.out.println("Collect the Cash: "+withdrawAmount);
		atm.setBalance(atm.getBalance()-withdrawAmount);
		viewBalance();
	}
         else {
        	 System.out.println("Insufficient Balance!!");
         }
         }
		else {
			System.out.println("Please enter the amount Multiple of 500!!");
		}	
	}

	@Override
	public void depositAmount(double depositAmount) {

		miniStmt.put(depositAmount, " Amount Deposited!!");
		System.out.println(depositAmount+" Deposited Successfully!!");
		atm.setBalance(atm.getBalance()+depositAmount);
		viewBalance();
	}

	@Override
	public void viewMIniStatement() {
		for(Map.Entry<Double, String>m:miniStmt.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}

	}

}
