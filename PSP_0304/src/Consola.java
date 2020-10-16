import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import medac.validaciones.LibFrontend;

public class Consola {

	public static void main(String[] args) throws IOException, InterruptedException {
		String sSo = System.getProperty("os.name");
		System.out.println("Su sistema operativo es " + sSo + "\n");

		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();

		try {
			String sRuta = LibFrontend
					.leer("Introduzca un directorio para mostrar su contenido o un fichero para leerlo: ");
			File fLectura = new File(sRuta);
			argsM.add(0, sRuta);

			if (fLectura.exists() && fLectura.isFile()) {
				Process archivo = JavaProcess.exec(ProcesoFile.class, jvmArgs, argsM);
			} else if (fLectura.exists() && fLectura.isDirectory()) {
				Process directorio = JavaProcess.exec(ProcesoDir.class, jvmArgs, argsM);
			} else {
				System.out.println("No se han detectado archivos ni directorios");
			}

		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe" + e);
		} catch (IOException e) {
			System.err.println("Error de acceso" + e);
		}

	}

}
