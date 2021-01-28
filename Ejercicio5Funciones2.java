package ejercicio5funciones2;

/**
 *
 * @author Frank.Santos
 */
public class Ejercicio5Funciones2 {

    /*Guardo las temperaturas de los meses en un array, y el nombre en otro.
    Los guardo en la public class porque así me sirven de variables globales.*/
    static final float TEMPERATURAS[] = {9.8f, 10.7f, 12.5f, 14.6f, 17.7f,
        21.4f, 24.1f, 23.8f, 21.7f, 17.6f, 13.4f, 10.7f, 0};
    static final String MESES[] = {"Enero", "Febrero", "Marzo", "Abril",
        "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
        "Diciembre", null};

    public static void main(String[] args) {
        int resultado; //Variable que utilizaré para guardar el return de la función.

        resultado = calculosTemp(TEMPERATURAS, MESES); //Llamamos a la función.
        if (resultado > 5) { // Si el return vale más que 5 aparece el mensaje.
            System.out.println("\nWINTER IS COMING!!");
        }
    }

    public static int calculosTemp(float _arrayTemp[], String _arrayMeses[]) {

        float contadorMinus = 0; //Temperatura más fría
        float contadorPlus = 0; //Temperatura más cálida
        String hot = null; //Mes +caluroso
        String cold = null;//Mes +frío
        float contador = 0; // Variable para ir contando
        int winter = 0; //Contador de meses +fríos que la media

        //BUCLE PARA AVERIGUAR EL MES Y LA TEMPERATURA +CALUROSOS
        for (int i = 0; i < _arrayTemp.length - 1; i++) {
            if (contador < _arrayTemp[i]) {
                contador = _arrayTemp[i];
                contadorPlus = contador;
                hot = _arrayMeses[i];
            }
        }
        //BUCLE PARA AVERIGUAR EL MES Y LA TEMPERATURA +FRÍOS
        for (int i = 0; i < _arrayTemp.length - 1; i++) {
            if (_arrayTemp[i] < contador) {
                contador = _arrayTemp[i];
                contadorMinus = contador;
                cold = _arrayMeses[i];
            }
        }

        contador = 0;//reiniciamos el contador
        //BUCLE PARA OBTENER LA SUMA DE TODAS LAS TEMPERATURAS
        for (int i = 0; i < _arrayTemp.length - 1; i++) {
            contador = contador + _arrayTemp[i];
        }
        //GUARDAMOS EL RESULTADO EN LA ÚLTIMA POSICIÓN DEL ARRAY 
        _arrayTemp[12] = contador / 12; //Temperatura Media de todo el año

        //MOSTRAMOS DATOS RECOGIDOS EN LA FUNCIÓN
        System.out.println("El mes más caluroso es: " + hot + " con " + contadorPlus + "º");
        System.out.println("El mes más frío es: " + cold + " con " + contadorMinus + "º");
        System.out.println("La temperatura media del año es de " + _arrayTemp[12] + "º");

        //BUCLE PARA AVERIGUAR CUANTOS MESES SON INFERIORES A LA MEDIA
        for (int i = 0; i < _arrayTemp.length; i++) {
            if (_arrayTemp[i] < _arrayTemp[12]) {
                winter++;
            }
        }
        return winter;//La funcion devuelve cuantos meses hay +fríos que la media
    }
}
