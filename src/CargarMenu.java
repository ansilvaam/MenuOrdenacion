
import java.io.IOException;

public class CargarMenu {

    public static boolean generarNuevaSerie = true;
    public static int[] cloneSerie;

    public static void menuSeleccion() throws IOException {

        Mensajes imprimirMenu = new Mensajes(1);
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
            
            System.out.print("\033[34mGenerando.. ");

            for (int i = 0; i <= 100; i = i + 10) {

                try {
                    Thread.sleep(500); //0.5 segundos
                } catch (Exception e) {

                }
                
                System.out.print("\033[34m["+i+"%] ");

            }

            try {
                Thread.sleep(5000); //5 segundos
            } catch (Exception e) {

            }

            generarNuevaSerie = true;
            Mensajes.cls();
            System.out.println("\033[34m* Se ha generado correctamente una nueva serie.\n");
            menuSeleccion();
        }
        else {
            
            Mensajes.salirMenu();
        }
    }
}
