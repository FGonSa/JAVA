package ejerciciolibreria;

/**
 *
 * @author Frank.Santos
 */
public class EjercicioLibreria {

    public static final int LENGTHMAX = 5; //Tamaño del array y su cantidad de elementos

    public static void main(String[] args) {

        float array[] = new float[LENGTHMAX];
        int valorMax;
        float media;
        int posiciones = 0;
        boolean on = true;
        float elemento = 0;
        do {
            System.out.println("Cuantas posiciones del vector quieres llenar?: ");
            posiciones = Teclat.llegirInt();
            if (posiciones > LENGTHMAX) {
                System.out.println("ERROR! El vector no tiene tantas posiciones.");
            } else if (posiciones < 0) {
                System.out.println("ERROR! Introduce un valor positivo.");
            } else {
                on = false;
            }
        } while (on);

        for (int i = 0; i < posiciones; i++) {
            llenarArray(array, posiciones);
        }
        mostrarVector(array, 4);//hasta esta posicion.
        System.out.println("");
        System.out.println("");
        media = calcularMedia(array, LENGTHMAX);
        System.out.println(media);
        System.out.println("");
        System.out.println(ordenarVector(array, LENGTHMAX));
        System.out.println("");
        System.out.println("Introduce el elemento a buscar: ");
        elemento = Teclat.llegirFloat();
        buscarElement(array, LENGTHMAX, elemento);
    }

    public static void llenarArray(float _array[], int _position) {
        int dato;

        do {
            System.out.println("Indica la posición que quieres llenar: ");
            _position = Teclat.llegirInt();
            if (_position >= LENGTHMAX) {
                System.out.println("ERROR! Te pasas de tamaño.");
            }
        } while (_position >= LENGTHMAX);
        System.out.println("Introduzca el dato: "); //Se introduce el dato deseado
        dato = Teclat.llegirInt();
        _array[_position] = dato;
    }

    public static void mostrarVector(float _array[], int _position) {

        //Se recorre el array hasta la posición indicada
        for (int i = 0; i <= _position; i++) {
            System.out.print(_array[i] + "  ");
        }
    }

    public static float calcularMedia(float _array[], int _positions) {
        int total;
        float suma = 0;
        float media = 0;

        //Se suman los elementos del array
        for (int i = 0; i < LENGTHMAX; i++) {

            suma = suma + _array[i];
        }
        //Dividimos el total de la suma por el nº de elementos.
        media = suma / LENGTHMAX;

        return media;
    }

    public static float ordenarVector(float _array[], int _elements) {
        float aux; //VARIABLE AUXILIAR
        float valorMax = 0;

        for (int i = 0; i < _elements - 1; i++) {
            for (int j = 0; j < _elements - 1; j++) {
                if (_array[j] > _array[j + 1]) { //Si el número actual es mayor que el siguiente
                    aux = _array[j];//Guardo el actual mayor en una variable
                    _array[j] = _array[j + 1];//Actual se convierte en el menor
                    _array[j + 1] = aux;//el siguiente se convierte en el mayor
                }
            }
        }
        valorMax = _array[_elements - 1];
        return valorMax;
    }

    public static boolean buscarElement(float _array[], int _positions, float _element) {

        boolean noEncontrado = false;
        boolean encontrado = true;
        for (int i = 0; i < _positions; i++) {
            if (_element == _array[i]) {
                System.out.println("El elemento se encuentra en la posición " + i);
                return encontrado;
            }
        }
        System.out.println("El elemento NO se encuentra dentro del array.");
        return noEncontrado;
    }
}

