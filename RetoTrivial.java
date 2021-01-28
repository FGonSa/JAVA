/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retotrivial;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author Frank.Santos
 */
public class RetoTrivial {

    static final String ERROR = "Error. Debes introducir un valor adecuado.";
    static final String ACIERTO = "Correcto!";
    static final String FALLO = "Incorrecto!";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int numeroDePreguntas = 0;
        boolean finJuego = true, volverAjugar = true;
        char respuestaUsuario;
        int accAciertos = 0, accFallos = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        String[] preguntas = {"David Bowie era zurdo. ", "AC/DC se caracterizan por el simbolo de una llamarada.", "El lider de IRON MAIDEN queria ser futbolista originariamente. ", "La banda WASP es conocida por los albumes con su segundo vocalista. ", "SCORPIONS es una de las bandas americanas mas conocidas del mundo. ", "LED ZEPPELIN estaba compuesto por 5 miembros. ", "El lider de MEGADETH formo parte de METALLICA. ", "WHITESNAKE esta liderado por David Coverdale. ", "JUDAS PRIEST pusieron de moda la indumentaria de cuero. ", "HEROES DEL SILENCIO SON ORIGINARIOS DE MADRID. "};

        //Bucle Juego Entero
        while (finJuego) {
            volverAjugar = true; //
            System.out.println("Cuantas preguntas deseas responder? ");
            numeroDePreguntas = Teclat.llegirInt();

            //El juego va aqui dentro
            if (numeroDePreguntas >= 5) {
                for (int i = 0; i < numeroDePreguntas; i++) {
                    Random rand = new Random();
                    int posicionRandom = rand.nextInt(10);
                    String preguntaPrintada = preguntas[posicionRandom];
                    System.out.println(preguntaPrintada);//Pregunta Aleatoria aparece aqui
                    System.out.println("Verdadero (V) o Falso(F)?"); //se pregunta si es V o F
                    respuestaUsuario = Character.toUpperCase(Teclat.llegirChar()); //leemos el caracter y los transformamos a mayuscula
                    //Preguntas Verdaderas
                    if (preguntaPrintada.equals(preguntas[0]) || preguntaPrintada.equals(preguntas[2]) || preguntaPrintada.equals(preguntas[6]) || preguntaPrintada.equals(preguntas[7]) || preguntaPrintada.equals(preguntas[8])) {
                        if (respuestaUsuario == 'V') {
                            System.out.println(ACIERTO);
                            accAciertos = accAciertos + 10;
                        } else if (respuestaUsuario == 'F') {
                            System.out.println(FALLO);
                            accFallos = accFallos + 10;
                        } else {
                            System.out.println(ERROR);
                        }
                    }
                    //Preguntas Falsas
                    if (preguntaPrintada.equals(preguntas[1]) || preguntaPrintada.equals(preguntas[3]) || preguntaPrintada.equals(preguntas[4]) || preguntaPrintada.equals(preguntas[5]) || preguntaPrintada.equals(preguntas[9])) {
                        {
                            if (respuestaUsuario == 'F') {
                                System.out.println(ACIERTO);
                                accAciertos = accAciertos + 10;
                            } else if (respuestaUsuario == 'V') {
                                System.out.println(FALLO);
                                accFallos = accFallos + 10;
                            } else {
                                System.out.println(ERROR);
                            }
                        }
                    }
                }
                //La Puntuacion se muestra a partir de aqui
                float puntuacion = (accAciertos * 100 / numeroDePreguntas) / 10;
                System.out.println("Tu resultado es: " + df.format(puntuacion) + "% de aciertos. ");

                if (puntuacion <= 33) {
                    System.out.println("Eres rango bronce. Aun debes mejorar mucho para alcanzar la cima.");
                } else if (puntuacion <= 66 && puntuacion > 33) {
                    System.out.println("Eres rango plata. Intenta hacerlo mejor!");
                } else if (puntuacion > 66 && puntuacion < 99.99) {
                    System.out.println("Eres rango oro. Te falta poco para alcanzar la gloria!");
                } else if (puntuacion == 100) {
                    System.out.println("Wow! Has acertado todas las preguntas! Eres un Rock Master!!");
                }
                //Bucle para reiniciar o finalizar el juego
                while (volverAjugar) {
                    System.out.println("Quieres volver a jugar? S/N");
                    respuestaUsuario = Character.toUpperCase(Teclat.llegirChar());
                    if (respuestaUsuario == 'N') {
                        finJuego = false;
                        volverAjugar = false;
                    } else if (respuestaUsuario == 'S') {
                        finJuego = true;
                        volverAjugar = false;
                        accAciertos = 0;
                    } else {
                        System.out.println(ERROR);
                    }
                }
            } else {
                System.out.println("Debes responder un minimo de 5 preguntas!");
            }
        }
    }
}
/*MEJORAS QUE SE LE PUEDEN APLICAR:

*/
