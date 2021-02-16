package remakeuf1;

/**
 *
 * @author Frank.Santos
 */
public class RemakeUF1 {

    static final int LENGTHMAX = 12;

    public static void main(String[] args) {

        int opcion, comprobador, posicion, aux, aux2;
        float nota;
        String asignatura;

        String[] ASIGNATURAS = new String[LENGTHMAX];
        float[] NOTAS = new float[LENGTHMAX];

        do {
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
                    break;

                case 1:
                    comprobador = 0;
                    aux = 0;
                    aux2 = 0;

                    // COMPROBAMOS SI ESTÁ LLENO.
                    for (int i = 0; i < LENGTHMAX; i++) {
                        if (ASIGNATURAS[i] != null) {
                            comprobador++;
                        }
                    }
                    if (comprobador == LENGTHMAX) {
                        System.out.println("ERROR. Ya no se pueden guardar más asignaturas.");

                        // SI HAY ESPACIO, PREGUNTAMOS POSICION.
                    } else {
                        System.out.println("Introduzca posición: ");
                        posicion = Teclat.llegirInt();
                        if (posicion > LENGTHMAX || posicion < 0) {
                            System.out.println("Error. Las posiciones abarcan del 0 al " + (LENGTHMAX - 1));
                        } else {
                            // COMPROBAMOS QUE EN LA POSICION INDICADA NO HAY NADA
                            if (ASIGNATURAS[posicion] != null) {
                                aux++;
                            }
                            if (aux != 0) {
                                System.out.println("ERROR. En esta posición ya hay información guardada.");
                                // SI ESTÁ VACÍA, PREGUNTAMOS POR EL NOMBRE.
                            } else {
                                do {
                                    aux2=0;
                                    System.out.println("Introduzca nombre de la asignatura: ");
                                    asignatura = Teclat.llegirString();

                                    // COMPROBAMOS QUE EL NOMBRE NO ESTÉ EN USO
                                    for (int k = 0; k < LENGTHMAX; k++) {
                                        if (asignatura.equalsIgnoreCase(ASIGNATURAS[k])) {
                                            aux2++;
                                        }
                                    }
                                    if (aux2 != 0) {
                                        System.out.println("Ya existe una asignatura con este nombre."
                                                + " Modifique o elimine la anterior.");

                                        // NOMBRE LIBRE, PEDIMOS LA NOTA
                                    }
                                } while (aux2 != 0);
                                do {
                                    System.out.println("Introduzca la nota de la asignatura: ");
                                    nota = Teclat.llegirFloat();
                                    if (nota < 0 || nota > 10) {
                                        System.out.println("ERROR: La nota debe ser entre 0 y 10");

                                        // SI LA NOTA ES CORRECTA, GUARDAMOS
                                        // LOS DATOS EN LA POSICION.
                                    } else {
                                        NOTAS[posicion] = nota;
                                        ASIGNATURAS[posicion] = asignatura;
                                    }
                                } while (nota < 0 || nota > 10);
                            }
                        }
                    }
                    break;
                case 2:
                    aux = 0;
                    aux2 = 0;
                    System.out.println("Inserte el nombre de la asignatura a eliminar: ");
                    asignatura = Teclat.llegirString();
                    // COMPROBAMOS SI EXISTE ALGUNA ASIGNATURA CON ESE NOMBRE
                    // SI COINCIDE, GUARDAMOS LA POSICION.
                    for (int k = 0; k < LENGTHMAX; k++) {
                        if (asignatura.equalsIgnoreCase(ASIGNATURAS[k])) {
                            aux = k;
                            aux2++; // +1 SI HAY COINCIDENCIA
                        }
                    } // SI HAY COINCIDENCIA, PROCEDEMOS A ELIMINAR
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
                    // COMPROBAMOS SI HAY ALGO GUARDADO CON EL FOR.
                    // POR CADA NULO, SUMAMOS 1. SI AL FINAL TODO ES NULO, AVANZAMOS.
                    for (int k = 0; k < LENGTHMAX; k++) {
                        if (ASIGNATURAS[k] == null) {
                            aux++;
                        }
                    }
                    if (aux == LENGTHMAX) {// TODO NULO
                        System.out.println("No hay asignaturas guardadas para mostrar.");
                    } else {// EXISTE ALGO, MOSTRAMOS LO QUE EXISTA. LOS NULOS NO.
                        for (int j = 0; j < LENGTHMAX; j++) {
                            if (ASIGNATURAS[j] != null) {
                                System.out.println(ASIGNATURAS[j].toUpperCase() + " - " + "puntuación: " + NOTAS[j]);
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Introduce una opción correcta.");
            }
        } while (opcion
                != 0);
    }
}
