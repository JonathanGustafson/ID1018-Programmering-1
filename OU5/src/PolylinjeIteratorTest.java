//PolylinjeIteratorTest.java

public class PolylinjeIteratorTest {

	 public static void main(String[] args) {

	        System.out.println("PolylinjeIterator test:");
	        System.out.println();

	        //Använder slumpad polylinje från klassen ValjPolylinje.java
	        Polylinje polylinje = ValjPolylinje.slumpPolylinje();
	        Polylinje.PolylinjeIterator linjeIterator = polylinje.new PolylinjeIterator();

	        System.out.println("Linje: " + polylinje);
	        System.out.println("Linjens hörn: ");

	        //Medans det finns hörn, visa hörnet, gå vidare i iteratorn
	        while (linjeIterator.finnsHorn()) 
	        {
	        	System.out.println(linjeIterator.horn());
	            linjeIterator.gaFram();
	        }

	    }

}
