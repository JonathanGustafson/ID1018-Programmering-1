//EnTriangelOchDessCirklar.java

/***********************************************************************
 * 
 * En klass som tar in längden ifrån en triangels sidor och kallar på
 * funktioner ifrån Trangel.java som genomför beräkningar med den
 * angivna triangel. 
 * Klassen visar reultatet från beräkningarna.
 * 
 * @author Jonathan Gustafson
 **********************************************************************/

import java.util.*;

public class EnTriangelOchDessCirklar {

	public static void main(String[] args) {
		
		//inmatningsverktyg
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale (Locale.US);
		
		//ange triangelns sidor och placera i variabler
		System.out.println("Ange triangelns sidor:");
		double sidaA = scanner.nextDouble();
		double sidaB = scanner.nextDouble();
		double sidaC = scanner.nextDouble();
		
		// Kallar på beräkningsfunktioner för den omskrivna och inskrivna cirkelns radie och placerar i variabler
		double omskR = Triangel.omskrivnaCirkelnRadie(sidaA, sidaB, sidaC); // den omskrivna cirkelns radie
		double inskR = Triangel.inskrivnaCirkelnRadie(sidaA, sidaB, sidaC); // den inskrivna cirkelns radie
		
		//Visa resultatet
		System.out.println("Radien på den omskrivna cirkeln: " + omskR);
		System.out.println("Radien på den inskrivna cirkeln: " + inskR);
	}
}
