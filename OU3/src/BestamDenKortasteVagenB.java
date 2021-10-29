import java.util.*;

public class BestamDenKortasteVagen {

	public static void main(String[] args) {
		
		//inmatningsverktyg
				Scanner in = new Scanner(System.in);
				in.useLocale (Locale.US);
				
				System.out.println("Hur m�nga stationer i zon 2?");
				int antalZ2 = in.nextInt();
				System.out.println("Hur m�nga stationer i zon 3?");
				int antalZ3 = in.nextInt();
				
				int[] distXZ = new int[antalZ2 + 1];		
				int[] distZY = new int[antalZ3 + 1];
				int[][] distZZ = new int[antalZ2 + 1][antalZ3 + 1];
				
				//Mata in avst�nd fr�n start till alla stationer i zon 2
				System.out.println("Avst�nd till stationer i zon 2?");
				for(int i = 1; i <= antalZ2; i++) {
					distXZ[i] = in.nextInt();
				}
				
				//Mata in avst�nden mellan stationerna i zon 2 och zon 3
				System.out.println("Avst�nd till stationer i zon 3 (fr�n zon 1, sendan zon 2 osv)?");
				for(int i = 1; i <= antalZ2; i++)
					for(int j = 1; j <= antalZ3; j++) {
						distZZ[i][j] = in.nextInt();
					}
				
				//Mata in avst�nd fr�n stationerna i zon 3 till slutet
				System.out.println("Avst�nd till slut fr�n stationer i zon 3?");
				for(int i = 1; i <= antalZ2; i++) {
					distZY[i] = in.nextInt();
				}
				
				int minDist = distXZ[1] + distZZ[1][1] + distZY[1];
				int nr1 = 1;
				int nr2 = 1;

	}

}
