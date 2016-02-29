
import java.io.IOException;

public class Mensajes {

    private int nseleccion;
    private String seleccion;
    private String bubble = "1 - Bubble\n";
    private String insertion = "2 - Insertion\n";
    private String bidirectionalBubble = "3 - Bidirectional Bubble\n";
    private String genserie = "4 - Generar nueva Serie\n";
    private String salir = "5 - Salir\n";

    private String menu;

    public Mensajes(int nseleccion) {
        this.menu = bubble + insertion + bidirectionalBubble + genserie + salir;
        this.nseleccion = nseleccion;

        if (this.nseleccion == 1) {

            this.seleccion = bubble;
        }

        if (nseleccion == 2) {
            this.seleccion = insertion;
        }

        if (nseleccion == 3) {
            this.seleccion = bidirectionalBubble;
        }

    }

    public void setNseleccion(int nseleccion) {
        this.nseleccion = nseleccion;
    }

    public int getNseleccion() {
        return nseleccion;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

    public void setBidirectionalBubble(String bidirectionalBubble) {
        this.bidirectionalBubble = bidirectionalBubble;
    }

    public String getBidirectionalBubble() {
        return bidirectionalBubble;
    }

    public void setBubble(String bubble) {
        this.bubble = bubble;
    }

    public String getBubble() {
        return bubble;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public static void cls() {

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void volverMenu() throws IOException {

        System.out.println("\nRegresar al menu?\n 1 - SI\n 2 - NO");
        ObtenerSeleccion retmenu = new ObtenerSeleccion();
        if (retmenu.getSeleccion() == 1) {
            Mensajes.cls();
            CargarMenu.generarNuevaSerie = false;
            CargarMenu.menuSeleccion();
        } else if (retmenu.getSeleccion() == 2) {

            salirMenu();
        }

    }

    public static void salirMenu() {

        Mensajes.cls();
        System.out.println("\033[31mSaliendo.... Por favor espere");

        try {
            Thread.sleep(3000); //3 segundos
        } catch (Exception e) {

        }

        Mensajes.cls();
        System.out.println("\033[31mHa salido correctamente.");
    }
}
