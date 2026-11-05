
import java.util.Arrays;

/*
 * CLASE: PRUEBAS DE QUICK SORT

 * Esta clase permite verificar que el algoritmo
 *  Quick Sort ordena correctamente los números de un arreglo de menor a mayor.

 * Para comprobar su funcionamiento se realizarán
 * cuatro pruebas con diferentes tipos de entrada:

 * 1. Aleatorio: números sin un orden específico.
 * 2. Ascendente: números ordenados de menor a mayor.
 * 3. Descendente: números ordenados de mayor a menor.
 * 4. Duplicados: números que aparecen varias veces.

 * En cada prueba se crearán dos copias del arreglo.

 * La primera copia se ordenará utilizando Quick Sort,  que selecciona siempre el último elemento como pivote.

 * La segunda copia se ordenará mediante Arrays.sort(), que pertenece a la biblioteca estándar de Java.

 * Finalmente, se compararán ambos resultados. Si los arreglos son iguales, la prueba mostrará true.
  */

public class PruebasQuickSort {

    /*
     * MÉTODO: ejecutarPruebas

     * Se encarga de crear los cuatro arreglos y ejecutar sus respectivas pruebas.
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
        // Algunos valores aparecen más de una vez.
        int[] duplicados = {10, 5, 10, 3, 5};

        // Ejecuta la prueba con el arreglo aleatorio.
        probarQuickSort("Aleatorio", aleatorio);

        // Ejecuta la prueba con el arreglo ascendente.
        probarQuickSort("Ascendente", ascendente);

        // Ejecuta la prueba con el arreglo descendente.
        probarQuickSort("Descendente", descendente);

        // Ejecuta la prueba con los números duplicados.
        probarQuickSort("Duplicados", duplicados);
    }

    /*
     * MÉTODO: probarQuickSort

     * Recibe dos parámetros:

     * nombrePrueba: identifica el tipo de arreglo.
     * arreglo: contiene los números que vamos a ordenar.

     * Primero crea dos copias del arreglo original.

     * Después ordena una copia utilizando Quick Sort
     * y la otra mediante Arrays.sort().

     * Por último, compara ambos resultados y muestra si el algoritmo ordenó correctamente.
     */

    public static void probarQuickSort(
            String nombrePrueba, int[] arreglo) {

        // Crea una copia del arreglo original.
        // Esta copia será ordenada con Quick Sort.
        // Así se conservan los valores originales.
        int[] numeros = Arrays.copyOf(arreglo, arreglo.length);

        // Se crea otra copia con exactamente los mismos valores.
        // Esta se utilizará como referencia para verificar el resultado del algoritmo.
        int[] referencia = Arrays.copyOf(arreglo, arreglo.length);

        // Se llama al método ordenar de la clase QuickSort.
            // Este método modifica directamente el arreglo numeros.
        QuickSort.ordenar(numeros);

        // Ordena la segunda copia utilizando Arrays.sort(),
            // método de la biblioteca estándar de Java.
        Arrays.sort(referencia);

        // Compara ambos arreglos elemento por elemento.
            // Devuelve true si contienen los mismos valores en las mismas posiciones y false si son diferentes.
        boolean correcto = Arrays.equals(numeros, referencia);

        // Muestra el nombre de la prueba realizada.
        System.out.println("\nPRUEBA: " + nombrePrueba);

        // Muestra los números antes de ordenarlos.
        System.out.println("Original: " + Arrays.toString(arreglo));

        // Muestra el resultado obtenido con Quick Sort.
        System.out.println("Quick Sort: " + Arrays.toString(numeros));

        // Muestra el resultado del método de referencia.
        System.out.println("Arrays.sort(): " + Arrays.toString(referencia));

        // Muestra si ambos resultados coinciden.
        // true indica que la prueba fue correcta.
        // false indica que existe alguna diferencia.
        System.out.println("¿Ordenamiento correcto?: "
                + correcto);
    }
}

