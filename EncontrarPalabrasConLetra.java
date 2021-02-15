package pruebastrings;

/**
 *
 * @author Frank.Santos
 */
public class PruebaStrings {

    public static void main(String[] args) {
        String mensaje; //Mensaje Usuario
        char letra; //Letra Usuario
        int length = 0; //Longitud Vector
        String separador = " "; //Separador
        String mensajeMin; //Mensaje Usuario pasado a minus

        String frase[] = new String[length]; //Vector para guardar Mensaje User x palabras
        String fraseMin[] = new String[length]; //Vector para guardar MensajeMin User x palabras

        System.out.println("Introduce un mensaje: ");
        mensaje = Teclat.llegirString();
        mensajeMin = mensaje.toLowerCase();//Lo guardamos también en minúsculas.

        System.out.println("Introduce una letra:");
        letra = Teclat.llegirChar();
        letra = Character.toLowerCase(letra);//La pasamos a minúscula.

        frase = mensaje.split(separador);//Separo el mensaje x palabras
        fraseMin = mensajeMin.split(separador); //Separo el mensajeMin x palabras
        System.out.println("");
        System.out.println("Las palabras que contienen esta letra son: ");
        charAtWord(frase, fraseMin, letra);//Llamo a función
    }

    /**
     * Se reciben la letra introducida y los dos vectores, uno con la frase tal
     * cual introducida y otro con la frase reducida a minúsculas. Convertimos
     * el char recibido en String y comparamos. Cada posicion del vector será
     * una palabra. Si la palabra contiene la letra deseada, se imprime esa
     * posición del vector normal. Si se produce al menos una coincidencia, se
     * activa un booleano. Si no hay coincidencias, el booleano se mantiene
     * falso y se imprime el mensaje de que ninguna palabra contiene esa letra.
     *
     * @param _mensaje
     * @param _mensajeMin
     * @param _letra
     */
    private static void charAtWord(String[] _mensaje, String[] _mensajeMin, char _letra) {
        String s1;
        s1 = Character.toString(_letra); //Convertimos el char en String
        boolean b1 = false;

        for (int i = 0; i < _mensaje.length; i++) {
            if (_mensajeMin[i].contains(s1)) {
                System.out.println(_mensaje[i]);
                b1 = true;//Si hay coincidencia se activa este booleano.
            }
        }
        if (b1 == false) {//Si no hay ninguna palabra que contenga la letra aparece este mensaje
            System.out.println("NINGUNA.");
        }
    }
}
