//DenKortasteVagen.java

/***********************************************************
 * 
 * Programmet "DenKortasteVagen inneh�ller tv� metoder.
 * Den ena metoden "mellanstationer" tar emot vektorer som 
 * motsvarar avst�nd i ett v�gsystem och returnerar en vektor
 * som inneh�ller nummer p� de stationer som utg�r den kortaste
 * v�gen.
 * Den andra metoden "langd" ber�knar l�ngden av den kortaste
 * str�ckan som best�mts i den f�rsta metoden.
 * 
 * @author Jonathan Gustafson
 * 
 **********************************************************/
public class DenKortasteVagen {

	//mellanstationer tar emot tre vektorer som motsvarar avst�nd mellan en startpunkt,
	//tv� zoner som inneh�ller mellanstationer och en slutpunkt.
	// mellanstationer returnerar en vektor med de mellanstationersom finns p� den kortaste
	// v�gen. Ordningsnummer av den f�rsta mellanstationen finns p� index1, och ordningsnummer
	// avden andra mellanstationen p� index2 i vektorn.
	public static int[] mellanstationer (double a[], double[][] b, double[] c) {
		
		int s1 = 1;
		int s2 = 1;
		double minDist = a[1] + b[1][1] + c[1];
		
		//kortaste v�g ber�kning
		//pr�var alla m�jliga v�gkombinationer och sparar den kortaste v�gen. 
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
	
	//langde tar emot tre vektorer som motsvarar avst�nd mellan en startpunkt,
	//tv� zoner som inneh�ller mellanstationer och en slutpunkt.
	//langd returnerar l�ngden av den kortaste v�gen fr�n start till slut.
	public static double langd (double[] a, double[][] b, double[] c) {
		
		int[] station = mellanstationer(a, b, c);
		int s1 = station[1];
		int s2 = station[2];
		double kortasteVagen = a[s1] + b[s1][s2] + c[s2];
		
		return kortasteVagen;		
	}
	
}
