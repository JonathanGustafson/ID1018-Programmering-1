//Punkt.java

public class Punkt {

	private String namn;
	private int x;
	private int y;
	
	//Konstruktor, tar emot en string och två int som motsvarar namn och koordinater.
	public Punkt(String namn, int x, int y)
	{
		this.namn = namn;
		this.x = x;
		this.y = y;
	}
	
	//Konstruktor, tar emot en punkt och skapar en kopia av den punkten
	public Punkt(Punkt p)
	{
		Punkt punkt = new Punkt(p.namn, p.x, p.y);
		this.namn = punkt.namn;
		this.x = punkt.x;
		this.y = punkt.y;
	}
	
	//returnerar punkten i strängform
	public String toString()
	{
		String s = "(" + namn + ", " + x + ", " + y + ")";
		return s;
	}
	
	//returnerar punktens namn
	public String getNamn() {
		return namn;
	}
	
	//returnerar punktens x-värde
	public int getX() {
		return x;
	}
	
	//returnerar punktens y-värde
	public int getY() 
	{
		return y;
	}
	
	//tar emot en punkt och beräknar avståndet mellan den punkten och den aktuella punkten.
	//Returnerar avståndet.
	public double avstand(Punkt a)
	{
		double p1 = a.x - this.x;
		double p2 = a.y - this.y;
		double avstand = Math.sqrt(Math.pow(p1, 2) + Math.pow(p2, 2));
		return avstand;
	}
	
	//tar emot en punkt, jämför den med aktuella punkten. Returnerar
	//true om punkterna har samma x- och y-värde
	public boolean equals(Punkt a) 
	{
		if(this.x == a.x && this.y == a.y) 
			return true;
		else
			return false;
	}
	
	//Tar emot ett heltal och tilldelar det till x
	public void setX(int a) 
	{
		this.x = a;
	}
	
	//Tar emot ett heltal och tilldelar det till y
	public void setY(int a) 
	{
		this.y = a;
	}
}
