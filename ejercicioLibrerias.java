package ejerciciolibrerias;

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

        //Función para pedir posiciones al usuario. Le enviamos dos arrays y cuantas veces debe solicitar posición.
        positionsForArray(array, arrayPositions, 2);//Por ejemplo, vamos a hacer que nos pida 2 veces posición.

        //-----------------------------------------
        //DISTINTAS PRUEBAS DEL USO DE LA LIBRERÍA
        //-----------------------------------------
        //LLeno el vector con las posiciones solicitadas en la función anterior y le paso la longitud entera del array.
        Library.fillArray(array, arrayPositions, LENGTHMAX);
        Library.showVector(array, 3); //Recorro el vector tantas posiciones como indique el parametro y voy imprimiendo sus valores. 
                                      //Por ejemplo, que me muestre sólo las 3 primeras posiciones.

        valorMax = Library.ordenarVector(array, 3); //Ordeno el vector hasta el parametro indicado y devuelvo valorMax de entre esas posiciones
        System.out.println("\nEl valor máximo hasta la posicion indicada es: " + valorMax);

        System.out.println("");
        valorMax= Library.ordenarVector(array, LENGTHMAX);//Ahora quiero ordenar todos los elementos del vector.
         Library.showVector(array, LENGTHMAX); //Como hemos ordenado el vector entero, quiero verlo entero ordenado.
        System.out.println("\nEl valor máximo de todo el array es: " + valorMax); //Me devuele el valorMax de todo el vector
        media = Library.calcularMedia(array, LENGTHMAX);//Calculo la media de todos los elementos del array
        System.out.println("\nLa media es: " + media);
        Library.findElement(array, LENGTHMAX, 99); //Busco el número que le indique por parámetro, por ejemplo, el 99.

    }

    public static void positionsForArray(int array[], boolean _arrayPositions[], int _asking) {

        
        boolean on = true; //activa/desactiva el bucle while
        int i = 0;//Contador
        int positionInput = 0; //Posicion introducida por el usuario

        if (_asking > 0) {
            //Solicitamos las posiciones a llenar
            do {
                System.out.println(i + 1 + ".- " + "Indica qué posición quieres llenar: ");
                positionInput = Teclat.llegirInt();
                if ((positionInput >= LENGTHMAX) || (positionInput < 0)) {
                    System.out.println("ERROR! El dato no respeta las longitudes del vector con las que trabajamos.");
                } else {
                    _arrayPositions[positionInput] = true; //Si introducimos la posición 2, pues se guarda un true en la posición 2.
                    //De este modo, luego sólo se llenaran las posiciones true.
                    i++;
                }
            } while (i < _asking); //Se sale del bucle al haber llenado todas las posiciones solicitadas.
        }
    }
}

