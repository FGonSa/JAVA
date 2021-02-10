package probandostrings;

/**
 *
 * @author Frank.Santos
 */
public class StringLibrary {

    public static int manyTimesChar(String _messageUser, char _letter, int _length) {
        int manyTimes = 0;

        for (int i = 0; i < _length; i++) {
            if (_letter == _messageUser.charAt(i)) {
                manyTimes++;
            }
        }
        return manyTimes;

    }

    public static int CharFirstPosition(String _messageUser, char _letter, int _length) {
        int position = -1;
        int i = 0;

        do {
            if (_letter == _messageUser.charAt(i)) {
                position = i;
                return position;
            }
            i++;
        } while (i < _length);
        return position;
    }

    public static int CharLastPosition(String _messageUser, char _letter, int _length) {
        int position = -1;
        int i = 0;

        do {
            if (_letter == _messageUser.charAt(i)) {
                position = i;
                if (position < _messageUser.charAt(i)) {
                    position = i;
                }
            }
            i++;
        } while (i < _length);
        return position;
    }

    public static void CharPositions(String _messageUser, char _letter, int _length) {
        int position;
        int i = 0;
        int j = 0;
        int array[] = new int[_length];

        do {
            if (_letter == _messageUser.charAt(i)) {
                position = i;
                array[j] = i;
                j++;
            }
            i++;
        } while (i < _length);

        i = 0;
        System.out.print("La letra " + _letter + " aparece en las posiciones ");
        while (i < j) {
            System.out.print(array[i] + ", ");
            i++;
        }
    }

}
