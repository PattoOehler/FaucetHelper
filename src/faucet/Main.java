package faucet;

public class Main extends Thread {
	
	public void run() {
		Keygrabber.run_on_a_timer();
	}
	

	public static void main(String args[]) {
		
		File_io Files = new File_io();
		Files.read_options_txt();
		Files.Read_Csv();
		
		Faucets.Set_Order_Of_Amount();
		
		
		if(Keygrabber.Run_On_Timer_Time != 0) {
			Main thread = new Main();
			thread.start();
		}
		Keygrabber.perma_run();
		
	
		
	}
}
