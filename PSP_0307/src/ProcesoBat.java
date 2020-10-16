import java.io.IOException;

public class ProcesoBat {

	public static void main(String[] args) {
		Runtime bat = Runtime.getRuntime();

		try {
			bat.exec("cmd.exe /c > pinf files\\ejecuta.sh >> files\\sourceBat.txt 2>> files\\errorBat.txt");
		} catch (IOException e) {
			System.err.println("Archivo no localizado");
		}

	}

}
