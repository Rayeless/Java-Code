import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		BufferedReader scanner = new BufferedReader (new InputStreamReader(System.in));	//Initializes Scanner

		String s1 = scanner.readLine();	//Scans First Input Line
		String s2 = scanner.readLine(); //Scans Second Input Line
		
		String combined = combineStrings(s1, s2); //Calls Function to Combine 2 Strings
		System.out.println(combined); //Prints Combined String
		
	}
	
	public static String join(List<String> combinedString, String string) { //Takes a String List, then Spaces It
		StringBuilder sb = new StringBuilder();
		for (Object obj : combinedString)				//Repeats Value of "string" until no more Words 
			sb.append(obj.toString()).append(string);
		return sb.substring(0, sb.length() - 1);		//Returns Strings

	}
	
	public static String[] tokenize(String s1) { //Separates String into String Arrays 
		
    	int wordcount=1;						//Determines the amount of words in the String
    	for (int i=0; i<s1.length(); i++){
    		if(s1.charAt(i)==' '){
    			wordcount++;
    		}

    	}
    	int j=0;
    	String[] token=new String[wordcount];	//Initialize String Array
    	
    	StringTokenizer st = new StringTokenizer(s1);	//Creates a StringTokenizer
    	while(st.hasMoreTokens()) {						//While there are still more tokens
    		
    		token[j] = st.nextToken();					//Add the token(string) into the String Array
    		j++;
    	}

    	return token;									//Returns the String Array
 }

	public static int findInStringArray(String arrayS1, String arrayS2) {
		
		int positionS2 = -1;

		if (arrayS1.equalsIgnoreCase(arrayS2)) {	//If String1, matches anything in String2 (ignoring capitalization)
			
			positionS2 = 0;	//Sets the value to 0
		}
		
		return positionS2;	//returns a confirmation
		
	}
	
	public static List<String> combineArray(String[] arrayS1,String[] arrayS2,int num1,int num2)	{
		
		int s2Length = arrayS2.length - 1;				//Finds the length of 2nd Array

		List<String> array1 = new ArrayList<String>();	//Creates a String List
		
		for (int i = 0; i <= num1; i++)	{				//Adds 1st String to Array up to position
			
			array1.add(arrayS1[i]);						
		}
		
		List<String> array2 = new ArrayList<String>();	//Creates a Second String List
		
		
		for (int s2 = num2 + 1; s2 <= s2Length; s2++){	//Adds 2nd String into an Array
			
		array2.add(arrayS2[s2]);
		}
		
		List<String> Array = new ArrayList<String>();	//Initialize 3rd Array
		Array.addAll(array1);							//Adds First Array Value
		Array.addAll(array2);							//Adds Second Array 
		
		return Array;									//Returns String List
		
	}

	public static String combineStrings(String s1, String s2) {
		
		String[] arrayS1 = tokenize(s1);		//Calls function to turn String into String Array
		String[] arrayS2 = tokenize(s2);		//Calls function to turn String into String Array
		
		int s1Length = arrayS1.length - 1;		//Finds length of Array1
		int s2Length = arrayS2.length - 1;		//Finds length of Array2
		
		int s2Position = 0;
		int s1Position = 0;
		int determine = 0;
		
		for (int i = 0; i <= s1Length; i++)	{
			for(int k = 0;k <= s2Length; k++) {
				
				determine = findInStringArray((arrayS1[i]),arrayS2[k]);	//Call function to determine location match
				
				if (determine == 0)	{	//If strings match
					
					s2Position = k;		//Set s2Position to value of current k
					s1Position = i;		//Set s1Position to value of current i
					break;				//Breaks out of loop
				}
				
			}
			if (determine == 0)	{	//If previous break happened, then activate break
				
				break;
			}
			}
		
		if (determine == -1)	{	//If nothing similar found
			
			System.out.println("Error! There are no words that match within the texts.");	//Print Error Message
			System.exit(0);		//End Process
		}

		List<String> combinedString = combineArray(arrayS1, arrayS2, s1Position, s2Position);	//Calls function to combine Strings, while giving locations
		
		String finalString = join(combinedString, " ");	//Calls function to add spaces and transform into singular String
		
		return finalString;	//Return String
		
		
	}
	
	}



