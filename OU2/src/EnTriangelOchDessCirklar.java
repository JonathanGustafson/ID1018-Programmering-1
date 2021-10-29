//EnTriangelOchDessCirklar.java

/***********************************************************************
 * 
 * En klass som tar in l�ngden ifr�n en triangels sidor och kallar p�
 * funktioner ifr�n Trangel.java som genomf�r ber�kningar med den
 * angivna triangel. 
 * Klassen visar reultatet fr�n ber�kningarna.
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
		
		// Kallar p� ber�kningsfunktioner f�r den omskrivna och inskrivna cirkelns radie och placerar i variabler
		double omskR = Triangel.omskrivnaCirkelnRadie(sidaA, sidaB, sidaC); // den omskrivna cirkelns radie
		double inskR = Triangel.inskrivnaCirkelnRadie(sidaA, sidaB, sidaC); // den inskrivna cirkelns radie
		
		//Visa resultatet
		System.out.println("Radien p� den omskrivna cirkeln: " + omskR);
		System.out.println("Radien p� den inskrivna cirkeln: " + inskR);
	}
}
