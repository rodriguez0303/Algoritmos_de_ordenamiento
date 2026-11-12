package Experimentos;

import java.util.Arrays;
import java.util.Random;

/*
 * Clase: Experimentos.GeneradorArreglos

 * Esta clase permite generar cuatro tipos de arreglos
 * para realizar las pruebas de los algoritmos de ordenamiento:

 * 1. Aleatorio: números entre 0 y 999999.
 * 2. Ascendente: números ordenados de menor a mayor.
 * 3. Descendente: números ordenados de mayor a menor.
 * 4. Duplicados: números entre 0 y 10.

 * La cantidad de elementos dependerá del tamaño solicitado.
 */

public class GeneradorArreglos {

    /*
     * Método: generarAleatorio
     * Genera un arreglo con números aleatorios entre 0 y 999999.
     */
    public static int[] generarAleatorio(int tamano) {

        // Se crea un arreglo con la cantidad de elementos solicitada.
        int[] arreglo = new int[tamano];

        // Se crea un objeto que permite generar números aleatorios.
        Random aleatorio = new Random();

        // Recorre todas las posiciones del arreglo.
        for (int i = 0; i < arreglo.length; i++) {

            // Se genera un número entre 0 y 999999
            // y lo guarda en la posición actual.
            arreglo[i] = aleatorio.nextInt(1000000);
        }

        // se retorna el arreglo generado.
        return arreglo;
    }

    //*******************************************************************
    //*******************************************************************

    /*
     * Método: generarAscendente
     *
     * Genera un arreglo con números entre 0 y 999999
     * y los ordena de menor a mayor.
     */
    public static int[] generarAscendente(int tamano) {

        // Se genera primero un arreglo con números aleatorios.
        int[] arreglo = generarAleatorio(tamano);

        // Se Ordena los números de menor a mayor.
        Arrays.sort(arreglo);

        // se retorna el arreglo ordenado.
        return arreglo;
    }

    //*******************************************************************
    //*******************************************************************
    /*
     * Método: generarDescendente
     *
     * Genera un arreglo con números entre 0 y 999999
     * y los ordena de mayor a menor.
     */
    public static int[] generarDescendente(int tamano) {

        // Se genera un arreglo ordenado de menor a mayor.
        int[] arreglo = generarAscendente(tamano);


        /*
         * Se recorre el arreglo solamente hasta la mitad, porque
         * en cada vuelta se intercambian dos números:
         * uno del inicio y otro del final.
         */
        for (int i = 0; i < arreglo.length / 2; i++) {

            // Calcula la posición del número que se encuentra al final.
                // Se resta 1 porque los índices comienzan en 0.
                    // Se resta i para avanzar desde el final hacia el inicio
            int ultimaPosicion = arreglo.length - 1 - i;

            // Se guarda temporalmente el número de la posición actual,
                // porque será reemplazado por el número del otro extremo.
                    // Esto evita perder su valor durante el intercambio.
            int temporal = arreglo[i];

            // Se coloca en la posición actual el número que se encuentra
                // al otro extremo del arreglo.
                    // Por ejemplo, en la primera vuelta, el último número
                        // pasa a ocupar la primera posición.
            arreglo[i] = arreglo[ultimaPosicion];

            // Se coloca en el otro extremo el número que guardamos
                // anteriormente en la variable temporal.
                    // De esta manera, ambos números intercambian posiciones
                        // sin que se pierda ninguno de sus valores.
            arreglo[ultimaPosicion] = temporal;
        }
        // Se retorna el arreglo ordenado de mayor a menor.
        return arreglo;
    }

    //*******************************************************************
    //*******************************************************************
    /*
     * Método: generarDuplicados
     *
     * Método que genera un arreglo con muchos números repetidos.
     * Los valores estarán entre 0 y 10.
     */
    public static int[] generarDuplicados(int tamano) {

        // Se crea un arreglo con la cantidad de elementos solicitada.
        int[] arreglo = new int[tamano];

        // Se crea un objeto que permite generar números aleatorios.
        Random aleatorio = new Random();

        // Recorre todas las posiciones del arreglo.
        for (int i = 0; i < arreglo.length; i++) {

            // Se Genera un número entre 0 y 10 y lo guarda en la posición actual.
            arreglo[i] = aleatorio.nextInt(11);
        }

        // Devuelve el arreglo con números repetidos.
        return arreglo;
    }
}
