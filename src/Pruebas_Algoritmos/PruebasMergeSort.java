package Pruebas_Algoritmos;

import Algoritmos.MergeSort;

import java.util.Arrays;

/*
 * CLASE: PRUEBAS DE MERGE SORT

 * Esta clase permite comprobar que el algoritmo
 * Merge Sort ordena correctamente los números de un arreglo de menor a mayor.

 * Se realizarán cuatro pruebas:

 * 1. Aleatorio: números sin un orden específico.
 * 2. Ascendente: números ordenados de menor a mayor.
 * 3. Descendente: números ordenados de mayor a menor.
 * 4. Duplicados: números que aparecen varias veces.

 * Para cada prueba se crean dos copias del arreglo.

 * La primera copia se ordena utilizando Merge Sort,
 * mientras que la segunda se ordena con Arrays.sort(), que pertenece a la biblioteca estándar de Java.

 * Finalmente, se comparan ambos arreglos.
 * Si los resultados coinciden, se muestra true.

 */

public class PruebasMergeSort {

    /*
     * MÉTODO: ejecutarPruebas
     * Se encarga de crear los cuatro arreglos y llamar al método que realiza cada prueba.
     */
    public static void ejecutarPruebas() {

        // PRUEBA 1: ARREGLO ALEATORIO.
        // Contiene números sin un orden específico.
        int[] aleatorio = {64, 25, 12, 22, 11};

        // PRUEBA 2: ARREGLO ASCENDENTE.
        // Los números ya están ordenados de menor a mayor.
        int[] ascendente = {10, 20, 30, 40, 50};

        // PRUEBA 3: ARREGLO DESCENDENTE.
        // Los números están ordenados de mayor a menor.
        int[] descendente = {50, 40, 30, 20, 10};

        // PRUEBA 4: ARREGLO CON DUPLICADOS.
        // Algunos valores se repiten dentro del arreglo.
        int[] duplicados = {10, 5, 10, 3, 5};

        // Ejecuta la prueba con el arreglo aleatorio.
        probarMergeSort("Aleatorio", aleatorio);

        // Ejecuta la prueba con el arreglo ascendente.
        probarMergeSort("Ascendente", ascendente);

        // Ejecuta la prueba con el arreglo descendente.
        probarMergeSort("Descendente", descendente);

        // Ejecuta la prueba con el arreglo de duplicados.
        probarMergeSort("Duplicados", duplicados);
    }

    /*
     * MÉTODO: probarMergeSort
     *
     * Recibe dos parámetros:
     *
     * nombrePrueba: identifica el tipo de arreglo.
     * arreglo: contiene los números que se van a ordenar.
     *
     * Primero crea dos copias del arreglo original.
     *
     * Después ordena una copia utilizando Merge Sort
     * y la otra mediante Arrays.sort().
     *
     * Finalmente, compara ambos resultados y muestra
     * si el algoritmo realizó correctamente el ordenamiento.
     */
    public static void probarMergeSort(
            String nombrePrueba, int[] arreglo) {

        // Se crea una copia del arreglo original.
         // Esta copia será ordenada utilizando Merge Sort.
            // De esta forma no se modifica el arreglo recibido.
        int[] numeros = Arrays.copyOf(
                arreglo, arreglo.length);

        // Se crea otra copia con exactamente los mismos valores.
            // Esta se utilizará como referencia para comprobar
                // el resultado de nuestro algoritmo.
        int[] referencia = Arrays.copyOf(
                arreglo, arreglo.length);

        // Se llama al método ordenar de la clase Algoritmos.MergeSort.
            // Este método modifica directamente el arreglo numeros.
        MergeSort.ordenar(numeros);

        // Se ordena la segunda copia utilizando Arrays.sort(),
            // que pertenece a la biblioteca estándar de Java.
        Arrays.sort(referencia);

        // Se compara ambos arreglos elemento por elemento.
            // Devuelve true si tienen los mismos valores en las mismas posiciones y false si son diferentes.
        boolean correcto = Arrays.equals(
                numeros, referencia);

        // Muestra el nombre de la prueba realizada.
        System.out.println("\nPRUEBA: " + nombrePrueba);

        // Muestra los valores antes del ordenamiento.
        System.out.println("Original: " + Arrays.toString(arreglo));

        // Muestra el resultado obtenido con Merge Sort.
        System.out.println("Merge Sort: " + Arrays.toString(numeros));

        // Muestra el resultado del método de referencia.
        System.out.println("Arrays.sort(): " + Arrays.toString(referencia));

        // Muestra true significa que la prueba fue correcta.
        // Muestra false indica que existe alguna diferencia.
        System.out.println("¿Ordenamiento correcto?: " + correcto);
    }
}
