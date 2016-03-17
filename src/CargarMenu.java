
import java.io.IOException;

public class CargarMenu {

    public static boolean generarNuevaSerie = true;
    public static int[] cloneSerie;
    public static char[] cloneSerieLetras;
    public static boolean letras = true, numeros = true;
    public static boolean happyflag = true;

    public static void menuSeleccion() throws IOException {

        System.out.println("\033[34mUn menu, con los distintos algoritmos "
                + "de ordenamiento\n"
                + "\033[34mvistos en clase del Dr. Ivan - "
                + "\033[32mUniversidad Cuauhtémoc (UCQ)\n");
        Mensajes imprimirMenu = new Mensajes(1);

        if (happyflag) {

            System.out.println(imprimirMenu.getPantallaPrincipal());
            ObtenerSeleccion pantallaPrincipal = new ObtenerSeleccion();
            Mensajes.cls();

            if (pantallaPrincipal.getSeleccion() == 1) {
                happyflag = false;
                letras = false;
                numeros = true;
            } else if (pantallaPrincipal.getSeleccion() == 2) {
                happyflag = false;
                numeros = false;
                letras = true;
            } else {
                System.out.println("\033[31m*Vaya, parece que has ingresado una "
                        + "opcion invalida, \n\"\033[31mPor favor vuelve a intentarlo.\n");
                menuSeleccion();
            }

        }

        System.out.println(imprimirMenu.getMenu());
        ObtenerSeleccion menu = new ObtenerSeleccion();

        Mensajes indicarSel = new Mensajes(menu.getSeleccion());

        Mensajes.cls();
        if (menu.getSeleccion() == 1) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());
            Bubble.OrdenarSerie();

        } else if (menu.getSeleccion() == 2) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());
            Insertion.OrdenarSerie();

        } else if (menu.getSeleccion() == 3) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());
            BidirectionalBubble.ordenarSerie();

        } else if (menu.getSeleccion() == 4) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());

            ShellSort.OrdenarSerie();

        } else if (menu.getSeleccion() == 5) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());
            SelectionSort.ordenarSerie();

        } else if (menu.getSeleccion() == 6) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());
            HeapSort.OrdenarSerie();

        } else if (menu.getSeleccion() == 7) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());
            MergeSort.OrdenarSerie();

        } else if (menu.getSeleccion() == 8) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());
            QuickSort.OrdenarSerie();

        } else if (menu.getSeleccion() == 9) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());
            QuickSort3.OrdenarSerie();

        } else if (menu.getSeleccion() == 10) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());

        } else if (menu.getSeleccion() == 11) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());

        } else if (menu.getSeleccion() == 12) {

            System.out.println("Usted ha seleccionado: "
                    + indicarSel.getSeleccion());

        } else if (menu.getSeleccion() == 13) {

            Mensajes.cls();

            System.out.print("\033[34mGenerando.. ");

            for (int i = 0; i <= 100; i = i + 10) {

                try {
                    Thread.sleep(300); //0.5 segundos
                } catch (Exception e) {

                }

                System.out.print("\033[34m[" + i + "%] ");

            }

            try {
                Thread.sleep(1000); //5 segundos
            } catch (Exception e) {

            }

            generarNuevaSerie = true;
            Mensajes.cls();
            System.out.println("\033[32m* Se ha generado correctamente "
                    + "una nueva serie.\n");
            menuSeleccion();
        } else if (menu.getSeleccion() == 14) {

            Mensajes.salirMenu();

        } else {

        }
    }
}
