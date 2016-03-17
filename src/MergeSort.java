
import java.io.IOException;

public class MergeSort {

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

    public static void mergesort(int A[], int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(A, izq, m);
            mergesort(A, m + 1, der);
            merge(A, izq, m, der);
        }
    }

    public static void merge(int A[], int izq, int m, int der) {
        int i, j, k;
        int[] B = new int[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }
    }

    public static void mergeL(char A[], int izq, int m, int der) {
        int i, j, k;
        char[] B = new char[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }
    }

    public static void mergeSortNumbers() throws IOException {

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
            mergesort(v, 0, tam - 1);

            System.out.println("Serie Ordenada ");
            imprimirArreglo(v);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();

        } else {
            
            int[] vec;
            vec = CargarMenu.cloneSerie.clone();

            System.out.println("Serie a Ordenar: ");
            imprimirArreglo(vec);

            int tam = CargarMenu.cloneSerie.length;

            mergesort(vec, 0, tam-1);
            
            System.out.println("Serie Ordenada ");
            imprimirArreglo(vec);

            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            Mensajes.volverMenu();
        }
    }

    public static void mergeSortLetters() {
        
        
    }

    public static void OrdenarSerie() throws IOException {

        if (CargarMenu.numeros) {
            mergeSortNumbers();
        } else {
            mergeSortLetters();
        }

    }

}
