//ValjPolylinje.java
  
import java.io.PrintWriter;
import java.util.Random;

public class ValjPolylinje {

	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 10;
	
	public static void main(String[] args) 
	{
		PrintWriter out = new PrintWriter(System.out, true);
        out.println("VÄLJ POLYLINJE:");
		
		// skapa ett antal slumpmässiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
		polylinjer[i] = slumpPolylinje();
		 
		// visa polylinjerna
		for (Polylinje linje : polylinjer)
            out.println(linje + " med längd " + linje.langd());
		 
		// bestäm den kortaste av de polylinjer som är gula
		int kortastGul = -1;
		int i = 0;
		
		//Hittar första gula linjen
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
            out.println("Den kortaste gula linjen är: " + polylinjer[kortastGul]);
        else
            out.println("Det finns ingen gul linje");
	}
	
	// slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
	// det engelska alfabetet, och slumpmässiga koordinater.
	public static Punkt slumpPunkt ()
	{
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);
		return new Punkt (n, x, y);
	}
	
	// slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
	// eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
	// kan inte ha samma namn.
	public static Polylinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och lägg till hörn till den
		Polylinje polylinje = new Polylinje ();
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];
		 
		// ett och samma namn kan inte förekomma flera gånger
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
		 
		// sätt färg
		int valdFarg = rand.nextInt(3);
        switch (valdFarg) {
            case 0:
                polylinje.setFarg("blå");
                break;

            case 1:
                polylinje.setFarg("röd");
                break;

            case 2:
                polylinje.setFarg("gul");
                break;
        }

        return polylinje;
	}

}
