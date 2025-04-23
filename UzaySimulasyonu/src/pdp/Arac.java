/**
*
* @author elif ranagül akyol ranagul.akyol@ogr.sakarya.edu.tr
* @since 21.04.2025
* <p>
* 1C Simulasyon.java
* </p>
*/


package pdp;
import java.util.ArrayList;

public class Arac extends Zaman{

	private String durum = "Bekdawyor";
	private String ad;
	private int mesafe=0 ;
	private int kalanSaat;
	private String cikisTarihi;
	private ArrayList<Kisi> yolcular;
	public Gezegen gezegenVaris;
	public Gezegen gezegenCikis;
	private String varisTarihi;
	
	public String getVarisTarihi() {
		return varisTarihi;
	}
	public void setVarisTarihi(String varisTarihi) {
		if(varisTarihi.equals("0.0.0"))
			System.out.println("Gecersiz tarih!");
		this.varisTarihi = varisTarihi;
	}
	public String getDurum() {
		return durum;
	}

	public void setDurum(String durum) {
		this.durum = durum;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public int getMesafe() {
		return mesafe;
	}

	public void setMesafe(int mesafe) {
		this.mesafe = mesafe;
	}

	public int getKalanSaat() {
		return kalanSaat;
	}

	public void setKalanSaat(int kalanSaat) {
		this.kalanSaat = kalanSaat;
	}


	public String getCikisTarihi() {
		return cikisTarihi;
	}


	public void setCikisTarihi(String cikisTarihi) {
		this.cikisTarihi = cikisTarihi;
	}

	public ArrayList<Kisi> getYolcular() {
		return yolcular;
	}


	public void setYolcular(ArrayList<Kisi> yolcular) {
		this.yolcular = yolcular;
	}

	public Gezegen getGezegenVaris() {
		return gezegenVaris;
	}

	public void setGezegenVaris(Gezegen gezegenVaris) {
		this.gezegenVaris = gezegenVaris;
	}


	public Gezegen getGezegenCikis() {
		return gezegenCikis;
	}

	public void setGezegenCikis(Gezegen gezegenCikis) {
		this.gezegenCikis = gezegenCikis;
	}




	public Arac(String ad, Gezegen gezegenCikis, Gezegen gezegenVaris, String cikisTarihi, int mesafe) {
		this.ad=ad;
		this.mesafe=mesafe;
		this.cikisTarihi=cikisTarihi;
		this.gezegenVaris=gezegenVaris;
		this.gezegenCikis=gezegenCikis;
		this.kalanSaat=mesafe;
		this.yolcular= new ArrayList<Kisi>();
	}
	
	
	
	private int saateDonustur(String tarih, Gezegen gezegen)
	{
		String[] parcala = tarih.split("\\."); //nokta özel karakter oldugu için  \\ kullanmaliyiz
		int gun= Integer.parseInt(parcala[0]);
		int ay= Integer.parseInt(parcala[1]);
		int yil= Integer.parseInt(parcala[2]);
		
		int toplamSaat = gun*gezegen.getGunSaati() + ay*30*gezegen.getGunSaati() + yil*12*30*gezegen.getGunSaati();
		return toplamSaat;
	}
	
	
	public String varisTarihiDondur()
	{
		int toplamGecenSure=saateDonustur(cikisTarihi, gezegenCikis)-saateDonustur(gezegenCikis.getTarih(), gezegenCikis) + saateDonustur(gezegenVaris.getTarih(), gezegenVaris)+mesafe;
		return gezegenVaris.tariheDonustur(toplamGecenSure);
	}
	
	public int kisiSayisiDonudur()
	{
		int kisiSayisi=0;
		for(Kisi kisi:yolcular)
		{
			if(kisi.getKalanOmur()>0)
			{
				kisiSayisi++;
			}
		}
		
		return kisiSayisi;
		
	}
	public String durumuDondur()
	{
		if(saateDonustur(cikisTarihi,gezegenCikis)>saateDonustur(gezegenCikis.getTarih(),gezegenCikis))
		{
			durum="Bekliyor";
		}
		else
			durum="Yolda";
		
		if(kalanSaat<=0)
		{
			durum="Vardı";
		}
		if(kisiSayisiDonudur()==0)
		{
			durum="IMHA";
		}
		
		
		return durum;

	}
	@Override
	protected void zamanArttir() {
		// TODO Auto-generated method stub
		saat++;
	}
	
	public void zamaniIlerlet()
	{
		zamanArttir();
		if(saateDonustur(cikisTarihi, gezegenCikis) < saateDonustur(gezegenCikis.getTarih(),gezegenCikis) && kalanSaat>0);
			kalanSaat--;
		if(kalanSaat<0)
			kalanSaat=0;
		for(Kisi yolcu:yolcular)
		{
			yolcu.kalanOmruAzalt();
			
		}
	}
	
	public int kisiSayisiDondur()
	{
		int kisiSayisi=0;
		for(Kisi kisi:yolcular)
		{
			if(kisi.getKalanOmur()!=0)
			{
				kisiSayisi++;
			}
				
		}
		return kisiSayisi;
	}
	
	public void kisiEkle(Kisi kisi)
	{
		yolcular.add(kisi);
	}
	
}
