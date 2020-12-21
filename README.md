# FaucetHelper
Assists in long term use of bitcoin and alt-coin faucets


To use run New_Faucets.jar with `java -jar New_Faucets.jar`
this will create 2 files with the default options.  
Pressing enter will open the website in chrome with the profile directed in Options.txt

Faucets.csv is a csv file with each line containing
Website,timeinseconds,priority,
priority(int) is just what ranking it should have, you can easily use this as how many satoshis you get on the site
timeinseconds(int) is how long it will take until you can go back and redeem more bitcoins
Website(string) is the link to the site you want to go to

Options.txt is the options that go into running such as the profiles chrome uses and if you want to use multiple profiles

