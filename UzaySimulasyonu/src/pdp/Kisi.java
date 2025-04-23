/**
*
* @author elif ranagül akyol ranagul.akyol@ogr.sakarya.edu.tr
* @since 21.04.2025
* <p>
* 1C Simulasyon.java
* </p>
*/

package pdp;

public class Kisi{
	
	private String ad, bulunduguUzayAraci;
	private int yas, kalanOmur;
	
	

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getBulunduguUzayAraci() {
		return bulunduguUzayAraci;
	}

	public void setBulunduguUzayAraci(String bulunduguUzayAraci) {
		this.bulunduguUzayAraci = bulunduguUzayAraci;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public int getKalanOmur() {
		return kalanOmur;
	}

	public void setKalanOmur(int kalanOmur) {
		this.kalanOmur = kalanOmur;
	}

	public Kisi(String ad,int yas,int kalanOmur,String bulunduguUzayAraci)
	{
		this.ad=ad;
		this.yas=yas;
		this.kalanOmur=kalanOmur;
		this.bulunduguUzayAraci=bulunduguUzayAraci;
	}
	
	public void kalanOmruAzalt()
	{
		if(kalanOmur>0)
			kalanOmur--;
	}

}
