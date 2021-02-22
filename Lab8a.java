public class Lab8a {
	 //-----------------------------------------------------------------
	   //  Creates some bank accounts and requests various services.
	   //-----------------------------------------------------------------
	   public static void main (String[] args) {
		   Account acct1 = new Account ("Ted Murphy", 72354, 102.56);
		   Account acct2 = new Account ("Anita Gomez", 69713, 40.00);
		   Account acct3 = new Account ("Sanchit Red", 93757, 759.32);
		   Account acct4 = new Account("Fred Smith", 12345, 200.00);

		   System.out.println (acct1);
		   System.out.println (acct2);
		   System.out.println (acct3);
		   System.out.println (acct4);
		    
		   System.out.println("\n---------Lock Account 1 and Try to Withdraw/Transfer/Deposit/AddInterest (/4) --------\n");
		   acct1.setKey(123);
		   acct1.lock(123);
		   System.out.println ("Withdraw $100: " + acct1.withdraw(100, 0));
		   System.out.println ("Transfer $100: " + acct4.transfer(100, acct1));
		   System.out.println ("Deposit $100: " + acct1.deposit(100));
		   System.out.println ("Add Interest: " + acct1.addInterest());
	       System.out.println("\n---------Unlock Account 1 and Try to Withdraw/Transfer/Deposit/AddInterest (/4) --------\n");
           acct1.unlock(123);
		   System.out.println ("Withdraw $100: " + acct1.withdraw(100, 0));
		   System.out.println ("Transfer $100: " + acct4.transfer(100, acct1));
		   System.out.println ("Deposit $100: " + acct1.deposit(100));
		   System.out.println ("Add Interest: " + acct1.addInterest());


		   System.out.println("\n---------Lock Account 2 and Withdraw If Locked  (/3)--------\n");
		   acct2.setKey(15);
		      if (acct2.locked()) {
		        System.out.println("1. Locked is not working");
		      } else {
		        System.out.println("1. Locked is working");
		      }
		      acct2.lock(15);
		      if (acct2.locked()) {
		        System.out.println("2. Locked is working");
		      } else {
		        System.out.println("2. Locked is not working");
		      }

		      acct2.unlock(15);
		      if (acct2.locked()) {
		        System.out.println("3. Locked is not working");
		      } else {
		        System.out.println("3. Locked is working");
		      }
		      
		      System.out.println("\n-------------------------------------------------------\n");

	   }//main

}//Lab8a
