package library;

/**
 *
 * @author Frank.Santos
 */
public class Library {

    static int LENGTHMAX = 5;
    static String ERROR = "ERROR! Posición incorrecta.";

    public static void main(String[] args) {
        int array[] = new int[LENGTHMAX];
        boolean arrayPositions[] = new boolean[LENGTHMAX];
        int positions = 0;
        boolean on = true;
        int i = 0;
        int positionInput = 0;

        //Solicitamos al usuario cuantas posiciones quiere llenar
        do {
            System.out.println("Cuantas posiciones del vector quieres llenar?: ");
            positions = Teclat.llegirInt();
            if (positions > LENGTHMAX) {
                System.out.println(ERROR);
            } else if (positions < 0) {
                System.out.println(ERROR);
            } else {
                on = false;
            }
        } while (on); //Hay que apagarlo para salir del bucle

        //Solicitamos las posiciones a llenar
        do {
            System.out.println("Indica qué posición quieres llenar: ");
            positionInput = Teclat.llegirInt();
            if ((positionInput >= LENGTHMAX) || (positionInput < 0)) {
                System.out.println(ERROR);
            } else {
                arrayPositions[positionInput] = true;
                i++;
            }
        } while (i < positions); //se sale del bucle cuando se han pedido las posiciones

        fillArray(array, arrayPositions); //Funcion para llenar el array
     
        System.out.println("La Media es: " +calcularMedia(array, LENGTHMAX));
        System.out.println("");
        ordenarVector(array, LENGTHMAX);
         showVector(array, LENGTHMAX);
         
         buscarElement(array, LENGTHMAX, 0);
        
    }

    public static void fillArray(int _array[], boolean _arrayPositions[]) {
        int dato = 0;
        for (int i = 0; i < LENGTHMAX; i++) {
            if (_arrayPositions[i] == true) {
                System.out.println("Introduzca el dato: "); //Se introduce el dato deseado
                dato = Teclat.llegirInt();
                _array[i] = dato;
            }
        }
    }

    public static void showVector(int _array[], int _position) {

        //Se recorre el array hasta la posición indicada
        for (int i = 0; i < _position; i++) {
            System.out.print(_array[i] + "  ");
        }
    }

    public static float calcularMedia(int _array[], int _positions) {

        int suma = 0;
        float media = 0;

        //Se suman los elementos del array
        for (int i = 0; i < LENGTHMAX; i++) {

            suma = suma + _array[i];
        }
        //Dividimos el total de la suma por el nº de elementos.
        media = suma / LENGTHMAX;

        return media;
    }

    public static float ordenarVector(int _array[], int _elements) {
        int aux; //VARIABLE AUXILIAR
        int valorMax = 0;

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

    public static boolean buscarElement(int _array[], int _positions, int _element) {

        boolean noEncontrado = false;
        boolean encontrado = true;
        for (int i = 0; i < _positions; i++) {
            if (_element == _array[i]) {
                System.out.println("\nEl elemento se encuentra en la posición " + i);
                return encontrado;
            }
        }
        System.out.println("El elemento NO se encuentra dentro del array.");
        return noEncontrado;
    }
}
