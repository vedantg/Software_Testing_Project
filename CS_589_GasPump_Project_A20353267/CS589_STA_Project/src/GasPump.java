import java.util.Scanner;

public class GasPump {
	private float Rprice;
	private float Sprice;
	private float Dprice;
	private int w;
	private float price;
	private int L;
	private float total;
	private float cash;
	private int k;

	public GasPump() {
		Rprice = 0;
		Sprice = 0;
		Dprice = 0;
		w = 0;
		price = 0;
		L = 0;
		total = 0;
		cash = 0;
		k = -1;
	}

	public final int Activate(float a, float b, float d) {
		if ((k == -1) && (a > 0) && (b > 0) && (d > 0)) {
			k = 0;
			Rprice = a;
			Sprice = b;
			Dprice = d;
			System.out.print("GAS PUMP IS ON");
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}

	}

	public final int PayCredit() {
		if (k == 0) {
			k = 2;
			System.out.print("CHECKING CREDIT CARD.");
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}
	}

	public final int Reject() {
		if (k == 2) {
			k = 0;
			System.out.print("CREDIT CARD IS REJECTED.");
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}
	}

	public final int Cancel() {
		if ((k == 3) || (k == 4)) {
			k = 0;
			System.out.print("TRANSACTION IS CANCELLED.");
			System.out.print("\n");
			if (w == 0) {
				System.out.print("$");
				System.out.print(cash);
				System.out.print(" OF CASH IS RETURNED");
				System.out.print("\n");
			}
			return 1;
		} else {
			return 0;
		}
	}

	public final int Approved() {
		if (k == 2) {
			k = 3;
			w = 1;
			System.out.print("CREDIT CARD APPROVED.");
			System.out.print("\n");
			System.out.print("SELECT TYPE OF GASOLINE:");
			System.out.print("\n");
			System.out.print("a. REGULAR");
			System.out.print("\n");
			System.out.print("b. SUPER");
			System.out.print("\n");
			System.out.print("c. DIESEL");
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}
	}

	public final int PayCash(float c) {
		if ((k == 0) && (c > 0)) {
			k = 3;
			w = 0;
			cash = c;
			System.out.print("SELECT TYPE OF GASOLINE:");
			System.out.print("\n");
			System.out.print("a. REGULAR");
			System.out.print("\n");
			System.out.print("b. SUPER");
			System.out.print("\n");
			System.out.print("c. DIESEL");
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}
	}

	public final int Regular() {
		if (k == 3) {
			k = 4;
			System.out.print("REGULAR IS SELECTED.");
			System.out.print("\n");
			price = Rprice;
			return 1;
		} else {
			return 0;
		}
	}

	public final int Super() {
		if (k == 3) {
			k = 4;
			System.out.print("SUPER IS SELECTED.");
			System.out.print("\n");
			price = Sprice;
			return 1;
		} else {
			return 0;
		}
	}

	public final int Diesel() {
		if (k == 3) {
			k = 4;
			System.out.print("DIESEL IS SELECTED.");
			System.out.print("\n");
			price = Dprice;
			return 1;
		} else {
			return 0;
		}
	}

	public final int StartPump() {
		if (k == 4) {
			k = 5;
			L = 0;
			total = 0;
			System.out.print("PUMP IS READY TO DISPOSE ");
			System.out.print("\n");
			System.out.print("# OF LITERS PUMPED: ");
			System.out.print(L);
			System.out.print("\n");
			System.out.print("TOTAL CHARGE: $");
			System.out.print(total);
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}
	}

