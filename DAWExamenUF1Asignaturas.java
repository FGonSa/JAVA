/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenuf1asignaturas;

/**
 *
 * @author Frank.Santos
 */
public class ExamenUF1Asignaturas {

    /**
     * @param args the command line arguments
     */
    static final String[] ASIGNATURAS = new String[12];
    static final float[] NOTAS = new float[ASIGNATURAS.length];

    public static void main(String[] args) {

        boolean menu = true;
        int opcion, comprobador, posicion, aux, aux2;
        float nota;
        String asignatura;

        while (menu) {
            System.out.println("MENÚ");
            System.out.println("1. GUARDAR ASIGNATURA");
            System.out.println("2. ELIMINAR ASIGNATURA");
            System.out.println("3. MOSTRAR ASIGNATURA");
            System.out.println("0. SALIR.");
            System.out.println("");
            System.out.print("Escoja una opción: ");
            opcion = Teclat.llegirInt();

            switch (opcion) {
                case 0:
                    menu = false;
                    break;

                case 1:
                    comprobador = 0;
                    aux = 0;
                    aux2 = 0;

                    //COMPROBAMOS SI ESTÁ LLENO.
                    for (int i = 0; i < ASIGNATURAS.length; i++) {
                        if (ASIGNATURAS[i] != null) {
                            comprobador++;
                        }
                    }
                    if (comprobador == ASIGNATURAS.length) {
                        System.out.println("ERROR. Ya no se pueden guardar más asignaturas.");
                        
                        //SI HAY ESPACIO, PREGUNTAMOS POSICION.
                    } else {
                        System.out.println("Introduzca posición: ");
                        posicion = Teclat.llegirInt();
                        if (posicion > ASIGNATURAS.length) {
                            System.out.println("Error. Las posiciones abarcan del 0 al " + (ASIGNATURAS.length - 1));
                        } else {
                            //COMPROBAMOS QUE EN LA POSICION INDICADA NO HAY NADA
                            if (ASIGNATURAS[posicion] != null) {
                                aux++;
                            }
                            if (aux != 0) {
                                System.out.println("ERROR. En esta posición ya hay información guardada.");
                                //SI ESTÁ VACÍA, PREGUNTAMOS POR EL NOMBRE.
                            } else {
                                System.out.println("Introduzca nombre de la asignatura: ");
                                asignatura = Teclat.llegirString();

                                //COMPROBAMOS QUE EL NOMBRE NO ESTÉ EN USO
                                for (int k = 0; k < ASIGNATURAS.length; k++) {
                                    if (asignatura.equalsIgnoreCase(ASIGNATURAS[k])) {
                                        aux2++;
                                    }
                                }
                                if (aux2 != 0) {
                                    System.out.println("Ya existe una asignatura con este nombre."
                                            + " Modifique o elimine la anterior.");
                                    
                                    //NOMBRE LIBRE, PEDIMOS LA NOTA
                                } else {
                                    System.out.println("Introduzca la nota de la asignatura: ");
                                    nota = Teclat.llegirFloat();
                                    if (nota < 0 || nota > 10) {
                                        System.out.println("ERROR: La nota debe ser entre 0 y 10");
                                        
                                        //SI LA NOTA ES CORRECTA, GUARDAMOS
                                        //LOS DATOS EN LA POSICION.
                                    } else {
                                        NOTAS[posicion] = nota;
                                        ASIGNATURAS[posicion] = asignatura;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    aux = 0;
                    aux2 = 0;
                    System.out.println("Inserte el nombre de la asignatura a eliminar: ");
                    asignatura = Teclat.llegirString();
                    //COMPROBAMOS SI EXISTE ALGUNA ASIGNATURA CON ESE NOMBRE
                    //SI COINCIDE, GUARDAMOS LA POSICION.
                    for (int k = 0; k < ASIGNATURAS.length; k++) {
                        if (asignatura.equalsIgnoreCase(ASIGNATURAS[k])) {
                            aux = k;
                            aux2++; //+1 SI HAY COINCIDENCIA
                        }
                    } //SI HAY COINCIDENCIA, PROCEDEMOS A ELIMINAR
                    // UTILIZANDO LA POSICION QUE HABIAMOS GUARDADO.
                    // SEÑALAMOS AL ARRAY QUE VAYA A ESA POSICION Y ELIMINE.
                    if (aux2 != 0) {
                        ASIGNATURAS[aux] = null;
                        NOTAS[aux] = 0;
                        System.out.println("Asignatura eliminada.");
                    } else {
                        System.out.println("La asignatura no coincide con ninguna asignatura guardada.");
                    }
                    break;
                case 3:
                    aux = 0;
                    //COMPROBAMOS SI HAY ALGO GUARDADO CON EL FOR.
                    //POR CADA NULO, SUMAMOS 1. SI AL FINAL TODO ES NULO, AVANZAMOS.
                    for (int k = 0; k < ASIGNATURAS.length; k++) {
                        if (ASIGNATURAS[k] == null) {
                            aux++;
                        }
                    }
                    if (aux == ASIGNATURAS.length) {//TODO NULO
                        System.out.println("No hay asignaturas guardadas para mostrar.");
                    } else {//EXISTE ALGO, MOSTRAMOS LO QUE EXISTA. LOS NULOS NO.
                        for (int j = 0; j < ASIGNATURAS.length; j++) {
                            if (ASIGNATURAS[j] == null) {
                                System.out.print("");
                            } else {
                                System.out.println(ASIGNATURAS[j].toUpperCase() + " - "
                                        + "puntuación: " + NOTAS[j]);
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
