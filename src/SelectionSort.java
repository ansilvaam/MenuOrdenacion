
import java.io.IOException;

public class SelectionSort {

    public static void imprimirArregloLetters(char v[]) {

        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public static void imprimirArreglo(int v[]) {

        System.out.println();

        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }

        System.out.println();
    }

    public static void selectionSortLetters() throws IOException {

        int tam = (int) (Math.random() * 20) + 1; //tam random hasta el 20
        int comp = 0;
        int camb = 0;
        char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z'};
        char[] v = new char[tam];

        if (CargarMenu.generarNuevaSerie) {

            for (int i = 0; i < v.length; i++) {

                v[i] = abecedario[(int) (Math.random() * 25)];
                System.out.print(v[i] + "  ");
            }

            CargarMenu.cloneSerieLetras = v.clone();

            char minimo, aux;
            int nminimo;
            //Algoritmo de Ordenacion por Seleccion
            for (int i = 0; i < v.length; i++) {
                minimo = v[i];
                nminimo = i;
                for (int j = i; j < v.length - 1; j++) {

                    comp++;
                    if (minimo > v[j + 1]) {

                        camb++;
                        //imprimirArreglo(v);
                        minimo = v[j + 1];
                        nminimo = j + 1;
                    }
                }
                aux = v[i];
                v[i] = v[nminimo];
                v[nminimo] = aux;
            }

            System.out.println("\nSerie Ordenada: ");
            imprimirArregloLetters(v);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);
            
            Mensajes.volverMenu();
        } else {
            
            //temporal vector
            char[] vec;
            vec = CargarMenu.cloneSerieLetras.clone();
            
            imprimirArregloLetters(CargarMenu.cloneSerieLetras);
            
            //Algoritmo de Ordenacion por Seleccion
            
            char minimo, aux;
            int nminimo;
            
            for (int i = 0; i < vec.length; i++) {
                minimo = vec[i];
                nminimo = i;
                for (int j = i; j < vec.length - 1; j++) {

                    comp++;
                    if (minimo > vec[j + 1]) {

                        camb++;
                        //imprimirArreglo(v);
                        minimo = vec[j + 1];
                        nminimo = j + 1;
                    }
                }
                aux = vec[i];
                vec[i] = vec[nminimo];
                vec[nminimo] = aux;
            }            
            
            System.out.println("\nSerie Ordenada: ");
            imprimirArregloLetters(vec);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);

            Mensajes.volverMenu();
        }
    }

    public static void selectionsortNumbers() throws IOException {

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

            int minimo, nminimo, aux;

            //Algoritmo de Ordenacion por Seleccion
            for (int i = 0; i < v.length; i++) {
                minimo = v[i];
                nminimo = i;
                for (int j = i; j < v.length - 1; j++) {

                    comp++;
                    if (minimo > v[j + 1]) {

                        camb++;
                        //imprimirArreglo(v);
                        minimo = v[j + 1];
                        nminimo = j + 1;
                    }
                }
                aux = v[i];
                v[i] = v[nminimo];
                v[nminimo] = aux;
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
            
            //Algoritmo de Ordenacion por Seleccion
             int minimo, nminimo, aux;
            for (int i = 0; i < vec.length; i++) {
                minimo = vec[i];
                nminimo = i;
                for (int j = i; j < vec.length - 1; j++) {

                    comp++;
                    if (minimo > vec[j + 1]) {

                        camb++;
                        //imprimirArreglo(v);
                        minimo = vec[j + 1];
                        nminimo = j + 1;
                    }
                }
                aux = vec[i];
                vec[i] = vec[nminimo];
                vec[nminimo] = aux;
            }
            
            System.out.println("\nSerie Ordenada: ");
            imprimirArreglo(vec);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);

            Mensajes.volverMenu();

        }
    }

    public static void ordenarSerie() throws IOException {

        if (CargarMenu.numeros) {

            selectionsortNumbers();
        } else {
            
            selectionSortLetters();

        }
    }

}
