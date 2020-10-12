package faucet;

public class Main {

	public static void main(String args[]) {
		
		
		File_io Files = new File_io();
		Files.read_options_txt();
		Files.Read_Csv();
		
		Faucets.Set_Order_Of_Amount();
		
		Keygrabber Keyg = new Keygrabber();
		Keyg.perma_run();
		
		
	}
}
