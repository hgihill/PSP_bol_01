import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ProcesoFile {

	public static void main(String[] args) throws IOException {
		Path pRuta = Paths.get(args[0]);
		String sFile = null;

		try {
			List<String> sLeeLineas = Files.readAllLines(pRuta, StandardCharsets.UTF_8);
			sFile = String.join(System.lineSeparator(), sLeeLineas);
		} catch (IOException e) {
			System.err.println(e);
		}
		System.out.println(sFile);
	}

}
