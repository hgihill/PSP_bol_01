import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcesoDir {

	public static void main(String[] args) {

		Path pRuta = Paths.get(args[0]);
		File dir = new File(String.valueOf(pRuta));
		List<String> listaDir = new ArrayList<>();
		listaDir = Arrays.asList(dir.list());
		System.out.println(listaDir);
	}

}
