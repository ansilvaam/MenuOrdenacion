
import java.io.IOException;

public class ShellSort {

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

    public static void shellSortL(char v[]) {

        //Este algoritmo de shellSort lo implemente de este link, por falta de tiempo no he elaborado aun el mio propio
        //ya que el algoritmo de clase tenia una falla que no logre identificar. 
        //https://elframeworkdeluis.wordpress.com/2009/11/07/metodo-de-ordenamiento-en-java-shellsort/
        for (int gap = v.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {

            for (int i = gap; i < v.length; i++) {
                comp++;
                char tmp = v[i];
                int j;

                for (j = i; j >= gap && tmp < v[j - gap]; j -= gap) {
                    v[j] = v[j - gap];
                    camb++;
                }
                v[j] = tmp;
            }
        }

        System.out.println("Serie Ordenada ");
        imprimirArregloLetters(v);
    }

    public static void shellSort(int v[]) {

        //Este algoritmo de shellSort lo implemente de este link, por falta de tiempo no he elaborado aun el mio propio
        //ya que el algoritmo de clase tenia una falla que no logre identificar. 
        //https://elframeworkdeluis.wordpress.com/2009/11/07/metodo-de-ordenamiento-en-java-shellsort/
        for (int gap = v.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {

            for (int i = gap; i < v.length; i++) {
                comp++;
                int tmp = v[i];
                int j;

                for (j = i; j >= gap && tmp < v[j - gap]; j -= gap) {
                    v[j] = v[j - gap];
                    camb++;
                }
                v[j] = tmp;
            }
        }

        System.out.println("Serie Ordenada ");
        imprimirArreglo(v);
    }

    public static void shellSortNumbers() throws IOException {

        comp = 0;
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

            shellSort(v);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        } else {

            int[] vec;
            vec = CargarMenu.cloneSerie.clone();

            System.out.println("Serie a Ordenar: ");
            imprimirArreglo(vec);

            int tam = CargarMenu.cloneSerie.length;

            shellSort(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }

    }

    public static void shellSortLetters() throws IOException {

        if (CargarMenu.generarNuevaSerie) {
            int tam = (int) (Math.random() * 20) + 1; //tam random hasta el 20
            char[] v = new char[tam];

            char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z'};
            
            
            for (int i = 0; i < v.length; i++) {

                v[i] = abecedario[(int) (Math.random() * 25)];
                System.out.print(v[i] + "  ");
            }

            CargarMenu.cloneSerieLetras = v.clone();

            shellSortL(v);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        } else {

            char[] vec;
            vec = CargarMenu.cloneSerieLetras.clone();

            System.out.println("Serie a Ordenar: ");
            imprimirArregloLetters(vec);

            int tam = CargarMenu.cloneSerieLetras.length;

            shellSortL(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }

    }

    public static void OrdenarSerie() throws IOException {

        if (CargarMenu.numeros) {

            shellSortNumbers();
        } else {

            shellSortLetters();
        }

    }
}
