import java.util.*;

public class Temperaturer {

	public static void main (String[] args)
	 {
		System.out.println ("TEMPERATURER\n");

	 	// inmatningsverktyg
	 	Scanner in = new Scanner (System.in);
	 	in.useLocale (Locale.US);
	 	
	 	// mata in uppgifter om antalet veckor och antalet mätningar
	 	System.out.print ("antalet veckor: ");
	 	int antalVeckor = in.nextInt ();
	 	System.out.print ("antalet mätningar per vecka: ");
	 	int antalMatningarPerVecka = in.nextInt ();
	 	
	 	// plats att lagra temperaturer
	 	double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
	 	
	 	// mata in temperaturerna
	 	for (int vecka = 1; vecka <= antalVeckor; vecka++)
	 	{
	 		System.out.println ("temperaturer - vecka " + vecka + ":");
	 		for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
	 			t[vecka][matning] = in.nextDouble ();
	 	}
	 	System.out.println ();
	 	// visa temperaturerna
	 	System.out.println ("temperaturerna:");
	 	for (int vecka = 1; vecka <= antalVeckor; vecka++)
	 	{
	 		for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
	 			System.out.print (t[vecka][matning] + " ");
	 			System.out.println ();
	 	}
	 	System.out.println ();
	 	
	 	// den minsta, den största och medeltemperaturen – veckovis
	 	double[] minT = new double[antalVeckor + 1];
	 	double[] maxT = new double[antalVeckor + 1];
	 	//double[] sumT = new double[antalVeckor + 1];
	 	double[] medelT = new double[antalVeckor + 1];
	 	double sumTemp = 0;
	 	
	 // koden ska skrivas här ****************************************************** Jonathans kod (nedåt)
	 	
	
	 	for(int vecka = 1; vecka <= antalVeckor; vecka++) {
			double sum = 0;
			minT[vecka] = t[vecka][1];
			maxT[vecka] = t[vecka][1];
			for(int matning = 1; matning <= antalMatningarPerVecka; matning++) {
				if(t[vecka][matning] < minT[vecka]) {
					minT[vecka] = t[vecka][matning];
				}
				else if(t[vecka][matning] > maxT[vecka]) {
					maxT[vecka] = t[vecka][matning];
				}
				sum += t[vecka][matning];
				sumTemp += t[vecka][matning];
			}
			medelT[vecka] = (double)(sum/antalMatningarPerVecka);
		}
	 	
	    // visa den minsta, den största och medeltemperaturen för varje vecka
	 	
	 	//visa minsta temperaturen
	 	System.out.println("Minsta temperaturerna:");
	 	for(int vecka = 1; vecka <= antalVeckor; vecka++) {
	 		System.out.println("v" + vecka + ": " + minT[vecka]);
	 	}	
	 	//visa största temperaturen
	 	System.out.println("Största temperaturerna:");
	 	for(int vecka = 1; vecka <= antalVeckor; vecka++) {
	 		System.out.println("v" + vecka + ": " + maxT[vecka]);
	 	}	
	 	//visa medel temperaturen
	 	System.out.println("Medeltemperaturerna:");	 	
	 	for(int vecka = 1; vecka <= antalVeckor; vecka++) {
	 		System.out.println("v" + vecka + ": " + medelT[vecka]);
	 	}
	 	
	 // den minsta, den största och medeltemperaturen - hela mätperioden
	 	
	 double minTemp = minT[1];
	 double maxTemp = maxT[1];
	 //sumTemp = sumT[1];
	 double medelTemp = (double) sumTemp/(antalVeckor*antalMatningarPerVecka);
	 
	 for(int vecka = 1; vecka <= antalVeckor; vecka++) {
		 minTemp = Math.min(minTemp, minT[vecka]);
		 maxTemp = Math.max(maxTemp, maxT[vecka]);
	 }
	 
	 // visa den minsta, den största och medeltemperaturen i hela mätperioden
	 
	 //visa minsta temperaturen
	 System.out.println("Minsta temperaturen (Hela mätperioden):");
	 System.out.println(minTemp);
	 //visa största temperaturen
	 System.out.println("Största temperaturen (Hela mätperioden):");
	 System.out.println(maxTemp);
	 //visa medel temperaturen
	 System.out.println("Medeltemperaturen (Hela mätperioden):");	 	
	 System.out.println(medelTemp);
	 
	 }
}
