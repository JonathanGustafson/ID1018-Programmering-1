//BestämDenKortasteVagen.java

/************************************************************
 * 
 * Detta program låter användaren mata in avstånd mellan en
 * startpunkt, två zoner med mellanstationer och en slutpunkt.
 * Med metoder från DenKortasteVagen.java så beräknar 
 * programmet den kortaste vägen från start till slut och
 * redovisar sedan resultatet.
 * 
 * @author Jonathan Gustafson
 * 
 ***********************************************************/

import java.util.Scanner;

public class BestamDenKortasteVagen {

	public static void main(String[] args) {
		
		//inmatningsverktyg
		Scanner in = new Scanner(System.in);
		
		//mata in antalet stationer i zon 2 och zon 3
		System.out.println("Hur många stationer i zon 2?");
		int antalZ2 = in.nextInt();
		System.out.println("Hur många stationer i zon 3?");
		int antalZ3 = in.nextInt();
		
		double[] distZ1 = new double[antalZ2 + 1]; //avstånd från zon1 till zon 2		 
		double[][] distZ2Z3 = new double[antalZ2 + 1][antalZ3 + 1]; //avstånd från zon 2 till zon 3
		double[] distZ4 = new double[antalZ3 + 1]; //avstånd från zon 3 till zon fyra
		
		//Mata in avstånd från zon1 till alla stationer i zon 2
		System.out.println("Avstånd till stationer i zon 2?");
		for(int i = 1; i <= antalZ2; i++) {
			distZ1[i] = in.nextInt();
		}
		
		//Mata in avstånden mellan stationerna i zon 2 och zon 3
		System.out.println("Avstånd till stationer i zon 3 (från zon 1, sendan zon 2 osv)?");
		for(int i = 1; i <= antalZ2; i++)
			for(int j = 1; j <= antalZ3; j++) {
				distZ2Z3[i][j] = in.nextInt();
			}
		
		//Mata in avstånd från start till alla stationer i zon 4
		System.out.println("Avstånd till stationer i zon 4?");
		for(int i = 1; i <= antalZ3; i++) {
			distZ4[i] = in.nextInt();
		}

		//beräkna kortaste vägen
		int[] station = DenKortasteVagen.mellanstationer(distZ1, distZ2Z3, distZ4);
		double kortasteVagen = DenKortasteVagen.langd(distZ1, distZ2Z3, distZ4);
		
		//visa resultat
		System.out.println("Den kortaste vägen går via Z2-" + station[1] + " och Z3-" +
							station[2] + " och längden är: " + kortasteVagen);
	}

}
