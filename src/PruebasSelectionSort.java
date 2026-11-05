
import java.util.Arrays;

/*
 * CLASE: PRUEBAS DE ORDENAMIENTO
 *
 * Esta clase permite verificar que Selection Sort ordena correctamente diferentes arreglos.
 *
 * Se realizarán cuatro pruebas:
 *
 * 1. Arreglo aleatorio.
 * 2. Arreglo ordenado de menor a mayor.
 * 3. Arreglo ordenado de mayor a menor.
 * 4. Arreglo con números repetidos.
 *
 * Para comprobar los resultados, cada arreglo se
 * ordenará utilizando Selection Sort y Arrays.sort().
 *
 * Finalmente, se compararán ambos resultados.
 * Si son iguales, la prueba mostrará true.
 *
 * Estas pruebas verifican el funcionamiento.
 * No realizan mediciones de tiempo.
 */

public class PruebasSelectionSort {

    // Método que ejecuta las cuatro pruebas.
    // Es static para llamarlo desde Main sin crear un objeto.
    // Es void porque no devuelve ningún valor.
    public static void ejecutarPruebas() {

        // PRUEBA 1: ARREGLO ALEATORIO.
        // Los números no siguen un orden específico.
        int[] aleatorio = {64, 25, 12, 22, 11};

        // PRUEBA 2: ARREGLO ASCENDENTE.
        // Los números ya están ordenados de menor a mayor.
        int[] ascendente = {10, 20, 30, 40, 50};

        // PRUEBA 3: ARREGLO DESCENDENTE.
        // Los números están ordenados de mayor a menor.
        int[] descendente = {50, 40, 30, 20, 10};

        // PRUEBA 4: ARREGLO CON DUPLICADOS.
        // Algunos números aparecen más de una vez.
        int[] duplicados = {10, 5, 10, 3, 5};

        // Llama al método probarSelectionSort para
        // verificar cada uno de los cuatro arreglos.
        probarSelectionSort("Aleatorio", aleatorio);

        probarSelectionSort("Ascendente", ascendente);

        probarSelectionSort("Descendente", descendente);

        probarSelectionSort("Duplicados", duplicados);
    }

    /*
     * MÉTODO: probarSelectionSort
     *
     * Recibe el nombre de la prueba y el arreglo que se desea ordenar.
     *
     * Crea dos copias del mismo arreglo para que ambos métodos trabajen con los mismos valores.
     *
     * Después se compara los resultados obtenidos.
     */

    public static void probarSelectionSort(
            String nombrePrueba, int[] arreglo) {

        // Crea una copia para ejecutar Selection Sort. Así se conserva intacto el arreglo recibido.
        int[] numeros = Arrays.copyOf(arreglo, arreglo.length);

        // Se crea otra copia para utilizar Arrays.sort(). Ambas copias contienen los mismos números.
        int[] referencia = Arrays.copyOf(arreglo, arreglo.length);

        // Se ordena la primera copia con nuestro algoritmo.
        SelectionSort.ordenar(numeros);

        // Se ordena la segunda copia con la biblioteca de Java.
        Arrays.sort(referencia);

        // Se Compara si ambos arreglos contienen exactamente los mismos valores y en el mismo orden.
        boolean correcto = Arrays.equals(
                numeros, referencia);

        // Muestra el nombre de la prueba realizada.
        System.out.println("\nPRUEBA: " + nombrePrueba);

        // Muestra los números antes del ordenamiento.
        System.out.println("Original: " + Arrays.toString(arreglo));

        // Muestra el resultado de nuestro algoritmo.
        System.out.println("Selection Sort: " + Arrays.toString(numeros));

        // Muestra el resultado del algoritmo de referencia.
        System.out.println("Arrays.sort(): " + Arrays.toString(referencia));

        // Muestra true si ambos resultados coinciden.
            // Muestra false si existe alguna diferencia.
        System.out.println("¿Ordenamiento correcto?: "
                + correcto);
    }
}
