//Polylinje.java

public class Polylinje
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	
	//konstruktor, utan parametrar skapas en polilinje med ett h�rn.
	public Polylinje()
	{
		this.horn = new Punkt[0];
	}

	//konstruktor, skapar en polylinje med alla punkter i angiven punkt-array.
	public Polylinje(Punkt[] horn)
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt (horn[i]);
	}
	
	//konstruktor, kopierar en polylinje och skapar en ny likadan.
	public Polylinje(Polylinje polylinje)
    {
        this.horn = new Punkt[polylinje.horn.length];
        for(int i = 0; i < horn.length; i++)
            this.horn[i] = polylinje.horn[i];

        this.bredd = polylinje.bredd;
        this.farg = polylinje.farg;
    }
	
	//Skriver ut polylinjen p� ett l�sligt vis.
	public String toString() 
	{
		StringBuilder s = new StringBuilder();
		s.append("{[");
		for(int i = 0; i < horn.length; i++) {
			s.append(horn[i].toString());
		}
		s.append("], " + farg + ", " + bredd + "}");
		
		return s.toString();
	}
	
	
	//Returnerar en vektor med alla resurser fr�n punkterna i polylinjen. 
	public Punkt[] getHorn() 
	{
		Punkt[] kopia = new Punkt[horn.length];

        for (int i = 0; i < horn.length; i++)
            kopia[i] = new Punkt(horn[i]);

        return kopia;
	}
	
	//Returnerar polylinjens f�rg
	public String getFarg() 
	{
		return farg;
	}
	
	//Returnerar polylinjens bredd
	public int getBredd() 
	{
		return bredd;
	}
	
	//Tar emot str�ng och anger str�nger som polylinjens f�rg
	public void setFarg (String farg) 
	{
		this.farg = farg;
	}
	
	//Tar emot en int och anger integern som polylinjens bredd 
	public void setBredd (int bredd) 
	{
		this.bredd = bredd;
	}
	
	//Returnerar l�ngden p� polylinjen. L�ngden blir avst�ndet mellan alla punkter.
	public double langd() 
	{
		double langd = 0;
		
		for(int i = 0; i < horn.length - 1; i++)
		{
			langd += horn[i].avstand(horn[i + 1]);
		}
		
		return langd;
	}
	
	//returnerar antalet h�rn
	public int antalHorn() 
	{
        return horn.length;
    }
	
	//Tar emot ett punkt och l�gger till den till polylinjen
	public void laggTill (Punkt horn)
	{
			Punkt[] h = new Punkt[this.horn.length + 1];
			int i = 0;
			for (i = 0; i < this.horn.length; i++)
				h[i] = this.horn[i];
			h[i] = new Punkt (horn);
			this.horn = h;
	}
	
	//Tar emot en ny punkt och namnet av en existerande punkt och l�gger
	//till den nya punkten framf�r den angivna existerande punkten 
	public void laggTillFramfor (Punkt horn, String hornNamn) 
	{
		//Skapar en array med r�tt l�ngd
        Punkt[] h = new Punkt[this.horn.length + 1];

        int i = 0;
        
        //Kopierar h�rn fram till eventuellt h�rn med angivet namn
        while (!this.horn[i].getNamn().equals(hornNamn) && i < this.horn.length) {
            h[i] = this.horn[i];
            i++;
        }
        
        //Om namnet hittas, l�gg till ny punkt
        if (i < this.horn.length) {
            //L�gger till den nya
            h[i] = new Punkt(horn);
        }
        
        //Kopierar resten av h�rnen
        while (i < this.horn.length) {
            //L�gger till h�rnen p� i+1 f�r att en ny punkt ligger framf�r orginal indexet
            h[i + 1] = this.horn[i];
            i++;
        }
        
        this.horn = h;
	}
        
	//Tar emot en str�ng som representerar namnet av en punkt, letar efter punkten, och tar bort punkten.
	public void taBort (String hornNamn) 
	{
		//Skapar en ny array med r�tt l�ngd
		Punkt[] h = new Punkt[this.horn.length - 1];
		
		int i = 0;
		
		//Kopierar h�rn fram till eventuellt h�rn med angivet namn
        while (!this.horn[i].getNamn().equals(hornNamn) && i < this.horn.length) {
            h[i] = this.horn[i];
            i++;
        }
        
        //Om det finns element kvar, det vill s�ga att namnet �r hittat, hoppa �ver indexet
        if (i < horn.length) {
            i++;
            
            while (i < horn.length) {
                //L�gger till resten av h�rnen p� i-1 eftersom ett element f�r har tagits bort.
                h[i - 1] = horn[i];
                i++;
            }
        }
        
        this.horn = h;
	}
	
	public class PolylinjeIterator 
	{

        private int aktuell = -1;

        public PolylinjeIterator()
        {
            if(Polylinje.this.horn.length > 0)
                aktuell = 0;
        }

        public  boolean finnsHorn()
        {
            return  aktuell != -1;
        }

        public Punkt horn() throws java.util.NoSuchElementException
        {
            if(!finnsHorn())
                throw new java.util.NoSuchElementException("Slut p� iterationen");

            return Polylinje.this.horn[aktuell];
        }

        public void gaFram()
        {
            //Stegar fram om det finns mer horn
            if(finnsHorn() && aktuell < Polylinje.this.horn.length -1)
                aktuell++;

            else
                aktuell = -1;
        }
    }
}	