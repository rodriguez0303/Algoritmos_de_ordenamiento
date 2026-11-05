
/*
 * ALGORITMO: INSERTION SORT (ORDENAMIENTO POR INSERCIÓN)

 * Este algoritmo permite ordenar los elementos de un arreglo de números enteros de menor a mayor.

 * Su funcionamiento consiste en tomar un elemento y compararlo con los valores que se encuentran
 * en las posiciones anteriores.

 * Cuando encuentra valores mayores, los desplaza una posición hacia la derecha para dejar espacio
 * donde insertar el elemento seleccionado.

 * Este procedimiento se repite hasta completar el ordenamiento de todos los números.

 * Para realizar el proceso utiliza:

 * 1. Un ciclo for que recorre el arreglo desde la segunda posición.

 * 2. Un ciclo while que desplaza hacia la derecha los elementos mayores que el valor seleccionado.
 */

public class InsertionSort {

    // Método que recibe un arreglo de números enteros y permite ordenarlos de menor a mayor.

    public static void ordenar(int[] arreglo) {

        // Este ciclo for comienza en la posición 1, ya que el primer elemento se considera
            // inicialmente como la parte ordenada.
            for (int i = 1; i < arreglo.length; i++) {

            // Se guarda el valor que se quiere insertar dentro de la parte ordenada del arreglo.
                // Es necesario guardarlo porque algunos elementos serán desplazados.
            int valorActual = arreglo[i];

            // La variable j representa la posición anterior al elemento seleccionado.
            // Se utiliza para comparar valorActual con los elementos que están a su izquierda.
            int j = i - 1;

            // 1. j sea mayor o igual a 0, para evitar acceder a posiciones inexistentes.

            // 2. El elemento de la posición j sea mayor que el valor que queremos insertar.

            // Cuando ambas condiciones se cumplen, se debe desplazar ese elemento.
            while (j >= 0 && arreglo[j] > valorActual) {

                // Desplaza el elemento mayor una posición hacia la derecha.
                    // Así se deja espacio para insertar el valor seleccionado.
                arreglo[j + 1] = arreglo[j];

                // Se retrocede una posición para continuar comparando con los elementos anteriores.
                j--;
            }

            // Cuando termina el while, j + 1 indica la posición donde corresponde insertar el valor que habíamos guardado.
            arreglo[j + 1] = valorActual;

            // Al finalizar este recorrido, la parte del arreglo desde la posición 0 hasta i queda ordenada de menor a mayor.
        }

        // Cuando finaliza el for, todos los elementos del arreglo se encuentran ordenados.
    }
}

