
import java.io.IOException;

public class CargarMenu {

    public static boolean generarNuevaSerie = true;
    public static int[] cloneSerie;
    public static char[] cloneSerieLetras;
    public static boolean letras = true, numeros = true;
    public static boolean happyflag = true;

    public static void menuSeleccion() throws IOException {

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
            }

        }

        System.out.println(imprimirMenu.getMenu());
        ObtenerSeleccion menu = new ObtenerSeleccion();

        Mensajes indicarSel = new Mensajes(menu.getSeleccion());

        if (menu.getSeleccion() == 1) {

            Mensajes.cls();
            System.out.println("Usted ha seleccionado: " + indicarSel.getSeleccion());
            Bubble.OrdenarSerie();

        } else if (menu.getSeleccion() == 2) {

            Mensajes.cls();
            System.out.println("Usted ha seleccionado: " + indicarSel.getSeleccion());
            Insertion.OrdenarSerie();

        } else if (menu.getSeleccion() == 3) {

            Mensajes.cls();
            System.out.println("Usted ha seleccionado: " + indicarSel.getSeleccion());
            BidirectionalBubble.ordenarSerie();

        } else if (menu.getSeleccion() == 4) {

            Mensajes.cls();
            System.out.println("Usted ha seleccionado: " + indicarSel.getSeleccion());
            ShellSort.OrdenarSerie();

        } else if (menu.getSeleccion() == 5) {
            
           Mensajes.cls();
           System.out.println("Usted ha seleccionado: "+indicarSel.getSeleccion());
           SelectionSort.ordenarSerie();
            
        } else if (menu.getSeleccion() == 6) {

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
            System.out.println("\033[34m* Se ha generado correctamente una nueva serie.\n");
            menuSeleccion();
        } else {

            Mensajes.salirMenu();
        }
    }
}
