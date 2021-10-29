//DenKortasteVagen.java

/***********************************************************
 * 
 * Programmet "DenKortasteVagen innehåller två metoder.
 * Den ena metoden "mellanstationer" tar emot vektorer som 
 * motsvarar avstånd i ett vägsystem och returnerar en vektor
 * som innehåller nummer på de stationer som utgör den kortaste
 * vägen.
 * Den andra metoden "langd" beräknar längden av den kortaste
 * sträckan som bestämts i den första metoden.
 * 
 * @author Jonathan Gustafson
 * 
 **********************************************************/
public class DenKortasteVagen {

	//mellanstationer tar emot tre vektorer som motsvarar avstånd mellan en startpunkt,
	//två zoner som innehåller mellanstationer och en slutpunkt.
	// mellanstationer returnerar en vektor med de mellanstationersom finns på den kortaste
	// vägen. Ordningsnummer av den första mellanstationen finns på index1, och ordningsnummer
	// avden andra mellanstationen på index2 i vektorn.
	public static int[] mellanstationer (double a[], double[][] b, double[] c) {
		
		int s1 = 1;
		int s2 = 1;
		double minDist = a[1] + b[1][1] + c[1];
		
		//kortaste väg beräkning
		//prövar alla möjliga vägkombinationer och sparar den kortaste vägen. 
		for(int i = 1; i <= a.length - 1; i++)
			for(int j = 1; j <= b[i].length - 1; j++) {
				if(minDist > a[i] + b[i][j] + c[j]) {
					s1 = i;
					s2 = j;
					minDist = a[i] + b[i][j] + c[j];
				}
			}
		
		int[] kortasteVagen = {0, s1, s2};
		return kortasteVagen;
	}
	
	//langde tar emot tre vektorer som motsvarar avstånd mellan en startpunkt,
	//två zoner som innehåller mellanstationer och en slutpunkt.
	//langd returnerar längden av den kortaste vägen från start till slut.
	public static double langd (double[] a, double[][] b, double[] c) {
		
		int[] station = mellanstationer(a, b, c);
		int s1 = station[1];
		int s2 = station[2];
		double kortasteVagen = a[s1] + b[s1][s2] + c[s2];
		
		return kortasteVagen;		
	}
	
}
