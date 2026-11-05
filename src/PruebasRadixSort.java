
import java.util.Arrays;

/*
 * CLASE: PRUEBAS DE RADIX SORT

 * Esta clase permite comprobar que el algoritmo
 * Radix Sort ordena correctamente los números enteros no negativos de un arreglo.

 * Se realizarán cuatro pruebas:

 * 1. Aleatorio: números sin un orden específico.
 * 2. Ascendente: números ordenados de menor a mayor.
 * 3. Descendente: números ordenados de mayor a menor.
 * 4. Duplicados: números que aparecen varias veces.

 * Para realizar cada prueba se crean dos copias del mismo arreglo original.

 * La primera copia se ordena utilizando Radix Sort,
 * mientras que la segunda se ordena con Arrays.sort(), que pertenece a la biblioteca estándar de Java.
 */

public class PruebasRadixSort {

    /*
     * MÉTODO: ejecutarPruebas

     * Este método crea los cuatro arreglos y llama al método que realiza cada prueba.
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
        // Algunos valores aparecen varias veces.
        int[] duplicados = {10, 5, 10, 3, 5};

        // Ejecuta la prueba con el arreglo aleatorio.
        probarRadixSort("Aleatorio", aleatorio);

        // Ejecuta la prueba con el arreglo ascendente.
        probarRadixSort("Ascendente", ascendente);

        // Ejecuta la prueba con el arreglo descendente.
        probarRadixSort("Descendente", descendente);

        // Ejecuta la prueba con los números duplicados.
        probarRadixSort("Duplicados", duplicados);
    }

    /*
     * MÉTODO: probarRadixSort

     * Se reciben dos parámetros:

     * nombrePrueba: identifica el tipo de arreglo.
     * arreglo: contiene los números que vamos a ordenar.

     * Primero crea dos copias del arreglo original.

     * Después ordena una copia utilizando Radix Sort
     * y la otra mediante Arrays.sort().

     * Finalmente, compara ambos resultados
     * para verificar que el ordenamiento sea correcto.
     */

    public static void probarRadixSort(
            String nombrePrueba, int[] arreglo) {

        // Se crea una copia del arreglo original.
            // Esta copia será ordenada con Radix Sort.
                // Así conservamos los valores originales.
        int[] numeros = Arrays.copyOf(arreglo, arreglo.length);

        // Se crea otra copia con exactamente los mismos valores.
            // Esta se utilizará como referencia para verificar el resultado obtenido con nuestro algoritmo.
        int[] referencia = Arrays.copyOf(arreglo, arreglo.length);

        // Se llama al método ordenar de la clase RadixSort.
            // Este método modifica directamente el arreglo numeros.
        RadixSort.ordenar(numeros);

        // Se ordena la segunda copia utilizando Arrays.sort(),
            // método de la biblioteca estándar de Java.
        Arrays.sort(referencia);

        // Se compara ambos arreglos elemento por elemento.
            // Devuelve true si contienen los mismos valores
                // en las mismas posiciones y false si son diferentes.
        boolean correcto = Arrays.equals(numeros, referencia);

        // Muestra el nombre de la prueba realizada.
        System.out.println("\nPRUEBA: " + nombrePrueba);

        // Muestra los números antes del ordenamiento.
        System.out.println("Original: " + Arrays.toString(arreglo));

        // Muestra el resultado obtenido con Radix Sort.
        System.out.println("Radix Sort: " + Arrays.toString(numeros));

        // Muestra el resultado del método de referencia.
        System.out.println("Arrays.sort(): " + Arrays.toString(referencia));

        // Muestra si ambos resultados coinciden.
        // true indica que la prueba fue correcta.
        // false indica que existe alguna diferencia.
        System.out.println("¿Ordenamiento correcto?: " + correcto);
    }
}