	public final int PumpLiter() {
		if (k == 5) {
			if ((w == 1) || ((cash >= price * (L + 1)) && (w == 0))) {
				L = L + 1;
				total = L * price;
				System.out.print("# OF LITERS PUMPED: ");
				System.out.print(L);
				System.out.print("\n");
				System.out.print("TOTAL CHARGE: $");
				System.out.print(total);
				System.out.print("\n");
				System.out.print("CONTINUE PUMPING");
				System.out.print("\n");
				return 1;
			} else if ((w == 0) && (cash < price * (L + 1))) {
				k = 6;
				System.out.print("PUMP STOPPED. NOT SUFFICIENT FUNDS. ");
				System.out.print("\n");
				System.out.print("# OF LITERS PUMPED: ");
				System.out.print(L);
				System.out.print("\n");
				System.out.print("TOTAL CHARGE: $");
				System.out.print(total);
				System.out.print("\n");
				if ((w == 0) && (total < cash)) {
					System.out.print("$");
					System.out.print(cash - total);
					System.out.print(" OF CASH IS RETURNED");
					System.out.print("\n");
				}
				System.out.print("DO YOU WANT A RECEIPT?");
				System.out.print("\n");
				return 1;
			}
			;
		}
		;
		return 0;
	}

	public final int StopPump() {
		if (k == 5) {
			k = 6;
			System.out.print("PUMP STOPPED. ");
			System.out.print("\n");
			System.out.print("# OF LITERS PUMPED: ");
			System.out.print(L);
			System.out.print("\n");
			System.out.print("TOTAL CHARGE: $");
			System.out.print(total);
			System.out.print("\n");
			if ((w == 0) && (total < cash)) {
				System.out.print("$");
				System.out.print(cash - total);
				System.out.print(" OF CASH IS RETURNED");
				System.out.print("\n");
			}
			System.out.print("DO YOU WANT A RECEIPT?");
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}
	}

	public final int NoReceipt() {
		if (k == 6) {
			k = 0;
			System.out.print("NO RECEIPT IS PRINTED ");
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}
	}

	public final int Receipt() {
		if (k == 6) {
			k = 0;
			System.out.print("RECEIPT IS PRINTED: ");
			System.out.print("\n");
			System.out.print("# OF LITERS PUMPED: ");
			System.out.print(L);
			System.out.print("\n");
			System.out.print("TOTAL CHARGE: $");
			System.out.print(total);
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}
	}

	public final int TurnOff() {
		if (k == 0) {
			k = -2;
			System.out.print("GAS PUMP IS TURNED OFF ");
			System.out.print("\n");
			return 1;
		} else {
			return 0;
		}
	}

/*
 * Testing Oriented Methods : 
 * 1) Show the entered base price for the Gasoline
 * 2) Show the amount entered by the customer
 * 3) Show the currently residing state of GasPump system
 * 4) Show how many liters have been pumped out of selected Gasoline
 * 5) Show the total amount spent by the customer on selected Gasoline */
	
	public float BasetPriceOfGasoline() {
		return price;
	}

	public float GetAmountEntered() {
		return cash;
	}
	public int DisplayCurrentState()
	{
		if (k==-1)
		return -1;
		else if(k==5 && w==1)
			return k-4;
		else if(k==5 && w==0)
			return k;
		else if (k == -2)
			return k;
		else
			return k;
	}
	
	public float ShowNoOfLiterPumped() {
		return L;
	}

	public float GetTotalAmountSpent() {
		return total;
	}

	
// Start of Test Driver ::
	
