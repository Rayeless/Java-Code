import java.io.*;
import java.util.*;
public class 1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("D:\\Documents\\Coding Comp\\2018\\Q1\\DATA11.txt"));
		
		Scanner scanner = new Scanner(new FileReader("d:\\Documents\\Coding Comp\\2018\\Q1\\DATA12.txt"));
		
		int n = scanner.nextInt();
		
		for (int p = 0; p < n; p++)	{
		
		int boxDays = scanner.nextInt();
		int shopDays = scanner.nextInt();
		
		String trash = br.readLine();
		
		int counter = 0;
		int emptyDays = 0;
		String b = "B";
		String e = "E";
		
		String[] eb = new String[shopDays];
		Integer[] result = new Integer[shopDays];
		
		for(int i = 0; i < shopDays; i++)	{
			
			eb[i] = br.readLine();
		}
		
		for (int i = 0; i < shopDays; i++)	{	//Calcuates 
			
			if (eb[i].equals(b))	{
				result[i] = 1;
			}	else	{
				result[i] = 0;
			}
		}
		
			for (int i = 0; i < shopDays; i++)	{	//Counts Bs
				
				if (result[i].equals(1))	{
					counter++;
					
				}
			}
		int forceExit = 0;
		for (int i = 0; i < shopDays; i++) {
				
				if (result[i].equals(0))	{
					emptyDays++;
				}	else if (result[i].equals(1))	{
					forceExit = 1;
					break;
				}
				
				if (forceExit == 1)	{
					break;
				}
		}
		
		int endDays = counter * boxDays;
		endDays = endDays + emptyDays;
		endDays = endDays - shopDays;
		
		if (endDays <= 0)	{
			endDays = 0;
		}
		
		System.out.println(endDays);
		
		for (int i = 0; i < shopDays; i++)	{
			
			scanner.next();
		}
		
	}
	}
}
