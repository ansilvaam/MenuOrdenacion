
import java.io.IOException;

public class Mensajes {

    private int nseleccion;
    private String seleccion;
    private String numeros = "1) Ordenar numeros\n";
    private String letras = "2) Ordenar letras\n";
    private String bubble = "1  - Bubble\n";
    private String insertion = "2  - Insertion\n";
    private String bidirectionalBubble = "3  - Bidirectional Bubble\n";
    private String shellsort ="4  - Shell Sort\n";
    private String selectionSort = "5  - Selection Sort\n";
    private String heapsort = "6  - Heap Sort\n";
    private String mergesort = "7  - Merge Sort\n";
    private String quicksort = "8  - Quick Sort\n";
    private String quick3sort = "9  - Quick 3 Sort\n";
    private String radixsort = "10 - Radix Sort\n";
    private String introsort = "11 - Intro Sort\n";
    private String timsort = "12 - Tim Sort\n";
    private String genserie = "13 - Generar nueva Serie\n";
    private String salir = "14 - Salir\n";

    private String pantallaPrincipal;
    private String menu;

    public Mensajes(int nseleccion) {
        this.pantallaPrincipal = numeros + letras;
        this.menu = bubble + insertion + bidirectionalBubble + shellsort 
                + selectionSort  + heapsort + mergesort +quicksort +quick3sort
                + radixsort + introsort + timsort + genserie + salir;
        this.nseleccion = nseleccion;

        if (nseleccion == 1) {

            this.seleccion = bubble;
        }

        if (nseleccion == 2) {
            this.seleccion = insertion;
        }

        if (nseleccion == 3) {
            this.seleccion = bidirectionalBubble;
        }
        
        if (nseleccion == 4) {
            this.seleccion = shellsort;
        }
        
        if (nseleccion == 5) {
            this.seleccion = selectionSort;
        }
        
        if (nseleccion == 6) {

            this.seleccion = heapsort;
        }

        if (nseleccion == 7) {
            this.seleccion = mergesort;
        }

        if (nseleccion == 8) {
            this.seleccion = quicksort;
        }
        
        if (nseleccion == 9) {
            this.seleccion = quick3sort;
        }
        
        if (nseleccion == 10) {
            this.seleccion = radixsort;
        }
        
        if (nseleccion == 11) {

            this.seleccion = introsort;
        }

        if (nseleccion == 12) {
            this.seleccion = timsort;
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

    public String getPantallaPrincipal() {
        return pantallaPrincipal;
    }

    public void setPantallaPrincipal(String pantallaPrincipal) {
        this.pantallaPrincipal = pantallaPrincipal;
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
        else {
            System.out.println("Por favor, seleccione una opcion valida");
            Mensajes.cls();
            volverMenu();
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