	public static void main(String[] args) {
		
		float get_regular, get_super, get_diesel, get_cash;
		int return_type,operation;
		
		GasPump objGasPump = new GasPump();   // Created Object of GasPump Class

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("\t\t CS 589 : Software Testing And Analysis \n");
		System.out.print("\t\t\t Fall 2015 : Project \n");
		System.out.print("\t\t\t GasPump Test Driver !!! \n\n");
			

// Display Menu (operations) for the customer
		
		do{
		System.out.print("1.Activate");
		System.out.print(" 2.PayCredit");
		System.out.print(" 3.Reject");
		System.out.print(" 4.Approved");
		System.out.print(" 5.Cancel");
		System.out.print(" 6.PayCash");
		System.out.print(" 7.Regular");
		System.out.print(" 8.Super");
		System.out.println(" 9.Diesel");
		System.out.print("10.StartPump");
		System.out.print(" 11.PumpLiter");
		System.out.print(" 12.StopPump");
		System.out.print(" 13.PumpLiter");
		System.out.print(" 14.Receipt");
		System.out.print(" 15.NoReceipt");
		System.out.println(" 16.TurnOff");
		System.out.println("Testing Oriented Methods:: ");
		System.out.print("17.Show Current State of Gas Pump");
		System.out.print(" 18.Price of Gasoline");
		System.out.print(" 19.Show Enterted Amount");
		System.out.print(" 20.Show Total Amount Spent");
		System.out.print(" 21.Liters of Gasoline Pumped");

		System.out.println("\n\nPlease Select Operation To Be Performed");

		
		operation = input.nextInt();

// Switch cases to drive a selected operation
		
			switch (operation) {

			// Transaction : Activate
			case 1:

				System.out.println("Enter Base Price for Gasoline:: Regular, Super and Diesel");
				get_regular = input.nextFloat();
				get_super = input.nextFloat();
				get_diesel = input.nextFloat();
				return_type = objGasPump.Activate(get_regular, get_super, get_diesel);
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;

				// Transaction : PayCredit	
			case 2:

				return_type = objGasPump.PayCredit();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;

				// Transaction : Reject
			case 3:

				return_type = objGasPump.Reject();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;
				
				// Transaction : Approved
			case 4:

				return_type = objGasPump.Approved();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;
				
				// Transaction : Cancel
			case 5:

				return_type = objGasPump.Cancel();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;

				// Transaction : PayCash
			case 6:

				System.out.println(" Please Enter the Amount of Cash:: ");
				get_cash = input.nextFloat();
				return_type = objGasPump.PayCash(get_cash);
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;

				// Transaction : Regular (Type of Gasoline)
			case 7:

				return_type = objGasPump.Regular();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;
				
				// Transaction : Super (Type of Gasoline)
			case 8:

				return_type = objGasPump.Super();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;

				// Transaction : Diesel (Type of Gasoline)
			case 9:

				return_type = objGasPump.Diesel();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;
				
				// Transaction : StartPump
			case 10:

				return_type = objGasPump.StartPump();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;
				
				
				// Transaction : PumpLiter
			case 11:

				return_type = objGasPump.PumpLiter();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;

				// Transaction : StopPump
			case 12:

				return_type = objGasPump.StopPump();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;
				
			case 13:

				return_type = objGasPump.PumpLiter();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;

				// Transaction : Receipt
			case 14:

				return_type = objGasPump.Receipt();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;
				
				
				// Transaction : NoReceipt
			case 15:

				return_type = objGasPump.NoReceipt();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!! \n");
				}
				break;

				// Transaction : TurnOff
			case 16:

				return_type = objGasPump.TurnOff();
				if (return_type == 1) {
					System.out.println("Transaction Completed Successfully!!\n ");
				} else {
					System.out.println("Transaction is Unsuccessful!!\n");
				}
				break;

				// Testing Oriented Method : DisplayCurrentState
			case 17:
                return_type = objGasPump.DisplayCurrentState();
                if (return_type == -1)
                	System.out.println("Pump Has Not Been Entered Into Any State Yet!!!");
                else if (return_type == -2)
				System.out.println(" Gas Pump Has Been Turned Off: No Current State");
                else
                	System.out.println("Current State Of The GasPump: " + "S" + return_type);
				break;
				
				
				// Testing Oriented Method : BasetPriceOfGasoline
			case 18:
				
				System.out.println("Base Price Of Selected Gasoline Is: " +"$" + objGasPump.BasetPriceOfGasoline());
				break;


				// Testing Oriented Method : GetAmountEntered
			case 19:

				System.out.println("Entered Amount Is:$ " + objGasPump.GetAmountEntered());
				break;


				// Testing Oriented Method : GetTotalAmountSpent
			case 20:

				System.out.println("Total Amount Spent Is:$ " + objGasPump.GetTotalAmountSpent());
				break;
				
				// Testing Oriented Method : ShowNoOFLiterPumped
			case 21:

				System.out.println("No of Liters Gasoline Is Pumped: "+ objGasPump.ShowNoOfLiterPumped());
				break;
				
				// Default Case : Asking for valid input from user
			default:
				System.out.println("Please Select Valid Option");
				break;

			}

		}while(operation != -1);
	}
}