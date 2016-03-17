
import java.util.Random;
import java.io.*;

public class QuickSort3 {

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

    static public void sortL(char arr[], int izquierda, int derecha) {
        int index = partitionL(arr, izquierda, derecha);
        if (izquierda < index - 1) {
            sortL(arr, izquierda, index - 1);
        }
        if (index < derecha) {
            sortL(arr, index, derecha);
        }
    }

    static public void sort(int arr[], int izquierda, int derecha) {
        int index = partition(arr, izquierda, derecha);
        if (izquierda < index - 1) {
            sort(arr, izquierda, index - 1);
        }
        if (index < derecha) {
            sort(arr, index, derecha);
        }
    }

    public static int partition(int arr[], int izquierda, int derecha) {
        int i = izquierda, j = derecha;
        int tmp;

        int pivot = arr[izquierda];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    public static int partitionL(char arr[], int izquierda, int derecha) {
        int i = izquierda, j = derecha;
        char tmp;

        int pivot = arr[izquierda];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    public static void quickSort3Numbers() throws IOException {

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
            sort(v, 0, tamanio - 1);

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

            sort(vec, 0, tamanio - 1);

            System.out.println("Serie Ordenada ");
            imprimirArreglo(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }
    }

    public static void quickSortLetters() throws IOException {
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
            sortL(v, 0, tam - 1);

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

            sortL(vec, 0, tam - 1);

            System.out.println("Serie Ordenada ");
            imprimirArregloLetters(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }

    }

    public static void OrdenarSerie() throws IOException {

        if (CargarMenu.numeros) {
            quickSort3Numbers();
        } else {
            quickSortLetters();
        }

    }

}
