
/*
 * ALGORITMO: SHELL SORT (ORDENAMIENTO SHELL)

 * Este algoritmo permite ordenar los elementos de un arreglo de números enteros de menor a mayor.

 * Su funcionamiento es similar al de Insertion Sort,
 * pero comienza comparando elementos que se encuentran separados por una determinada cantidad de posiciones.
 * Esa separación se conoce como intervalo o gap.

 * Inicialmente, el intervalo corresponde a la mitad de la cantidad de elementos del arreglo.

 * Después, el intervalo se divide entre dos hasta llegar a 1, momento en el que se comparan elementos consecutivos.

 * Para realizar el ordenamiento utiliza:

 * 1. Un ciclo for que controla los intervalos.

 * 2. Un segundo ciclo for que recorre los elementos a partir del intervalo correspondiente.

 * 3. Un ciclo while que desplaza los valores mayores para colocar cada elemento en su posición.

 * Secuencia de intervalos: n/2, n/4, ..., 1.

 */

public class ShellSort {

    // Método que recibe un arreglo de números enteros y permite ordenarlos de menor a mayor.
    public static void ordenar(int[] arreglo) {

        // Este primer ciclo controla los intervalos.
            // Inicialmente, gap es la mitad del tamaño del arreglo, utilizando división entera.
                // En cada pasada se divide entre dos hasta que el intervalo llegue a cero.
        for (int gap = arreglo.length / 2;
             gap > 0;
             gap /= 2) {

            // Este segundo ciclo recorre el arreglo comenzando desde la posición gap.
                // La variable i indica el elemento que se va a insertar en el grupo correspondiente al intervalo actual.
            for (int i = gap; i < arreglo.length; i++) {

                // Guarda temporalmente el elemento que se desea colocar en su posición.
                    // Esto evita perder su valor cuando se desplacen otros elementos.
                int temporal = arreglo[i];

                // La variable j comienza en i.
                    // Se utilizará para retroceder de gap en gap dentro del arreglo.
                int j = i;

                // Este ciclo while continúa mientras:
                // 1. j sea mayor o igual que gap, para evitar posiciones negativas.

                // 2. El elemento ubicado gap posiciones atrás sea mayor que temporal.

                // Cuando ambas condiciones se cumplen, el valor anterior debe desplazarse.
                while (j >= gap &&
                        arreglo[j - gap] > temporal) {

                    // Se desplaza el elemento mayor hacia la posición actual j.
                        // La distancia del desplazamiento corresponde al intervalo gap.
                    arreglo[j] = arreglo[j - gap];

                    // Retrocede gap posiciones para continuar buscando el lugar
                        // donde corresponde insertar temporal.
                    j -= gap;
                }

                // Se coloca el valor guardado en la posición
                    // que le corresponde dentro del grupo que se está ordenando.
                arreglo[j] = temporal;
            }

            // Al terminar esta pasada, los elementos quedan ordenados respecto al intervalo
            // utilizado, aunque el arreglo completo todavía puede estar desordenado.
        }

        // Cuando se completa la pasada con gap = 1,
        // todos los elementos quedan ordenados de menor a mayor.
    }
}

