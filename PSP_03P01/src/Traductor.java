import java.io.IOException;
import java.util.concurrent.TimeUnit;

import medac.validaciones.LibFrontend;

public class Traductor {

	public static void main(String[] args) throws InterruptedException, IOException {
		int iStop = (int) LibFrontend.valida("Introduzca el tiempo máximo de ejecución del proceso: ", 1, 20, 1);
		int iSleep = (int) LibFrontend
				.valida("Introduzca el tiempo que su proceso dormirá hasta que se vuelva a ejecutar: ", 1, 10000, 1);
		String sRutaProceso = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
		String sOri = LibFrontend.leer("Introduzca el idioma de origen: ");
		String sTar = LibFrontend.leer("Introduzca el idioma de destino: ");
		String sText = LibFrontend.leer("Introduzca el texto que desee traducir: ");
		String sTrad = ("https://translate.google.es/?hl=#view=home&op=translate&sl=" + sOri + "&tl=" + sTar + "&text="
				+ sText);
		byte bReturn = 0;

		ProcessBuilder pb = new ProcessBuilder(sRutaProceso, sTrad);

		try {
			Process process = pb.start();
			System.out.println(process);
			process.waitFor(iStop, TimeUnit.SECONDS);

		} catch (IOException e) {
			System.out.println("Error IO: " + e.getMessage());
			System.exit(-1);
		} catch (InterruptedException ex) {
			System.out.println("ERROR IE: " + ex.getMessage());
			System.exit(-1);
		}

		while (bReturn == 0) {
			bReturn = (byte) LibFrontend.valida("¿Desea traducir algún otro texto? \n0-Si \n1-No", 0, 1, 3);
			if (bReturn == 0) {
				Thread.sleep(1000);
				sRutaProceso = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
				sOri = LibFrontend.leer("Introduzca el idioma de origen: ");
				sTar = LibFrontend.leer("Introduzca el idioma de destino: ");
				sText = LibFrontend.leer("Introduzca el texto que desee traducir: ");
				sTrad = LibFrontend.leer("https://translate.google.es/?hl=#view=home&op=translate&sl=" + sOri + "&tl="
						+ sTar + "&text=" + sText);

				pb = new ProcessBuilder(sRutaProceso, sTrad);

				try {
					Process process = pb.start();

					bReturn = (byte) process.waitFor();

					System.out.println("La ejecucion de " + sTrad + " devuelve " + bReturn);

				} catch (IOException e) {
					System.out.println("Error IO: " + e.getMessage());
					System.exit(-1);
				} catch (InterruptedException ex) {
					System.out.println("ERROR IE: " + ex.getMessage());
					System.exit(-1);
				}
			} else {
				System.out.println("Fin del programa.");
			}
		}

	}

}
