package faucet;
import java.util.*;  

public class Keygrabber {
	public void perma_run() {


		

		Scanner sc= new Scanner(System.in);


		while(true) {

			System.out.print("Press Enter: ");

			String str= sc.nextLine();
			
			int h = Faucets.Get_Best_Faucet();
			if(h != -1) {
				Chrome.open_link(h);
			}
			else {
				System.out.println("Error: No available sites currently(try again or add more sites)");
			}
		}
	}


}
