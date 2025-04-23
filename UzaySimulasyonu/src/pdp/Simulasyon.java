/**
*
* @author elif ranagül akyol ranagul.akyol@ogr.sakarya.edu.tr
* @since 21.04.2025
* <p>
* 1C Simulasyon.java
* </p>
*/


package pdp;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;

public class Simulasyon {

	ArrayList<Gezegen> gezegenler = new ArrayList<Gezegen>();
	ArrayList<Arac> araclar = new ArrayList<Arac>();
	ArrayList<Kisi> kisiler = new ArrayList<Kisi>();
	
	
	public Simulasyon(ArrayList<Gezegen> gezegenler, ArrayList<Arac> araclar, ArrayList<Kisi> kisiler)
	{
		this.gezegenler=gezegenler;
		this.araclar=araclar;
		this.kisiler=kisiler;
	}
	public void baslat() 
	{ 
		String varisTarihi;
		for(int i=0; i<araclar.size(); i++)
		{ 
			for(Gezegen gezegen:gezegenler)
			{
				if(gezegen.getAd().equals(araclar.get(i).getGezegenVaris()) )//////////
				{
					araclar.get(i).setGezegenVaris(gezegen);
				}
				if(gezegen.getAd().equals(araclar.get(i).getGezegenCikis()) )//////////
				{
					araclar.get(i).setGezegenCikis(gezegen);
				}
			}
			
			varisTarihi=araclar.get(i).varisTarihiDondur();
			araclar.get(i).setVarisTarihi(varisTarihi);
		}
		while(true) {
			
			System.out.print("\033[H\033[2J");
			System.out.flush();

			   
			for(Gezegen gezegen:gezegenler)
			{
				gezegen.setNufus(0);
				for(Arac arac:araclar)
				{
					if(gezegen.getAd().equals(arac.getGezegenCikis().getAd())&&arac.getDurum().equals("Bekliyor"))
					{
						gezegen.setNufus(gezegen.getNufus()+arac.kisiSayisiDondur());
					}
					if(gezegen.getAd().equals(arac.getGezegenVaris().getAd())&&arac.getDurum().equals("Vardı"))
					{
						gezegen.setNufus(gezegen.getNufus()+arac.kisiSayisiDondur());
					}
					
				}
			}
			
			
			System.out.println("Gezegenler:");
			System.out.print("\t\t\t");
			for(Gezegen gezegen:gezegenler)
			{
				gezegen.getAd();
				System.out.print("    -- " + gezegen.getAd() + " --    ");
			}
			
			
			
			System.out.println("");
			System.out.print("Tarih\t\t\t   ");
			for(Gezegen gezegen:gezegenler)
			{
				System.out.printf("%-15s",gezegen.getTarih());
			}
			System.out.println();
			System.out.print("Nüfus\t\t\t       ");
			for(Gezegen gezegen:gezegenler)
			{
				System.out.printf("%-15s",gezegen.getNufus());
			}
			System.out.println("\n\n\n");
			System.out.println("Uzay Araçları:");
			System.out.println("Arac Adi                     Durum            Cikis             Varis               Hedefe Kalan Saat            Hedefe Varacagi Tarih");
			
			for(Arac arac:araclar)
			{
				System.out.print(arac.getAd()+"\t\t\t     ");
				System.out.printf("%-16s ",arac.durumuDondur());
				System.out.printf("%-17s ",arac.gezegenCikis.ad);
				System.out.printf("%-19s ",arac.gezegenVaris.ad);
				System.out.printf("%-28s ",arac.getKalanSaat());
				System.out.printf("%-20s ",arac.getVarisTarihi());
				System.out.println();
				
				
				
			}
			
			for(Arac arac:araclar)
			{
				arac.zamaniIlerlet();
			}
			for(Gezegen gezegen:gezegenler)
			{
				gezegen.zamaniIlerlet();
			}
			
		}
		
	}
	
	
}
