import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import medac.validaciones.LibFrontend;

public class Padre {

	public static void main(String[] args) throws InterruptedException, IOException {
		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();
		byte dos = 0;
		while (dos == 0) {
			Process p = JavaProcess.exec(Hijo.class, jvmArgs, argsM);
			System.out.println(p.exitValue());
			dos = (byte) LibFrontend.valida("¿Desea seguir ejecutando el programa? 0-Si / 1-No", 0, 1, 3);
		}
	}

}
