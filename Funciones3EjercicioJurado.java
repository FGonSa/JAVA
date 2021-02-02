package funciones3ejerciciojurado;

/**
 *
 * @author Frank.Santos
 */
public class Funciones3EjercicioJurado {

    public static int JUECES = 7; //Nº DE JUECES
    public static float CD = 2.3f; //COEFICIENTE DE DIFICULTAD

    public static void main(String[] args) {
        float notaJurado;//La nota que pone cada juez
        float arrayNotas[] = new float[JUECES]; //Vector para almacenar las notas
        int contadorValido = 0; //Cuenta cuantas notas validas hay.

        //Bucle para pedir las notas. Por cada nota válida, el contadorValido++
        //Hasta que el contadorValido no iguale el nº de Jueces, no se sale del bucle
        do {
            for (int i = 0; i < JUECES; i++) {
                System.out.println("Introduzca nota: ");
                notaJurado = Teclat.llegirFloat();
                if (notaJurado < 0 || notaJurado > 10) {
                    System.out.println("Nota inválida.");
                } else {
                    arrayNotas[i] = notaJurado;
                    contadorValido++;
                }
            }
        } while (contadorValido < JUECES);
        ordenarVector(arrayNotas); //Ordeno el vector con la función del ejercicio anterior

        System.out.println("La puntuación final es de: " + puntuacionFinal(arrayNotas, CD));

    }

    public static float puntuacionFinal(float _array[], float _CD) {
        float points;
        float suma = 0;

        //Las dos primeras posiciones y las dos últimas se eliminan.
        _array[0] = 0;
        _array[1] = 0;
        _array[JUECES - 1] = 0;
        _array[JUECES - 2] = 0;

        //Se suma el resto de puntuaciones
        for (int i = 0; i < _array.length; i++) {

            suma = suma + _array[i];
        }
        //Multiplicamos la suma por el CD
        points = suma * CD;

        return points;
    }

    public static void ordenarVector(float _array[]) {
        float aux; //VARIABLE AUXILIAR

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
}
