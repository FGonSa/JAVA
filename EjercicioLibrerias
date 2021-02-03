package ejerciciolibrerias;

/**
 *
 * @author Frank.Santos
 */
public class EjercicioLibrerias {

	public static final int LENGTHMAX = 5; //Tamaño del array

	public static void main(String[] args) {

		int array[] = new int[LENGTHMAX];
		int valorMax;
		float media;

		llenarArray(array, LENGTHMAX);
		mostrarVector(array, 3);
		media = calcularMedia(array, LENGTHMAX);
		System.out.println(media);
		valorMax = ordenarVector(array, LENGTHMAX);
		System.out.println(valorMax);
	}

	public static void llenarArray(int _array[], int _position) {
		int dato;

		System.out.println("Procedemos a llenar el array: ");
		for (int i = 0; i < LENGTHMAX; i++) {
			System.out.println("Posición " + i + ":");
			System.out.println("Introduzca el dato: "); //Se introduce el dato deseado
			dato = Teclat.llegirInt();
			_array[i] = dato;
		}
	}

	public static void mostrarVector(int _array[], int _position) {

		//Se recorre el array hasta la posición indicada
		for (int i = 0; i < _position; i++) {
			System.out.print(_array[i] + " ");
		}
	}

	public static float calcularMedia(int _array[], int _positions) {
		int total;
		int suma = 0;
		float media = 0;

		//Se suman los elementos del array
		for (int i = 0; i < _positions; i++) {

			suma = suma + _array[i];
		}
		//Dividimos el total de la suma por el nº de elementos.
		media = suma / _positions;

		return media;
	}

	public static int ordenarVector(int _array[], int _positions) {
		int aux; //VARIABLE AUXILIAR
		int valorMax = 0;

		for (int i = 0; i < _positions - 1; i++) {
			for (int j = 0; j < _positions - 1; j++) {
				if (_array[j] > _array[j + 1]) { //Si el número actual es mayor que el siguiente
					aux = _array[j];//Guardo el actual mayor en una variable
					_array[j] = _array[j + 1];//Actual se convierte en el menor
					_array[j + 1] = aux;//el siguiente se convierte en el mayor
				}
			}
		}
		return valorMax;
	}

	public static int buscarElement(int _array, int _positions, int _element) {

		return _element;
	}
}
