import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import medac.validaciones.LibFrontend;

public class Archivos {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		Path path1 = Paths.get(args[0]);
		Path path2 = Paths.get(args[1]);

		String sCont1 = null;
		String sCont2 = null;

		try {
			// Lee los ficheros de la ruta dada por el usuario
			List<String> lines1 = Files.readAllLines(path1, StandardCharsets.UTF_8);
			sCont1 = String.join(System.lineSeparator(), lines1);

			// Lee los ficheros de la ruta dada por el usuario
			List<String> lines2 = Files.readAllLines(path2, StandardCharsets.UTF_8);
			sCont2 = String.join(System.lineSeparator(), lines2);
		} catch (IOException e) {
			System.err.println("Error IO: " + e.getMessage());
			;
		}

		if (sCont1.equals(sCont2)) {
			System.out.println("Ambos archivos son iguales.");
		} else {
			System.out.println("Los archivos comparados no coinciden.");
		}
	}

}
