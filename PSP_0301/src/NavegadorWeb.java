import java.io.IOException;

import medac.validaciones.LibFrontend;

public class NavegadorWeb {

	public static void main(String[] args) throws InterruptedException {

		String sRutaProceso = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
		String sUrl = LibFrontend.leer("Introduzca una dirección (ej. google.com): ");
		int iReturn = 0;
		
		ProcessBuilder pb = new ProcessBuilder(sRutaProceso, "https://www." + sUrl);

		try {
			Process process = pb.start();
			iReturn = process.waitFor();

			System.out.println("La ejecucion de " + sUrl + " devuelve " + iReturn);

		} catch (IOException e) {
			System.out.println("Error IO: " + e.getMessage());
			System.exit(-1);
		} catch (InterruptedException ex) {
			System.out.println("ERROR IE: " + ex.getMessage());
			System.exit(-1);
		}
		
		while (iReturn == 0) {
			Thread.sleep(10000); // 10 segundos
			sRutaProceso = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
			sUrl = LibFrontend.leer("Introduzca una dirección (ej. google.com): ");

			pb = new ProcessBuilder(sRutaProceso, "https://www." + sUrl);

			try {
				Process process = pb.start();

				iReturn = process.waitFor();

				System.out.println("La ejecucion de " + sUrl + " devuelve " + iReturn);

			} catch (IOException e) {
				System.out.println("Error IO: " + e.getMessage());
				System.exit(-1);
			} catch (InterruptedException ex) {
				System.out.println("ERROR IE: " + ex.getMessage());
				System.exit(-1);
			}
		}

	}

}
