package puebavsc;
/*
        EJERCICIO:
        Realitza les següents funcions:

1. Funció per introduir dades en un vector (passarem el vector com a paràmetre i la posició on insertar).
        
2. Funció per ordenar un vector (passarem el vector com a paràmetre). 
Utilitzarem el mètode de la bombolla (heu d’implementar l’algorisme d’ordenació, 
no podeu utilitzar el mètode sort de la classe Collections o algun altre que realitzi aquesta tasca).
        
3. Funció per mostrar un vector (passarem el vector com a paràmetre). 

Crea dos arrays de diferents mides i executa les funcions que has creat, validant que funcionen correctament.
 */
/**
 *
 * @author Frank.Santos
 */
public class Funciones3Ejercicio1 {

    public static final int LENGTHMAX = 6;

    public static void main(String[] args) {
        int array1[] = new int[LENGTHMAX];
        int posicion=0;
        
        System.out.println("Introduzca posicion del array: ");
        posicion = Teclat.llegirInt();
        
        introducirDatosArray(array1, posicion);
    }

    public static void introducirDatosArray(int _array[], int _posicion) {
        int dato;
        System.out.println("Introduce un número: ");
        dato = Teclat.llegirInt();
        _array[_posicion] = dato;
    }
} 