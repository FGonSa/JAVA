package ejerciciolibrerias;

import library.*;

/**
 *
 * @author Frank.Santos
 */
public class EjercicioLibrerias {

    static int LENGTHMAX = 5; //Constante con el tamaño del array

    public static void main(String[] args) {
        int array[] = new int[LENGTHMAX]; //Array con el que trabajaremos
        boolean arrayPositions[] = new boolean[LENGTHMAX]; //Array aux para la funcion positionsForArray()
        float media = 0; //Media que guardamos del return de calcularMedia()
        int valorMax = 0; //Valor Max del Array que nos devuelve la función ordenarVector()
 
        //Función para pedir posiciones al usuario. Le enviamos dos arrays.
        positionsForArray(array, arrayPositions);

        //Uso de la librería
        //LLeno el vector con las posiciones solicitadas en la función anterior
        Library.fillArray(array, arrayPositions, LENGTHMAX);
        valorMax = Library.ordenarVector(array, LENGTHMAX); //Ordeno el vector y devuelvo valorMax
        System.out.println("El valor máximo es: " + valorMax);
        Library.showVector(array, LENGTHMAX); //Muestro el vector
        media = Library.calcularMedia(array, LENGTHMAX);
        System.out.println("\nLa media es: " + media);
        Library.findElement(array, LENGTHMAX, 99); //Busco el número 99

    }

    public static void positionsForArray(int array[], boolean _arrayPositions[]) {

        String Error = "ERROR! El dato no respeta la Longitud Máxima.";
        int positions = 0;
        boolean on = true;
        int i = 0;
        int positionInput = 0;

        //Solicitamos al usuario cuantas posiciones quiere llenar
        do {
            System.out.println("Cuantas posiciones del vector quieres llenar?: ");
            positions = Teclat.llegirInt();
            if (positions > LENGTHMAX) {
                System.out.println(Error);
            } else if (positions < 0) {
                System.out.println(Error);
            } else {
                on = false; //Una vez solicitadas todas, se apaga.
            }
        } while (on); //Hay que apagarlo para salir del bucle

        //Solicitamos las posiciones a llenar
        do {
            System.out.println("Indica qué posición quieres llenar: ");
            positionInput = Teclat.llegirInt();
            if ((positionInput >= LENGTHMAX) || (positionInput < 0)) {
                System.out.println(Error);
            } else {
                _arrayPositions[positionInput] = true; //Si introducimos la posición 2, pues se guarda un true en la posición 2.
                //De este modo, luego sólo se llenaran las posiciones true.
                i++;
            }
        } while (i < positions); //Se sale del bucle al haber llenado todas las posiciones solicitadas.

    }
}
