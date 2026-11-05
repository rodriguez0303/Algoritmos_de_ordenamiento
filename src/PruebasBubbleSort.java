
import java.util.Arrays;

/*
 * CLASE: PRUEBAS DE BUBBLE SORT

 * Esta clase permite comprobar que el algoritmo Bubble Sort ordena correctamente los números.

 * Se realizarán cuatro pruebas:

 * 1. Arreglo aleatorio.
 * 2. Arreglo ordenado de menor a mayor.
 * 3. Arreglo ordenado de mayor a menor.
 * 4. Arreglo con números duplicados.

 * Para cada prueba se crearán dos copias del arreglo.
 * La primera se ordenará utilizando Bubble Sort y la segunda mediante Arrays.sort(), que pertenece
 * a la biblioteca estándar de Java.

 * Posteriormente, se compararán ambos resultados
 * para verificar que el ordenamiento sea correcto.
 */

public class PruebasBubbleSort {

    // Método encargado de ejecutar las cuatro pruebas.
    public static void ejecutarPruebas() {

        // PRUEBA 1: ARREGLO ALEATORIO.
        // Los valores no tienen un orden establecido.
        int[] aleatorio = {64, 25, 12, 22, 11};

        // PRUEBA 2: ARREGLO ASCENDENTE.
        // Los valores ya están ordenados de menor a mayor.
        int[] ascendente = {10, 20, 30, 40, 50};

        // PRUEBA 3: ARREGLO DESCENDENTE.
        // Los valores están ordenados de mayor a menor.
        int[] descendente = {50, 40, 30, 20, 10};

        // PRUEBA 4: ARREGLO CON DUPLICADOS.
        // Algunos números aparecen más de una vez.
        int[] duplicados = {10, 5, 10, 3, 5};

        // Ejecuta la prueba con el arreglo aleatorio.
        probarBubbleSort("Aleatorio", aleatorio);

        // Ejecuta la prueba con el arreglo ascendente.
        probarBubbleSort("Ascendente", ascendente);

        // Ejecuta la prueba con el arreglo descendente.
        probarBubbleSort("Descendente", descendente);

        // Ejecuta la prueba con el arreglo de duplicados.
        probarBubbleSort("Duplicados", duplicados);
    }

    /*
     * MÉTODO: probarBubbleSort
     *
     * Recibe dos parámetros:
     *
     * nombrePrueba: identifica el tipo de arreglo.
     * arreglo: contiene los números que se van a ordenar.
     *
     * Se crean dos copias para que ambos algoritmos
     * trabajen con exactamente los mismos valores.
     *
     * Después se comparan los resultados para
     * comprobar que Bubble Sort funciona correctamente.
     */

    public static void probarBubbleSort(
            String nombrePrueba, int[] arreglo) {

        // Crea una copia del arreglo original
        // para ordenarla utilizando Bubble Sort.
        int[] numeros = Arrays.copyOf(
                arreglo, arreglo.length);

        // Crea una segunda copia del mismo arreglo
        // para ordenarla utilizando Arrays.sort().
        int[] referencia = Arrays.copyOf(
                arreglo, arreglo.length);

        // Llama al método ordenar de BubbleSort.
        // Este método modifica directamente el arreglo numeros.
        BubbleSort.ordenar(numeros);

        // Ordena el arreglo referencia mediante
        // el método de la biblioteca estándar de Java.
        Arrays.sort(referencia);

        // Compara ambos arreglos elemento por elemento.
        // Devuelve true cuando tienen los mismos valores
        // en las mismas posiciones y false si son diferentes.
        boolean correcto = Arrays.equals(
                numeros, referencia);

        // Muestra el nombre de la prueba realizada.
        System.out.println("\nPRUEBA: " + nombrePrueba);

        // Muestra el arreglo antes de ordenarlo.
        System.out.println("Original: "
                + Arrays.toString(arreglo));

        // Muestra el resultado obtenido con Bubble Sort.
        System.out.println("Bubble Sort: "
                + Arrays.toString(numeros));

        // Muestra el resultado del método de referencia.
        System.out.println("Arrays.sort(): "
                + Arrays.toString(referencia));

        // Indica si ambos métodos produjeron el mismo resultado.
        System.out.println("¿Ordenamiento correcto?: "
                + correcto);
    }
}

