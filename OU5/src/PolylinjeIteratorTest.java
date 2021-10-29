//PolylinjeIteratorTest.java

public class PolylinjeIteratorTest {

	 public static void main(String[] args) {

	        System.out.println("PolylinjeIterator test:");
	        System.out.println();

	        //Anv�nder slumpad polylinje fr�n klassen ValjPolylinje.java
	        Polylinje polylinje = ValjPolylinje.slumpPolylinje();
	        Polylinje.PolylinjeIterator linjeIterator = polylinje.new PolylinjeIterator();

	        System.out.println("Linje: " + polylinje);
	        System.out.println("Linjens h�rn: ");

	        //Medans det finns h�rn, visa h�rnet, g� vidare i iteratorn
	        while (linjeIterator.finnsHorn()) 
	        {
	        	System.out.println(linjeIterator.horn());
	            linjeIterator.gaFram();
	        }

	    }

}
