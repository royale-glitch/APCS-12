//********************************************************************
//  Account.java       Author: Lewis/Loftus
//
//  Represents a bank account with basic services such as deposit
//  and withdraw.
//********************************************************************

import java.text.NumberFormat;

public class Account{
   private NumberFormat fmt = NumberFormat.getCurrencyInstance();
   private final double RATE = 0.035;  // interest rate of 3.5%

   private long acctNumber;
   private double balance;
   private String name;

   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner, account number,
   //  and initial balance.
   //-----------------------------------------------------------------
   public Account (String owner, long account, double initial)
   {
      name = owner;
      acctNumber = account;
      balance = initial;
   }

   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner and account number.
   //  Initial balance is set to zero
   //-----------------------------------------------------------------
   public Account (String owner, long account)   {
     name = owner;
	 acctNumber = account;  
	 balance = 0;
   }
   
   //-----------------------------------------------------------------
   //  Deposits the specified amount into the account. Returns the
   //  new balance.
   //-----------------------------------------------------------------
   public double deposit (double amount)
   {
       if (amount < 0)  // deposit value is negative
       {
          System.out.println ();
          System.out.println ("Error: Deposit amount is invalid.");
          System.out.println (acctNumber + "  " + fmt.format(amount));
       }
       else
          balance = balance + amount;

       return balance;
   }

   //-----------------------------------------------------------------
   //  Withdraws the specified amount from the account and applies
   //  the fee. Returns the new balance.
   //-----------------------------------------------------------------
   public double withdraw (double amount, double fee)
   {
      amount += fee;

		if (amount < 0){
			System.out.println ();
			System.out.println ("Error: Withdraw amount is invalid.");
			System.out.println ("Account: " + acctNumber);
			System.out.println ("Requested: " + fmt.format(amount));
		}
		else if (amount > balance) {  // withdraw value exceeds balance
			
			System.out.println ();
			System.out.println ("Error: Insufficient funds.");
			System.out.println ("Account: " + acctNumber);
			System.out.println ("Requested: " + fmt.format(amount));
			System.out.println ("Available: " + fmt.format(balance));
			}else {
			balance = balance - amount;
			}
		return balance;
   }

   //-----------------------------------------------------------------
   //  Adds interest to the account and returns the new balance.
   //-----------------------------------------------------------------
   public double addInterest () {
      balance += (balance * RATE);
      return balance;
   }

   //-----------------------------------------------------------------
   //  Returns the current balance of the account.
   //-----------------------------------------------------------------
   public double getBalance () {
      return balance;
   }

   //-----------------------------------------------------------------
   //  Validates the transaction.  If sufficent funds exist, withdraws the specified amount
   //  from the "from" account and deposits it into the "to" account returning true,
   //  else does nothing and returns false.
   //-----------------------------------------------------------------
   public static boolean transfer (double amount, double fee, Account from, Account to){

      return true;
   }
    //-----------------------------------------------------------------
   //  Validates the transaction.  If sufficent funds exist, withdraws the specified amount
   //  from this account and deposits it to the "to" account returning true,
   //  else does nothing and returns false.
   //-----------------------------------------------------------------

   public boolean transfer (double amount, Account to){
      
	   
	   return true;
   } 

	//-----------------------------------------------------------------
	//  Returns the account number.
	//-----------------------------------------------------------------
	public long getAccountNumber () {
		return acctNumber;
	}
   //-----------------------------------------------------------------
   //  Returns a one-line description of the account as a string.
   //-----------------------------------------------------------------
   public String toString (){
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
   }
}