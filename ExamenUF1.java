/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenuf1;

import projecte.Teclat;

/**
 *
 * @author Frank.Santos
 */
public class ExamenUF1 {

    /**
     * @param args the command line arguments
     */
    static final String ERROR = "ERROR: Puntúe del 1 al 5";
    static final String[] PELICULAS = new String[4];
    static final int[] PUNTOS = new int[PELICULAS.length];

    public static void main(String[] args) {

        int opcion, puntuacion;
        int contadorCaso1 = 0, contadorCaso2, i = 0;
        String peli;
        int[] Comprobante = new int[PELICULAS.length];
        boolean menu = true;
        boolean repeat = true;

        while (menu) {
            System.out.println("MENÚ");
            System.out.println("1. GUARDAR PELÍCULA");
            System.out.println("2. MODIFICAR PUNTUACIÓN");
            System.out.println("3. MOSTRAR PELÍCULAS");
            System.out.println("0. SALIR.");
            System.out.println("");
            System.out.print("Escoja una opción: ");
            opcion = Teclat.llegirInt();

            switch (opcion) {
                case 0:
                    menu = false;
                    break;
                case 1:
                    if (contadorCaso1 >= PELICULAS.length) {
                        System.out.println("No se pueden añadir más películas.");
                        System.out.println("");
                    } else {
                        //AQUI ESTÁ EL FOLLÓN
                        System.out.print("Introduce película: ");
                        peli = Teclat.llegirString();
                        while (repeat) {
                            for (int k = 0; k < PELICULAS.length; k++) {
                                if (peli.equalsIgnoreCase(PELICULAS[k])) {
                                    System.out.println("Este título ya está registrado.");
                                    repeat = false;
                                } else {
                                    while (repeat) {
                                        PELICULAS[contadorCaso1] = peli;
                                        System.out.print("Introduce puntuación: ");
                                        puntuacion = Teclat.llegirInt();
                                        if (puntuacion < 1 || puntuacion > 5) {
                                            System.out.println(ERROR);
                                        } else {
                                            PUNTOS[contadorCaso1] = puntuacion;
                                            contadorCaso1++;
                                            System.out.println("");
                                            repeat = false;
                                        }
                                    }
                                }
                            }
                        }
                        repeat = true;
                    }
                    break;
                case 2:
                    contadorCaso2 = 0;
                    if (PELICULAS[0] == null) {
                        System.out.println("No hay ninguna película guardada.");
                    } else {
                        System.out.print("Introduzca el título de la película"
                                + " de la cual "
                                + "desea modificar su puntuación: ");
                        peli = Teclat.llegirString();
                        while (contadorCaso2 < PELICULAS.length) {
                            if (peli.equalsIgnoreCase(PELICULAS[contadorCaso2])) {
                                System.out.print("Introduce puntuación: ");
                                puntuacion = Teclat.llegirInt();
                                if (puntuacion < 1 || puntuacion > 5) {
                                    System.out.println(ERROR);
                                } else {
                                    PUNTOS[contadorCaso2] = puntuacion;
                                    contadorCaso2 = PELICULAS.length + 1;
                                }
                            } else {
                                if (PELICULAS[contadorCaso2] == null) {
                                    contadorCaso2 = PELICULAS.length + 1;
                                } else {
                                    System.out.println("El título no coincide con"
                                            + " ninguna película guardada. Pruebe a"
                                            + " escribir el título de nuevo.");
                                }
                                contadorCaso2 = PELICULAS.length + 1;
                            }
                        }
                    }
                    break;
                case 3:
                    if (PELICULAS[0] == null) {
                        System.out.println("No hay ninguna película guardada.");
                    } else {
                        for (int j = 0; j < PELICULAS.length; j++) {
                            if (PELICULAS[j] == null) {
                                System.out.print("");
                            } else {
                                System.out.println(PELICULAS[j].toUpperCase() + " - "
                                        + PUNTOS[j] + " ☆. ");
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Introduce una opción correcta.");
            }
        }
    }
}
