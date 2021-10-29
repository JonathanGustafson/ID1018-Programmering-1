//Triangel.java

/***********************************************************************
 * 
 * En klass som innehåller metoder som gör beräkningar för en triangel
 *  med tre angina sidor.
 * Klassen kan beräkna triangelns omkrets, area, bisektrisers längder,
 * och radien på triangelns inskrina och omskrivna cirkel
 * 
 * @author Jonathan Gustafson
 **********************************************************************/

public class Triangel {
	
	// omkrets tar emot längden på tre angivna sidor av en
	// triangel och returnerar omkretsen av triangeln.
	public static double omkrets(double a, double b, double c) {	
		
		double omkrets = a + b + c;
		
		return omkrets;
	}
	
	// area tar emot längden på tre angivna sidor av en triangel
	// och returnerar triangelns area.
	public static double area(double a, double b, double c) {	
		
		double s = (a + b + c)/2; //s = semiperimeter (halva omkretsen)
		double hojd = (2/a) * Math.sqrt(s*(s-a)*(s-b)*(s-c));
		double area = (double)(a * hojd)/2;
		
		return area;
	}
	
	// bisektris tar emot två sidor och vinkeln mellan sidorna i en triangel.
	// bisetris returnerar längden på bisektrisen som delar vinkeln i två lika
	// stora delar
	public static double bisektris(double s1, double s2, double vinkel) {
		
		double p = 2 * s1 * s2  * Math.cos (vinkel/2); //Formel tagen från OU2.pdf
		double bisektris = p / (s1 + s2);
		
		return bisektris;
	}
	
	
	//omskrivnaCirkelnRadie tar emot längden på tre sidor av en triangel och 
	//returnerar radien på triangelns omskrivna cirkel
	public static double omskrivnaCirkelnRadie(double a, double b, double c) {
		
		double s = (a + b + c)/2; // Semiperimeter (halva omkretsen)
		double radie = (a * b * c)/(4 * Math.sqrt(s * (s-a) * (s-b) * (s-c))); 
		
		return radie;
	}
	
	//omskrivnaCirkelnRadie tar emot längden på tre sidor av en triangel och 
	//returnerar radien på triangelns inskrivna cirkel
	public static double inskrivnaCirkelnRadie(double a, double b, double c) {
		
		double s = (a + b + c) / 2; // Semiperimeter (halva omkretsen)
		double rotSats = ((s - a) * (s - b) * (s - c))/s;
		double radie = Math.sqrt(rotSats);
		
		return radie;
	}
}
