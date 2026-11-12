
package Experimentos;

/*
 * Clase: PruebasGeneradorArreglos
 *
 * Esta clase comprueba que los cuatro tipos de arreglos
 * se generan correctamente.

 * Comenzando con 1000 elementos y duplicando la cantidad hasta llegar a 1024000.

 * Para cada tamaño se comprueba:
 * 1. Que el arreglo tenga la cantidad correcta de elementos.
 * 2. Que los números estén dentro del rango permitido.
 * 3. Que los arreglos ascendentes y descendentes tengan el orden correspondiente.
 *
 * No se imprimen todos los números para evitar
 * llenar la consola con demasiada información.
 */

public class PruebasGeneradorArreglos {

    public static void main(String[] args) {

        // Comienza con 1000 elementos y duplica el tamaño
        // en cada vuelta hasta llegar a 1024000.
        for (int tamano = 1000; tamano <= 1024000; tamano = tamano * 2) {

            System.out.println("\n================================");
            System.out.println("TAMAÑO DEL ARREGLO: " + tamano);
            System.out.println("================================");

            /*
             * PRUEBA 1: ARREGLO ALEATORIO
             */

            // Genera un arreglo con números entre 0 y 999999.
            int[] aleatorio = GeneradorArreglos.generarAleatorio(tamano);

            // Comprueba el tamaño y el rango de los números.
            boolean pruebaAleatorio = verificarTamano(aleatorio, tamano)
                    && verificarRango(aleatorio, 0, 999999);

            System.out.println("Aleatorio: " + pruebaAleatorio);


            /*
             * PRUEBA 2: ARREGLO ASCENDENTE
             */

            // Genera un arreglo ordenado de menor a mayor.
            int[] ascendente = GeneradorArreglos.generarAscendente(tamano);

            // Comprueba el tamaño, el rango y el orden ascendente.
            boolean pruebaAscendente = verificarTamano(ascendente, tamano)
                    && verificarRango(ascendente, 0, 999999)
                    && verificarAscendente(ascendente);

            System.out.println("Ascendente: " + pruebaAscendente);


            /*
             * PRUEBA 3: ARREGLO DESCENDENTE
             */

            // Genera un arreglo ordenado de mayor a menor.
            int[] descendente = GeneradorArreglos.generarDescendente(tamano);

            // Comprueba el tamaño, el rango y el orden descendente.
            boolean pruebaDescendente = verificarTamano(descendente, tamano)
                    && verificarRango(descendente, 0, 999999)
                    && verificarDescendente(descendente);

            System.out.println("Descendente: " + pruebaDescendente);


            /*
             * PRUEBA 4: ARREGLO CON DUPLICADOS
             */

            // Genera un arreglo utilizando números entre 0 y 10.
            int[] duplicados = GeneradorArreglos.generarDuplicados(tamano);

            // Comprueba el tamaño y el rango de los números.
            boolean pruebaDuplicados = verificarTamano(duplicados, tamano)
                    && verificarRango(duplicados, 0, 10);

            System.out.println("Duplicados: " + pruebaDuplicados);
        }
    }

    //************************************************
    //************************************************

    /*
     * Método: verificarTamano

     * Comprueba que el arreglo tenga exactamente sea la cantidad de elementos solicitada.
     */
    public static boolean verificarTamano(int[] arreglo, int tamano) {

        // Devuelve true si la cantidad de elementos es correcta.
        return arreglo.length == tamano;
    }

    //************************************************
    //************************************************

    /*
     * Método: verificarRango
     *
     * Se comprueba que todos los números del arreglo
     * estén entre el valor mínimo y el máximo permitidos.
     */
    public static boolean verificarRango(int[] arreglo, int minimo, int maximo) {

        // Recorre todos los números del arreglo.
        for (int i = 0; i < arreglo.length; i++) {

            // Si encuentra un número fuera del rango,
            // devuelve false porque la prueba no se cumple.
            if (arreglo[i] < minimo || arreglo[i] > maximo) {
                return false;
            }
        }

        // Si todos los números cumplen el rango, devuelve true.
        return true;
    }

    //************************************************
    //************************************************

    /*
     * Método: verificarAscendente
     *
     * Se comprueba que los números estén ordenados  de menor a mayor.
     */
    public static boolean verificarAscendente(int[] arreglo) {

        // Comienza en la segunda posición para poder
        // comparar cada número con el que está antes.
        for (int i = 1; i < arreglo.length; i++) {

            // Si un número es menor que el anterior,
            // significa que el arreglo no está ordenado.
            if (arreglo[i] < arreglo[i - 1]) {
                return false;
            }
        }

        // Si no encontró errores, el orden es correcto.
        return true;
    }

    //************************************************
    //************************************************
    /*
     * Método: verificarDescendente
     *
     * Comprueba que los números estén ordenados
     * de mayor a menor.
     */
    public static boolean verificarDescendente(int[] arreglo) {

        // Comienza en la segunda posición para comparar
        // cada número con el que se encuentra antes.
        for (int i = 1; i < arreglo.length; i++) {

            // Si un número es mayor que el anterior,
            // significa que el arreglo no está en orden descendente.
            if (arreglo[i] > arreglo[i - 1]) {
                return false;
            }
        }

        // Si no encontró errores, el orden es correcto.
        return true;
    }
}
