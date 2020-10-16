import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjecutaBat {

	public static void main(String[] args) {
		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();

		try {
			Process process = JavaProcess.exec(ProcesoBat.class, jvmArgs, argsM);
		} catch (IOException e) {
			System.err.println("Archivo no encontrado");
		} catch (InterruptedException e) {
			System.err.println("Ejecución del archivo interrumpida");
		}

	}

}
