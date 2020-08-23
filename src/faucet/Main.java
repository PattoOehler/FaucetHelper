package faucet;

public class Main {

	public static void main(String args[]) {
		
		//System.out.println(System.currentTimeMillis());
		//long asdf = System.currentTimeMillis();
		
		File_io Files = new File_io();
		Files.read_options_txt();
		Files.Read_Csv();
		
		//Files.getbestline();
		Faucets.Set_Order_Of_Amount();
		
		//Faucets.Get_Best_Faucet();
		//int x = 0;
		//while(x < Faucets.Order_Of_Amount.length) {
			//System.out.println(Faucets.Order_Of_Amount[x]);
			//x+=1;
		//}
		
		//Keygrabber Keyg = new Keygrabber();
		//Keyg.perma_run();
		Keygrabber Keyg = new Keygrabber();
		Keyg.perma_run();
		
		
	}
}
