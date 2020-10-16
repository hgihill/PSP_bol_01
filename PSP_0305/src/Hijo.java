import java.io.FileNotFoundException;
import java.io.IOException;

public class Hijo {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {

		Thread.sleep(3000);
		System.out.println("Proceso hijo terminado.");
		System.exit(2);
	}

}
