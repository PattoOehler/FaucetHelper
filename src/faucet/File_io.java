package faucet;
import java.io.*;

public class File_io {
	
	int max_faucets_to_use = Faucets.max_faucets_to_use;
	
	String site[] = new String[max_faucets_to_use];
	int time[] = new int[max_faucets_to_use];
	int amount[] = new int[max_faucets_to_use];
	long current_time[] = new long[max_faucets_to_use];
	int amount_counter = 0;
	
	public void Read_Csv() {
		
		/* Standard for the csv file is
		 * Link, Time(seconds), Amount_gained in Shatoshi
		 * ^per line
		 * Named Faucets.csv
		 * If the file isn't made will automatically make one with one line
		 */
		
		File file = new File("Faucets.csv");
		if(file.exists() == false) {
			try {
				 if (file.createNewFile()) {
				        System.out.println("File created: " + file.getName());
				 } else {
				        System.out.println("File already exists... Error");
				 }
				 
				FileWriter myWriter = new FileWriter("Faucets.csv");
				myWriter.write("Freebitco.in,3600,228,");
				myWriter.close();
				
				
			}catch (IOException e) {
				System.out.println("Error");
			}
			
		}
		
		//Reading the file
		String line = null;
		try {
			FileReader fileReader = new FileReader("Faucets.csv");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			/*int x = 0;
			int commacounter = 0;
			int commaposition[] = new int[2];
			String shatoshis;
			*/
			int x = 0;
			int commacounter = 0;
			int commaposition[] = new int[3];
			while((line = bufferedReader.readLine()) != null) {
				
				while(x < line.length()) {
					
					if(line.charAt(x) == ',') {
						commaposition[commacounter] = x;
						commacounter +=1;
					}
					if(commacounter == 3) {
						
						
						Faucets.site[amount_counter] = line.substring(0, commaposition[0]);
						Faucets.time[amount_counter] = Integer.parseInt(line.substring(commaposition[0]+1, commaposition[1]));
						Faucets.amount[amount_counter] = Integer.parseInt(line.substring(commaposition[1]+1, commaposition[2]));
						amount_counter += 1;
						commacounter=0;
					}
					
					
					x+=1;
				}
				x=0;
				//System.out.println(line);
			}
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	
			
	}
	
	public int String_Compare(String A, String B) {
		//Returns 1 on failure 0 on success
		
		//System.out.println("String comparing: " + A + " " + B);
		
		int shorter_length;
		if(A.length() >= B.length()) {
			shorter_length=B.length();
		}
		else {
			shorter_length=A.length();
		}
		

		
		
		int i = 0;
		int A_char;
		int B_char;
		
		while(i < shorter_length ) {
			A_char = (int)A.charAt(i);
			B_char = (int)B.charAt(i);

			if(A_char != B_char) {
				//System.out.println("A and B are not similar because of " + i);
				return 1;
			}
			i+=1;
		}
		//System.out.println("A and B are the same");
		return 0;
	}
	
	
	
	
	
	
	public int getbestline() {
		//Get the most paying line
		int i=0;
		int biggest=0;
		int keep_track=0;
		while(i < amount.length) {
			if(Faucets.amount[i] > biggest) {
				biggest = Faucets.amount[i];
				keep_track = i;
			}
			i+=1;
			
		}
		System.out.println("Keep_Track = \"" + keep_track + "\"");
		return keep_track;
		
	}
	
	
	public void read_options_txt() {
		
		File file = new File("Options.txt");
		if(file.exists() == false) {
			try {
				 if (file.createNewFile()) {
				        System.out.println("File created: " + file.getName());
				 } else {
				        System.out.println("File already exists... Error");
				 }
				 
				FileWriter myWriter = new FileWriter("Options.txt");
				myWriter.write("#This file is for setting the options for this project\n");
				myWriter.write("#Profile1 and Profile2 are the profiles that chrome uses\n");
				myWriter.write("Profile1=\n");
				myWriter.write("Profile2=\n");
				myWriter.write("#Set UseBothProfiles to 1 if you would like to use Profile1 and Profile2\n");
				myWriter.write("UseBothProfiles=0\n");
				//myWriter.write("#Set Use_Timer to 1 if you would like to open sites on a timer rather then pressing enter\n");
				//myWriter.write("Use_Timer=0\n");
				//myWriter.write("#Set Time_Inbetween_Sites to the time(Seconds) to open the next site\n");
				//myWriter.write("Time_Inbetween_Sites=10\n");
				myWriter.close();
				
				
			}catch (IOException e) {
				System.out.println("Error");
			}
			
		}
		
		String line = null;
		try {
			FileReader fileReader = new FileReader("Options.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				
				if(line.charAt(0) == '#') {
					//System.out.println("# line");
				}
				else if(String_Compare(line, "Profile1=") == 0) {
					if(line.length() > 9) {
						System.out.println("Setting Profile1 to-\"" + line.substring(9, line.length())+ "\"");
						Chrome.Profile_Directory1 = line.substring(9, line.length());
					}
				}
				else if(String_Compare(line, "Profile2=") == 0) {
					if(line.length() > 9) {
						System.out.println("Setting Profile2 to- \"" + line.substring(9, line.length())+ "\"");
						Chrome.Profile_Directory2 = line.substring(9, line.length());
					}
				}
				else if(String_Compare(line, "UseBothProfiles=") == 0) {
					if(line.length() > 16) {
						System.out.println("Setting UseBothProfiles to - \"" + line.substring(16, line.length())+ "\"");
						if(line.charAt(16) == '1') {
							System.out.println("Using both Profiles");
							Chrome.Use_Both_Profiles = 1;
						}
						else if(line.charAt(16) == '0') {
							System.out.println("Not using both Profiles");
							
						}
						else {
							System.out.println("Unknown option for Use_Both_Profiles");
						}
					}
				}
				
				
			}
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
	
}