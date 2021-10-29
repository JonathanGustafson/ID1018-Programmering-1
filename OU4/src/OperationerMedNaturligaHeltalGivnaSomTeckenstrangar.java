import static java.lang.System.out;

import java.util.Scanner;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
	public static void main (String[] args)
	{	
		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
	
		// mata in två naturliga heltal
		Scanner in = new Scanner (System.in);
		out.println ("två naturliga heltal:");
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


	// addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
	// summa som en teckensträng.
	public static String addera (String tal1, String tal2)
	{
		//deklarera talen som används för att räkna
		StringBuilder summa = new StringBuilder();
		int talA;
		int talB;
		int minne = 0;	

		for(int i = 1; i <= tal1.length(); i++) {
			//skapa index för talet som först ska adderas
			int indexA = tal1.length() - i;
			int indexB = tal2.length() - i;
		
		if (indexB < 0)
		{
			talA = tal1.charAt(indexA) - 48;
			talB = 0; //om andra talet tagit slut på siffror. (för att undvika error)
		}
		else {
			talA = tal1.charAt(indexA) - 48;
			talB = tal2.charAt(indexB) - 48;
		}
		
		//addera siffrorna från båda talen och eventuell minnessiffra
		int sum = talA + talB + minne;
		
		//om summan av siffrorna är större än 9, lägg till en minnessiffra
		if(sum > 9)
		{
			minne = 1;
			sum -= 10;
		}
		else {
			minne = 0;
		}
		
		//out.println("Beräkning " + i + ": " + talA + " + " + talB);
		
		summa.append(Integer.toString(sum));
	}
	
	summa.reverse(); //eftersom att svaret blir skrivet baklänges.
	
	return summa.toString();
	}


	// subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
	// deras differens som en teckensträng.
	// Det första heltalet är inte mindre än det andra heltalet.
	public static String subtrahera (String tal1, String tal2)
	{
		//deklarera talen som används för att räkna
		StringBuilder differens = new StringBuilder();
		int talA;
		int talB;
		int minne = 0;
		for(int i = 1; i <= tal1.length(); i++) 
		{
			//skapa index för talet som först ska subraheras
			int indexA = tal1.length() - i;
			int indexB = tal2.length() - i;
		
			if (indexB < 0)
			{
				talA = tal1.charAt(indexA) - 48;
				talB = 0; //om andra talet tagit slut på siffror. (för att undvika error)
			}
			else 
			{
				talA = tal1.charAt(indexA) - 48;
				talB = tal2.charAt(indexB) - 48;
			}
		
			//en tal som representerar det tal som ska subraheras med motsvarande talB
			int repA = talA - minne;
			//subrahera siffrorna från båda talen och eventuell minnessiffra
			int dif = repA - talB;	
			
			if(dif < 0) 
			{
				dif += 10;
				minne = 1;
			}
			else
				minne = 0;
		
			//out.println("Beräkning " + i + ": " + repA  + " - " + talB + " = " + dif);

			differens.append(Integer.toString(dif));
		}
		
			differens.reverse(); //eftersom att svaret blir skrivet baklänges.
			return differens.toString(); //OBS, FUNGERAR EJ ATM: RÄKNAR RÄTT, RETURNERAR FEL SVAR (NÅGOT FEL MED differens.reverse();)
	}

// visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
// utförd i samband med hetalen
public static void visa (String tal1, String tal2, String resultat, char operator)
{
// sätt en lämplig längd på heltalen och resultatet
int len1 = tal1.length ();
int len2 = tal2.length ();
int len = resultat.length ();
int maxLen = Math.max (Math.max (len1, len2), len);
tal1 = sattLen (tal1, maxLen - len1);

//ID1018 Programmering I OU4 Fadil Galjic
//Från boken Programmeringsprinciper i Java : Exempel och övningar (Fadil Galjic & Studentlitteratur)

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

// sattLen lägger till ett angivet antal mellanslag i början av en given sträng
public static String sattLen (String s, int antal)
{
StringBuilder sb = new StringBuilder (s);
for (int i = 0; i < antal; i++)
	sb.insert (0, " ");
return sb.toString ();
}

}
