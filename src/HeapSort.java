
import java.io.IOException;

public class HeapSort {

    private static int[] a;
    private static char[] aL;
    private static int n;
    private static int izquierda;
    private static int derecha;
    private static int largo;
    private static int comp = 0;
    private static int camb = 0;

    public static void imprimirArregloLetters(char arreglo[]) {

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static void imprimirArreglo(int arreglo[]) {

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }

        System.out.println();
    }

    public static void hacerHeap(int[] a) {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxHeap(a, i);
        }
    }

    public static void hacerHeapL(char[] a) {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxHeapL(a, i);
        }
    }

    public static void maxHeapL(char[] a, int i) {
        izquierda = 2 * i;
        derecha = 2 * i + 1;
        if (izquierda <= n && a[izquierda] > a[i]) {
            largo = izquierda;
        } else {
            largo = i;
        }

        if (derecha <= n && a[derecha] > a[largo]) {
            largo = derecha;
        }
        if (largo != i) {
            cambioL(i, largo);
            maxHeapL(a, largo);
        }
    }

    public static void maxHeap(int[] a, int i) {
        izquierda = 2 * i;
        derecha = 2 * i + 1;
        if (izquierda <= n && a[izquierda] > a[i]) {
            largo = izquierda;
        } else {
            largo = i;
        }

        if (derecha <= n && a[derecha] > a[largo]) {
            largo = derecha;
        }
        if (largo != i) {
            cambio(i, largo);
            maxHeap(a, largo);
        }
    }

    public static void cambio(int i, int j) {
        camb++;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void cambioL(int i, int j) {
        camb++;
        char t = aL[i];
        aL[i] = aL[j];
        aL[j] = t;
    }

    public static void ordenar(int[] a0) {
        a = a0;
        hacerHeap(a);

        for (int i = n; i > 0; i--) {
            cambio(0, i);
            n = n - 1;
            maxHeap(a, 0);
        }
    }

    public static void ordenarL(char[] a0) {
        aL = a0;
        hacerHeapL(aL);

        for (int i = n; i > 0; i--) {
            cambioL(0, i);
            n = n - 1;
            maxHeapL(aL, 0);
        }
    }

    public static void heapSortNumbers() throws IOException {

        camb = 0;

        if (CargarMenu.generarNuevaSerie) {
            int tam = 10;
            int[] v = new int[tam];

            for (int i = 0; i < v.length; i++) {
                v[i] = (int) (Math.random() * 200) + 1; //rnd 200
            }

            System.out.println("Serie a Ordenar: ");
            imprimirArreglo(v);
            CargarMenu.cloneSerie = v.clone();
            ordenar(v);

            System.out.println("Serie Ordenada ");
            imprimirArreglo(v);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();

        } else {

            int[] vec;
            vec = CargarMenu.cloneSerie.clone();

            System.out.println("Serie a Ordenar: ");
            imprimirArreglo(vec);

            ordenar(vec);

            System.out.println("Serie Ordenada ");
            imprimirArreglo(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }
    }

    public static void heapSortLetters() throws IOException {

        camb = 0;

        if (CargarMenu.generarNuevaSerie) {
            int tam = (int) (Math.random() * 20) + 1; //tam random hasta el 20
            char[] v = new char[tam];

            char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z'};

            for (int i = 0; i < v.length; i++) {

                v[i] = abecedario[(int) (Math.random() * 25)];
            }

            CargarMenu.cloneSerieLetras = v.clone();

            System.out.println("Serie a Ordenar: ");
            imprimirArregloLetters(v);
            ordenarL(v);

            System.out.println("Serie Ordenada ");
            imprimirArregloLetters(v);
            
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();

        } else {

            char[] vec;
            vec = CargarMenu.cloneSerieLetras.clone();

            System.out.println("Serie a Ordenar: ");
            imprimirArregloLetters(vec);

            int tam = CargarMenu.cloneSerieLetras.length;

            ordenarL(vec);
            
            System.out.println("Serie Ordenada ");
            imprimirArregloLetters(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }
    }

    public static void OrdenarSerie() throws IOException {

        if (CargarMenu.numeros) {

            heapSortNumbers();
        } else {
            heapSortLetters();
        }

    }
}
