import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] string = new String[9];
		
		string[0] = "1";
		string[1] = "2";
		string[2] = "3";
		string[3] = "4";
		string[4] = "5";
		string[5] = "6";
		string[6] = "7";
		string[7] = "8";
		string[8] = "9";
		
		String x = "X";
		String o = "O";	
		
		print(string);
		
		for(int i = 0; i < 9; i++) {
			
		PlayerX(string);
		clearScreen();
		print(string);
		winner(string);
		
		PlayerY(string);
		clearScreen();
		print(string);
		winner(string);
		
		}
		
	}
	
	public static String[] PlayerY(String[] string)	{
		
		Scanner scanner = new Scanner(System.in);
		
		String num = "";
		int jump = 0;
		
		System.out.println("Player 2:");
		System.out.println("Enter A Number Between 1-9");
		num = scanner.nextLine();

		
		for(int i = 0; i <= 8; i++) {
			
			if (string[i].equals(num))	{
				
				string[i] = "O";
			}
			
		}
		
		return string;
	}

	public static String[] PlayerX(String[] string)	{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Player 1:");
		System.out.println("Enter A Number Between 1-9");
		
		String num = scanner.nextLine();
		
		for(int i = 0; i <= 8; i++) {
			
			if (string[i].equals(num))	{
				
				string[i] = "X";
			}
			
		}
		
		return string;
	}

	public static void print(String[] string)	{
		
		System.out.println("___________________");
		System.out.println("|     |     |     |");
		System.out.println("|  " + string[0] + "  |  " + string[1] + "  |  " + string[2] + "  |");
		System.out.println("|     |     |     |");
		System.out.println("-------------------");
		System.out.println("|     |     |     |");
		System.out.println("|  " + string[3] + "  |  " + string[4] + "  |  " + string[5] + "  |");
		System.out.println("|     |     |     |");
		System.out.println("-------------------");
		System.out.println("|     |     |     |");
		System.out.println("|  " + string[6] + "  |  " + string[7] + "  |  " + string[8] + "  |");
		System.out.println("|     |     |     |");
		System.out.println("___________________");
		
	}


	public static void winner(String[] string)	{
		
		if (string[0].equals(string[3]) && string[0].equals(string[6]))	{
			System.out.println("Winner!!");
			System.exit(0);
		}
		if (string[1].equals(string[4]) && string[1].equals(string[7]))	{
			System.out.println("Winner!!");
			System.exit(0);
		}
		if (string[2].equals(string[5]) && string[2].equals(string[8]))	{
			System.out.println("Winner!!");
			System.exit(0);
		}
		if (string[0].equals(string[1]) && string[0].equals(string[2]))	{
			System.out.println("Winner!!");
			System.exit(0);
		}
		if (string[3].equals(string[4]) && string[3].equals(string[5]))	{
			System.out.println("Winner!!");
			System.exit(0);
		}
		if (string[6].equals(string[7]) && string[6].equals(string[8]))	{
			System.out.println("Winner!!");
			System.exit(0);
		}
		if (string[0].equals(string[4]) && string[0].equals(string[8]))	{
			System.out.println("Winner!!");
			System.exit(0);
		}
		if (string[2].equals(string[4]) && string[2].equals(string[6]))	{
			System.out.println("Winner!!");
			System.exit(0);
		}

	}
	
	public static void clearScreen() {  
	    
		for(int i = 0; i < 21; i++) {
			
			System.out.println();
			
		}
		
	} 

}