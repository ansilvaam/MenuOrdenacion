
import java.io.IOException;

public class Bubble {

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

    public static void bubbleLetters() throws IOException {

        int tam = (int) (Math.random() * 20) + 1; //tam random hasta el 20
        char aux;
        int comp = 0;
        int camb = 0;
        char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o','p','q','r','s','t','u','v','x','y','z'};
        char[] v = new char[tam];

        System.out.println("Serie a Ordenar: ");

        if (CargarMenu.generarNuevaSerie) {

            for (int i = 0; i < v.length; i++) {

                v[i] = abecedario[(int) (Math.random() * 25)];
                System.out.print(v[i] + "  ");
            }

            CargarMenu.cloneSerieLetras = v.clone();

            for (int i = 0; i < tam; i++) {

                for (int j = 0; j < (tam - (i + 1)); j++) {
                    comp++;

                    if (v[j] > v[j + 1]) {
                        camb++;
                        aux = v[j];
                        v[j] = v[j + 1];
                        v[j + 1] = aux;
                    }
                }
            }
            System.out.println("\nSerie Ordenada: ");
            imprimirArregloLetters(v);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);

            Mensajes.volverMenu();

        } else {
            imprimirArregloLetters(CargarMenu.cloneSerieLetras);

            //temporal vector
            char[] vec;
            vec = CargarMenu.cloneSerieLetras.clone();

            for (int i = 0; i < vec.length; i++) {

                for (int j = 0; j < (vec.length - (i + 1)); j++) {
                    comp++;

                    if (vec[j] > vec[j + 1]) {
                        camb++;
                        aux = vec[j];
                        vec[j] = vec[j + 1];
                        vec[j + 1] = aux;
                    }
                }
            }

            System.out.println("\nSerie Ordenada: ");
            imprimirArregloLetters(vec);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);

            Mensajes.volverMenu();
        }

    }

    public static void bubbleNumbers() throws IOException {

        int tam = (int) (Math.random() * 15) + 1; //tam random hasta el 15
        int aux;
        int comp = 0;
        int camb = 0;
        int[] v = new int[tam];

        System.out.println("Serie a Ordenar: ");
        if (CargarMenu.generarNuevaSerie) {
            for (int i = 0; i < v.length; i++) {
                v[i] = (int) (Math.random() * 200) + 1; //rnd 200
                System.out.print(v[i] + " ");
            }

            CargarMenu.cloneSerie = v.clone();

            for (int i = 0; i < tam; i++) {

                for (int j = 0; j < (tam - (i + 1)); j++) {
                    comp++;

                    if (v[j] > v[j + 1]) {
                        camb++;
                        aux = v[j];
                        v[j] = v[j + 1];
                        v[j + 1] = aux;
                    }
                }
            }
            System.out.println("\nSerie Ordenada: ");
            imprimirArreglo(v);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);

            Mensajes.volverMenu();

        } else {
            imprimirArreglo(CargarMenu.cloneSerie);

            //temporal vector
            int[] vec;
            vec = CargarMenu.cloneSerie.clone();

            for (int i = 0; i < vec.length; i++) {

                for (int j = 0; j < (vec.length - (i + 1)); j++) {
                    comp++;

                    if (vec[j] > vec[j + 1]) {
                        camb++;
                        aux = vec[j];
                        vec[j] = vec[j + 1];
                        vec[j + 1] = aux;
                    }
                }
            }

            System.out.println("\nSerie Ordenada: ");
            imprimirArreglo(vec);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);

            Mensajes.volverMenu();
        }

    }

    public static void OrdenarSerie() throws IOException {

        if (CargarMenu.numeros) {

            bubbleNumbers();
        } else {

            bubbleLetters();
        }

    }

}
