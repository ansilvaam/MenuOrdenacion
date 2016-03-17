
import java.io.IOException;

public class RadixSort {

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

    public static void radixSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }
            np[i][1] = -1;
            for (i = 0; i < q.length; i++) {
                q[i] = -1;
            }
            for (f = i = 0; i < arr.length; i++) {
                j = ((0xFF << (k << 3)) & arr[i]) >> (k << 3);
                if (q[j] == -1) {
                    l = q[j] = f;
                } else {
                    l = q[j];
                    while (np[l][1] != -1) {
                        l = np[l][1];
                    }
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = arr[i];
                np[l][1] = -1;
            }
            for (l = q[i = j = 0]; i < 0x100; i++) {
                for (l = q[i]; l != -1; l = np[l][1]) {
                    arr[j++] = np[l][0];
                }
            }
        }
    }

    public static void radixSortL(char[] arr) {
        if (arr.length == 0) {
            return;
        }
        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }
            np[i][1] = -1;
            for (i = 0; i < q.length; i++) {
                q[i] = -1;
            }
            for (f = i = 0; i < arr.length; i++) {
                j = ((0xFF << (k << 3)) & arr[i]) >> (k << 3);
                if (q[j] == -1) {
                    l = q[j] = f;
                } else {
                    l = q[j];
                    while (np[l][1] != -1) {
                        l = np[l][1];
                    }
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = arr[i];
                np[l][1] = -1;
            }
            for (l = q[i = j = 0]; i < 0x100; i++) {
                for (l = q[i]; l != -1; l = np[l][1]) {
                    arr[j++] = (char) np[l][0];
                }
            }
        }
    }

    public static void radixSortNumbers() throws IOException {
        if (CargarMenu.generarNuevaSerie) {
            int tam = 10;
            int[] v = new int[tam];

            for (int i = 0; i < v.length; i++) {
                v[i] = (int) (Math.random() * 200) + 1; //rnd 200
            }

            System.out.println("Serie a Ordenar: ");
            imprimirArreglo(v);
            CargarMenu.cloneSerie = v.clone();

            int tamanio = v.length;
            radixSort(v);

            System.out.println("Serie Ordenada ");
            imprimirArreglo(v);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();

        } else {

            int[] vec;
            vec = CargarMenu.cloneSerie.clone();

            System.out.println("Serie a Ordenar: ");
            imprimirArreglo(vec);

            int tamanio = CargarMenu.cloneSerie.length;

            radixSort(vec);

            System.out.println("Serie Ordenada ");
            imprimirArreglo(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }
    }

    public static void radixSortLetters() throws IOException {

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
            radixSortL(v);

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

            radixSortL(vec);

            System.out.println("Serie Ordenada ");
            imprimirArregloLetters(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }
    }

    public static void OrdenarSerie() throws IOException {

        if (CargarMenu.numeros) {
            radixSortNumbers();
        } else {
            radixSortLetters();

        }

    }
}
