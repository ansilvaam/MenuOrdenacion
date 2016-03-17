
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ObtenerSeleccion {
    
    private int seleccion;
    
    public ObtenerSeleccion() throws IOException {
        
        this.seleccion = (int) pedirDatos();
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public int getSeleccion() {
        return seleccion;
    }
    
    public static boolean isNumeric(String str) { 
        try { 
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true; 
    }

    public static double pedirDatos() throws IOException { // metodo con resultado para pedir datos.

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nPor favor seleccione una opcion: ");

        String isnumero = leer.readLine();
        boolean esNumero = isNumeric(isnumero); //mi metodo is numeric me regresa un true o un false

        if (!esNumero) { //loe evaluo si es falso y entra al if es porque se ingresaron letras
            Mensajes.cls();
            System.out.println("\033[31m*No puedes ingresar letras.");
            return pedirDatos();
        }

        double n = Double.parseDouble(isnumero);

        if (!(n % 1 == 0)) {
            Mensajes.cls();
            System.out.println("\033[31m*No puedes ingresar numero decimales.");
            return pedirDatos();
        }

        if (n < 1 || n > 14) { //limite del menu de ordenamiento
            Mensajes.cls();
            System.out.println("\033[31m*Ingresa los datos como se especifica.");

            return pedirDatos();

        } else {

            return n;
        }
    }
    
}
