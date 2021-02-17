package billetesbus;

/**
 *
 * @author Frank.Santos
 */
public class BilletesBus {

    public static void main(String[] args) {
        int plazasBus = 0;
        int opcionUser = 0;
        int plazasLibres = 0;
        int[] plazas = new int[]{0, 0, 0}; //Totales, Libres, Ocupadas.

        System.out.println("Cuantas plazas tiene el bus?");
        plazasBus = Teclat.llegirInt();
        plazas[0] = plazasBus;
        plazas[1] = plazasBus;

        do {
            opcionUser = menu();
            opcionesSwitch(opcionUser, plazasLibres, plazas);
        } while (opcionUser != 0);

    }

    public static int menu() {
        int opcionMenu;

        System.out.println("MENÚ");
        System.out.println("1. VENTA DE BILLETES");
        System.out.println("2. DEVOLUCIÓN DE BILLETES");
        System.out.println("3. ESTADO DE LA VENTA");
        System.out.println("0. SALIR.");
        System.out.println("Selecciona una opción.");
        opcionMenu = Teclat.llegirInt();

        return opcionMenu;
    }

    public static void opcionesSwitch(int _opcionUser, int _plazasLibres, int[] _array) {
        boolean venta = true;
        switch (_opcionUser) {
            case 1:
                venta = ventaBilletes(_plazasLibres, _array);
                if (venta == true) {
                    System.out.println("Venta realizada con éxito.");
                   
                } else {
                    System.out.println("La venta NO ha podido realizarse.");
                 
                }
                break;
            case 2:
                devolucionBillete(_array);
                break;
            case 3:
                estadoVenta(_array);
                break;
            case 0:
                break;
            default:
                System.out.println("Has marcado una opción errónea.");
        }
    }

    public static int calcularPlazasLibres(int[] _array, int _billete) {

        int plazasLibres = 0;

        if (_array[2] == _array[0]) {

            System.out.println("Están todas las plazas ocupadas!");
            plazasLibres = -1;
        } else if (_billete > _array[1]) {
            System.out.println("No hay tantas plazas libres!");
            plazasLibres = -1;
        } else {
            plazasLibres = _array[0] - _array[2];
        }
        return plazasLibres;
    }

    public static boolean ventaBilletes(int _plazasLibres, int[] _array) {
        int billete = 0;
        boolean venta = false;

        if (_array[2] == _array[0]) {
            System.out.println("Están todas las plazas ocupadas!");
        } else {
            do {
                System.out.println("Introduce cuántos billetes quieres comprar: ");
                billete = Teclat.llegirInt();
                if (billete < 0 || billete > _array[0]) {
                    System.out.println("Introduce una cantidad válida!");
                }
            } while (billete < 0 || billete > _array[0]);

            //QUEDAN PLAZAS LIBRES?
            _plazasLibres = calcularPlazasLibres(_array, billete);

            if (_plazasLibres != -1) {
                _array[2] = _array[2] + billete;
                _array[1] = _array[0] - _array[2];
                venta = true;
            } else {
                venta = false;
            }
        }
        return venta;
    }

    public static void estadoVenta(int[] _array) {

        System.out.println("Plazas totales: " + _array[0]);
        System.out.println("Plazas vendidas: " + _array[2]);
        System.out.println("Plazas libres: " + _array[1]);

    }

    public static int devolucionBillete(int[] _array) {
        int billete = 0;
        boolean check = false;

        if (_array[2] > 0) {
            check = true;
        }
        if (check == true) {
            do {
                System.out.println("Introduce el nº de billetes que quieres devolver:");
                billete = Teclat.llegirInt();

                if (billete < 0) {
                    System.out.println("Introduce una cantidad válida!");
                }
                if (billete == 0) {
                    System.out.println("No has introducido ningún billete a devolver.");
                }
                if (billete > _array[0] || billete > _array[2]) {
                    System.out.println("No existen tantas plazas a devolver!");
                    System.out.println("No se ha podido efectuar la devolución.");
                } else {
                    //SE HACE DEVOLUCIÓN
                    _array[1] = _array[1] + billete;
                    _array[2] = _array[2] - billete;
                    System.out.println("Devolución efectuada con éxito.");
                }
            } while (billete < 0);
        }else{
            System.out.println("No se ha efectuado ninguna venta todavía.");
        }
        return _array[1];
    }

}
