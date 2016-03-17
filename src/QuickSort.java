
import java.io.IOException;

public class QuickSort {

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

    public static void quicksort(int A[], int izq, int der) {

        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {            // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote
            }
            //leer(A);
            //System.out.println("");
            while (A[j] > pivote) {
                j--;         // busca elemento menor que pivote
            }
            //leer(A);
            //System.out.println("");

            if (i < j) {                      // si no se han cruzado                      
                aux = A[i];                  // los intercambia
                A[i] = A[j];
                A[j] = aux;
                //leer(A);
                //System.out.println("");
            }
        }
        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
            //leer(A);
            //System.out.println("");
        }

        if (j + 1 < der) {
            quicksort(A, j + 1, der); // ordenamos subarray derecho
            //leer(A);
            //System.out.println("");
        }
    }
    
    public static void quicksortL(char A[], int izq, int der) {

        char pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        char aux;

        while (i < j) {            // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote
            }
            //leer(A);
            //System.out.println("");
            while (A[j] > pivote) {
                j--;         // busca elemento menor que pivote
            }
            //leer(A);
            //System.out.println("");

            if (i < j) {                      // si no se han cruzado                      
                aux = A[i];                  // los intercambia
                A[i] = A[j];
                A[j] = aux;
                //leer(A);
                //System.out.println("");
            }
        }
        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            quicksortL(A, izq, j - 1); // ordenamos subarray izquierdo
            //leer(A);
            //System.out.println("");
        }

        if (j + 1 < der) {
            quicksortL(A, j + 1, der); // ordenamos subarray derecho
            //leer(A);
            //System.out.println("");
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
            quicksortL(v, 0, tam-1);

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

            quicksortL(vec, 0, tam-1);
            
            System.out.println("Serie Ordenada ");
            imprimirArregloLetters(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }
    }

    public static void quickSortNumbers() throws IOException {

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
            quicksort(v, 0, tamanio - 1);

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

            quicksort(vec, 0, tamanio - 1);

            System.out.println("Serie Ordenada ");
            imprimirArreglo(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }
    }

    public static void OrdenarSerie() throws IOException {

        if (CargarMenu.numeros) {
            quickSortNumbers();
        } else {
            quickSortLetters();
        }

    }

}
