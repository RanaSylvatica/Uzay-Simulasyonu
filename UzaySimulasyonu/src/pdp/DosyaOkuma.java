/**
*
* @author elif ranagül akyol ranagul.akyol@ogr.sakarya.edu.tr
* @since 21.04.2025
* <p>
* 1C Simulasyon.java
* </p>
*/

package pdp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DosyaOkuma {

	public static ArrayList<Kisi> kisileriOku(String dosyaIsmi)  {
		ArrayList<Kisi> kisiler = new ArrayList<Kisi>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(dosyaIsmi));
			String satir;
			while ((satir = br.readLine()) != null) {
				String[] parcalar = satir.split("#");
				String ad = parcalar[0];
				int yas = Integer.parseInt(parcalar[1]);
				int kalanOmur = Integer.parseInt(parcalar[2]);
				String bulunduguUzayAraci = parcalar[3];
				Kisi kisi = new Kisi(ad, yas, kalanOmur, bulunduguUzayAraci);
				kisiler.add(kisi);
				
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Dosya okunurken hata oluştu: " + e.getMessage());
		}
		return kisiler;
	}
	

	
	
	public static ArrayList<Gezegen> gezegenleriOku(String dosyaIsmi)  {
		ArrayList<Gezegen> gezegenler = new ArrayList<Gezegen>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(dosyaIsmi));
			String satir;
			while ((satir = br.readLine()) != null) {
				String[] parcalar = satir.split("#");
				String ad = parcalar[0];
				int gunSaati = Integer.parseInt(parcalar[1]);
				String tarih = parcalar[2];
				Gezegen gezegen = new Gezegen(ad, gunSaati, tarih);
				gezegenler.add(gezegen);
				
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Dosya okunurken hata oluştu: " + e.getMessage());
		}
		return gezegenler;
	}
	
	
	public static ArrayList<Arac> araclariOku(String dosyaIsmi, ArrayList<Kisi> kisiler, ArrayList<Gezegen> gezegenler)  {
		Gezegen cikisGezegeniKopya = null;
		Gezegen varisGezegeniKopya = null;
		ArrayList<Arac> araclar = new ArrayList<Arac>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(dosyaIsmi));
			String satir;
			while ((satir = br.readLine()) != null) {
				String[] parcalar = satir.split("#");
				String ad = parcalar[0];
				String cikisGezegeni = parcalar[1];
				String varisGezegeni = parcalar[2];
				String cikisTarihi = parcalar[3];
				int mesafe = Integer.parseInt(parcalar[4]);
				
				for(Gezegen gezegen:gezegenler)
				{
					if(gezegen.getAd().equals(cikisGezegeni))
					{
						cikisGezegeniKopya=gezegen;
					}
					if(gezegen.getAd().equals(varisGezegeni))
					{
						varisGezegeniKopya=gezegen;
					}
				
				
				
				}
				Arac arac = new Arac(ad, cikisGezegeniKopya, varisGezegeniKopya, cikisTarihi, mesafe);
				for(int i = 0; kisiler.size() > i; i++)
				{
					if(kisiler.get(i).getBulunduguUzayAraci().equals(ad))
					{
						arac.kisiEkle(kisiler.get(i));
					}
				}

				araclar.add(arac);
				
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Dosya okunurken hata oluştu: " + e.getMessage());
		}
		return araclar;
	}
	
}
