package repasarrays;

/**
 *
 * @author Frank.Santos
 */
public class RepasArrays {

	final static int LENGTHMAX = 4;

	public static void main(String[] args) {
		boolean menu = true;
		int option;
		float prices[] = new float[LENGTHMAX];
		float priceUser;
		float positions[] = new float[LENGTHMAX];
		String messageDiscount = " que queda en ";
		String messageAply = "Se aplica el descuento en ";
		boolean priceOn = true;
		boolean priceShow[] = new boolean[LENGTHMAX];

		do {
			System.out.println("Escoge una opción: ");
			System.out.println("1. AÑADIR PRECIOS AL MENÚ.");
			System.out.println("2. APLICAR DESCUENTO.");
			System.out.println("3. SALIR.");
			option = Teclat.llegirInt();

			switch (option) {
				case 1:
					System.out.println("Introduce " + LENGTHMAX + " precios:");
					for (int i = 0; i < LENGTHMAX; i++) {
						System.out.println("Introduce precio nº " + (i + 1) + ": ");
						prices[i] = Teclat.llegirFloat();
					}
					priceOn = false;
					break;
				case 2:
					if (priceOn) {
						System.out.println("No hay ningún precio introducido todavía!");
					} else {
						System.out.println("Introduce un precio: ");
						priceUser = Teclat.llegirFloat();
						discount(prices, priceUser, positions, priceShow);

						for (int i = 0; i < LENGTHMAX; i++) {
							System.out.println(messageAply + prices[i] + messageDiscount + positions[i]);
						}
					}
					System.out.println("");
					break;
				case 3:
					menu = false;
					break;
				default:
					System.out.println("ERROR. Introduce una opción válida.");
					break;
			}
		} while (menu);
	}

	public static void discount(float[] _prices, float _priceUser, float[] _positions, boolean[] _show) {
		float percentage = 0.1f;
		float discount = 0;
		float result;
		for (int i = 0; i < LENGTHMAX; i++) {
			if (_prices[i] > _priceUser) {
				discount = _prices[i] * percentage;
				result = _prices[i] - discount;
				_positions[i] = result;
				_show[i] = true;
			}
		}
	}
}
