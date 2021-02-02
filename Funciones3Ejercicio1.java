package funciones3ejercicio1;

/**
 *
 * @author Frank.Santos
 */
public class Funciones3Ejercicio1 {

    public static final int LENGTHMAX = 6; //Numero al azar

    public static void main(String[] args) {
        int array1[] = new int[LENGTHMAX];
        int array2[] = new int[LENGTHMAX / 2];
        int posicion = 0;

        //PRIMER VECTOR
        System.out.println("PRIMER VECTOR");
        for (int i = 0; i < array1.length; i++) {//Lleno el array con datos del usuario
            introducirDatoArray(array1, posicion);
        }
        ordenarVector(array1);
        mostrarVector(array1);

        //SEGUNDO VECTOR
        System.out.println("");
        System.out.println("SEGUNDO VECTOR");
        for (int i = 0; i < array2.length; i++) {//Lleno el array con datos del usuario
            introducirDatoArray(array2, posicion);
        }
        ordenarVector(array2);
        mostrarVector(array2);
    }

    public static void introducirDatoArray(int _array[], int _posicion) {
        int dato;
        System.out.println("Introduzca posicion del array: ");
        _posicion = Teclat.llegirInt();
        System.out.println("Introduce el dato: "); //Se introduce el dato deseado
        dato = Teclat.llegirInt();
        _array[_posicion] = dato;
    }

    public static void ordenarVector(int _array[]) {
        int aux; //VARIABLE AUXILIAR

        for (int i = 0; i < _array.length - 1; i++) {
            for (int j = 0; j < _array.length - 1; j++) {
                if (_array[j] > _array[j + 1]) { //Si el número actual es mayor que el siguiente
                    aux = _array[j];//Guardo el actual mayor en una variable
                    _array[j] = _array[j + 1];//Actual se convierte en el menor
                    _array[j + 1] = aux;//el siguiente se convierte en el mayor
                }
            }
        }
    }

    public static void mostrarVector(int _array[]) {
        for (int i = 0; i < _array.length; i++) {
            System.out.print(_array[i] + " ");
        }
    }
}
