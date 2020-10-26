package faucet;

public class Faucets {

	public static int max_faucets_to_use = 100;
	
	public static String site[] = new String[max_faucets_to_use];
	public static int time[] = new int[max_faucets_to_use];
	public static int amount[] = new int[max_faucets_to_use];
	
	
	public static long time_to_use[] = new long[max_faucets_to_use];
	public static int Order_Of_Amount[] = new int[max_faucets_to_use];
	static int Order_Of_Amount_Counter = 0;
	
	
	
	
	public static void Set_Order_Of_Amount() {
		
		int x = 0;
		int y = 2147483647;
		int temp_biggest = 0;
		int pos_temp_biggest= 0;
		int z = 0;
				
		Boolean Use_Same_Number = false;
		int Num_Use_Same_Number = 0;
		int SameNumber[] = new int[amount.length];
		
		
		while(z < amount.length) { 
			while(x < amount.length) {
				//Sorts from biggest to smallest
				if((amount[x] < y) & (temp_biggest < amount[x])) {
					//System.out.println("asdf");
					pos_temp_biggest = x;
					temp_biggest = amount[x];
					Num_Use_Same_Number =0;
				}
				else if((amount[x] != 0)  && (amount[x] == temp_biggest )) {
					//System.out.println("Amount[x] and temp_biggest are == each other " + amount[x]);
					SameNumber[Num_Use_Same_Number] = x;
					
					Use_Same_Number = true;
					Num_Use_Same_Number++;
				}
				
				x+=1;
			}
			y = amount[pos_temp_biggest];
			temp_biggest = 0;
			//System.out.println(y);
			if(Order_Of_Amount_Counter < max_faucets_to_use) {
				Order_Of_Amount[Order_Of_Amount_Counter] = pos_temp_biggest;
				Order_Of_Amount_Counter += 1;
				if(Use_Same_Number) {
					for(int loop=0; loop<Num_Use_Same_Number; loop++) {
						//System.out.println("Loop=" + Num_Use_Same_Number);
						Order_Of_Amount[Order_Of_Amount_Counter] = SameNumber[loop];
						Order_Of_Amount_Counter += 1;
					}
				
				}
			}
			
			
			
			
			z+=1;
			x=0;
		}
	}
	
	
	public static int Get_Best_Faucet() {
		int x = 0;
		while( x < max_faucets_to_use) {
			//System.out.println("Order of amount [x] = " + Order_Of_Amount[x]);
			
			if(time_to_use[Order_Of_Amount[x]] < System.currentTimeMillis()) {
				
				time_to_use[Order_Of_Amount[x]] = (System.currentTimeMillis() + time[Order_Of_Amount[x]]*1000);
				//System.out.println("Order of amount [x] = " + Order_Of_Amount[x]);
				return Order_Of_Amount[x];
			}
			
			x+=1;
		}
		return -1;
		
		
		//System.out.println("Time[0] = " + time_to_use[0]);
	}
	
	
}
