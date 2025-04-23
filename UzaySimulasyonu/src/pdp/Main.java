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

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Kisi> yolcular = DosyaOkuma.kisileriOku("src/pdp/Kisiler.txt");
		ArrayList<Gezegen> gezegenler = DosyaOkuma.gezegenleriOku("src/pdp/Gezegenler.txt");
		ArrayList<Arac> araclar = DosyaOkuma.araclariOku("src/pdp/Araclar.txt", yolcular, gezegenler);
		
		Simulasyon simulasyon = new Simulasyon(gezegenler, araclar, yolcular);
		simulasyon.baslat();
	}
}
