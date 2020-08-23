package faucet;

import java.io.IOException;

public class Chrome {

	public static String Profile_Directory1="Bitcoin";
	public static String Profile_Directory2="Bitcoin2";
	public static int Use_Both_Profiles = 0;
	
	private static int Use_First_Profile = 1;
	
	public static void open_link(int faucet_number) {
		
		try {
			if(Use_Both_Profiles == 1 & Use_First_Profile == 1) {
				System.out.println("Opening chrome with the profile: " + Profile_Directory1);
				Runtime.getRuntime().exec("chrome --profile-directory=\"" + Profile_Directory1 + "\" " + Faucets.site[faucet_number]);
				Use_First_Profile = 0;
			}
			else if(Use_Both_Profiles == 1 & Use_First_Profile == 0) {
				System.out.println("Opening chrome with the profile: " + Profile_Directory2);
				Runtime.getRuntime().exec("chrome --profile-directory=\"" + Profile_Directory2 + "\" " + Faucets.site[faucet_number]);
				Use_First_Profile = 1;
			}
			else if(Use_Both_Profiles == 0) {
				System.out.println("Opening chrome with the profile: " + Profile_Directory1);
				Runtime.getRuntime().exec("chrome --profile-directory=\"" + Profile_Directory1 + "\" " + Faucets.site[faucet_number]);
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
