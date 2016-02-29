
import java.io.IOException;

public class Insertion {

    public static void imprimirArreglo(int arreglo[]) {

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }

        System.out.println();
    }

    public static void OrdenarSerie() throws IOException {
        
        //Mensajes.cls();

        int tam = (int) (Math.random() * 15) + 1; //tam random hasta el 15
        int comp = 0;
        int camb = 0;
        int[] v = new int[tam];

        if (CargarMenu.generarNuevaSerie) {

            System.out.println("Serie a Ordenar: ");
            for (int i = 0; i < v.length; i++) { //llenamos el vec
                v[i] = (int) (Math.random() * 200) + 1;
                System.out.print(v[i] + " ");
            }
            CargarMenu.cloneSerie = v.clone(); //clonamos el vector generado

            // Algoritmo de ordenacion por insercion
            final int N = v.length;
            for (int i = 1; i < N; i++) {
                comp++;
                int j = i;
                while (j > 0 && v[j] < v[j - 1]) {
                    camb++;
                    int tmp = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = tmp;
                    j--;
                }
            }

            System.out.println("\nSerie Ordenada: ");
            imprimirArreglo(v);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);

            Mensajes.volverMenu();

        } else {
            
            System.out.println("Serie a Ordenar: ");
            imprimirArreglo(CargarMenu.cloneSerie);
            
            //temporal vector
            int[] vec;
            vec = CargarMenu.cloneSerie.clone();
            
             // Algoritmo de ordenacion por insercion
            final int N = vec.length;
            for (int i = 1; i < N; i++) {
                comp++;
                int j = i;
                while (j > 0 && vec[j] < vec[j - 1]) {
                    camb++;
                    int tmp = vec[j];
                    vec[j] = vec[j - 1];
                    vec[j - 1] = tmp;
                    j--;
                }
            }
            
            System.out.println("\nSerie Ordenada: ");
            imprimirArreglo(vec);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            
            Mensajes.volverMenu();

        }
    }
}
