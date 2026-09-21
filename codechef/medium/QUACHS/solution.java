import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		if(scanner.hasNextInt()) {
		    int X = scanner.nextInt();
		    int Y = scanner.nextInt();
		    int Z = scanner.nextInt();
		    
		    int totalChips = X + Y;
		    int unavailableChips = 2* Z;
		    int remainingChips = totalChips - unavailableChips;
		    
		    System.out.println(remainingChips);
		}
		
		scanner.close();

	}
}
