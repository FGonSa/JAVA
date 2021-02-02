package funciones3ejercicioanemia;

/**
 *
 * @author Frank.Santos
 */
public class Funciones3EjercicioAnemia {

    public static void main(String[] args) {
        int edad;
        char sexo;
        float maxHemo, minHemo, hemoglobinaPaciente;
        String anemia;

        System.out.println("Introduzca edad: ");
        edad = Teclat.llegirInt();

        System.out.println("Introduzca sexo (H/M): ");
        sexo = Teclat.llegirChar();
        sexo = Character.toLowerCase(sexo);

        System.out.println("Introduzca nivel de Hemoglobina (%): ");
        hemoglobinaPaciente = Teclat.llegirFloat();
        System.out.println("");
        //FUNCIONES
        maxHemo = nivelMaxHemoglobina(edad, sexo);
        minHemo = nivelMinHemoglobina(edad, sexo);
        anemia = anemia(maxHemo, minHemo, hemoglobinaPaciente);

        //RESULTADOS
        System.out.println("");
        System.out.println("- - - - - - - - - - - - ");
        System.out.println("R E S U L T A D O S");
        System.out.println("- - - - - - - - - - - - ");
        System.out.println("El nivel mínimo óptimo de hemoglobina para alguien de su edad y sexo es del " + minHemo + "%");
        System.out.println("El nivel máximo óptimo de hemoglobina para alguien de su edad y sexo es del " + maxHemo + "%");
        System.out.println("Teniendo en cuenta la información anterior, y los datos introducidos por el usuario, el sistema determina que el paciente:");

        System.out.println("");
        System.out.println("- - - - - - - - - - - - ");
        System.out.println(anemia);
        System.out.println("- - - - - - - - - - - - ");
    }

    public static float nivelMaxHemoglobina(int _edad, char _sexo) {
        float hemoglobina = 0;

        if (_edad <= 1) {
            hemoglobina = 15;
        } else if (_edad > 1 && _edad <= 15) {
            hemoglobina = 15.5f;
        } else if (_sexo == 'm' && _edad > 15) {
            hemoglobina = 16;
        } else if (_sexo == 'h' && _edad > 15) {
            hemoglobina = 18;
        }
        return hemoglobina;
    }

    public static float nivelMinHemoglobina(int _edad, char _sexo) {
        float hemoglobina = 0;

        if (_edad <= 1) {
            hemoglobina = 11;
        } else if (_edad > 1 && _edad <= 15) {
            hemoglobina = 11.5f;
        } else if (_sexo == 'm' && _edad > 15) {
            hemoglobina = 12;
        } else if (_sexo == 'h' && _edad > 15) {
            hemoglobina = 14;
        }
        return hemoglobina;
    }

    public static String anemia(float _maxHemo, float _minHemo, float _hemoPaciente) {
        String anemia = "No tiene anemia.";//valor por defecto

        //Comprobaciones. Si se cumple algúna condición, se modifica el valor por defecto.
        if ((_minHemo == 11 && _hemoPaciente < _minHemo) || (_maxHemo == 15 && _hemoPaciente > _maxHemo)) {
            anemia = "Tiene anemia.";
        } else if ((_minHemo == 11.5 && _hemoPaciente < _minHemo) || (_maxHemo == 15.5 && _hemoPaciente > _maxHemo)) {
            anemia = "Tiene anemia.";
        } else if ((_minHemo == 12 && _hemoPaciente < _minHemo) || (_maxHemo == 16 && _hemoPaciente > _maxHemo)) {
            anemia = "Tiene anemia.";
        } else if ((_minHemo == 14 && _hemoPaciente < _minHemo) || (_maxHemo == 18 && _hemoPaciente > _maxHemo)) {
            anemia = "Tiene anemia.";
        }
        return anemia;//Si no se cumple ninguna condicion, se devuelve el valor por defecto.
    }
}
