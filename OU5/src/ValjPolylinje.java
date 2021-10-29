//ValjPolylinje.java
  
import java.io.PrintWriter;
import java.util.Random;

public class ValjPolylinje {

	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 10;
	
	public static void main(String[] args) 
	{
		PrintWriter out = new PrintWriter(System.out, true);
        out.println("V�LJ POLYLINJE:");
		
		// skapa ett antal slumpm�ssiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
		polylinjer[i] = slumpPolylinje();
		 
		// visa polylinjerna
		for (Polylinje linje : polylinjer)
            out.println(linje + " med l�ngd " + linje.langd());
		 
		// best�m den kortaste av de polylinjer som �r gula
		int kortastGul = -1;
		int i = 0;
		
		//Hittar f�rsta gula linjen
        while (i < polylinjer.length && kortastGul == -1) 
        {
            if (polylinjer[i].getFarg().equals("gul"))
                kortastGul = i;

            i++;
        }

        //Letar igenom resterande linjer efter kortare gula linjer
        while (i < polylinjer.length) {
            if (polylinjer[i].getFarg().equals("gul") && polylinjer[i].langd() < polylinjer[kortastGul].langd())
                kortastGul = i;

            i++;
        }
		
		// visa den valda polylinjen
        if (kortastGul != -1)
            out.println("Den kortaste gula linjen �r: " + polylinjer[kortastGul]);
        else
            out.println("Det finns ingen gul linje");
	}
	
	// slumpPunkt returnerar en punkt med ett slumpm�ssigt namn, som �r en stor bokstav i
	// det engelska alfabetet, och slumpm�ssiga koordinater.
	public static Punkt slumpPunkt ()
	{
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Punkt (n, x, y);
	}
	
	// slumpPolylinje returnerar en slumpm�ssig polylinje, vars f�rg �r antingen bl�, eller r�d
	// eller gul. Namn p� polylinjens h�rn �r stora bokst�ver i det engelska alfabetet. Tv� h�rn
	// kan inte ha samma namn.
	public static Polylinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och l�gg till h�rn till den
		Polylinje polylinje = new Polylinje ();
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		 
		// ett och samma namn kan inte f�rekomma flera g�nger
		Punkt valdPunkt = null;
		char valtChar = 0;
		while (antalValdaHorn < antalHorn)
		{
			valdPunkt = slumpPunkt();
            valtChar = valdPunkt.getNamn().charAt(0);

            if (!valdaNamn[valtChar - 65]) 
            {
                valdaNamn[valtChar - 65] = true;
                polylinje.laggTill(valdPunkt);
                antalValdaHorn++;
            }
		}
		 
		// s�tt f�rg
		int valdFarg = rand.nextInt(3);
        switch (valdFarg) {
            case 0:
                polylinje.setFarg("bl�");
                break;

            case 1:
                polylinje.setFarg("r�d");
                break;

            case 2:
                polylinje.setFarg("gul");
                break;
        }

        return polylinje;
	}

}
