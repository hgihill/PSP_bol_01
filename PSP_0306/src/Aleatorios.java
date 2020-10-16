import java.util.Random;

public class Aleatorios {

	public static void main(String[] args) {
		int iAleatorio = Integer.parseInt(args[0]);
		Random r = new Random();
		int iRandom = 0 + r.nextInt(10 - 0 + 1);

		if (iAleatorio == iRandom) {
			System.out.println(iAleatorio);
			System.out.println(iRandom);
			System.out.println("Los números generados coinciden");
		} else {
			System.out.println(iAleatorio);
			System.out.println(iRandom);
			System.out.println("Los números generados no coinciden");
		}
	}

}
