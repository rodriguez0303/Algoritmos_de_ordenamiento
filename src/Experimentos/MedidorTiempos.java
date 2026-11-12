
package Experimentos;

import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Clase: MedidorTiempos

 * Esta clase permite medir el tiempo que tarda
 * un algoritmo en ordenar un arreglo.

 * Para cada medición:

 * 1. Se realiza una ejecución inicial que no se registra.
 * 2. Se ejecuta el algoritmo cinco veces.
 * 3. Se registra el tiempo de cada ejecución.
 * 4. Se ordenan los cinco tiempos obtenidos.
 * 5. Se calcula la mediana de los tiempos.
 *
 * El tiempo se mide utilizando System.nanoTime().

 */

public class MedidorTiempos {

    /*
     * Método: medirTiempo

     * Recibe el arreglo original y el algoritmo que se desea evaluar.

     * Devuelve la mediana de cinco mediciones
     * expresadas en milisegundos.
     */

    public static double medirTiempo(int[] arregloOriginal,
                                     Consumer<int[]> algoritmo) {

        // Se crea una copia del arreglo original para realizar
            // la primera ejecución sin modificar los datos originales.
        int[] arregloInicial = arregloOriginal.clone();

        // Se ejecuta el algoritmo una primera vez.// Esta ejecución no se registra
        algoritmo.accept(arregloInicial);

        // Crea un arreglo para guardar los cinco tiempos medidos.
        long[] tiempos = new long[5];

        // Se repite la medición cinco veces.
        for (int i = 0; i < tiempos.length; i++) {

            // Se Crea una nueva copia del arreglo original.
                // De esta manera, todas las ejecuciones reciben
                    // los mismos números y en el mismo orden.
            int[] arregloCopia = arregloOriginal.clone();

            // Se registra el tiempo justo antes de ordenar.
            long tiempoInicio = System.nanoTime();

            // Se ejecuta el algoritmo de ordenamiento.
            algoritmo.accept(arregloCopia);

            // Se registra el tiempo justo después de ordenar.
            long tiempoFinal = System.nanoTime();

            // Se calcula cuánto tardó el algoritmo y guarda
            // el resultado en nanosegundos.
            tiempos[i] = tiempoFinal - tiempoInicio;
        }

        // Se muestra los cinco tiempos individuales antes de ordenarlos.
        System.out.println("Tiempos registrados en cada repetición:");

        for (int i = 0; i < tiempos.length; i++) {

            // Convierte el tiempo de nanosegundos a milisegundos.
            double tiempoMilisegundos = tiempos[i] / 1000000.0;

            // Muestra el número de repetición y su tiempo correspondiente.
            System.out.printf("Repetición %d: %.4f ms%n",
                    i + 1, tiempoMilisegundos);
        }

        // Se ordenan los cinco tiempos de menor a mayor.
        Arrays.sort(tiempos);

        // Se obtiene el tiempo que queda en la posición central.
            // Como se tienen cinco mediciones, la mediana
                // se encuentra en la posición 2.
        long mediana = tiempos[2];

        // Se convierte los nanosegundos a milisegundos.
        double medianaMilisegundos = mediana / 1000000.0;

        // Se devuelve la mediana expresada en milisegundos.
        return medianaMilisegundos;
    }
}

