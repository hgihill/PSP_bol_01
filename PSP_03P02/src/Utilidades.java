import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import medac.validaciones.LibFrontend;

public class Utilidades {

	public static void main(String[] args) throws IOException, InterruptedException {

		String sPam1 = LibFrontend.leer("Introduzca el primer parámetro deseado: ");

		byte sEleccion = (byte) LibFrontend.valida("¿Desea introducir otro parámetro?\n0-Si\n1-No", 0, 1, 3);
		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();
		Process process;

		if (sEleccion == 1) {
			argsM.add(sPam1);
			process = JavaProcess.exec(Usuarios.class, jvmArgs, argsM);

		} else if (sEleccion == 0) {
			String sPam2 = LibFrontend.leer("Introduzca el segundo parámetro deseado: ");
			argsM.add(sPam1);
			argsM.add(sPam2);
			process = JavaProcess.exec(Archivos.class, jvmArgs, argsM);

		} else {
			System.out.println("No ha escogido una opción registrada.");
		}
	}

}
