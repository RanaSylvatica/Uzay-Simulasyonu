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

public class Gezegen extends Zaman{
	
	public String ad;
	private String  tarih="0.0.0";
	private int gunSaati;
	private int gun, ay, yil, saat;
	private int nufus;
	private Zaman zaman;
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		if(ad== null || ad.equals("")) {
			System.out.println("Ad boş olamaz");
			return;
		}
		this.ad = ad;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		if(tarih.equals("0.0.0"))
			System.out.println("Gecersiz tarih!");
		this.tarih = tarih;
	}
	public int getGunSaati() {
		return gunSaati;
	}
	public void setGunSaati(int gunSaati) {
		this.gunSaati = gunSaati;
	}
	public int getGun() {
		return gun;
	}
	public void setGun(int gun) {
		this.gun = gun;
	}
	public int getAy() {
		return ay;
	}
	public void setAy(int ay) {
		this.ay = ay;
	}
	public int getYil() {
		return yil;
	}
	public void setYil(int yil) {
		this.yil = yil;
	}
	public int getSaat() {
		return saat;
	}
	public void setSaat(int saat) {
		this.saat = saat;
	}
	public int getNufus() {
		return nufus;
	}
	public void setNufus(int nufus) {
		this.nufus = nufus;
	}
	public Zaman getZaman() {
		return zaman;
	}
	public void setZaman(Zaman zaman) {
		this.zaman = zaman;
	}
	
	public Gezegen(String ad, int gunSaati, String tarih)
	{
		String[] tarihParcalari = tarih.split("\\.");
		this.ad=ad;
		this.gunSaati=gunSaati;
		this.tarih=tarih;
		this.nufus=0;
		this.gun = Integer.parseInt(tarihParcalari[0]);
		this.ay = Integer.parseInt(tarihParcalari[1]);
		this.yil = Integer.parseInt(tarihParcalari[2]);
		
	}
	
	public String tariheDonustur(int saat)
	{
		int yil = saat/(12*30*gunSaati);
		int ay = (saat%(12*30*gunSaati))/(30*gunSaati);
		if(ay==0) {
			ay=12;
			yil--;
		}
		int gun =(((saat%(12*30*gunSaati))%(30*gunSaati)))/gunSaati;
		if(gun==0) {
			gun=30;
			ay--;
		}

		return gun + "." + ay + "." + yil;
	}
	@Override
	protected void zamanArttir() {
		// TODO Auto-generated method stub
		saat++;
	}
	public void zamaniIlerlet()
	{
		zamanArttir();
		
		if(saat==gunSaati)
		{
			gun++;
			saat=0;
		}
		if(gun==31)
		{
			ay++;
			gun=1;
		}
		if(ay==13)
		{
			yil++;
			ay=1;
		}
		
		tarih=gun+"."+ay+"."+yil;
	}
}
