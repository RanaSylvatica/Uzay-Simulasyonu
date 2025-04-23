
/**
*
* @author elif ranagül akyol ranagul.akyol@ogr.sakarya.edu.tr
* @since 21.04.2025
* <p>
* 1C Simulasyon.java
* </p>
*/

package pdp;

public abstract class Zaman {
	
	public int saat;
	
	public Zaman()
	{
		this.saat=0;
	}

	public int getSaat() {
		return saat;
	}

	public void setSaat(int saat) {
		if(saat<0)
		{
			System.out.println("Saat 0'dan kucuk olamaz");
			return;
		}
		this.saat = saat;
	}
	
	protected abstract void zamanArttir();
	
	
	
	
}
