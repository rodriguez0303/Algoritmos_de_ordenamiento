
/*
 * ALGORITMO: QUICK SORT (ORDENAMIENTO RÁPIDO)

 * Este algoritmo permite ordenar los elementos de un arreglo de números enteros de menor a mayor.

 * Su funcionamiento consiste en seleccionar un elemento llamado pivote y organizar los demás
 * valores alrededor de este.

 * Los elementos menores o iguales al pivote  se colocan a su izquierda, mientras que los
 * mayores se colocan a su derecha.

 * Después, el algoritmo repite el procedimiento sobre las partes izquierda y derecha.

 * MÉTODOS:

 * 1. ordenar(): inicia el ordenamiento.

 * 2. quickSort(): divide recursivamente el arreglo.

 * 3. particionar(): organiza los elementos alrededor
 *    del pivote y devuelve su posición definitiva.

 */

public class QuickSort {

    /*
     * MÉTODO: ordenar
     * Recibe el arreglo que queremos ordenar.
     */
    public static void ordenar(int[] arreglo) {

        // Llama al método recursivo quickSort.
        // La primera posición del arreglo es 0.
        // La última posición es length - 1.
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    /*
     * MÉTODO: quickSort

     * Recibe el arreglo y los límites de la parte que queremos ordenar.

     * inicio: primera posición del arreglo
     * fin: última posición del arreglo.

     * Utiliza recursividad para ordenar las partes que quedan a ambos lados del pivote.
     */
    public static void quickSort(
            int[] arreglo, int inicio, int fin) {

        // Verifica que exista más de un elemento dentro de la parte que queremos ordenar.
        // Si inicio es igual o mayor que fin,
        // no necesitamos continuar dividiendo.
        if (inicio < fin) {

            // Llama al método particionar.
            // Este método coloca el pivote en su
            // posición definitiva y devuelve su índice.
            int posicionPivote = particionar(
                    arreglo, inicio, fin);

            // Ordena recursivamente los elementos
            // que quedaron a la izquierda del pivote.
            quickSort(arreglo, inicio, posicionPivote - 1);

            // Ordena recursivamente los elementos
            // que quedaron a la derecha del pivote.
            quickSort(arreglo, posicionPivote + 1, fin);
        }
    }

    /*
     * MÉTODO: particionar
     *
     * Selecciona siempre el último elemento como pivote.
     *
     * Recorre la parte del arreglo que se está ordenando
     * y coloca los valores menores o iguales al pivote
     * hacia la izquierda.
     *
     * Al finalizar, coloca el pivote entre los
     * valores menores y los mayores.
     *
     * Devuelve la posición definitiva del pivote.
     */
    public static int particionar(
            int[] arreglo, int inicio, int fin) {

        // Selecciona el último elemento de la parte
        // actual del arreglo como pivote fijo.
        int pivote = arreglo[fin];

        // La variable i indica la última posición
        // ocupada por un elemento menor o igual
        // al pivote.
        //
        // Comienza una posición antes de inicio
        // porque todavía no hemos encontrado
        // ningún elemento que cumpla la condición.
        int i = inicio - 1;

        // Recorre los elementos desde inicio
        // hasta la posición anterior al pivote.
        for (int j = inicio; j < fin; j++) {

            // Compara el elemento actual con el pivote.
            // Si es menor o igual, debe quedar
            // en la parte izquierda del arreglo.
            if (arreglo[j] <= pivote) {

                // Avanza la posición donde se colocará
                // el siguiente elemento menor o igual.
                i++;

                // Guarda temporalmente el valor
                // que se encuentra en la posición i.
                int temporal = arreglo[i];

                // Coloca en la posición i el elemento
                // que encontramos en la posición j.
                arreglo[i] = arreglo[j];

                // Coloca el valor anterior de i
                // en la posición j.
                arreglo[j] = temporal;
            }
        }

        // Al finalizar el recorrido, coloca el pivote
        // después de todos los elementos menores
        // o iguales que él.

        // Guarda el valor que ocupa la posición
        // donde corresponde colocar el pivote.
        int temporal = arreglo[i + 1];

        // Coloca el pivote en su posición definitiva.
        arreglo[i + 1] = arreglo[fin];

        // Coloca el valor anterior en la posición
        // donde se encontraba el pivote.
        arreglo[fin] = temporal;

        // Devuelve la posición definitiva del pivote.
        // Esta posición se utiliza para dividir
        // el arreglo en las siguientes llamadas.
        return i + 1;
    }
}

