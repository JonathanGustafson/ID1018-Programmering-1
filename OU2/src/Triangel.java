//Triangel.java

/***********************************************************************
 * 
 * En klass som inneh�ller metoder som g�r ber�kningar f�r en triangel
 *  med tre angina sidor.
 * Klassen kan ber�kna triangelns omkrets, area, bisektrisers l�ngder,
 * och radien p� triangelns inskrina och omskrivna cirkel
 * 
 * @author Jonathan Gustafson
 **********************************************************************/

public class Triangel {
	
	// omkrets tar emot l�ngden p� tre angivna sidor av en
	// triangel och returnerar omkretsen av triangeln.
	public static double omkrets(double a, double b, double c) {	
		
		double omkrets = a + b + c;
		
		return omkrets;
	}
	
	// area tar emot l�ngden p� tre angivna sidor av en triangel
	// och returnerar triangelns area.
	public static double area(double a, double b, double c) {	
		
		double s = (a + b + c)/2; //s = semiperimeter (halva omkretsen)
		double hojd = (2/a) * Math.sqrt(s*(s-a)*(s-b)*(s-c));
		double area = (double)(a * hojd)/2;
		
		return area;
	}
	
	// bisektris tar emot tv� sidor och vinkeln mellan sidorna i en triangel.
	// bisetris returnerar l�ngden p� bisektrisen som delar vinkeln i tv� lika
	// stora delar
	public static double bisektris(double s1, double s2, double vinkel) {
		
		double p = 2 * s1 * s2  * Math.cos (vinkel/2); //Formel tagen fr�n OU2.pdf
		double bisektris = p / (s1 + s2);
		
		return bisektris;
	}
	
	
	//omskrivnaCirkelnRadie tar emot l�ngden p� tre sidor av en triangel och 
	//returnerar radien p� triangelns omskrivna cirkel
	public static double omskrivnaCirkelnRadie(double a, double b, double c) {
		
		double s = (a + b + c)/2; // Semiperimeter (halva omkretsen)
		double radie = (a * b * c)/(4 * Math.sqrt(s * (s-a) * (s-b) * (s-c))); 
		
		return radie;
	}
	
	//omskrivnaCirkelnRadie tar emot l�ngden p� tre sidor av en triangel och 
	//returnerar radien p� triangelns inskrivna cirkel
	public static double inskrivnaCirkelnRadie(double a, double b, double c) {
		
		double s = (a + b + c) / 2; // Semiperimeter (halva omkretsen)
		double rotSats = ((s - a) * (s - b) * (s - c))/s;
		double radie = Math.sqrt(rotSats);
		
		return radie;
	}
}
