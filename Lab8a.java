public class Lab8a {

	public static void main(String[] args) {
		Account acct1 = new Account ("Ted Murphy", 12345, 214.56);
	      Account acct2 = new Account ("Anita Gomez", 54321, 20.00);
	     

	      System.out.println ("Murphy balance after deposit: $" + acct1.deposit (14.58));
	      System.out.println ("Gomez balance after deposit: $" + acct2.deposit (300.00));

	      System.out.println ("Gomez balance after withdrawal: $" + acct2.withdraw (100.00, 2.00));

		  System.out.print("\nWithdraw $800 from Gomez account: ");
	      acct2.withdraw (800.00, 0.0);  // exceeds balance

	      acct1.addInterest();
	      acct2.addInterest();
	     
	      System.out.println ("\nAccount Balances:");
	      System.out.println (acct1);
	      System.out.println (acct2);
	     

	      // transfer $50 from account 1 to account 2
		  System.out.println ("\nTransfer $50 from Murphy to Gomez:");
	      acct1.transfer(50, acct2);

	   

	      System.out.println (acct1);
	      System.out.println (acct2);

	}

}
