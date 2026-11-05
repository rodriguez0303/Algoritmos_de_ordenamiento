
/*
 * ALGORITMO: SELECTION SORT (ORDENAMIENTO POR SELECCIÓN)
 *
 * Este algoritmo permite ordenar los elementos de un arreglo de menor a mayor.

 * Su funcionamiento consiste en buscar el número menor entre los elementos que todavía no están
 * ordenados y colocarlo en la posición que le corresponde.

 * Para realizar este procedimiento utiliza dos ciclos for:

 * 1. El primer ciclo recorre las posiciones del arreglo donde se deben colocar los valores ordenados.

 * 2. El segundo ciclo busca el número menor entre los elementos que todavía faltan por ordenar.

 * Una vez encontrado el menor, se intercambia con el  elemento que ocupa la posición actual.

 * Este procedimiento se repite hasta ordenar el arreglo.
 */

public class SelectionSort {

    // Método que recibe un arreglo de números enteros y los ordena de menor a mayor.
        // Es static para poder llamarlo desde otra clase sin crear un objeto de SelectionSort.
            // Es void porque modifica el arreglo recibido y no necesita devolver otro arreglo.
    public static void ordenar(int[] arreglo) {

        // Este primer for recorre las posiciones del arreglo.
        // La variable i indica la posición donde debemos colocar el siguiente número menor.
        // Se detiene en length - 1 porque el último elemento quedará ordenado después de las pasadas anteriores.
        for (int i = 0; i < arreglo.length - 1; i++) {

            // Se supone inicialmente que el número menor se encuentra en la posición actual i.
                // se guarda esa posición en indiceMenor.
            int indiceMenor = i;

            // El segundo for revisa los elementos que se encuentran después de la posición i.
                // La variable j comienza en i + 1 porque las posiciones anteriores ya están ordenadas.
            for (int j = i + 1; j < arreglo.length; j++) {

                // Se compara el número de la posición j con el número ubicado en indiceMenor.
                    // Si encuentra un valor más pequeño,debe actualizar la posición del menor.
                if (arreglo[j] < arreglo[indiceMenor]) {

                    // Se guarda la posición del nuevo número menor.
                        // No guarda el valor, sino su índice dentro del arreglo.
                    indiceMenor = j;
                }
            }

            // Una vez que se termina de recorrer el segundo for,
            // indiceMenor contiene la posición del número más pequeño entre los elementos restantes.

            //Se guarda temporalmente el valor que está en la posición i para no perderlo cuando se realiza el intercambio.
            int temporal = arreglo[i];

            // Se coloca el número menor encontrado en la posición actual i.
            arreglo[i] = arreglo[indiceMenor];

            // Se coloca el valor que estaba originalmente en la posición i donde se encontraba el menor.
            // Con esto se completa el intercambio.
            arreglo[indiceMenor] = temporal;

            // Al terminar, la posición i contiene el menor valor de la parte que todavía no estaba ordenada.
        }

        // Cuando finaliza el primer for,
        // todos los elementos quedan ordenados de menor a mayor dentro del mismo arreglo.
    }
}

