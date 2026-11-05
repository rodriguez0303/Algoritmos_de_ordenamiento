
/*
 * ALGORITMO: RADIX SORT (ORDENAMIENTO POR DÍGITOS)

 * Este algoritmo permite ordenar números enteros no negativos de menor a mayor.

 * A diferencia de otros algoritmos, Radix Sort
 * no compara directamente dos números completos.

 * Su funcionamiento consiste en ordenar los valores según sus dígitos, comenzando por las unidades,
 * después las decenas, centenas y así sucesivamente.

 * Para organizar los elementos de cada posición decimal se utiliza Counting Sort como método auxiliar.

 * MÉTODOS:

 * 1. ordenar(): inicia el ordenamiento y recorre las diferentes posiciones decimales.

 * 2. obtenerMaximo(): encuentra el número mayor para determinar cuántas posiciones revisar.

 * 3. ordenarPorDigito(): organiza los elementos según el dígito correspondiente.

 * Complejidad temporal: O(d(n + b)).

 * d: cantidad de dígitos del número mayor.
 * n: cantidad de elementos del arreglo.
 * b: base numérica utilizada, en este caso 10.

 */

public class RadixSort {

    /*
     * MÉTODO: ordenar

     * Recibe el arreglo que se quiere ordenar.

     */
    public static void ordenar(int[] arreglo) {

        // Si el arreglo está vacío, no hay elementos que ordenar y finaliza el método.
        if (arreglo.length == 0) {
            return;
        }

        // Se obtiene el número mayor del arreglo.
            // Este valor permite determinar hasta qué posición decimal se debe realizar pasadas.
        int maximo = obtenerMaximo(arreglo);

        // Se recorre las posiciones decimales
        // exp = 1: unidades.
        // exp = 10: decenas.
        // exp = 100: centenas.

        // En cada pasada se ordenan los números según el dígito de la posición actual.
        for (long exp = 1; maximo / exp > 0; exp *= 10) {

            // Llama al método auxiliar que ordena los elementos según el dígito actual.
            ordenarPorDigito(arreglo, exp);
        }
    }

    /*
     * MÉTODO: obtenerMaximo

     * Recorre el arreglo para encontrar el valor más grande entre todos sus elementos.

     * Devuelve ese valor para determinar cuántas posiciones decimales se revisarán.
     */
    public static int obtenerMaximo(int[] arreglo) {

        // Se considera inicialmente que el primer elemento es el número mayor.
        int maximo = arreglo[0];

        // Se recorre los demás elementos del arreglo.
        for (int i = 1; i < arreglo.length; i++) {

            // Si encuentra un número mayor, se actualiza el valor de maximo.
            if (arreglo[i] > maximo) {
                maximo = arreglo[i];
            }
        }

        // Se devuelve el número mayor encontrado.
        return maximo;
    }

    /*
     * MÉTODO: ordenarPorDigito

     * Recibe el arreglo y la posición decimal que se desea ordenar.

     * Se utiliza Counting Sort estable para organizar
     * los elementos según el dígito seleccionado.

     * El arreglo conteo registra cuántas veces aparece cada dígito entre 0 y 9.

     * El arreglo salida guarda temporalmente los números en el orden correspondiente.
     */

    public static void ordenarPorDigito(
            int[] arreglo, long exp) {

        // Se obtiene la cantidad de elementos.
        int n = arreglo.length;

        // Crea un arreglo auxiliar donde se guardarán los valores ordenados según el dígito actual.
        int[] salida = new int[n];

        // Se crea un arreglo de 10 posiciones, una para cada dígito decimal (0 al 9).
        int[] conteo = new int[10];

        // Se recorre todos los números para contar cuántas veces aparece cada dígito.
        for (int i = 0; i < n; i++) {

            // Se extrae el dígito de la posición actual.
            // Por ejemplo, si el número es 345:
            // exp = 1 obtiene 5.
            // exp = 10 obtiene 4.
            // exp = 100 obtiene 3.
            int digito = (int) ((arreglo[i] / exp) % 10);

            // Se incrementa el contador correspondiente al dígito que acabamos de encontrar.
            conteo[digito]++;
        }

        // Se convierte las frecuencias en posiciones
        // acumuladas para determinar dónde debe colocarse cada elemento en salida.
        for (int i = 1; i < 10; i++) {

            // Se suma la cantidad del dígito anterior a la cantidad del dígito actual.
            conteo[i] += conteo[i - 1];
        }

        // Se recorre el arreglo desde el final para conservar el orden relativo
        // de los elementos con el mismo dígito.

        // Esto hace que Counting Sort sea estable,
        // condición necesaria para Radix Sort LSD.
        for (int i = n - 1; i >= 0; i--) {

            // Se obtiene el dígito correspondiente a la posición decimal actual.
            int digito = (int) ((arreglo[i] / exp) % 10);

            // Se coloca el número en la posición que le corresponde dentro de salida.
                // Se resta 1 porque los índices de los arreglos comienzan en 0.
            salida[conteo[digito] - 1] = arreglo[i];

            // Se disminuye el contador para que otro
            // elemento con el mismo dígito pueda ocupar la posición anterior.
            conteo[digito]--;
        }

        // Se copia los elementos del arreglo auxiliar al arreglo original, conservando el orden
        // obtenido durante esta pasada.
        for (int i = 0; i < n; i++) {
            arreglo[i] = salida[i];
        }
    }
}

