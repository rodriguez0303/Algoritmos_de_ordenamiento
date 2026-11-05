
/*
 * CLASE MAIN - BENCHMARK DE ALGORITMOS DE ORDENAMIENTO

 * Su función es ejecutar las pruebas de los diferentes  algoritmos de ordenamiento que se implementarán
 * durante el desarrollo de la tarea.
 *
 * Cada algoritmo tendrá una clase independiente que contendrá su código de ordenamiento.
 *
 * Cada algoritmo contará con otra clase encargada de verificar que ordene correctamente
 * los elementos de diferentes arreglos.
 */

public class Main {

    // Método principal donde comienza la ejecución
    // del programa cuando se presiona Run en IntelliJ.
    public static void main(String[] args) {

        // Muestra un título general para identificar el programa que estamos ejecutando.
        System.out.println("BENCHMARK DE ALGORITMOS DE ORDENAMIENTO");

        // Muestra el nombre del algoritmo que se esta ejecutando
        System.out.println("\nPRUEBAS DE SELECTION SORT");

        // Se llama al método que ejecuta las cuatro pruebas de funcionamiento de Selection Sort.
            // Este método se encuentra definido en la clase PruebasSelectionSort.
        PruebasSelectionSort.ejecutarPruebas();

        //*****************************************************************************
        //*****************************************************************************

        // Muestra el nombre del segundo algoritmo.
        System.out.println("\nPRUEBAS DE BUBBLE SORT");

        // Ejecuta las cuatro pruebas de Bubble Sort.
        PruebasBubbleSort.ejecutarPruebas();

        //*****************************************************************************
        //*****************************************************************************

        // Muestra el nombre del tercer algoritmo.
        System.out.println("\nPRUEBAS DE INSERTION SORT");

        // Se ejecuta las cuatro pruebas de Insertion Sort.
        PruebasInsertionSort.ejecutarPruebas();

        //*****************************************************************************
        //*****************************************************************************

        // Muestra el nombre del cuarto algoritmo.
        System.out.println("\nPRUEBAS DE SHELL SORT");

        // Ejecuta las cuatro pruebas de Shell Sort.
        PruebasShellSort.ejecutarPruebas();

        //*****************************************************************************
        //*****************************************************************************

        // Muestra el nombre del quinto algoritmo.
        System.out.println("\nPRUEBAS DE MERGE SORT");

        // Ejecuta las cuatro pruebas de Merge Sort.
        PruebasMergeSort.ejecutarPruebas();

        //*****************************************************************************
        //*****************************************************************************

        // Primero muestra el nombre del algoritmo Quick Sort en la consola.
                System.out.println("\nPRUEBAS DE QUICK SORT");

        // Se llama al método ejecutarPruebas de PruebasQuickSort.
            // Este método realiza las pruebas con arreglos aleatorios,
                // ascendentes, descendentes y con números duplicados.
                PruebasQuickSort.ejecutarPruebas();

        //*****************************************************************************
        //*****************************************************************************

        // Se muestra el nombre del último algoritmo.
        System.out.println("\nPRUEBAS DE RADIX SORT");

        // Llama al método ejecutarPruebas() de la clase PruebasRadixSort.

        // Este método ejecuta las pruebas con
        // arreglos aleatorios, ascendentes,descendentes y con números duplicados.
        PruebasRadixSort.ejecutarPruebas();
    }

    }

