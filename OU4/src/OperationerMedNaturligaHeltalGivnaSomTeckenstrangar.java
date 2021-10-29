import static java.lang.System.out;

import java.util.Scanner;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
	public static void main (String[] args)
	{	
		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
	
		// mata in tv� naturliga heltal
		Scanner in = new Scanner (System.in);
		out.println ("tv� naturliga heltal:");
		String tal1 = in.next ();
		String tal2 = in.next ();
		out.println ();

		// addera heltalen och visa resultatet
		String summa = addera (tal1, tal2);
		visa (tal1, tal2, summa, '+');
		
		// subtrahera heltalen och visa resultatet
		String differens = subtrahera(tal1,tal2);
		visa (tal1, tal2, differens, '-');

	}


	// addera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar deras
	// summa som en teckenstr�ng.
	public static String addera (String tal1, String tal2)
	{
		//deklarera talen som anv�nds f�r att r�kna
		StringBuilder summa = new StringBuilder();
		int talA;
		int talB;
		int minne = 0;	

		for(int i = 1; i <= tal1.length(); i++) {
			//skapa index f�r talet som f�rst ska adderas
			int indexA = tal1.length() - i;
			int indexB = tal2.length() - i;
		
		if (indexB < 0)
		{
			talA = tal1.charAt(indexA) - 48;
			talB = 0; //om andra talet tagit slut p� siffror. (f�r att undvika error)
		}
		else {
			talA = tal1.charAt(indexA) - 48;
			talB = tal2.charAt(indexB) - 48;
		}
		
		//addera siffrorna fr�n b�da talen och eventuell minnessiffra
		int sum = talA + talB + minne;
		
		//om summan av siffrorna �r st�rre �n 9, l�gg till en minnessiffra
		if(sum > 9)
		{
			minne = 1;
			sum -= 10;
		}
		else {
			minne = 0;
		}
		
		//out.println("Ber�kning " + i + ": " + talA + " + " + talB);
		
		summa.append(Integer.toString(sum));
	}
	
	summa.reverse(); //eftersom att svaret blir skrivet bakl�nges.
	
	return summa.toString();
	}


	// subtrahera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar
	// deras differens som en teckenstr�ng.
	// Det f�rsta heltalet �r inte mindre �n det andra heltalet.
	public static String subtrahera (String tal1, String tal2)
	{
		//deklarera talen som anv�nds f�r att r�kna
		StringBuilder differens = new StringBuilder();
		int talA;
		int talB;
		int minne = 0;
		for(int i = 1; i <= tal1.length(); i++) 
		{
			//skapa index f�r talet som f�rst ska subraheras
			int indexA = tal1.length() - i;
			int indexB = tal2.length() - i;
		
			if (indexB < 0)
			{
				talA = tal1.charAt(indexA) - 48;
				talB = 0; //om andra talet tagit slut p� siffror. (f�r att undvika error)
			}
			else 
			{
				talA = tal1.charAt(indexA) - 48;
				talB = tal2.charAt(indexB) - 48;
			}
		
			//en tal som representerar det tal som ska subraheras med motsvarande talB
			int repA = talA - minne;
			//subrahera siffrorna fr�n b�da talen och eventuell minnessiffra
			int dif = repA - talB;	
			
			if(dif < 0) 
			{
				dif += 10;
				minne = 1;
			}
			else
				minne = 0;
		
			//out.println("Ber�kning " + i + ": " + repA  + " - " + talB + " = " + dif);

			differens.append(Integer.toString(dif));
		}
		
			differens.reverse(); //eftersom att svaret blir skrivet bakl�nges.
			return differens.toString(); //OBS, FUNGERAR EJ ATM: R�KNAR R�TT, RETURNERAR FEL SVAR (N�GOT FEL MED differens.reverse();)
	}

// visa visar tv� givna naturliga heltal, och resultatet av en aritmetisk operation
// utf�rd i samband med hetalen
public static void visa (String tal1, String tal2, String resultat, char operator)
{
// s�tt en l�mplig l�ngd p� heltalen och resultatet
int len1 = tal1.length ();
int len2 = tal2.length ();
int len = resultat.length ();
int maxLen = Math.max (Math.max (len1, len2), len);
tal1 = sattLen (tal1, maxLen - len1);

//ID1018 Programmering I OU4 Fadil Galjic
//Fr�n boken Programmeringsprinciper i Java : Exempel och �vningar (Fadil Galjic & Studentlitteratur)

tal2 = sattLen (tal2, maxLen - len2);
resultat = sattLen (resultat, maxLen - len);

// visa heltalen och resultatet
out.println (" " + tal1);
out.println ("" + operator + " " + tal2);
for (int i = 0; i < maxLen + 2; i++)
	out.print ("-");
out.println ();
out.println (" " + resultat + "\n");
}

// sattLen l�gger till ett angivet antal mellanslag i b�rjan av en given str�ng
public static String sattLen (String s, int antal)
{
StringBuilder sb = new StringBuilder (s);
for (int i = 0; i < antal; i++)
	sb.insert (0, " ");
return sb.toString ();
}

}
