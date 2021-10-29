//PolylinjeTest.java

public class PolylinjeTest {

	public static void main(String[] args) {
		
		Punkt t = new Punkt("Svart", 2, 3);
		Punkt e = new Punkt("Grå", 3, 6);
		Punkt s = new Punkt("Blond", 4, 2);
		Punkt ta = new Punkt("Orange", 5, 3);
		
		Punkt[] testa = {t,e,s,ta};
		Polylinje poly1 = new Polylinje(testa);
		
		System.out.println(poly1);
		
		Polylinje poly2 = new Polylinje();
		
		System.out.println(poly2);
		
		Polylinje poly3 = new Polylinje(poly1);
		
		System.out.println(poly3);
		
		poly3.laggTillFramfor(s, "Svart");
		
		System.out.println(poly3);
		
		poly3.taBort("Blond");
		
		System.out.println(poly3);

	}

}
