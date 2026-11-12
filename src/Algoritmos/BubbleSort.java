package Algoritmos;
/*
 * ALGORITMO: BUBBLE SORT (ORDENAMIENTO BURBUJA)

 * Este algoritmo permite ordenar los números de un arreglo de menor a mayor.

 * Su funcionamiento consiste en comparar dos elementos consecutivos del arreglo.

 * Si el primer elemento es mayor que el segundo, ambos valores intercambian sus posiciones.

 * El procedimiento se repite hasta que todos los elementos quedan ordenados.

 * Para realizar el ordenamiento utiliza dos ciclos for:

 * 1. El primer ciclo controla la cantidad de pasadas.
 *
 * 2. El segundo ciclo compara los elementos consecutivos y realiza los intercambios.
 */

public class BubbleSort {

    // Método que recibe un arreglo de números enteros y los ordena de menor a mayor.
    public static void ordenar(int[] arreglo) {

        // Este primer ciclo controla las pasadas necesarias para ordenar los elementos.
        // La variable i indica cuántas pasadas se han realizado.
        for (int i = 0; i < arreglo.length - 1; i++) {

            // Este segundo ciclo recorre los elementos que todavía necesitan compararse.
            for (int j = 0; j < arreglo.length - 1 - i; j++) {

                // Se compara dos elementos consecutivos.
                    // Si el primero es mayor que el segundo, significa que están en el orden incorrecto.
                if (arreglo[j] > arreglo[j + 1]) {

                    // Se guarda temporalmente el primer valor para evitar perderlo durante el intercambio.
                    int temporal = arreglo[j];

                    // Se coloca el segundo valor en la posición que ocupaba el primero.
                    arreglo[j] = arreglo[j + 1];

                    // Se coloca el primer valor en la posición que ocupaba el segundo.
                    arreglo[j + 1] = temporal;
                }
            }

            // Al finalizar cada pasada, el número mayor de la parte pendiente queda en su posición
            // definitiva al final del arreglo.
        }

        // Al finalizar todas las pasadas, el arreglo queda ordenado de menor a mayor.
    }
}
