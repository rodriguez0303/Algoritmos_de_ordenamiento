package Pruebas_Algoritmos;

import Algoritmos.InsertionSort;

import java.util.Arrays;

/*
 * CLASE: PRUEBAS DE INSERTION SORT

 * Esta clase permite verificar que el algoritmo
 * Insertion Sort ordena correctamente los elementos de un arreglo de números enteros.

 * Para comprobar su funcionamiento se realizarán cuatro pruebas con diferentes tipos de entrada:

 * 1. Aleatorio: números sin un orden establecido.
 * 2. Ascendente: números ordenados de menor a mayor.
 * 3. Descendente: números ordenados de mayor a menor.
 * 4. Duplicados: números que aparecen varias veces.

 * En cada prueba se utilizarán dos copias del mismo arreglo para garantizar que ambos métodos reciban
 * exactamente los mismos valores.

 * La primera copia se ordenará con Insertion Sort, mientras que la segunda utilizará Arrays.sort(),
 * que pertenece a la biblioteca estándar de Java.

 * Finalmente, se compararán ambos resultados.  Si los arreglos son iguales, la prueba mostrará true.

 */

public class PruebasInsertionSort {

    /*
     * MÉTODO: ejecutarPruebas
     * Este método se encarga de crear los cuatro arreglos y ejecutar sus respectivas pruebas.
     */
    public static void ejecutarPruebas() {

        // PRUEBA 1: ARREGLO ALEATORIO.
        // Contiene números que no siguen un orden específico.
        int[] aleatorio = {64, 25, 12, 22, 11};

        // PRUEBA 2: ARREGLO ASCENDENTE.
        // Los números ya se encuentran ordenados de menor a mayor.
        int[] ascendente = {10, 20, 30, 40, 50};

        // PRUEBA 3: ARREGLO DESCENDENTE.
        // Los números están organizados de mayor a menor.
        int[] descendente = {50, 40, 30, 20, 10};

        // PRUEBA 4: ARREGLO CON DUPLICADOS.
        // Algunos valores aparecen más de una vez.
        int[] duplicados = {10, 5, 10, 3, 5};

        // Ejecuta la prueba con los números aleatorios.
        probarInsertionSort("Aleatorio", aleatorio);

        // Ejecuta la prueba con el arreglo ascendente.
        probarInsertionSort("Ascendente", ascendente);

        // Ejecuta la prueba con el arreglo descendente.
        probarInsertionSort("Descendente", descendente);

        // Ejecuta la prueba con los números duplicados.
        probarInsertionSort("Duplicados", duplicados);
    }

    /*
     * MÉTODO: probarInsertionSort

     * Este método recibe dos parámetros:

     * nombrePrueba: nombre del tipo de entrada.
     * arreglo: conjunto de números que vamos a ordenar.

     * Primero se crea dos copias del arreglo original.

     * Después ordena una copia utilizando Insertion Sort y la otra mediante Arrays.sort().

     * Por último, compara ambos resultados y muestra  en consola si el ordenamiento fue correcto.
     */
    public static void probarInsertionSort(
            String nombrePrueba, int[] arreglo) {

        // Se crea una copia del arreglo original.
            // Esta copia será ordenada con Insertion Sort.
                // El arreglo recibido permanece sin modificaciones.
        int[] numeros = Arrays.copyOf(arreglo, arreglo.length);

        // Se Crea una segunda copia con los mismos valores.
            // Esta se utilizará como referencia para comprobar que nuestro algoritmo ordena correctamente.
        int[] referencia = Arrays.copyOf(
                arreglo, arreglo.length);

        // Llama al método ordenar de la clase Algoritmos.InsertionSort.
            // Este método modifica directamente el arreglo numeros.
        InsertionSort.ordenar(numeros);

        // Ordena la segunda copia utilizando Arrays.sort(),
            // método que pertenece a la biblioteca estándar de Java.
        Arrays.sort(referencia);

        // Compara los dos arreglos elemento por elemento.
            // Arrays.equals devuelve true si ambos contienen
                // los mismos valores en las mismas posiciones. Si encuentra alguna diferencia, devuelve false.
        boolean correcto = Arrays.equals(numeros, referencia);

        // Muestra el nombre de la prueba que se está ejecutando.
        System.out.println("\nPRUEBA: " + nombrePrueba);

        // Muestra los números originales antes de ordenarlos.
        System.out.println("Original: " + Arrays.toString(arreglo));

        // Muestra el resultado obtenido con Insertion Sort.
        System.out.println("Insertion Sort: " + Arrays.toString(numeros));

        // Muestra el resultado obtenido con Arrays.sort().
        System.out.println("Arrays.sort(): " + Arrays.toString(referencia));

        // Indica si ambos resultados coinciden.
            // true significa que el ordenamiento fue correcto.
                // false indica que los resultados son diferentes.
        System.out.println("¿Ordenamiento correcto?: " + correcto);
    }
}
