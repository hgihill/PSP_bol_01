import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import medac.validaciones.LibFrontend;

public class Padre {

	public static void main(String[] args) throws IOException, InterruptedException {

		int i = 0;
		byte iReturn;
		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();

		while (i == 0) {
			iReturn = (byte) Padre.numAl();
			argsM.add(0, String.valueOf(iReturn));
			Process p = JavaProcess.exec(Aleatorios.class, jvmArgs, argsM);
			i = (byte) LibFrontend.valida("¿Desea volver a ejecutar el programa? \n(0 Si) \n(1 No)", 0, 1, 3);
		}

	}

	public static int numAl() {
		Random r = new Random();
		return 0 + r.nextInt(10 - 0 + 1);
	}

}
