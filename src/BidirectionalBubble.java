
import java.io.IOException;

public class BidirectionalBubble {

    public static void imprimirArreglo(int arreglo[]) {

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }

        System.out.println();
    }

    public static void ordenarSerie() throws IOException {

        //Mensajes.cls();
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

            boolean banderitafeliz;

            int comprobaciones = 0;
            do {
                banderitafeliz = false;

                //primero recorro los valores 
                for (int i = 0; i <= v.length - 2; i++) {

                    comp++;
                    if (v[i] > v[i + 1]) {

                        camb++;
                        int temp = v[i];
                        v[i] = v[i + 1];
                        v[i + 1] = temp;
                        banderitafeliz = true;
                    }
                }
                if (!banderitafeliz) { //Sentencia if para optimizacion del codigo

                    break;
                }
                banderitafeliz = false;

                for (int i = v.length - 2; i >= 0; i--) {

                    comp++;
                    if (v[i] > v[i + 1]) {
                        camb++;
                        int temp = v[i];
                        v[i] = v[i + 1];
                        v[i + 1] = temp;
                        banderitafeliz = true;
                    }
                }

            } while (banderitafeliz); //si mi bandera no se prende salimos

            System.out.println("\nSerie Ordenada: ");
            imprimirArreglo(v);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);

            Mensajes.volverMenu();
        } else {

            imprimirArreglo(CargarMenu.cloneSerie);

            //temporal vector
            int[] vec;
            vec = CargarMenu.cloneSerie.clone();

            boolean banderitafeliz;

            int comprobaciones = 0;
            do {
                banderitafeliz = false;

                //primero recorro los valores 
                for (int i = 0; i <= vec.length - 2; i++) {

                    comp++;
                    if (vec[i] > vec[i + 1]) {

                        camb++;
                        int temp = vec[i];
                        vec[i] = vec[i + 1];
                        vec[i + 1] = temp;
                        banderitafeliz = true;
                    }
                }
                if (!banderitafeliz) { //Sentencia if para optimizacion del codigo

                    break;
                }
                banderitafeliz = false;

                for (int i = vec.length - 2; i >= 0; i--) {

                    comp++;
                    if (vec[i] > vec[i + 1]) {
                        camb++;
                        int temp = vec[i];
                        vec[i] = vec[i + 1];
                        vec[i + 1] = temp;
                        banderitafeliz = true;
                    }
                }

            } while (banderitafeliz);

            System.out.println("\nSerie Ordenada: ");
            imprimirArreglo(vec);
            System.out.println("\nNumero Comprobaciones: " + comp + "\nCambios hechos: " + camb);

            Mensajes.volverMenu();

        }
    }

}
