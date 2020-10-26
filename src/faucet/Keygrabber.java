package faucet;
import java.util.*;
import java.util.concurrent.TimeUnit;  

public class Keygrabber {
	
	public static double Run_On_Timer_Time=0;
	
	
	public static void run_on_a_timer() {
		
		while(true) {
			int h = Faucets.Get_Best_Faucet();
			if(h != -1) {
				Chrome.open_link(h);
			}
			else {
				System.out.println("Error: No available sites currently(try again or add more sites)");
			}
			
			
			
			try {
				TimeUnit.MILLISECONDS.sleep((int)(Run_On_Timer_Time*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public static void perma_run() {	

		Scanner sc= new Scanner(System.in);


		while(true) {
			
			
			System.out.print("Press Enter: ");

			String str= sc.nextLine();
			
			//System.out.println(str);
			
			//System.out.println("Do Something!!");
			//System.out.println("This is the best site: " + Faucets.site[Faucets.Get_Best_Faucet()]);
			int h = Faucets.Get_Best_Faucet();
			if(h != -1) {
				Chrome.open_link(h);
			}
			else {
				System.out.println("Error: No available sites currently(try again or add more sites)");
			}
			//sc.close();
		}
	}


}
