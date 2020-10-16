import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Usuarios {

	public static void main(String[] args) throws IOException {
		String sUserName = args[0];
		String sOs = System.getProperty("os.name");

		if (sOs.equals("Windows 10")) {
			Process process = Runtime.getRuntime()
					.exec("cmd.exe /c net user " + sUserName + " 2 >> ERRORES.DAT");

			BufferedReader consola = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String sConsola = consola.readLine();

			if (sConsola == null) {
				System.err.println("Usuario no localizado.");
			}
			while (sConsola != null) {
				System.out.println(sConsola);
				sConsola = consola.readLine();
			}

		} else if (sOs.equals("Linux")) {
			Process process = Runtime.getRuntime().exec("cut -d : -f -1 etc/passwd");

			BufferedReader consola = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String sConsola = consola.readLine();

			if (sConsola == null) {
				System.err.println("Usuario no localizado.");
			} else if (sConsola != null) {
				System.out.println("El usuario ha sido localizado");
			}
			
		} else {
			System.err.println("Su SO no se encuentra entre los registrados");
		}

	}

}
