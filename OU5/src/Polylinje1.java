//Polylinje1.java

public class Polylinje1 
{

	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	
	public Polylinje1() 
	{
		this.horn = new Punkt[0];
	}
	
	public Polylinje1(Punkt[] horn) 
	{
		this.horn = horn;
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
	
	public Punkt[] getHorn() 
	{
        return horn;
    }

    public String getFarg() 
    {
        return farg;
    }

    public int getBredd() 
    {
        return bredd;
    }

    public void setFarg (String farg) 
    {
        this.farg = new String(farg);
    }

    public void setBredd (int bredd) 
    {
        this.bredd = bredd;
    }
    
    //Returnerar l�ngden p� polylinjen. L�ngden blir avst�ndet mellan alla punkter.
  	public double langd () 
  	{
  		double langd = 0;
  		
  		for(int i = 0; i < horn.length - 1; i++)
  		{
  			langd += horn[i].avstand(horn[i + 1]);
  		}
  		
  		return langd;
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
          while (!this.horn[i].getNamn().equals(hornNamn) && i < this.horn.length) 
          {
              h[i] = this.horn[i];
              i++;
          }
          
          //Om namnet hittas, l�gg till ny punkt
          if (i < this.horn.length) 
          {
              //L�gger till den nya
              h[i] = new Punkt(horn);
          }
          
          //Kopierar resten av h�rnen
          while (i < this.horn.length) 
          {
              //L�ggger till h�rnen p� i+1 f�r att en ny punkt ligger framf�r orginal indexet
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
        while (!this.horn[i].getNamn().equals(hornNamn) && i < this.horn.length) 
        {
            h[i] = this.horn[i];
            i++;
        }
          
        //Om det finns element kvar, det vill s�ga att namnet �r hittat, hoppa �ver indexet
        if (i < horn.length) 
        {
            i++;
             
            while (i < horn.length)
            {
                //L�gger till resten av h�rnen p� i-1 eftersom ett element f�r har tagits bort.
                h[i - 1] = horn[i];
                i++;
             }
         }
          
         this.horn = h;
  	}
	
}
