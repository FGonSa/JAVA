package remakedam;

/**
 *
 * @author Frank.Santos
 */
public class RemakeDAM {

    static final int LENGTHMAX = 10;

    public static void main(String[] args) {
        int opcion = 0;
        String[] movies = new String[LENGTHMAX];
        int[] score = new int[LENGTHMAX];
        boolean check, added = false;
        int position = 0;

        do {
            System.out.println("MENÚ");
            System.out.println("1. GUARDAR PELÍCULA");
            System.out.println("2. MODIFICAR PUNTUACIÓN");
            System.out.println("3. MOSTRAR PELÍCULAS");
            System.out.println("0. SALIR.");
            System.out.println("");
            System.out.print("Escoja una opción: ");
            opcion = Teclat.llegirInt();

            switch (opcion) {
                case 1:
                    check = checkVector(movies, LENGTHMAX);
                    if (check == false) {
                        position = position(LENGTHMAX, movies);
                        added = inputMovie(LENGTHMAX, movies, score, position);
                    }
                    break;
                case 2:
                    if (added == false) {
                        System.out.println("No hay ninguna película registrada.");
                    } else {
                        changeScore(LENGTHMAX, movies, score);
                    }
                    break;
                case 3:
                    if (added == false) {
                        System.out.println("No hay ninguna película registrada.");
                    } else {
                        showArray(LENGTHMAX, movies, score);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduce una opción correcta.");
            }
        } while (opcion != 0);

    }

    public static void showArray(int _length, String[] _movie, int[] _score) {
        for (int i = 0; i < _length; i++) {
            if (_movie[i] != null) {
                System.out.println(_movie[i].toUpperCase() + " - " + _score[i] + " ☆. ");
            }
        }
    }

    public static boolean checkVector(String[] _array, int _length) {
        int aux = 0;
        boolean check = false;
        for (int i = 0; i < _length; i++) {
            if (_array[i] != null) {
                aux++;
            }
        }
        if (aux == _length) {
            System.out.println("¡No se pueden introducir más peliculas!");
            return check = true;
        }
        return check;
    }

    public static boolean inputMovie(int _length, String[] _movie, int[] _score, int _position) {
        int i = _position;
        boolean exit = false;
        boolean added = true;
        do {
            if (_movie[i] == null) {
                _movie[i] = inputName(_length, _movie, _score);
                _score[i] = inputScore();
                exit = true;
            }
        } while (exit = false);
        return added = true;
    }

    public static String inputName(int _length, String[] _movie, int[] _score) {

        String title;
        int aux;

        do {
            aux = 0;
            System.out.println("Introduce un título: ");
            title = Teclat.llegirString();

            //ESTÁ EN USO?
            for (int i = 0; i < _length; i++) {
                if (title.equalsIgnoreCase(_movie[i])) {
                    aux++;
                }
            }
            if (aux != 0) {
                System.out.println("El título ya está registrado!");
            }
        } while (aux != 0);
        return title;
    }

    public static int inputScore() {
        int score = 0;
        int maxScore = 5;
        int minScore = 1;

        do {
            System.out.println("Introduzca una puntuación del " + minScore + " al " + maxScore + ": ");
            score = Teclat.llegirInt();
            if (score > maxScore || score < minScore) {
                System.out.println("ERROR! La puntuación no respeta los límites establecidos.");
            }
        } while (score > maxScore || score < minScore);
        return score;
    }

    public static int position(int _length, String[] _movie) {
        int position = 0;
        for (int i = 0; i < _length; i++) {
            if (_movie[i] == null) {
                position = i;
            }
        }
        return position;
    }

    public static void changeScore(int _length, String[] _movies, int[] _score) {

        int aux = 0;
        String title;
        boolean match = false;
        int score = 0;
        System.out.println("Introduce el título de película:");
        title = Teclat.llegirString();
        int i = 0, j = 0;

        do {
            if (title.equalsIgnoreCase(_movies[j])) {
                match = true;
                i = j;
            }
            j++;
        } while (j < _length || match == false);
        if (match = true) {
            score = inputScore();
            _score[i] = score;
        } else {
            System.out.println("No existe ninguna película con ese título.");
        }
    }
}
