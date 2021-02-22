//********************************************************************
//  Account.java       Author: Lewis/Loftus
//
//  Represents a bank account with basic services such as deposit
//  and withdraw.
//********************************************************************

import java.text.NumberFormat;

public class Account implements Lockable{
   private NumberFormat fmt = NumberFormat.getCurrencyInstance();
   private final double RATE = 0.035;  // interest rate of 3.5%

   private long acctNumber;
   private double balance;
   private String name;
   private int key;
   private boolean isLocked;

   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner, account number,
   //  and initial balance.
   //-----------------------------------------------------------------
   public Account (String owner, long account, double initial){
      name = owner;
      acctNumber = account;
      balance = initial;
      isLocked = false;
   }//Account

   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner and account number.
   //  Initial balance is set to zero
   //-----------------------------------------------------------------
   public Account (String owner, long account)   {
     name = owner;
	 acctNumber = account;  
	 balance = 0;
	 isLocked = false;
   }//Account
   
   //-----------------------------------------------------------------
   //  Deposits the specified amount into the account. Returns the
   //  new balance.
   //-----------------------------------------------------------------
   public double deposit (double amount) {
	   if(this.isLocked) {
    	   return balance;
       }
	   if (amount < 0)  // deposit value is negative
       {
          System.out.println ();
          System.out.println ("Error: Deposit amount is invalid.");
          System.out.println (acctNumber + "  " + fmt.format(amount));
       }
       else {
          balance = balance + amount;
       }
       return balance;
   }//deposit

   //-----------------------------------------------------------------
   //  Withdraws the specified amount from the account and applies
   //  the fee. Returns the new balance.
   //-----------------------------------------------------------------
   public double withdraw (double amount, double fee) {
	   if(this.isLocked) {
    	   return balance;
       }
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
			balance -= amount;
			}
		return balance;
   }//withdraw

   //-----------------------------------------------------------------
   //  Adds interest to the account and returns the new balance.
   //-----------------------------------------------------------------
   public double addInterest () {
	   if(this.isLocked) {
    	   return balance;
       }
	   balance += (balance * RATE);
      return balance;
   }//addInterest

   //-----------------------------------------------------------------
   //  Returns the current balance of the account.
   //-----------------------------------------------------------------
   public double getBalance () {
      return balance;
   }//getBalance

   //-----------------------------------------------------------------
   //  Validates the transaction.  If sufficent funds exist, withdraws the specified amount
   //  from the "from" account and deposits it into the "to" account returning true,
   //  else does nothing and returns false.
   //-----------------------------------------------------------------
   public static boolean transfer (double amount, double fee, Account from, Account to){
	   if(from.isLocked || to.isLocked) {
    	   return false;
       }
	   if(from.getBalance() >= amount) {
		   from.withdraw(amount, fee);
		   to.deposit(amount);
		   return true;
	   }else {
		   return false;
	   }
   }//transfer
    //-----------------------------------------------------------------
   //  Validates the transaction.  If sufficent funds exist, withdraws the specified amount
   //  from this account and deposits it to the "to" account returning true,
   //  else does nothing and returns false.
   //-----------------------------------------------------------------

   public boolean transfer (double amount, Account to){
       if(this.isLocked || to.isLocked) {
    	   return false;
       }
	   
	   if(this.getBalance() >= amount) {
    	  this.withdraw(amount, 0);
    	  to.deposit(amount);    	  
    	  return true;
      } else {
    	  return false;
      }

   } //transfer

	//-----------------------------------------------------------------
	//  Returns the account number.
	//-----------------------------------------------------------------
	public long getAccountNumber () {
		return acctNumber;
	}//getAccountNumber
   //-----------------------------------------------------------------
   //  Returns a one-line description of the account as a string.
   //-----------------------------------------------------------------
   public String toString (){
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
   }//toString

   @Override
	public void setKey(int key) {
		this.key = key;
		
	}//setKey
	
   @Override
	public void lock(int key) {
		if(this.key != key) {
			return;
		} else {			
			this.isLocked = true;
		}
		
	}//lock
	
   @Override
	public void unlock(int key) {
	   if(this.key != key) {
			return;
		} else {			
			this.isLocked = false;
		}
		
	}//unlock
   @Override
	public boolean locked() {
		return this.isLocked;
	}//locked
}//Account
