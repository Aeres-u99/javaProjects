import java.util.Scanner;

class Bank
{
	private String accno;
	private String name;
	private long balance;

	Scanner KB=new Scanner(System.in);
	
	//method to open an account

  
	void openAccount()
	{ 
		System.out.print("Enter Account No: ");
		accno=KB.next();
		System.out.print("Enter Name: ");
		name=KB.next();
		System.out.print("Enter Balance: ");
		balance=KB.nextLong();
	}

	//method to display account details
	void showAccount()
	{ 
        System.out.println("____________________________________");
		System.out.println(accno+"|"+name+"|"+balance);
        System.out.println("------------------------------------");
	}

	//method to deposit money
	void deposit()
	{
		long amt;
		System.out.println("Enter Amount you would like to Deposit : ");
		amt=KB.nextLong();
		balance=balance+amt;
	}

	//method to withdraw money
	void withdrawal()
	{
		long amt;
		System.out.println("Enter Amount you would like to withdraw : ");
		amt=KB.nextLong();
		if(balance>=amt)
		{ 
			balance=balance-amt;
		}
		else
		{
			System.out.println("Less Balance... \n Transaction Failed..");
		}
	}

	//method to search an account number
	boolean search(String acn)
	{ 
		if(accno.equals(acn))
		{ 
			showAccount();
			return(true);
		}
		return(false);
	}
}

class ExBank
{
    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}
	public static void main(String arg[])
	{
		Scanner KB=new Scanner(System.in);
		
		//create initial accounts
        clearScreen();
System.out.println("____              _   ");
System.out.println("| __ )  __ _ _ __ | | __");
System.out.println("|  _ \\ / _` | '_ \\| |/ /");
System.out.println("| |_) | (_| | | | |   < ");
System.out.println("|____/ \\__,_|_| |_|_|\\_\\");
                        
        
		System.out.print("How Many Customer you would like to Input : ");
		int n=KB.nextInt();
		Bank  C[]=new Bank[n];
		for(int i=0;i<C.length;i++)
		{   
			C[i]=new Bank();
			C[i].openAccount();
		}
		
		//run loop until menu 5 is not pressed
		int ch;
		do
		{
			System.out.println("Main Menu\n [1].Display All\n [2].Search By Account\n [3].Deposit\n [4].Withdrawal\n [5].Exit");
			System.out.println(" Select an option from Menu :");
			ch=KB.nextInt();
			switch(ch)
			{ 
				case 1:
                    clearScreen();
					for(int i=0;i<C.length;i++)
					{
						C[i].showAccount();
					}
					break;

				case 2:
					System.out.print("Enter Account number you would like to Search...: ");
					String acn=KB.next();
					boolean found=false;
                    clearScreen();
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(acn);
						if(found)
						{
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed... \n Account does not Exists..");
					}
					break;

				case 3:
					System.out.print("Enter Account No : ");
					acn=KB.next();
					found=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(acn);
						if(found)
						{
							C[i].deposit();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed... \n Account does not Exists..");
					}
					break;

				case 4:
					System.out.print("Enter Account No : ");
					acn=KB.next();
					found=false;
					for(int i=0;i<C.length;i++)
					{  
						found=C[i].search(acn);
						if(found)
						{
							C[i].withdrawal();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Search Failed... \n Account does not Exists..");
					}
					break;

				case 5:
                    clearScreen();
					System.out.println("Good Bye..");
					break;
			}
		}
		while(ch!=5);
	}
}

