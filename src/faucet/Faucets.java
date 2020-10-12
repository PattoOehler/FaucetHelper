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
		while(z < amount.length) { 
			while(x < amount.length) {
				if((amount[x] < y) & (temp_biggest < amount[x])) {
					pos_temp_biggest = x;
					temp_biggest = amount[x];
				}
				
				x+=1;
			}
			y = amount[pos_temp_biggest];
			temp_biggest = 0;

			Order_Of_Amount[Order_Of_Amount_Counter] = pos_temp_biggest;
			Order_Of_Amount_Counter += 1;
			z+=1;
			x=0;
		}
	}
	
	
	public static int Get_Best_Faucet() {
		int x = 0;
		while( x < max_faucets_to_use) {
			
			if(time_to_use[Order_Of_Amount[x]] < System.currentTimeMillis()) {
				
				time_to_use[Order_Of_Amount[x]] = (System.currentTimeMillis() + time[Order_Of_Amount[x]]*1000);
				return Order_Of_Amount[x];
			}
			
			x+=1;
		}
		return -1;
		
	}
	
	
}
