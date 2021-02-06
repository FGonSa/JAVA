package ejerciciolibrerias;

import java.text.DecimalFormat;

/**
 *
 * @author Frank.Santos
 */
public class Library {

    public static void fillArray(int _array[], boolean _arrayPositions[], int _length) {

        /**
         * *Función que rellena un array según las posiciones que se le hayan
         * indicado. Para saber qué posiciones hay que llenar, previamente hemos
         * tenido que registrar un array con valores TRUE en las posiciones
         * deseadas y envíarselo. La función llenará las posiciones que sean
         * TRUE. Es necesario enviarle la longitud entera para que haga sus comprobaciones.
         */
        int dato = 0;
        for (int i = 0; i < _length; i++) {
            if (_arrayPositions[i] == true) { //Si la posición es true, nos solicitará introducir un dato.
                System.out.println("Introduzca el dato: "); //Se introduce el dato deseado
                dato = Teclat.llegirInt();
                _array[i] = dato;
            }
        }
    }

    public static void showVector(int _array[], int _position) {
        /**
         * *
         * Función que muestra un array hasta la posición indicada.
         */
        //Se recorre el array hasta la posición indicada
        for (int i = 0; i <_position; i++) {
            System.out.print(_array[i] + "  ");
        }
    }

    public static float calcularMedia(int _array[], int _positions) {

        /**
         * *Función que suma todos los elementos de un array y luego los divide
         * por el número de posiciones para obtener la media. Es necesario
         * enviarle el array y el número de posiciones.
         */
        float media = 0;

        //Se suman todos los elementos del array, por eso pongo la longitud total.
        for (int i = 0; i < _positions; i++) {

            media = media + _array[i];
        }
        //Dividimos el total de la suma por el nº de elementos.

        DecimalFormat df = new DecimalFormat("####.##");
        media = media / _positions;
        df.format(media);
        return media;
    }

    public static int ordenarVector(int _array[], int _elements) {

        /**
         * *Esta función ordena los elementos de un array de menor a mayor y
         * devuelve el elemento más grande. Es necesario indicarle el array y la
         * longitud hasta la que queremos inspeccionar el valor max.
         */
        int aux; //VARIABLE AUXILIAR
        int valorMax = 0;

        //Le envio las posiciones para que trabaje con los elementos que contienen.
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

    public static boolean findElement(int _array[], int _positions, int _elementToFind) {

        /**
         * *Esta función busca un elemento en un array. Recorre hasta la
         * posición indicada y si encuentra el elemento indicado, devuelve un
         * mensaje indicando en qué posición se encuentra.
         */
        boolean noEncontrado = false;
        boolean encontrado = true;
        for (int i = 0; i < _positions; i++) {
            if (_elementToFind == _array[i]) {
                System.out.println("\nEl elemento se encuentra en la posición " + i);
                return encontrado;
            }
        }
        System.out.println("El elemento NO se encuentra dentro del array.");
        return noEncontrado;
    }
}
