
/*
 * ALGORITMO: MERGE SORT (ORDENAMIENTO POR MEZCLA)

 * Este algoritmo permite ordenar los elementos de un arreglo de números enteros de menor a mayor.

 * Su funcionamiento consiste en dividir el arreglo  en dos partes, continuar dividiendo cada una
 * hasta obtener partes de un solo elemento y, posteriormente, unirlas de forma ordenada.

 * Para realizar este procedimiento utiliza tres métodos:

 * 1. ordenar(): inicia el ordenamiento del arreglo.

 * 2. dividir(): divide recursivamente el arreglo en partes más pequeñas.

 * 3. mezclar(): une las partes comparando sus valores para colocarlos de menor a mayor.
 */

public class MergeSort {

    //MÉTODO: ordenar

     // Recibe el arreglo que queremos ordenar.

    public static void ordenar(int[] arreglo) {

        // Se verifica que el arreglo tenga al menos dos elementos, ya que uno solo está ordenado.
        if (arreglo.length > 1) {

            // Se Llama al método dividir indicando la primera posición del arreglo (0)
            // y la última posición (length - 1).
            dividir(arreglo, 0, arreglo.length - 1);
        }
    }

    /*
     * MÉTODO: dividir

     * Recibe el arreglo y las posiciones que se quieren ordenar.
     * Se utiliza recursividad para dividir el arreglo  hasta llegar a partes de un solo elemento.
     */

    public static void dividir(int[] arreglo, int inicio, int fin) {

        // Verifica que la parte del arreglo tenga más de un elemento.
        // Si inicio y fin son iguales, significa que solamente queda un elemento.
        if (inicio < fin) {

            // Se calcula la posición central para dividir la parte actual en dos.
            int medio = inicio + (fin - inicio) / 2;

            // Se llama nuevamente al método dividir para trabajar con la mitad izquierda.
            dividir(arreglo, inicio, medio);

            // Llama nuevamente al método dividir para trabajar con la mitad derecha.
            dividir(arreglo, medio + 1, fin);

            // Cuando ambas mitades han sido ejecutadas, se llama al método mezclar para unirlas
            // en orden ascendente.
            mezclar(arreglo, inicio, medio, fin);
        }
    }

    /*
     * MÉTODO: mezclar

     * Recibe dos partes consecutivas del arreglo que ya se encuentran ordenadas.

     * La primera va desde inicio hasta medio.
     * La segunda va desde medio + 1 hasta fin.

     * Se compara los valores de ambas partes  y los coloca en orden dentro del arreglo.
     */
    public static void mezclar(
            int[] arreglo, int inicio, int medio, int fin) {

        // Se calcula la cantidad de elementos que tendrá la mitad izquierda.
        int tamañoIzquierdo = medio - inicio + 1;

        // Se calcula la cantidad de elementos que tendrá la mitad derecha.
        int tamañoDerecho = fin - medio;

        // Se crea un arreglo auxiliar para guardar los elementos de la mitad izquierda.
        int[] izquierda = new int[tamañoIzquierdo];

        // Se crea otro arreglo auxiliar para guardar los elementos de la mitad derecha.
        int[] derecha = new int[tamañoDerecho];

        // Se copia los valores correspondientes a la mitad izquierda.
        for (int i = 0; i < tamañoIzquierdo; i++) {
            izquierda[i] = arreglo[inicio + i];
        }

        // Se copia los valores correspondientes a la mitad derecha.
        for (int j = 0; j < tamañoDerecho; j++) {
            derecha[j] = arreglo[medio + 1 + j];
        }

        // i indica la posición que estamos revisando dentro del arreglo auxiliar izquierdo.
        int i = 0;

        // j indica la posición que estamos revisando dentro del arreglo auxiliar derecho.
        int j = 0;

        // k indica la posición del arreglo original donde colocaremos el siguiente valor menor.
        int k = inicio;

        // Continúa mientras ambas mitades tengan elementos pendientes de comparar.
        while (i < tamañoIzquierdo && j < tamañoDerecho) {

            // Se compara los elementos actuales de los dos arreglos auxiliares.
            if (izquierda[i] <= derecha[j]) {

                // Si el valor izquierdo es menor o igual, lo coloca en el arreglo original.
                arreglo[k] = izquierda[i];

                // Se avanza a la siguiente posición del arreglo auxiliar izquierdo.
                i++;

            } else {

                // Si el valor derecho es menor, lo coloca en el arreglo original.
                arreglo[k] = derecha[j];

                // Se avanza a la siguiente posición del arreglo auxiliar derecho.
                j++;
            }

            // Se avanza a la siguiente posición donde se colocará un valor ordenado.
            k++;
        }

        // Si quedaron elementos en la mitad izquierda, se copian al arreglo original.
            // Ya no es necesario compararlos porque esa mitad se encontraba ordenada.
        while (i < tamañoIzquierdo) {

            arreglo[k] = izquierda[i];

            // Se avanza en el arreglo izquierdo.
            i++;

            // Se avanza en el arreglo original.
            k++;
        }

        // Si quedaron elementos en la mitad derecha, también los copia al arreglo original.
        while (j < tamañoDerecho) {

            arreglo[k] = derecha[j];

            // Avanza en el arreglo derecho.
            j++;

            // Avanza en el arreglo original.
            k++;
        }
    }
}
